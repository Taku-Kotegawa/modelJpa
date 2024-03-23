package com.example.modeljpa.domain.model.purchase;

import com.example.modeljpa.domain.model.AbstractEntity;
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
    private String fistApprover;

    @Comment("第２承認者")
    private String secondApprover;

    @Override
    public Long getId() {
        return null;
    }
}
