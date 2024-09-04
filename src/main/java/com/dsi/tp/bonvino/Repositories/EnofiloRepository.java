package com.dsi.tp.bonvino.Repositories;

import com.dsi.tp.bonvino.Entities.Enofilo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnofiloRepository extends JpaRepository<Enofilo, Integer> {
}
