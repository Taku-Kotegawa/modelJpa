package com.example.modelJpa.domain.model.organization;

import com.example.modelJpa.domain.model.AbstractEntity;
import com.example.modelJpa.domain.model.common.Status;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comment;

import java.io.Serializable;

/**
 * 役職
 */
@Comment("役職")
@Data
@Entity
public class Position extends AbstractEntity<Long> implements Serializable {


    /**
     * 役職ID
     */
    @Comment("役職ID")
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long positionId;

    /**
     * 役職名
     */
    @Comment("役職名")
    @Column(nullable = false)
    private String positionName;

    /**
     * ステータス
     */
    @Comment("ステータス")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Override
    public Long getId() {
        return null;
    }
}
