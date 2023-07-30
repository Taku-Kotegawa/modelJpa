package com.example.modelJpa.domain.model.purchase;

import com.example.modelJpa.domain.model.AbstractEntity;
import com.example.modelJpa.domain.model.organization.Employee;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comment;


/**
 * 承認フロー
 */
@Comment("承認フロー")
@Entity
@Data
public class ApprovalFlow extends AbstractEntity<Long> {

    @Comment("承認フローID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long approvalFlowId;

    @Comment("第１承認者")
    @ManyToOne
    @JoinColumn(name = "fist_approver", foreignKey = @ForeignKey(name = "fk_approval_flow_01"))
    private Employee fistApprover;

    @Comment("第２承認者")
    @ManyToOne
    @JoinColumn(name = "second_approver", foreignKey = @ForeignKey(name = "fk_approval_flow_02"))
    private Employee secondApprover;

    @Override
    public Long getId() {
        return null;
    }
}
