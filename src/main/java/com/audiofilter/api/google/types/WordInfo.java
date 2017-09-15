package com.audiofilter.api.google.types;

import com.google.gson.*;
import com.google.gson.annotations.*;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * Java Wrapper for class specified at:
 *
 * https://cloud.google.com/speech/reference/rest/v1/speech/recognize#WordInfo
 */
public class WordInfo {

    @SerializedName("startTime") @Accessors(prefix = "m") @Getter
    protected String mStartTime;

    @SerializedName("endTime") @Accessors(prefix = "m") @Getter
    protected String mEndTime;

    @SerializedName("word") @Accessors(prefix = "m") @Getter
    protected String mWord;
}//WordInfo class
