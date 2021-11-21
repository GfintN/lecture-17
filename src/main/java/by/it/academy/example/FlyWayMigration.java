package by.it.academy.example;

import by.it.academy.example.util.HibernateUtil;
import org.flywaydb.core.Flyway;
import org.hibernate.Session;

import javax.sql.DataSource;

public class FlyWayMigration {
    public final Session session = (Session) HibernateUtil.getEntityManager().getDelegate();
    private Flyway flyway;

    public void skipAutomaticAndTriggerManualFlywayMigration() {
        flyway = Flyway.configure().locations("classpath:db.migration")
                .dataSource((DataSource) session).load();
        flyway.migrate();
    }

    public void initSqlAndMigrationFlyway(String sql) {
        flyway = Flyway.configure().dataSource((DataSource) session).initSql(sql).load();
        flyway.migrate();
    }

    public void clean(){
        flyway.clean();
    }
}

