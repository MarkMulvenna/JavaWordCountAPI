package com.markmulvenna.synalogik.javatestsynalogik;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.*;


@Data
public class WordsModel {


    //Set up variables to hold the necessary data which will be outputted to the user.
    private Long id;
    private TreeMap<Integer, Integer> lengthsOfWords;
    private HashMap<Integer, List<Integer>> frequenciesOfWordLengths;
    private int totalWords;
    private double avgLength;

    //Custom toString function to give more detailed custom output regarding the WordsModel
    @Override
    public String toString()
    {
        StringBuilder finalOutput = new StringBuilder();
        finalOutput.append("Total words = " + this.getTotalWords());
        finalOutput.append("<br> Average word length = " + String.format("%.3f", this.getAvgLength()));
        finalOutput.append(formatWordLengthBreakdown());
        finalOutput.append(getMostCommonWordLengthFormat());


        return finalOutput.toString();
    }

    //Get the most common word length in a format readable by the end user.
    private String getMostCommonWordLengthFormat() {
        String finalOutput = "";
        for (Map.Entry<Integer, List<Integer> > entry2 : frequenciesOfWordLengths.entrySet())
        {

            finalOutput = "<br>The most common word length is " + entry2.getKey() + " for word lengths of " + String.valueOf(entry2.getValue()).replaceAll("\\[|\\]", "").replace(",", " &");
        }
        return finalOutput;
    }

    //Get the most common word length breakdown in a format readable by the end user.
    public String formatWordLengthBreakdown()
    {
        String finalOutput;
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : this.getLengthsOfWords().entrySet())
        {
            sb.append("<br> Number of words of length " + entry.getKey() + " is " + entry.getValue());
        }
        finalOutput = sb.toString();

        return finalOutput;
    }




    //Getter & Setter for Word Lengths.
    public TreeMap<Integer, Integer> getLengthsOfWords() {
        return lengthsOfWords;
    }
    public void setLengthsOfWords(TreeMap<Integer, Integer> lengthsOfWords)
    {
        this.lengthsOfWords = lengthsOfWords;
    }

    //Getter & Setter for frequency of Word Lengths.
    public HashMap<Integer, List<Integer>> getFrequenciesOfWordLengths() {
        return frequenciesOfWordLengths;
    }

    public void setFrequenciesOfWordLengths(HashMap<Integer, List<Integer>> frequenciesOfWordLengths) {
        this.frequenciesOfWordLengths = frequenciesOfWordLengths;
    }

    //Getter & Setter for Total Words
    public void setTotalWords(int totalWords) {
        this.totalWords = totalWords;
    }
    public int getTotalWords() {
        return totalWords;
    }

    //Getter & Setter for Average Length.
    public void setAvgLength(double avgLength) {
        this.avgLength = avgLength;
    }
    public double getAvgLength() {
        return avgLength;
    }


    //Getter & Setter for unique ID
    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
