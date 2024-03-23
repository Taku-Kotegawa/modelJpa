package com.example.modeljpa.domain.model.organization;

import com.example.modeljpa.domain.model.AbstractEntity;
import com.example.modeljpa.domain.model.common.Status;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comment;

import java.io.Serializable;

/**
 * 部署
 */
@Comment("部署")
@Data
@Entity
public class Organization extends AbstractEntity<Long> implements Serializable {

    @Comment("内部ID")
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 部署ID
     */
    @Comment("部署ID")
    @Column(nullable = false, updatable = false)
    private String organizationId;

    /**
     * ステータス
     */
    @Comment("ステータス")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    /**
     * 部署名
     */
    @Comment("部署名")
    @Column(nullable = false)
    private String organizationName;

    /**
     * 親部署ID
     */
    @Comment("親部署ID")
    private Long parentId;

    /**
     * 部門長ID
     */
    @Comment("部門長ID")
    private String directorId;

    @Override
    public Long getId() {
        return null;
    }
}
