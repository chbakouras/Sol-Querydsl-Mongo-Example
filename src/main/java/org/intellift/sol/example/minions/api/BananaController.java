package org.intellift.sol.example.minions.api;

import org.intellift.sol.example.minions.domain.entity.system.Banana;
import org.intellift.sol.example.minions.dto.system.BananaDto;
import org.intellift.sol.example.minions.mapper.system.BananaMapper;
import org.intellift.sol.example.minions.service.BananaServiceImpl;
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
@RequestMapping("/bananas")
public class BananaController implements QueryDslCrudApiController<Banana, BananaDto, String> {

    private final BananaServiceImpl bananaService;

    private final BananaMapper bananaMapper;

    @Autowired
    public BananaController(BananaServiceImpl bananaService, BananaMapper bananaMapper) {
        this.bananaService = bananaService;
        this.bananaMapper = bananaMapper;
    }

    @Override
    public Class<Banana> getEntityClass() {
        return Banana.class;
    }

    @Override
    public PageMapper<Banana, BananaDto> getEntityMapper() {
        return bananaMapper;
    }

    @Override
    public QueryDslCrudService<Banana, String> getEntityService() {
        return bananaService;
    }

    @Override
    public ResponseEntity<Page<BananaDto>> getAll(@QuerydslPredicate(root = Banana.class) Predicate predicate, Pageable pageable) {
        return getAllDefaultImplementation(predicate, pageable);
    }
}
