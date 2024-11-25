package com.api.backend.fideliz.mapper;

import com.api.backend.fideliz.model.Recompensa;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class RecompensaMapper implements RowMapper<Recompensa> {
    @Override
    public Recompensa map(ResultSet rs, StatementContext ctx) throws SQLException {
        Recompensa recompensa = new Recompensa();
        recompensa.setIdLojista(rs.getLong("id_lojista"));
        recompensa.setQuantidadeSelo(rs.getInt("qt_selo"));
        recompensa.setDescricao(rs.getString("descricao"));
        return recompensa;
    }
}