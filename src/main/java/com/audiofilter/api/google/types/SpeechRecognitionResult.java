package com.audiofilter.api.google.types;

import com.google.gson.*;
import com.google.gson.annotations.*;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.ArrayList;

/**
 * Java Wrapper for class specified at:
 *
 * https://cloud.google.com/speech/reference/rest/v1/speech/recognize#SpeechRecognitionResult
 */
public class SpeechRecognitionResult {
    @SerializedName("alternatives") @Accessors(prefix = "m") @Getter
    protected ArrayList<SpeechRecognitionAlternative> mAlternatives;
}//SpeechRecognitionResult class
