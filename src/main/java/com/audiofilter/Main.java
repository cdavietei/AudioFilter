package com.audiofilter;

// import com.audiofilter.api.google.SpeechApiConnector;
// import com.audiofilter.api.google.types.RecognizeResult;

import com.audiofilter.pipeline.PipelineStage;
import com.audiofilter.profanityfilter.ProfanityStage;

import com.google.gson.*;

public class Main {

    public static void main(String[] args) {

        // SpeechApiConnector connector = new SpeechApiConnector();
        // RecognizeResult obj = connector.setAudioFile("data/zach-short.flac")
        //     .setFlacConfig()
        //     .sendSync();
        //
        // System.out.println(obj);

        PipelineStage pFilter = new ProfanityStage();
        pFilter.input("data/zach-short.flac");
        pFilter.run();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        System.out.println(gson.toJson(pFilter.result()));

    }
}//Main class
