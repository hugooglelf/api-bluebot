package br.com.hugoogle.api.core;

public class CacheRegion {

    public static final String ETERNAL_ENTITIES = "eternalEntitiesCache";
    public static final String ETERNAL_QUERIES = "eternalQueriesCache";

    public static final String RARELY_UPDATED_ENTITIES = "rarelyUpdatedEntitiesCache";
    public static final String RARELY_UPDATED_QUERIES = "rarelyUpdatedQueriesCache";

    private CacheRegion() {
    }
}
