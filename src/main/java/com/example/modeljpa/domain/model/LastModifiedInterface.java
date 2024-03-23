package com.example.modeljpa.domain.model;

import java.time.LocalDateTime;

public interface LastModifiedInterface {

    String getLastModifiedBy();

    LocalDateTime getLastModifiedDate();

    void setLastModifiedBy(String lastModifiedBy);

    void setLastModifiedDate(LocalDateTime lastModifiedDate);

}
