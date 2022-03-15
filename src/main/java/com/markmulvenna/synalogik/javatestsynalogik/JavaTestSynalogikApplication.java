package com.markmulvenna.synalogik.javatestsynalogik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.TreeMap;

@SpringBootApplication
@RestController
public class JavaTestSynalogikApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaTestSynalogikApplication.class, args);
    }

    @GetMapping("/word-counter")
    public String generateOutputFromURL(@RequestParam(value = "url", defaultValue = "No URL Detected, please try again.") String urlInput) {
        try {
            //Generate a new WordsModel object, and generate a WordsModel based on a given URL, return the string of words model to the user on frontend.
            URL url = new URL(urlInput);
            WordsModel wordsModel = outputGenerator.generateWordsModel(url);
            return wordsModel.toString();
        }
        catch (IOException ex)
        {
            return null;
        }


    }


}
