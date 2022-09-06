package ru.example.jsonbtest.app.services;

import org.springframework.stereotype.Service;
import ru.example.jsonbtest.api.model.QuestionnaireData;

@Service
public interface FormService {

    void saveToJsonbOrRegular(Long formId, Long personId, QuestionnaireData formData, boolean isJsonbSave, int countOfDuplicate);

}
