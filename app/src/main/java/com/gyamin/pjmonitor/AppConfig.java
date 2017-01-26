package com.gyamin.pjmonitor;

import javax.sql.DataSource;

import com.gyamin.pjmonitor.config.PostgresConfig;
import com.gyamin.pjmonitor.config.RedisConfig;
import org.seasar.doma.SingletonConfig;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.PostgresDialect;
import org.seasar.doma.jdbc.tx.LocalTransactionDataSource;
import org.seasar.doma.jdbc.tx.LocalTransactionManager;
import org.seasar.doma.jdbc.tx.TransactionManager;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SingletonConfig
public class AppConfig implements Config {

    private static final AppConfig CONFIG = new AppConfig();

    private final Dialect dialect;

    private final LocalTransactionDataSource dataSource;

    private final TransactionManager transactionManager;

    private AppConfig() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-postgres.xml");
        PostgresConfig postgresConfig = ctx.getBean(PostgresConfig.class);

        dialect = new PostgresDialect();
        dataSource = new LocalTransactionDataSource(
                postgresConfig.getUrl(), postgresConfig.getUsername(), postgresConfig.getPassword());
        transactionManager = new LocalTransactionManager(
                dataSource.getLocalTransaction(getJdbcLogger()));
    }

    @Override
    public Dialect getDialect() {
        return dialect;
    }

    @Override
    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public TransactionManager getTransactionManager() {
        return transactionManager;
    }

    public static AppConfig singleton() {
        return CONFIG;
    }
}
