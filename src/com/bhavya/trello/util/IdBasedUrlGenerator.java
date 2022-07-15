package com.bhavya.trello.util;

import java.util.Map;

public class IdBasedUrlGenerator implements UrlGenerator {

    private String domain;

    public IdBasedUrlGenerator(String domain)
    {
        this.domain = domain;
    }

    @Override
    public String generateUrl(Map<String, String> options) {
        String entity = options.get("ENTITY");
        String id = options.get("ID");
        return String.format("https://%s/%s/%s", domain, entity, id);
    }
}
