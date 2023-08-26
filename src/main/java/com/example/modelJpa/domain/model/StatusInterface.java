package com.example.modelJpa.domain.model;

public interface StatusInterface {

    /**
     * ステータスの設定
     *
     * @param status ステータス
     */
    void setStatus(String status);

    /**
     * ステータスの取得
     *
     * @return ステータスのコード
     */
    String getStatus();

}
