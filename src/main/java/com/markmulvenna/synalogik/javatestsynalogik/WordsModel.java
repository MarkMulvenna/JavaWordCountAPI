package com.markmulvenna.synalogik.javatestsynalogik;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class WordsModel {


    //Set up variables to hold the necessary data which will be outputted to the user.
    private Long id;
    private int totalWords;
    private double avgLength;
    private int lengthFrequency;




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

    //Getter and Setter for Length Frequency.
    public void setLengthFrequency(int lengthFrequency) {
        this.lengthFrequency = lengthFrequency;
    }

    public int lengthFrequency()
    {
        return lengthFrequency;
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
