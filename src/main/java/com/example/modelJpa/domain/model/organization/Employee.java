package com.example.modelJpa.domain.model.organization;

import com.example.modelJpa.domain.model.AbstractEntity;
import com.example.modelJpa.domain.model.common.Status;
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

    /**
     * 従業員ID
     */
    @Comment("従業員ID")
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

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
    @ManyToOne
    @JoinColumn(name = "organization_id", foreignKey = @ForeignKey(name = "fk_employee_01"))
    private Organization organization;

    /**
     * 役職
     */
    @Comment("役職")
    @ManyToOne
    @JoinColumn(name = "position_id", foreignKey = @ForeignKey(name = "fk_employee_02"))
    private Position position;

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
