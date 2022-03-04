package com.betbull.teamservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "creDate", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime creDate = LocalDateTime.now();

    @Column(name = "updDate", nullable = false)
    @LastModifiedDate
    private LocalDateTime updDate = LocalDateTime.now();

    @Override
    public int hashCode() {
        return (getId() == null) ? System.identityHashCode(this) : getId().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        if (org.hibernate.Hibernate.getClass(this) != org.hibernate.Hibernate.getClass(obj))
            return false;
        BaseEntity other = (BaseEntity) obj;
        if (getId() == null || other.getId() == null)
            return false;
        return getId().equals(other.getId());
    }
}