package com.api.backend.fideliz.repository;

import com.api.backend.fideliz.model.LojistaRequest;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.springframework.stereotype.Repository;

@Repository
@UseClasspathSqlLocator
public interface LojistaRepository {
    @SqlUpdate
    @GetGeneratedKeys
    Long criarLojista(@BindBean LojistaRequest lojistaRequest);

    @SqlQuery
    boolean selectByCnpj(@Bind("cnpj") String cnpj);

    @SqlUpdate
    void atualizarLojista(@BindBean LojistaRequest lojistaRequest);

    @SqlQuery
    Long findIdByCnpj(@Bind("cnpj") String cnpj);
}
