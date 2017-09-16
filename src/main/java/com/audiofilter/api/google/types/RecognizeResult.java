package com.audiofilter.api.google.types;

import com.google.gson.*;
import com.google.gson.annotations.*;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Java Wrapper for both:
 * https://cloud.google.com/speech/reference/rest/v1/LongRunningRecognizeResponse
 * and
 * https://cloud.google.com/speech/reference/rest/v1/speech/recognize#response-body
 */
public class RecognizeResult {
    @SerializedName("results") @Accessors(prefix="m") @Getter
    protected List<SpeechRecognitionResult> mResults;

    public String toString() {
        return new Gson().toJson(this);
    }//toString()
}//RecognizeResult class
