package ru.example.jsonbtest.app.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.example.jsonbtest.api.model.QuestionnaireData;
import ru.example.jsonbtest.app.JsonMapper;
import ru.example.jsonbtest.app.entity.JsonbFormInformation;
import ru.example.jsonbtest.app.repositories.JsonbFormRepository;
import ru.example.jsonbtest.app.repositories.RegularFormRepository;
import ru.example.jsonbtest.app.services.FormService;
import ru.example.jsonbtest.app.utils.GeneratorQuestionAndAnswer;
import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class FormServiceImpl implements FormService {

    private final JsonbFormRepository jsonbFormRepository;

    private final RegularFormRepository regularFormRepository;

    private final JsonMapper jsonMapper;

    @Override
    public void saveToJsonbOrRegular(Long formId, Long personId, QuestionnaireData formData, boolean isJsonbSave, int countOfDuplicate) {
        try {
            if (isJsonbSave) {
                log.info("[SAVE_WITH_JSONB_TYPE] Сохраняем данные в БД в виде типа Jsonb");

                for (int i = 0; i < countOfDuplicate; i++) {
                    jsonbFormRepository.save(mapToSaveInJsonb(formId + i, personId + i, formData));
                }
            } else {
                log.info("[SAVE_WITHOUT_JSONB_TYPE] Сохраняем данные в БД не используя тип Jsonb");

                for (int i = 0; i < countOfDuplicate; i++) {
                    regularFormRepository.save(jsonMapper.mapRawDataFromJson(formId + i, personId + i, formData));
                }
            }

            log.info("[SAVE_SUCCESS] Успешное сохранение записи в БД (isJsonbSave = {})", isJsonbSave);
        } catch (Exception e) {
            log.error("[SAVE_ERROR] При сохранении в БД произошла непредвиденная ошибка: {}", e.getMessage());
        }
    }

    private JsonbFormInformation mapToSaveInJsonb(Long formId, Long personId, QuestionnaireData formData)
            throws IOException {
        log.info("[MAP_JSON_TO_ENTITY] Преобразуем пришедшие данные для в объект для сохранения в БД");

        new GeneratorQuestionAndAnswer(new ObjectMapper()).getFormWithRandomAnswers();

        JsonbFormInformation entity = new JsonbFormInformation();
        entity.setFormId(formId);
        entity.setPersonId(personId);
        entity.setRawData(formData);

        return entity;
    }
}
