package com.api.backend.fideliz.repository;

import com.api.backend.fideliz.model.ClienteRequest;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.springframework.stereotype.Repository;

@Repository
@UseClasspathSqlLocator
public interface ClienteRepository {
    @SqlUpdate
    @GetGeneratedKeys
    Long criarCliente(@BindBean ClienteRequest request);

    @SqlQuery
    boolean selectClienteByCpf(@Bind("cpf") String cpf);
}
