package by.it.academy.example;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

import static org.mockito.Mockito.mock;

public class FlyWayTest {
    private FlyWayMigration flyway;
    private FlyWayMigration flywayPostgresqlContainer;

    @BeforeAll
    void generateContainer(){
        DockerImageName myImage = DockerImageName.parse("postgres");
        PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer(myImage);
        postgreSQLContainer.addExposedPort(5432);
        postgreSQLContainer.start();
        flywayPostgresqlContainer = mock(FlyWayMigration.class);
    }

    @BeforeEach
    void createFlyway(){
        flyway = mock(FlyWayMigration.class);
    }

    @Test
    public void testSkipAutomaticAndTriggerManualFlywayMigration(){
        Assertions.assertDoesNotThrow(()-> {
            flyway.skipAutomaticAndTriggerManualFlywayMigration();
        });
    }

    @Test
    public void testInitSqlAndMigrationFlyway(){
        Assertions.assertDoesNotThrow(()-> {
            flyway.initSqlAndMigrationFlyway("SELECT breed FROM cats_breeds;");
        });
    }

    @Test
    public void testFlywayOnDAO(){
        flywayPostgresqlContainer.initSqlAndMigrationFlyway("SELECT name FROM cats;");
    }


}
