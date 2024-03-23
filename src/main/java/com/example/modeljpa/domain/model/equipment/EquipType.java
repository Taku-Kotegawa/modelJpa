package com.example.modeljpa.domain.model.equipment;

import com.example.modeljpa.domain.model.AbstractEntity;
import com.example.modeljpa.domain.model.common.Status;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comment;

import java.io.Serializable;

/**
 * 備品タイプ
 */
@Comment("備品タイプ")
@Data
@Entity
public class EquipType extends AbstractEntity<Long> implements Serializable {

    /**
     * 備品タイプID
     */
    @Comment("備品タイプID")
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long equipTypeId;

    /**
     * 備品タイプ名
     */
    @Comment("備品タイプ名")
    @Column(nullable = false)
    private String equipType;

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
