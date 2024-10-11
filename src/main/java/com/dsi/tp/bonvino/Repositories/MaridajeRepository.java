package com.dsi.tp.bonvino.Repositories;

import com.dsi.tp.bonvino.Models.Maridaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaridajeRepository extends JpaRepository<Maridaje, Integer> {

}
