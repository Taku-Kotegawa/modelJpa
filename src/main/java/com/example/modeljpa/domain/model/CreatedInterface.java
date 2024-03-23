package com.example.modeljpa.domain.model;

import java.time.LocalDateTime;

public interface CreatedInterface {

    String getCreatedBy();

    LocalDateTime getCreatedDate();

    void setCreatedBy(String createdBy);

    void setCreatedDate(LocalDateTime createdDate);

}
