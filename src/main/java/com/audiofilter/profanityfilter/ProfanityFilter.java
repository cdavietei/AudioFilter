package com.audiofilter.profanityfilter;

import java.util.*;
import java.io.*;

import lombok.*;
import lombok.experimental.Accessors;

import com.audiofilter.api.google.types.*;

public class ProfanityFilter {

    //TODO: Change this for production
    public static final String SWEARS_FILE = "data/filters/swears-fake.txt";

    protected static Set<String> BLACK_LIST;

    @Accessors(prefix = "m") @Getter
    protected List<WordInfo> mSelection;

    public ProfanityFilter() {
        setup(SWEARS_FILE);
    }//ProfanityFilter()

    public ProfanityFilter(String filePath) {
        setup(filePath);
    }//ProfanityFilter(String)

    protected void setup(String filePath) {

        mSelection = new LinkedList<>();

        if(BLACK_LIST != null && !BLACK_LIST.isEmpty()) return;

        setupBlacklist(filePath);
    }//setup()

    protected void setupBlacklist(String filePath) {
        BLACK_LIST = new HashSet<String>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            while(reader.ready()) {
                String word = prepareWord(reader.readLine());
                BLACK_LIST.add(word);
            }//while ready

            reader.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }//catch
    }

    protected String prepareWord(String word) {
        //Steps:
        //  Remove non-alphanumeric characters
        //  Convert to lowercase
        return word.replaceAll("\\P{L}","").toLowerCase();
    }//prepareWord(String)

    protected void identify(SpeechRecognitionAlternative list) {
        List<WordInfo> wordList = list.getWords();

        for(WordInfo info : wordList) {
            String curWord = prepareWord(info.getWord());
            if(BLACK_LIST.contains(curWord))
                mSelection.add(info);
        }//foreach WordInfo
    }//identify(SpeechRecognitionAlternative)
}//ProfanityFilter
