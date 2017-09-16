package com.audiofilter.utils;

import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;

import com.audiofilter.api.google.SpeechApi;

public class ApiUtil {

    public static final String SPEECH_API_URL = "https://speech.googleapis.com/";

    protected static SpeechApi SPEECH_API = null;

    public static SpeechApi getSpeechApi() {
        if(SPEECH_API != null) return SPEECH_API;

        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(SPEECH_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

            SPEECH_API = retrofit.create(SpeechApi.class);
            return SPEECH_API;
    }//getSpeechApi()
}//ApiUtil class
