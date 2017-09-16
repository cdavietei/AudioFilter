package com.audiofilter.api.google.types;

import com.google.gson.*;
import com.google.gson.annotations.*;

import lombok.*;
import lombok.experimental.Accessors;

@Builder
public class SpeechRequestBody {

    @SerializedName("config") @Accessors(prefix = "m") @Getter @Setter
    protected RecognitionConfig mConfig;

    @SerializedName("audio") @Accessors(prefix = "m") @Getter @Setter
    protected RecognitionAudio mAudio;

    public String toString() {
        return new Gson().toJson(this);
    }//toString()

}//RequestBody class
