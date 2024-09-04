package com.dsi.tp.bonvino.Repositories;

import com.dsi.tp.bonvino.Entities.Siguiendo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiguiendoRepository extends JpaRepository<Siguiendo, Integer> {
}