package com.audiofilter.api.google;

import retrofit2.*;
import retrofit2.http.*;

import com.audiofilter.api.google.types.*;

import com.google.gson.*;

public interface SpeechApi {

// https://speech.googleapis.com/v1/speech:longrunningrecognize

    @POST("/v1/speech:longrunningrecognize")
    Call<LongRecognizeResult> longRecognize(
        @Query("key") String key,
        @Body RequestBody body
    );

    @POST("/v1/speech:recognize")
    Call<JsonObject> recognize(
        @Query("key") String key,
        @Body RequestBody body
    );

    @GET("/v1/operations/{name}")
    Call<Operation> operation(
        @Query("key") String apiKey,
        @Path("name") String name
    );
}//SpeechApi interface
