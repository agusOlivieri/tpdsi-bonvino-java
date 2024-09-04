package com.dsi.tp.bonvino.Repositories;

import com.dsi.tp.bonvino.Entities.TipoUva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUvaRepository extends JpaRepository<TipoUva, Integer> {
}