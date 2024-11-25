package com.api.backend.fideliz.config;

import com.api.backend.fideliz.model.Recompensa;
import com.api.backend.fideliz.repository.ClienteRepository;
import com.api.backend.fideliz.repository.LojistaRepository;
import com.api.backend.fideliz.repository.RecompensaRepository;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.spi.JdbiPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class JdbiConfing {

    @Bean
    public Jdbi jdbi(DataSource ds, List<JdbiPlugin> jdbiPlugins, List<RowMapper<?>> rowMappers) {
        TransactionAwareDataSourceProxy proxy = new TransactionAwareDataSourceProxy(ds);
        Jdbi jdbi = Jdbi.create(proxy);

        // Register all available plugins
        jdbiPlugins.forEach(jdbi::installPlugin);

        // Register all available rowMappers
        rowMappers.forEach(jdbi::registerRowMapper);
        return jdbi;
    }

    @Bean
    public JdbiPlugin sqlObjectPlugin() {
        return new SqlObjectPlugin();
    }

    @Bean
    public LojistaRepository lojistaRepository(Jdbi jdbi){
        return jdbi.onDemand(LojistaRepository.class);
    }

    @Bean
    public ClienteRepository clienteRepository(Jdbi jdbi){
        return jdbi.onDemand(ClienteRepository.class);
    }

    @Bean
    public RecompensaRepository recompensaRepository(Jdbi jdbi){
        return jdbi.onDemand(RecompensaRepository.class);
    }
}
