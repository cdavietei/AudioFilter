package com.audiofilter.api.google.types;

import com.google.gson.*;
import com.google.gson.annotations.*;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * Java wrapper for class:
 * https://cloud.google.com/speech/reference/rest/v1/LongRunningRecognizeMetadata
 */

public class RecognizeMetadata {
    @SerializedName("progressPercent") @Accessors(prefix = "m") @Getter
    protected float mProgressPercent;

    @SerializedName("startTime") @Accessors(prefix = "m") @Getter
    protected String mStartTime;

    @SerializedName("lastUpdateTime") @Accessors(prefix = "m") @Getter
    protected String mLastUpdateTimeTime;
}//RecognizeMetadata class
