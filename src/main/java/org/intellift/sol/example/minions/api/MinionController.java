package org.intellift.sol.example.minions.api;

import org.intellift.sol.example.minions.domain.entity.system.Minion;
import org.intellift.sol.example.minions.dto.system.MinionDto;
import org.intellift.sol.example.minions.mapper.system.MinionMapper;
import org.intellift.sol.example.minions.service.MinionServiceImpl;
import com.querydsl.core.types.Predicate;
import org.intellift.sol.controller.querydsl.api.QueryDslCrudApiController;
import org.intellift.sol.mapper.PageMapper;
import org.intellift.sol.service.querydsl.QueryDslCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chrisostomos Bakouras.
 */
@RestController
@RequestMapping("/minions")
public class MinionController implements QueryDslCrudApiController<Minion, MinionDto, String> {

    private final MinionServiceImpl minionService;

    private final MinionMapper minionMapper;

    @Autowired
    public MinionController(MinionServiceImpl minionService, MinionMapper minionMapper) {
        this.minionService = minionService;
        this.minionMapper = minionMapper;
    }

    @Override
    public Class<Minion> getEntityClass() {
        return Minion.class;
    }

    @Override
    public PageMapper<Minion, MinionDto> getEntityMapper() {
        return minionMapper;
    }

    @Override
    public QueryDslCrudService<Minion, String> getEntityService() {
        return minionService;
    }

    @Override
    public ResponseEntity<Page<MinionDto>> getAll(@QuerydslPredicate(root = Minion.class) Predicate predicate, Pageable pageable) {
        return getAllDefaultImplementation(predicate, pageable);
    }
}
