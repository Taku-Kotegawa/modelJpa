package com.example.modelJpa.domain.model.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ステータス.
 */
@AllArgsConstructor
@Getter
public enum Status {

    DRAFT("0", "下書き"),
    VALID("1", "有効"),
    INVALID("2", "無効");

    private final String value;
    private final String label;

}
