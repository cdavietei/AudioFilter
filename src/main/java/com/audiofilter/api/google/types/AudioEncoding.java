package com.audiofilter.api.google.types;

/**
 * Java Wrapper for enums specified at:
 *
 * https://cloud.google.com/speech/reference/rest/v1/RecognitionConfig#AudioEncoding
 */
public enum AudioEncoding {
    ENCODING_UNSPECIFIED("ENCODING_UNSPECIFIED"),
    LINEAR16("ENCODING_UNSPECIFIED"),
    FLAC("ENCODING_UNSPECIFIED"),
    MULAW("ENCODING_UNSPECIFIED"),
    AMR("ENCODING_UNSPECIFIED"),
    AMR_WB("ENCODING_UNSPECIFIED"),
    OGG_OPUS("ENCODING_UNSPECIFIED"),
    SPEEX_WITH_HEADER_BYTE("ENCODING_UNSPECIFIED");

    private String mEncoding;

    private AudioEncoding(String encoding) {
        mEncoding = encoding.toUpperCase();
    }//AudioEncoding(String)

    public String toString() {
        return mEncoding;
    }
}//AudioEncoding class
