package mc.sbm.operaconductor.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.io.Serializable;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Base abstract class for entities which will hold definitions for created, last modified, created by,
 * last modified by attributes.
 */
@SuperBuilder
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = { "tech_created_date", "tech_updated_date" }, allowGetters = true)
public abstract class AbstractAuditingEntitySBM<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    public abstract String getId();

    @CreationTimestamp
    @Column(name = "tech_created_date", updatable = false)
    private Timestamp techCreatedDate;

    @UpdateTimestamp
    @Column(name = "tech_updated_date")
    private Timestamp techUpdatedDate;

    public Timestamp getTechCreatedDate() {
        return techCreatedDate;
    }

    public void setTechCreatedDate(Timestamp techCreatedDate) {
        this.techCreatedDate = techCreatedDate;
    }

    public Timestamp getTechUpdatedDate() {
        return techUpdatedDate;
    }

    public void setTechUpdatedDate(Timestamp techUpdatedDate) {
        this.techUpdatedDate = techUpdatedDate;
    }
}
