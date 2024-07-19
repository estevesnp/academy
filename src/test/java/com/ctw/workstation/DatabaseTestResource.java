package com.ctw.workstation;

import io.quarkus.logging.Log;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.Map;

public class DatabaseTestResource implements QuarkusTestResourceLifecycleManager {
    PostgreSQLContainer postgres;

    @Override
    public Map<String, String> start() {
        Log.infof("About to start", "DatabaseTestResource");

        postgres = new PostgreSQLContainer<>("postgres")
                .withDatabaseName("fs_academy")
                .withExposedPorts(5432);

        postgres.start();

        return Map.of(
                "quarkus.log.console.json", "false",
                "quarkus.datasource.username", postgres.getUsername(),
                "quarkus.datasource.password", postgres.getPassword(),
                "quarkus.datasource.jdbc.url", postgres.getJdbcUrl()
        );
    }

    @Override
    public void stop() {
        Log.infof("Finishing test", "DatabaseTestResource");
        postgres.stop();
    }
}
