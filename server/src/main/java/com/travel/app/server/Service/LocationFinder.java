package com.travel.app.server.Service;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import opennlp.tools.doccat.DoccatModel;
import opennlp.tools.doccat.DocumentCategorizerME;

@Service
public class LocationFinder {


    public static String findLocation(String input) throws IOException {
        System.out.println(input);
        File file = ResourceUtils.getFile("src/main/resources/nlp-model/en-trained-modelplaces.bin");
        InputStream in = new FileInputStream(file);
        DoccatModel m = new DoccatModel(in);
        DocumentCategorizerME myCategorizer = new DocumentCategorizerME(m);

        String[] inputText = input.split(" ");
        double[] outcomes = myCategorizer.categorize(inputText);
        String place = myCategorizer.getBestCategory(outcomes);
        System.out.println(place);
        return place;
    }
}
