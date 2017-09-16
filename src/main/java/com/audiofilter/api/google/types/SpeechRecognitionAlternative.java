package com.audiofilter.api.google.types;

import com.google.gson.*;
import com.google.gson.annotations.*;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Java Wrapper for class specified at:
 *
 * https://cloud.google.com/speech/reference/rest/v1/speech/recognize#SpeechRecognitionAlternative
 */
public class SpeechRecognitionAlternative {

    @SerializedName("transcript") @Accessors(prefix = "m") @Getter
    protected String mTranscript;

    @SerializedName("confidence") @Accessors(prefix = "m") @Getter
    protected double mConfidence;

    @SerializedName("words") @Accessors(prefix = "m") @Getter
    protected List<WordInfo> mWords;
}//SpeechRecognitionAlternative class
