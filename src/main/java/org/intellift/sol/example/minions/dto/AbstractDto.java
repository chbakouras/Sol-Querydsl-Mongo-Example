package org.intellift.sol.example.minions.dto;

import org.intellift.sol.domain.Identifiable;

/**
 * @author Chrisostomos Bakouras.
 */
public class AbstractDto implements Identifiable<String> {

    private String id;

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
