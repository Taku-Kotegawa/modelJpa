package com.example.modelJpa.domain.model.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Yes/No
 */
@AllArgsConstructor
@Getter
public enum YesNo {

    YES("1", "はい"),
    NO("0", "いいえ");

    private final String value;
    private final String label;

}
