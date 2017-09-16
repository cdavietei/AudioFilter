package com.audiofilter.pipeline;

import com.google.gson.JsonElement;

public interface PipelineStage<T> {
    void input(T param);
    boolean isReady(); // Ready to execute
    void queue(); //Run Asynchronously
    void run(); //Run Synchronously
    JsonElement result();
}//PipelineStep classs
