package com.example.modelJpa.domain.model.purchase;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ProgressState
 */
@AllArgsConstructor
@Getter
public enum ProgressState {

    DRAFT("0", "下書き"),
    APPROVING("1", "承認待ち"),
    ORDERING("2", "注文中"),
    COMPLETE("3", "完了");

    private final String value;
    private final String label;

}
