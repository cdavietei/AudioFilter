package com.audiofilter.api.google.types;

import com.google.gson.*;
import com.google.gson.annotations.*;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Java Wrapper for class specified at:
 *
 * https://cloud.google.com/speech/reference/rest/v1/RecognitionConfig
 */
@Builder
public class RecognitionConfig {

    @SerializedName("encoding") @Accessors(prefix = "m") @Getter @Setter
    protected AudioEncoding mEncoding;

    @SerializedName("sampleRateHertz") @Accessors(prefix = "m") @Getter @Setter
    protected int mSampleRateHertz;

    @SerializedName("languageCode") @Accessors(prefix = "m") @Getter @Setter
    protected String mLanguageCode;

    @SerializedName("maxAlternatives") @Accessors(prefix = "m") @Getter @Setter
    protected int mMaxAlternatives;

    @SerializedName("profanityFilter") @Accessors(prefix = "m") @Getter @Setter
    protected boolean mProfanityFilter;

    @SerializedName("speechContexts") @Accessors(prefix = "m") @Getter @Setter @Singular
    protected List<SpeechContext> mSpeechContexts;

    @SerializedName("enableWordTimeOffsets") @Accessors(prefix = "m") @Getter @Setter
    protected boolean mEnableWordTimeOffsets;

    public String toString() {
        Gson gson = new Gson();

        return gson.toJson(this);
    }//toString()

}//RecognitionConfig class
