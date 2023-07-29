package com.example.modelJpa.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.Comment;

/**
 * テストマスター
 */
@Entity
@Comment("テストマスター")
public class TestMaster {

    /**
     * 主キー
     */
    @Id
    @Column(nullable = false)
    @Comment("主キー")
    private String id;

    /**
     * テスト項目
     */
    @Comment("テスト項目")
    private String test;

    public String getId() {
        return id;
    }

}
