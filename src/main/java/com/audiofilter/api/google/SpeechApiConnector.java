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

public class SpeechApiConnector {

    protected RecognitionConfig mConfig;
    protected RecognitionAudio mAudio;

    public String mApiKey;

    public static final String SPEECH_KEY_PATH = "data/api/google_api_key.txt";

    public SpeechApiConnector() {
        setup();
    }//SpeechApiConnector()

    protected void setup() {
        getApiKey();
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

    public JsonObject sendSync() {
        JsonObject results = null;

        try {
            SpeechApi api = ApiUtil.getSpeechApi();

            RequestBody body = RequestBody.builder()
                .config(mConfig)
                .audio(mAudio)
                .build();

            Call<JsonObject> call = api.recognize(
                mApiKey,
                body
            );

            results = call.execute().body();
        }
        catch(Exception e) {
            e.printStackTrace();
            return new JsonObject();
        }

        return results;
    }//sendSync()

    public LongRecognizeResult sendAsync() {
        LongRecognizeResult result = null;

        try {
            SpeechApi api = ApiUtil.getSpeechApi();

            RequestBody body = RequestBody.builder()
                .config(mConfig)
                .audio(mAudio)
                .build();

            Call<LongRecognizeResult> call = api.longRecognize(
                mApiKey,
                body
            );

            System.out.println(call.request());
            // System.out.println(body);
            // System.out.println(call.request().body());

            result = call.execute().body();
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }



}//SpeechApiConnector class
