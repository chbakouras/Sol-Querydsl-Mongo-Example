package org.intellift.sol.example.minions.dto.system;

import org.intellift.sol.example.minions.dto.AbstractDto;

/**
 * @author Chrisostomos Bakouras.
 */
public class MinionDto extends AbstractDto {

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
