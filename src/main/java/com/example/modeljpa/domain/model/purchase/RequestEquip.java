package com.example.modeljpa.domain.model.purchase;

import com.example.modeljpa.domain.model.AbstractEntity;
import com.example.modeljpa.domain.model.equipment.EquipType;
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

    @Comment("ProgressStateID")
    private ProgressState progressState;

    @Comment("購入品名")
    private String equipName;

    @Comment("備品タイプ")
    @ManyToOne
    @JoinColumn(name = "equip_type_id", foreignKey = @ForeignKey(name = "fk_request_equip_01"))
    private EquipType equipType;

    @Comment("購入依頼者")
    private String requesterId;

    @Comment("購入依頼日")
    private LocalDate requestDate;

    @Comment("購入依頼理由")
    private String reason;

    @Comment("承認フローID")
    @OneToOne
    @JoinColumn(name = "approval_flow_id", foreignKey = @ForeignKey(name = "fk_request_equip_02"))
    private ApprovalFlow approvalFlow;

    @Comment("備考")
    @Column(columnDefinition = "text")
    private String note;

    @Override
    public Long getId() {
        return null;
    }
}
