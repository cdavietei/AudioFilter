package com.audiofilter.api.google.types;

/**
 * Java Wrapper for enums specified at:
 *
 * https://cloud.google.com/speech/reference/rest/v1/RecognitionConfig#AudioEncoding
 */
public enum AudioEncoding {
    ENCODING_UNSPECIFIED("ENCODING_UNSPECIFIED"),
    LINEAR16("LINEAR16"),
    FLAC("FLAC"),
    MULAW("MULAW"),
    AMR("AMR"),
    AMR_WB("AMR_WB"),
    OGG_OPUS("OGG_OPUS"),
    SPEEX_WITH_HEADER_BYTE("SPEEX_WITH_HEADER_BYTE");

    private String mEncoding;

    private AudioEncoding(String encoding) {
        mEncoding = encoding.toUpperCase();
    }//AudioEncoding(String)

    public String toString() {
        return mEncoding;
    }
}//AudioEncoding class
