package org.intellift.sol.example.minions.domain.entity.system;

import org.intellift.sol.example.minions.domain.entity.AbstractEntity;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Chrisostomos Bakouras.
 */
@Document
public class Banana extends AbstractEntity {

    private Double juicy;

    public Double getJuicy() {
        return juicy;
    }

    public void setJuicy(Double juicy) {
        this.juicy = juicy;
    }
}
