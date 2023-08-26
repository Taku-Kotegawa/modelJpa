package com.example.modelJpa.domain.model.organization;

import com.example.modelJpa.domain.model.AbstractEntity;
import com.example.modelJpa.domain.model.common.Status;
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

    /**
     * 部署ID
     */
    @Comment("部署ID")
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long organizationId;

    /**
     * 部署名
     */
    @Comment("部署名")
    @Column(nullable = false)
    private String groupName; // TODO organizationName で良くない？

    /**
     * 親部署ID
     */
    @Comment("親部署ID")
    private Long parentId;

    /**
     * 部門長ID
     */
    @Comment("部門長ID")
    private Long directorId;

    /**
     * ステータス
     */
    @Comment("ステータス")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
//    @Column(nullable = false, columnDefinition = "varchar(255) default '0'")
    private Status status;


    @Override
    public Long getId() {
        return null;
    }
}
