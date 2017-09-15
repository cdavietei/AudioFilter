package com.audiofilter.api.google.types;

import com.google.gson.*;
import com.google.gson.annotations.*;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.ArrayList;

/**
 * Java Wrapper for class specified at:
 *
 * https://cloud.google.com/speech/reference/rest/v1/RecognitionConfig#SpeechContext
 */
public class SpeechContext {

    @SerializedName("phrases") @Accessors(prefix = "m") @Getter @Setter
    protected ArrayList<String> mPhrases;
}//SpeechContext class
