package com.audiofilter.api.google.types;

import com.google.gson.*;
import com.google.gson.annotations.*;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Java Wrapper for class specified at:
 *
 * https://cloud.google.com/speech/reference/rest/v1/RecognitionConfig#SpeechContext
 */
@Builder
public class SpeechContext {

    @SerializedName("phrases") @Accessors(prefix = "m") @Getter @Setter @Singular
    protected List<String> mPhrases;
}//SpeechContext class
