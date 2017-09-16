package com.audiofilter.api.google;

import retrofit2.*;
import retrofit2.http.*;

import com.google.gson.*;

import com.audiofilter.api.google.types.*;
import com.audiofilter.utils.*;

import org.apache.commons.codec.binary.Base64;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import lombok.*;
import lombok.experimental.Accessors;


public class SpeechApiConnector {

    protected SpeechApi mApi;

    protected RecognitionConfig mConfig;
    protected RecognitionAudio mAudio;

    @Accessors(prefix = "m") @Getter
    protected LongRecognizeResult mLongRecognizeResult;

    public String mApiKey;

    public static final String SPEECH_KEY_PATH = "data/api/google_api_key.txt";
    public static final long WAIT_TIME = 500;

    public SpeechApiConnector() {
        setup();
    }//SpeechApiConnector()

    protected void setup() {
        getApiKey();
        mApi = ApiUtil.getSpeechApi();
    }//setup()

    /**
     * Gets the Google Speech API key from the resources folder
     */
    protected void getApiKey() {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(SPEECH_KEY_PATH));

            mApiKey = reader.readLine();
            reader.close();
        }
        catch(IOException e) {
            e.printStackTrace();
            mApiKey = "";
        }//catch(IOException)
    }//setApiKey()

    public SpeechApiConnector setFlacConfig() {
        mConfig = RecognitionConfig.builder()
            .encoding(AudioEncoding.FLAC)
            .sampleRateHertz(44100)
            .languageCode("en-US")
            .maxAlternatives(5)
            .profanityFilter(false)
            .enableWordTimeOffsets(true)
            .build();

        return this;
    }//setFlacConfig()

    public SpeechApiConnector setAudioFile(String filePath) {
        try {
            Path path = Paths.get(filePath);
            byte[] data = Files.readAllBytes(path);

            byte[] encodedAudio = Base64.encodeBase64(data);

            mAudio =  RecognitionAudio.builder()
                .content(new String(encodedAudio))
                .build();
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        return this;
    }//setAudioFile(String)

    protected boolean isReady() {
        // TODO: Define function to check if request is readys
        return true;
    }//isReady()

    protected SpeechRequestBody buildRequestBody() {
        return SpeechRequestBody.builder()
            .config(mConfig)
            .audio(mAudio)
            .build();
    }//buildRequestBody()

    public RecognizeResult sendSync() {
        RecognizeResult results = null;

        try {
            Call<RecognizeResult> call = mApi.recognize(
                mApiKey,
                buildRequestBody()
            );

            results = call.execute().body();
        }
        catch(Exception e) {
            e.printStackTrace();
            return new RecognizeResult();
        }

        return results;
    }//sendSync()

    public SpeechApiConnector sendAsyncAndWait() {
        mLongRecognizeResult = null;

        try {
            Call<LongRecognizeResult> call = mApi.longRecognize(
                mApiKey,
                buildRequestBody()
            );

            mLongRecognizeResult = call.execute().body();
        }
        catch(Exception e) {
            e.printStackTrace();
            return this;
        }
        return this;
    }//sendAsync()

    public LongRecognizeResult sendAsync() {
        return sendAsyncAndWait().getLongRecognizeResult();
    }//sendAsync()

    public Operation waitForLongRecognize() {

        String name = getLongRecognizeResult().getName();
        Operation op = null;

        try {
            Call<Operation> call = mApi.operation(name, mApiKey);

            op = call.execute().body();

            op.getName();

            while(!op.isDone()) {
                Thread.sleep(WAIT_TIME);

                call = call.clone();

                op = call.execute().body();
            }//while op !done
        }
        // catch(IOException e) {
        //
        // }
        // catch(IllegalArgumentException e) {
        //
        // }
        // catch(InterruptedException e) {
        //
        // }
        catch(Exception e) {
            e.printStackTrace();
        }
        return op;
    }//waitForLongRecognize()

    public boolean checkLongRecognize() {
        //TODO: Check long running recognize process
        //Blocking operation
        return true;
    }//checkLongRecognize()
}//SpeechApiConnector class
