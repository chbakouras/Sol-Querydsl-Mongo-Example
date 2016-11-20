package org.intellift.sol.example.minions.dto.system;

import org.intellift.sol.example.minions.dto.AbstractDto;
import org.intellift.sol.example.minions.dto.Reference;

/**
 * @author Chrisostomos Bakouras.
 */
public class BananaDto extends AbstractDto {

    private Double juicy;

    public Double getJuicy() {
        return juicy;
    }

    public void setJuicy(Double juicy) {
        this.juicy = juicy;
    }
}
