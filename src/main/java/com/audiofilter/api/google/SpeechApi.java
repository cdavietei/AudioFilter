package com.audiofilter.api.google;

import retrofit2.*;
import retrofit2.http.*;

import com.audiofilter.api.google.types.*;

import com.google.gson.*;

public interface SpeechApi {

    @POST("/v1/speech:longrunningrecognize")
    Call<LongRecognizeResult> longRecognize(
        @Query("key") String key,
        @Body SpeechRequestBody body
    );

    @POST("/v1/speech:recognize")
    Call<RecognizeResult> recognize(
        @Query("key") String key,
        @Body SpeechRequestBody body
    );

    @GET("/v1/operations/{name}")
    Call<Operation> operation(
        @Path("name") String name,
        @Query("key") String apiKey
    );
}//SpeechApi interface
