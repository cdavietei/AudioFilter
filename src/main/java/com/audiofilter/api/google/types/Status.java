package com.audiofilter.api.google.types;

import com.google.gson.*;
import com.google.gson.annotations.*;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * Java Wrapper for class specified at:
 *
 * https://cloud.google.com/speech/reference/rest/v1/operations#Status
 */
public class Status {

    @SerializedName("code") @Accessors(prefix = "m") @Getter
    protected int mCode;

    @SerializedName("message") @Accessors(prefix = "m") @Getter
    protected String mMessage;

    @SerializedName("details") @Accessors(prefix = "m") @Getter
    protected JsonObject[] mDetails;

}//Status class
