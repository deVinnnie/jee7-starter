package com.realdolmen.course.domain;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Defines common fields used by most AirportEntities.
 */
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Integer version;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDate;

    public AbstractEntity(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @PreUpdate
    @PrePersist
    public void updateLastUpdateDate(){
        this.lastUpdateDate = new Date();
    }
}
