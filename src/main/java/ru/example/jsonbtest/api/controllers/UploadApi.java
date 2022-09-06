package ru.example.jsonbtest.api.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.example.jsonbtest.api.model.QuestionnaireData;

public interface UploadApi {

    @ApiOperation(value = "", tags = "UploadApi")
    @ApiResponse(code = 200, message = "Сохранение в формате JSONB")
    @PostMapping
    ResponseEntity<String> jsonbSaveViaUploadJson(@RequestParam(value = "formId") Long formId,
                                                  @RequestParam(value = "personId") Long personId,
                                                  @RequestBody QuestionnaireData formData,
                                                  @RequestParam(value = "countOfDuplicate",
                                                                defaultValue = "1") int countOfDuplicate);

    @ApiOperation(value = "", tags = "UploadApi")
    @ApiResponse(code = 200, message = "Сохранение размазыванием по БД сведений JSON")
    @PostMapping
    ResponseEntity<String> regularSaveViaUploadJson(@RequestParam(value = "formId") Long formId,
                                                    @RequestParam(value = "personId") Long personId,
                                                    @RequestBody QuestionnaireData formData,
                                                    @RequestParam(value = "countOfDuplicate",
                                                                  defaultValue = "1") int countOfDuplicate);

    @ApiOperation(value = "", tags = "UploadApi")
    @ApiResponse(code = 200, message = "Возвращает все анкеты гражданина по его идентификатору")
    @GetMapping
    ResponseEntity<?> getAllQuestionnaireInfoByPersonId(@RequestParam(value = "personId") Long personId);

    @ApiOperation(value = "", tags = "UploadApi")
    @ApiResponse(code = 200, message = "Возвращает данные анкеты по ее идентификатору")
    @GetMapping
    ResponseEntity<?> getDataByFormId(@RequestParam(value = "formId") Long formId);
}
