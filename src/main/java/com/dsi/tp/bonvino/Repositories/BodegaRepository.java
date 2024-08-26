package com.dsi.tp.bonvino.Repositories;

import com.dsi.tp.bonvino.Models.Bodega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodegaRepository extends JpaRepository<Bodega, Integer> {

}
