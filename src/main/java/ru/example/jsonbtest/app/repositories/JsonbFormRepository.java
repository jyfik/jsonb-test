package ru.example.jsonbtest.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.jsonbtest.app.entity.JsonbFormInformation;
import java.util.List;
import java.util.Optional;

@Repository
public interface JsonbFormRepository extends JpaRepository<JsonbFormInformation, Long> {

    Optional<JsonbFormInformation> getJsonbFormInformationByFormId(Long formId);

    List<JsonbFormInformation> getJsonbFormInformationByPersonId(Long personId);

}
