package ru.example.jsonbtest.app;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.example.jsonbtest.api.model.QuestionnaireData;
import ru.example.jsonbtest.app.entity.RegularFormInformation;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface JsonMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "formId", target = "formId"),
            @Mapping(source = "personId", target = "personId")
    })
    RegularFormInformation mapRawDataFromJson(Long formId, Long personId, QuestionnaireData source);
}
