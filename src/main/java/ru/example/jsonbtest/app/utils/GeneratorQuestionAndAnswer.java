package ru.example.jsonbtest.app.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Slf4j
@RequiredArgsConstructor
public class GeneratorQuestionAndAnswer {

    private final Map<String, String> resultMap = new HashMap<>(61);

    private static final Map<Integer, String> QUESTIONS_MAP = new HashMap<>(61);
    private static final Map<Integer, List<String>> ANSWERS_MAP = new HashMap<>(61);

    private static final String OUT_FILE = "out/out.json";

    private final ObjectMapper objectMapper;

    public Map<String, String> getFormWithRandomAnswers() throws IOException {
        if (CollectionUtils.isEmpty(this.resultMap)) {
            fillQuestions();
            fillAnswers();
        } else {
            resultMap.clear();
        }

        QUESTIONS_MAP.forEach((questionNum, question) -> {
            if (ANSWERS_MAP.containsKey(questionNum)) {
                int i = new Random().nextInt(3);

                resultMap.put(question, ANSWERS_MAP.get(questionNum).get(i));
            }
        });

        log.info("[JSON_SAVE_TO_FILE] Сохраняем подготовленный JSON в файл: {}", OUT_FILE);
        objectMapper.writeValue(new File(OUT_FILE), resultMap);

        return resultMap;
    }

    public JsonNode getJson() throws IOException {
        if (CollectionUtils.isEmpty(this.resultMap)) {
            getFormWithRandomAnswers();
        }

        return objectMapper.valueToTree(resultMap);
    }

    private void fillAnswers() {
        try (BufferedReader reader =  new BufferedReader(new FileReader("answers.txt"))) {
            List<String> listWithAnswerForQuestion = new ArrayList<>(3);
            String str;
            Integer countOfQuestion = 1;
            int countOfAnswers = 0;


            while ((str = reader.readLine()) != null) {
                if (countOfAnswers != 3) {
                    listWithAnswerForQuestion.add(str);

                    countOfAnswers++;
                } else {
                    ANSWERS_MAP.put(countOfQuestion, new ArrayList<>(listWithAnswerForQuestion));

                    countOfAnswers = 0;
                    countOfQuestion++;

                    listWithAnswerForQuestion.clear();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void fillQuestions() {
        try (BufferedReader reader =  new BufferedReader(new FileReader("question.txt"))) {
            String str;
            Integer countOfQuestion = 1;

            while ((str = reader.readLine()) != null) {
                QUESTIONS_MAP.put(countOfQuestion, str);

                countOfQuestion++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
