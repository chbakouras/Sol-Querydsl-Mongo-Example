package org.intellift.sol.example.minions.client;

import org.intellift.sol.example.minions.domain.entity.system.Banana;
import org.intellift.sol.example.minions.dto.system.BananaDto;
import org.intellift.sol.sdk.client.PagedCrudApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.AsyncRestOperations;

/**
 * @author Chrisostomos Bakouras
 */
@Component
public class BananaClient extends PagedCrudApiClient<Banana, BananaDto, String> {

    @Autowired
    public BananaClient(AsyncRestOperations asyncRestOperations) {
        super(asyncRestOperations);
    }

    @Override
    public Class<BananaDto> getDtoClass() {
        return BananaDto.class;
    }

    @Override
    public String getBaseUrl() {
        return "http://localhost:8080";
    }

    @Override
    public String getEndpoint() {
        return "bananas";
    }
}
