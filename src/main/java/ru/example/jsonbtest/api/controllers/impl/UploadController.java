package ru.example.jsonbtest.api.controllers.impl;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.example.jsonbtest.api.controllers.UploadApi;
import ru.example.jsonbtest.api.model.QuestionnaireData;
import ru.example.jsonbtest.app.services.FormService;

@RestController
@RequestMapping("/api/")
@AllArgsConstructor
@Api(tags = "UploadApi", value = "Загрузка анкет в формате JSON для сохранения в БД")
public class UploadController implements UploadApi {

    private final FormService formService;

    @Override
    @PostMapping("upload-jsonb/")
    public ResponseEntity<String> jsonbSaveViaUploadJson(Long formId, Long personId, QuestionnaireData formData, int countOfDuplicate) {
        formService.saveToJsonbOrRegular(formId, personId, formData, true, countOfDuplicate);

        return ResponseEntity.ok("Saved!");
    }

    @Override
    @PostMapping("upload-regular")
    public ResponseEntity<String> regularSaveViaUploadJson(Long formId, Long personId, QuestionnaireData formData, int countOfDuplicate) {
        formService.saveToJsonbOrRegular(formId, personId, formData, false, countOfDuplicate);

        return ResponseEntity.ok("Saved!");
    }

    @Override
    @GetMapping("get-all-form-by-person")
    public ResponseEntity<?> getAllQuestionnaireInfoByPersonId(Long personId) {
        return ResponseEntity.ok("Something!");
    }

    @Override
    @GetMapping("get-data-by-form")
    public ResponseEntity<?> getDataByFormId(Long formId) {
        return ResponseEntity.ok("Something!");
    }
}
