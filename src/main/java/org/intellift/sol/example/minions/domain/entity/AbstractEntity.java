package org.intellift.sol.example.minions.domain.entity;

import org.intellift.sol.domain.Identifiable;
import org.springframework.data.annotation.Id;

/**
 * @author Chrisostomos Bakouras.
 */
public class AbstractEntity implements Identifiable<String> {

    @Id
    protected String id;

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
