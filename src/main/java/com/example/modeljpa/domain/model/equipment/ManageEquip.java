package com.example.modeljpa.domain.model.equipment;

import com.example.modeljpa.domain.model.AbstractEntity;
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
    @JoinColumn(name = "equip_type_id", foreignKey = @ForeignKey(name = "fk_manage_equip_01"))
    private EquipType equipType;

    /**
     * 所有者(利用者)
     */
    @Comment("所有者(利用者)")
    private String ownerId;

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
    @Column(columnDefinition = "text")
    private String note;

    /**
     * 購入依頼ID
     */
    @Comment("購入依頼ID")
    private Long requestId;

    @Override
    public Long getId() {
        return null;
    }
}
