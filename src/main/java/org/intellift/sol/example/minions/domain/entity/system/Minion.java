package org.intellift.sol.example.minions.domain.entity.system;

import org.intellift.sol.example.minions.domain.entity.AbstractEntity;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Chrisostomos Bakouras.
 */
@Document
public class Minion extends AbstractEntity {

    private String name;

    private Integer despicability;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDespicability() {
        return despicability;
    }

    public void setDespicability(Integer despicability) {
        this.despicability = despicability;
    }
}
