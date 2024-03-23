package com.example.modeljpa.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;

import java.time.LocalDateTime;

/**
 * 抽象エンティティ(履歴管理なし).
 *
 * @param <ID> 主キーのクラス
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@MappedSuperclass
public abstract class AbstractEntity<ID> implements Persistable<ID> {

    /**
     * バージョン(排他制御用)
     */
    @Comment("バージョン(排他制御用)")
    @Version
    @Column(nullable = false)
    private Long version;

    /**
     * 作成者
     */
    @Comment("作成者")
    @CreatedBy
    @Column(nullable = false, updatable = false)
    private String createdBy;

    /**
     * 最終更新者
     */
    @Comment("最終更新者")
    @LastModifiedBy
    @Column(nullable = false)
    private String lastModifiedBy;

    /**
     * 作成日時
     */
    @Comment("作成日時")
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;

    /**
     * 最終更新日時
     */
    @Comment("最終更新日時")
    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime lastModifiedDate;

    @Override
    public boolean isNew() {
        return getVersion() == null;
    }

}