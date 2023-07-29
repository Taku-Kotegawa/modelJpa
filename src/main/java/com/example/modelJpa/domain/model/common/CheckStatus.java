package com.example.modelJpa.domain.model.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * チェックステータス
 */
@Getter
@RequiredArgsConstructor
public enum CheckStatus {

    UNCHECK("0", "未確認"),
    CHECKED("1", "確認済み");

    private final String value;
    private final String label;
}
