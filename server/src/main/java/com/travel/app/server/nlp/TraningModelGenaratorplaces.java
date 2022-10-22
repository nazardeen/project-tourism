package com.travel.app.server.nlp;

import opennlp.tools.doccat.*;
import opennlp.tools.ml.EventTrainer;
import opennlp.tools.util.*;
import org.springframework.util.ResourceUtils;

import java.io.*;

public class TraningModelGenaratorplaces {

    public static void main(String[] args) throws IOException {
        generateModels();
    }

    public static void generateModels() throws IOException {

        File file = ResourceUtils.getFile("src/main/resources/places-training-data.txt");
        InputStreamFactory inputStreamFactory = new MarkableFileInputStreamFactory(file);

        ObjectStream<String> lineStream = new PlainTextByLineStream(inputStreamFactory, "UTF-8");
        ObjectStream<DocumentSample> sampleStream = new DocumentSampleStream(lineStream);

        int minNgramSize = 1;
        int maxNgramSize = 6;
        DoccatFactory customFactory = new DoccatFactory(new FeatureGenerator[] { new BagOfWordsFeatureGenerator(),
                new NGramFeatureGenerator(minNgramSize, maxNgramSize) });
        TrainingParameters mlParams = new TrainingParameters();
        mlParams.put(TrainingParameters.ALGORITHM_PARAM, "MAXENT");
        mlParams.put(TrainingParameters.TRAINER_TYPE_PARAM, EventTrainer.EVENT_VALUE);
        mlParams.put(TrainingParameters.ITERATIONS_PARAM, 10);
        mlParams.put(TrainingParameters.CUTOFF_PARAM, 3);

        DoccatModel model = DocumentCategorizerME.train("en", sampleStream, mlParams, customFactory);

        try (OutputStream modelOut = new BufferedOutputStream(
                new FileOutputStream("src/main/resources/nlp-model/en-trained-modelplaces.bin"))) {
            model.serialize(modelOut);
        }
    }}


