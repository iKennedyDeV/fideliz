package com.api.backend.fideliz.repository;

import com.api.backend.fideliz.mapper.RecompensaMapper;
import com.api.backend.fideliz.model.Recompensa;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.springframework.stereotype.Repository;

@Repository
@UseClasspathSqlLocator
@RegisterBeanMapper(RecompensaMapper.class)
public interface RecompensaRepository {
    @SqlQuery
    Recompensa findByIdLojista(@Bind("id_lojista") Long idLojista);
    @SqlUpdate
    void adicionarRecompensa(@BindBean Recompensa recompensa);

    @SqlUpdate
    void atualizarRecompensa(@BindBean Recompensa recompensa);

    @SqlQuery
    Long findByCnpj(@Bind("cnpj") String cnpj);
}
