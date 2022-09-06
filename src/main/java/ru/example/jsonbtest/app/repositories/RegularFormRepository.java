package ru.example.jsonbtest.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.jsonbtest.app.entity.RegularFormInformation;
import java.util.List;
import java.util.Optional;

@Repository
public interface RegularFormRepository extends JpaRepository<RegularFormInformation, Long> {

    Optional<RegularFormInformation> getRegularFormInformationByFormId(Long formId);

    List<RegularFormInformation> getRegularFormInformationByPersonId(Long personId);

}
