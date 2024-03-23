package com.example.modeljpa.domain.model.organization;

import com.example.modeljpa.domain.model.AbstractEntity;
import com.example.modeljpa.domain.model.common.Status;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comment;

import java.io.Serializable;

/**
 * 従業員
 */
@Comment("従業員")
@Entity
@Data
public class Employee extends AbstractEntity<Long> implements Serializable {

    @Comment("内部ID")
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 従業員ID
     */
    @Comment("従業員ID")
    @Column(nullable = false, updatable = false)
    private String empId;

    /**
     * ステータス
     */
    @Comment("ステータス")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    /**
     * 従業員氏名
     */
    @Comment("従業員氏名")
    @Column(nullable = false)
    private String empName;

    /**
     * パスワード
     */
    @Comment("パスワード")
    @Column(nullable = false)
    private String password;

    /**
     * メールアドレス
     */
    @Comment("メールアドレス")
    private String email;

    /**
     * 所属部署
     */
    @Comment("所属部署")
    private String organizationId;

    /**
     * 役職
     */
    @Comment("役職")
    private String positionId;

    @Override
    public Long getId() {
        return null;
    }
}
