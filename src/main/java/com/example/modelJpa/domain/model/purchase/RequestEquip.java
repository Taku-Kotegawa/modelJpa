package com.example.modelJpa.domain.model.purchase;

import com.example.modelJpa.domain.model.AbstractEntity;
import com.example.modelJpa.domain.model.equipment.EquipType;
import com.example.modelJpa.domain.model.organization.Employee;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comment;

import java.time.LocalDate;

@Comment("購入依頼")
@Entity
@Data
public class RequestEquip extends AbstractEntity<Long> {

    @Comment("購入依頼ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    @Comment("購入品名")
    private String equipName;

    @Comment("備品タイプ")
    @ManyToOne
    @JoinColumn(name = "equip_type_id", foreignKey = @ForeignKey(name = "fk_request_equip_01"))
    private EquipType equipType;

    @Comment("購入依頼者")
    @ManyToOne
    @JoinColumn(name = "requester_id", foreignKey = @ForeignKey(name = "fk_request_equip_02"))
    private Employee requesterId;

    @Comment("購入依頼日")
    private LocalDate requestDate;

    @Comment("購入依頼理由")
    private String reason;

    @Comment("ProgressStateID")
    private ProgressState progressState;

    @Comment("承認フローID")
    @OneToOne
    @JoinColumn(name = "approval_flow_id", foreignKey = @ForeignKey(name = "fk_request_equip_03"))
    private ApprovalFlow approvalFlow;

    @Comment("備考")
    private String note;


    @Override
    public Long getId() {
        return null;
    }
}
