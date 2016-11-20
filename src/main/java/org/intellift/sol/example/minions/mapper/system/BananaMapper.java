package org.intellift.sol.example.minions.mapper.system;

import org.intellift.sol.example.minions.domain.entity.system.Banana;
import org.intellift.sol.example.minions.dto.system.BananaDto;
import org.intellift.sol.example.minions.mapper.ReferenceMapper;
import org.intellift.sol.mapper.PageMapper;
import org.mapstruct.Mapper;

/**
 * @author Chrisostomos Bakouras
 */
@Mapper(uses = ReferenceMapper.class)
public interface BananaMapper extends PageMapper<Banana, BananaDto> {
}
