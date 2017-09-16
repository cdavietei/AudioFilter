package com.audiofilter.profanityfilter;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import com.audiofilter.pipeline.PipelineStage;
import com.audiofilter.api.google.types.*;
import com.audiofilter.api.google.SpeechApiConnector;

import java.lang.reflect.Type;
import java.util.*;

public class ProfanityStage implements PipelineStage<String> {

    protected SpeechApiConnector mConnector;
    protected ProfanityFilter mFilter;
    protected JsonObject mResult;

    protected boolean mReady;

    public ProfanityStage() {
        setup();
    }//ProfanityStage()

    protected void setup() {
        mConnector = new SpeechApiConnector();
        mFilter = new ProfanityFilter();
        mReady = false;
    }//setup()

    protected void successful(Operation op) {
        SpeechRecognitionAlternative result =
            op.getResponse() // Gets RecognizeResult
            .getResults() // Gets List<SpeechRecognitionResult>
            .get(0) // Gets first SpeechRecognitionResult
            .getAlternatives() // Gets List<SpeechRecognitionAlternative>
            .get(0); // Gets first SpeechRecognitionAlternative

        mFilter.identify(result);

        prepareSuccessResult(op);
    }

    protected void prepareSuccessResult(Operation op) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<WordInfo>>(){}.getType();
        mResult = new JsonObject();

        List<WordInfo> selection = mFilter.getSelection();
        JsonElement selectionList = gson.toJsonTree(selection, listType);
        JsonElement jsonOp = gson.toJsonTree(op);

        mResult.addProperty("successful",true);
        mResult.add("selection",selectionList);
        mResult.add("operation",jsonOp);
    }//prepareSuccessResult(Operation)

    protected void unSuccessful(Operation op) {
        Gson gson = new Gson();
        JsonElement jsonOp = gson.toJsonTree(op);

        mResult.addProperty("successful",false);
        mResult.add("operation", jsonOp);
    }

    /*============= Pipline Methods =============*/
    public void input(String filePath) {
        //Restricts input to FLAC only for now

        if(!filePath.matches("\\S+(.flac|.FLAC)")) {
            System.err.println("File path must be to a .FLAC file");
            return;
        }

        mConnector.setAudioFile(filePath).setFlacConfig();
        mReady = true;
    }//input(String)

    public boolean isReady() {
        return mReady;
    }//isReady()

    public void queue() {
        // TODO: Implement Async callback interface
    }//queue()

    public void run() {
        if(!isReady()) return;

        //Blocks the thread for a significant amount of time
        Operation op = mConnector.sendAsyncAndWait()
            .waitForLongRecognize();

        //Was successful
        if(op.getResponse() != null) {
            successful(op);
        }
        //Was not successful
        else {
            unSuccessful(op);
        }
    }//run()

    public JsonElement result() {
        return mResult;
    }//result()


}//ProfanityStage class
