package ru.example.jsonbtest.app.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import ru.example.jsonbtest.api.model.QuestionnaireData;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@TypeDef(name = "json", typeClass = JsonType.class)
@Table(name = "form_info_jsonb")
public class JsonbFormInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "form_id", nullable = false)
    private Long formId;

    @Column(name = "person_id", nullable = false)
    private Long personId;

//    @JdbcTypeCode(SqlTypes.JSON)
    @Type(type = "json")
    @Column(name = "raw_data", nullable = false, columnDefinition = "jsonb")
    private QuestionnaireData rawData;

}
