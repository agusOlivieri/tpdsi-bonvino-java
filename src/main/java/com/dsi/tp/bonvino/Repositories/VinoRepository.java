package com.dsi.tp.bonvino.Repositories;

import com.dsi.tp.bonvino.Models.Vino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VinoRepository extends JpaRepository<Vino, Integer> {

}
