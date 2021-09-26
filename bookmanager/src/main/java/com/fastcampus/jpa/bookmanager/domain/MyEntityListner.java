package com.fastcampus.jpa.bookmanager.domain;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class MyEntityListner {

    // Listener의 파라미터는 반드시 Object가 되어야 한다. Entity 객체에서는 파라라미터를 받지 않아도 this의 값이기 때문에 파라미터를 받지 않아도 값을 알 수 있지만
    // Listener는 Entity 객체를 받아서 사용할시 해당 Object가 어떤 타입인지 알기 어렵기 때문이다.
    @PrePersist
    public void prePersist(Object o) {
        if (o instanceof Auditable) {
            ((Auditable) o).setCreatedAt(LocalDateTime.now());
            ((Auditable) o).setUpdatedAt(LocalDateTime.now());
        }
    }

    @PreUpdate
    public void preUpdate(Object o) {
        if (o instanceof Auditable) {
            ((Auditable) o).setUpdatedAt(LocalDateTime.now());
        }
    }
}
