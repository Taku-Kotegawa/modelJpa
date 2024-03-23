package com.example.modeljpa.domain.model.organization;

import com.example.modeljpa.domain.model.AbstractEntity;
import com.example.modeljpa.domain.model.common.Status;
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

    @Comment("内部ID")
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 役職ID
     */
    @Comment("役職ID")
    @Column(nullable = false, updatable = false)
    private String positionId;

    /**
     * ステータス
     */
    @Comment("ステータス")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    /**
     * 役職名
     */
    @Comment("役職名")
    @Column(nullable = false)
    private String positionName;

    @Override
    public Long getId() {
        return null;
    }
}
