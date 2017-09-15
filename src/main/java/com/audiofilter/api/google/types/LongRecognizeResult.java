package com.audiofilter.api.google.types;

import com.google.gson.*;
import com.google.gson.annotations.*;

import lombok.*;
import lombok.experimental.Accessors;

@ToString
public class LongRecognizeResult {

    @SerializedName("name") @Accessors(prefix = "m") @Getter
    protected String mName;
}//LongRecognizeResult class
