package com.example.springjdbc;

import com.example.springjdbc.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class AlienRepo {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Alien alien) {
        String sql = "INSERT INTO alien (id, name, tech) VALUES (?,?,?)";
        int rows = jdbcTemplate.update(sql, alien.getId(), alien.getName(), alien.getTech());
        System.out.println(rows + " row(s) inserted.");
    }
    public List<Alien> findAll() {
        String sql = "SELECT * FROM alien";
        RowMapper<Alien> rowMapper = (rs, rowNum) -> {
            Alien alien = new Alien();
            alien.setId(rs.getInt(1));
            alien.setName(rs.getString(2));
            alien.setTech(rs.getString(3));
            return alien;
        };
        return jdbcTemplate.query(sql, rowMapper);
    }
}






















