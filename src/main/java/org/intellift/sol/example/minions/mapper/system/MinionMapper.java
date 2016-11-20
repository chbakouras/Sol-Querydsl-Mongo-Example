package org.intellift.sol.example.minions.mapper.system;

import org.intellift.sol.example.minions.domain.entity.system.Minion;
import org.intellift.sol.example.minions.dto.system.MinionDto;
import org.intellift.sol.mapper.PageMapper;
import org.mapstruct.Mapper;

/**
 * @author Chrisostomos Bakouras.
 */
@Mapper(uses = BananaMapper.class)
public interface MinionMapper extends PageMapper<Minion, MinionDto> {
}
