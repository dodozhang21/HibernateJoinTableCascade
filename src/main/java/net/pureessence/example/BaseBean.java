package net.pureessence.example;

import java.io.Serializable;

public class BaseBean implements Serializable {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
