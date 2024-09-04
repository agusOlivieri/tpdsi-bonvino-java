package com.dsi.tp.bonvino.Repositories;

import com.dsi.tp.bonvino.Entities.Varietal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VarietalRepository extends JpaRepository<Varietal, Integer> {
}
