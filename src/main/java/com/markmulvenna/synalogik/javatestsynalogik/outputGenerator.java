package com.markmulvenna.synalogik.javatestsynalogik;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;


public class outputGenerator {

    /* This class handles the operation of setting the WordsModel and, where necessary, formatting for readability for the final output. Items are always set, in case the scope of the API were to expand past simple output, and
    formatting is done to ensure readable output in the current scope of the API
     */


    public static WordsModel generateWordsModel(URL url) throws IOException {
        WordsModel wordsModel = new WordsModel();

        //TreeMap to hold ordered list of word lengths, with the key being the actual length and the value being the amount of occurences.
        TreeMap<Integer, Integer> mapOfLength = new TreeMap<>();
        int scanValueLength;
        Scanner s = new Scanner(new InputStreamReader(url.openStream()));

        while (s.hasNext())
        {
            scanValueLength = s.next().replace(".", "").length();
            if (mapOfLength.containsKey(scanValueLength))
            {
                int currentLengthTotal = mapOfLength.get(scanValueLength);
                int updatedLengthTotal = currentLengthTotal+1;
                mapOfLength.replace(scanValueLength,currentLengthTotal, updatedLengthTotal);
            }
            else {
                mapOfLength.put(scanValueLength, 1);
            }
        }

        //Now the TreeMap is initialised, move on to finding other aspects of the WordsModel object
        wordsModel.setLengthsOfWords(mapOfLength);
        findTotalWords(wordsModel);
        findAverageLength(wordsModel);
        findMostFrequent(wordsModel);
        return wordsModel;
    }

    public static void findTotalWords(WordsModel wordsModel)
    {
        int totalWords = 0;
        for (Map.Entry<Integer, Integer> entry : wordsModel.getLengthsOfWords().entrySet()) //Loop through wordsModel treemap, set current key, value set as entry
        {
            totalWords += entry.getValue(); //When a new key is found, get the value amount associated and add it to totalWords
        }
        wordsModel.setTotalWords(totalWords);
    }

    private static void findAverageLength(WordsModel wordsModel)
    {
        double averageWordLength =0d;
        for (Map.Entry<Integer, Integer> entry : wordsModel.getLengthsOfWords().entrySet()) //Loop through wordsModel treemap, set current key, value set as entry
        {
            averageWordLength += (entry.getValue() * entry.getKey()); //For the keys and values, multiply them both and add to averageWordLength
        }
        averageWordLength /= wordsModel.getTotalWords(); //Divide keys and values multiplication by the total words to get the average.
        wordsModel.setAvgLength(averageWordLength);
    }

    private static void findMostFrequent(WordsModel wordsModel)
    {
        int mostFrequentValue = Collections.max(wordsModel.getLengthsOfWords().values()); //Get the most frequent word length
        HashMap<Integer, List<Integer>> frequenciesOfWordLengths = new HashMap<>();
        List<Integer> keysOfMostFrequent = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : wordsModel.getLengthsOfWords().entrySet()) //Loop through wordsModel treemap, set current key, value set as entry
        {
            if (entry.getValue()==mostFrequentValue) //Check if the current keys value is equal to the most common length, if it is, add that key to the list of keysOfMostFrequent.
            {
                keysOfMostFrequent.add(entry.getKey());
            }
        }
        frequenciesOfWordLengths.put(mostFrequentValue, keysOfMostFrequent);
        wordsModel.setFrequenciesOfWordLengths(frequenciesOfWordLengths);
    }
}
