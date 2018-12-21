package com.yunjae.springstartkotlin.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories
import org.springframework.data.cassandra.config.SchemaAction



@Configuration
@EnableReactiveCassandraRepositories
class CassandraConfig: AbstractCassandraConfiguration() {

    override fun getKeyspaceName() = "hr"

    override fun getContactPoints() = "localhost"

    override fun getEntityBasePackages() = arrayOf("com.yunjae.springstartkotlin.model")

    override fun getMetricsEnabled(): Boolean = false

    override fun getSchemaAction() = SchemaAction.CREATE_IF_NOT_EXISTS

}
