package com.markmulvenna.synalogik.javatestsynalogik;


import java.io.IOException;
import java.net.URL;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import org.junit.jupiter.api.Test;

class JavaTestSynalogikApplicationTests {

    @Test
    void contextLoads() throws IOException {
        //Test the output with expected output from the bible text file.
        URL url = new URL("https://janelwashere.com/files/bible_daily.txt");
        WordsModel wordsModel = outputGenerator.generateWordsModel(url);
        assertThat(wordsModel.getLengthsOfWords().size(), equalTo(18));
        assertThat(wordsModel.getTotalWords(), equalTo(793826));
        assertThat(wordsModel.getAvgLength(), equalTo(4.209956589983196));
        assertThat(String.valueOf(wordsModel.getFrequenciesOfWordLengths().get(213300)), equalTo("[3]"));
    }



}
