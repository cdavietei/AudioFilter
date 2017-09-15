package com.audiofilter.api.google.types;

import com.google.gson.*;
import com.google.gson.annotations.*;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * Java Wrapper for class specified at:
 *
 * https://cloud.google.com/speech/reference/rest/v1/RecognitionAudio
 */
@Builder
public class RecognitionAudio {

    @SerializedName("content") @Accessors(prefix = "m") @Getter @Setter
    protected String mContent;

    @SerializedName("uri") @Accessors(prefix = "m") @Getter @Setter
    protected String mUri;

    public String toString() {
        Gson gson = new Gson();

        return gson.toJson(this);
    }//toString()
}//RecognitionAudio class
