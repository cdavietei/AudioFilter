package com.audiofilter.api.google.types;

import com.google.gson.*;
import com.google.gson.annotations.*;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * Java Wrapper for class specified at:
 *
 * https://cloud.google.com/speech/reference/rest/v1/operations
 */
public class Operation {

    @SerializedName("name") @Accessors(prefix = "m") @Getter
    protected String mName;

    @SerializedName("metadata") @Accessors(prefix = "m") @Getter
    protected JsonObject mMetaData;

    @SerializedName("done") @Accessors(prefix = "m") @Getter
    protected boolean mDone;

    @SerializedName("error") @Accessors(prefix = "m") @Getter
    protected Status mError;

    @SerializedName("response") @Accessors(prefix = "m") @Getter
    protected JsonObject mResponse;

}//Operation class
