package com.vikram.learn

import com.google.inject.AbstractModule
import com.google.inject.Provides
import com.google.inject.Singleton
import com.vikram.learn.config.LearnConfiguration
import com.vikram.learn.provider.InventoryItemProvider
import com.vikram.learn.provider.SalesOrderItemProvider
import com.vikram.learn.provider.StockProvider
import io.dropwizard.db.ManagedDataSource
import io.dropwizard.jdbi.DBIFactory
import io.dropwizard.setup.Environment
import org.skife.jdbi.v2.DBI

class MyGuiceModule extends AbstractModule {

    private final LearnConfiguration configuration
    private final Environment environment
    private final ManagedDataSource managedDataSource

    public MyGuiceModule(final LearnConfiguration configuration, Environment environment) {
        this.configuration  =   configuration
        this.environment    =   environment
        this.managedDataSource  = configuration.getMyServiceDb().build(environment.metrics(),'postgresql')
    }

    @Provides
    @Singleton
    DBI prepareJdbi(final LearnConfiguration configuration, Environment environment) {
        final DBIFactory dbiFactory = new DBIFactory()
        final DBI dbi = dbiFactory.build(environment, configuration.getMyServiceDb(), managedDataSource, 'postgresql')
        dbi
    }

    @Provides
    public InventoryItemProvider prepareInventoryItemProvider(DBI jdbi) {
        jdbi.onDemand(InventoryItemProvider)
    }

    @Provides
    public SalesOrderItemProvider prepareSalesOrderItemProvider(DBI jdbi) {
        jdbi.onDemand(SalesOrderItemProvider)
    }

    @Provides
    public StockProvider prepareStockProvider(DBI jdbi) {
        jdbi.onDemand(StockProvider)
    }

    @Override
    protected void configure() {
        bind(LearnConfiguration).toInstance(configuration)
        bind(Environment).toInstance(environment)
    }
}
