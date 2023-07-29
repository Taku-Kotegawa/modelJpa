package com.example.modelJpa.domain.model.equipment;

import com.example.modelJpa.domain.model.AbstractEntity;
import com.example.modelJpa.domain.model.organization.Employee;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comment;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 部品管理台帳
 */
@Comment("部品管理台帳")
@Entity
@Data
public class ManageEquip extends AbstractEntity<Long> implements Serializable {

    /**
     * 備品ID
     */
    @Comment("備品ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long equipId;

    /**
     * 備品名
     */
    @Comment("備品名")
    @Column(nullable = false)
    private String equipName;

    /**
     * 備品タイプ
     */
    @Comment("備品タイプ")
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_manage_equip_01"))
    private EquipType equipType;

    /**
     * 所有者(利用者)
     */
    @Comment("所有者(利用者)")
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_manage_equip_02"))
    private Employee ownerId;

    /**
     * 購入日
     */
    @Comment("購入日")
    @Column(nullable = false)
    private LocalDate purchaseDate;

    /**
     * メモ
     */
    @Comment("メモ")
    private String note;


    // TODO 購入依頼との紐付け

    @Override
    public Long getId() {
        return null;
    }
}
