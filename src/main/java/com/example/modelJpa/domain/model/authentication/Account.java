package com.example.modelJpa.domain.model.authentication;


import com.example.modelJpa.domain.model.AbstractEntity;
import com.example.modelJpa.domain.model.StatusInterface;
import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Comment;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.List;

/**
 * ユーザアカウントエンティティ
 */
@Comment("ユーザアカウント")
@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
@Table(indexes = {@Index(columnList = "apiKey", unique = true)})
public class Account extends AbstractEntity<String> implements Serializable, StatusInterface {

    /**
     * ユーザID
     */
    @Comment("ユーザID")
    @Id
    @Column(nullable = false, updatable = false)
    private String username;

    /**
     * パスワード
     */
    @Comment("パスワード")
    private String password;

    /**
     * 名
     */
    @Comment("名")
    private String firstName;

    /**
     * 姓
     */
    @Comment("姓")
    private String lastName;

    /**
     * 所属
     */
    @Comment("所属")
    private String department;

    /**
     * メールアドレス
     */
    @Comment("メールアドレス")
    private String email;

    /**
     * URL
     */
    @Comment("URL")
    private String url;

    /**
     * プロフィール
     */
    @Column(length = 1000)
    @Comment("プロフィール")
    private String profile;

    /**
     * ロール
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @Comment("ロール")
    private List<Role> roles;

    /**
     * ステータス
     */
    @Comment("ステータス")
    private String status;

    /**
     * 画像UUID
     */
    @Comment("画像UUID")
    private String imageUuid;

    /**
     * API KEY
     */
    @Column(unique = true)
    @Comment("API KEY")
    private String apiKey;

    /**
     * ログイン許可IPアドレス
     */
    @Comment("ログイン許可IPアドレス")
    private String allowedIp;

    @Override
    public String getId() {
        return username;
    }

    @Override
    public boolean isNew() {
        return getVersion() == null;
    }

    public String getFullName() {

        if (StringUtils.isAllBlank(lastName, firstName)) {
            return "";
        } else if (StringUtils.isAllBlank(lastName)) {
            return firstName;
        } else if (StringUtils.isAllBlank(firstName)) {
            return lastName;
        }
        return lastName + " " + firstName;
    }

}
