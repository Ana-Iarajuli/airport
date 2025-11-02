package com.solvd.airport.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordCounter {

    private static final Logger logger = LogManager.getLogger(WordCounter.class);

    public static void main(String[] args) throws IOException {
        String filePath = "src/main/resources/How airport system works.txt";

        Set<String> uniqueWords = readUniqueWords(filePath);

        logger.info("Total unique words: " + uniqueWords.size());
            
    }

    public static Set<String> readUniqueWords(String filePath) throws IOException {
        Set<String> uniqueWords = new HashSet<>();

        try {
            String content = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

            String[] words = StringUtils.split(content, "\\s+");

            for (String word : words) {
                String cleanedWord = StringUtils.lowerCase(word);
                cleanedWord = StringUtils.replacePattern(cleanedWord, "[^a-z0-9]", "");

                if (StringUtils.isNotBlank(cleanedWord)) { 
                    uniqueWords.add(cleanedWord);
                }
            }
        } catch (IOException e) {
            logger.error("Error: " + e.getMessage());
        }
        return uniqueWords;
    }
}
