package com.alexfossa204.crmtenderbackendapp.database.extension;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

public class PostgresExtension implements BeforeAllCallback, AfterAllCallback {

    private static GenericContainer<?> postgres;

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        postgres = new GenericContainer<>(DockerImageName.parse("postgres:11"))
                .withEnv("POSTGRES_USER", "postgres")
                .withEnv("POSTGRES_PASSWORD", "root")
                .withEnv("POSTGRES_DB", "tender-crm-db")
                .withExposedPorts(5432);
        postgres.start();

        String jdbcUrl = String.format("jdbc:postgresql://127.0.0.1:%d/tender-crm-db", postgres.getFirstMappedPort());
        System.setProperty("spring.datasource.url", jdbcUrl);
        System.setProperty("spring.datasource.username", "postgres");
        System.setProperty("spring.datasource.password", "root");
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
    }
}