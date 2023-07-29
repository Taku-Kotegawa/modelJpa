package com.example.modelJpa.domain.model.equipment;

import com.example.modelJpa.domain.model.AbstractEntity;
import com.example.modelJpa.domain.model.common.CheckStatus;
import com.example.modelJpa.domain.model.organization.Employee;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comment;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 棚卸し履歴
 */
@Comment("棚卸し履歴")
@Entity
@Data
public class ConfirmHistroy extends AbstractEntity<Long> implements Serializable {


    /**
     * 棚卸し履歴ID
     */
    @Comment("棚卸し履歴ID")
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long confirmId;

    /**
     * 備品ID
     */
    @Comment("備品ID")
    @Column(nullable = false, updatable = false)
    private Long equipId;

    /**
     * 確認日
     */
    @Column(nullable = false)
    private LocalDate executeDate;

    /**
     * 確認者
     */
    @ManyToOne
    @JoinColumn(name = "execute_by", foreignKey = @ForeignKey(name = "fk_confirm_history_01"))
    private Employee executeBy;

    /**
     * 確認ステータス
     */
    @Column(nullable = false)
    private CheckStatus checkStatus;


    @Override
    public Long getId() {
        return null;
    }
}
