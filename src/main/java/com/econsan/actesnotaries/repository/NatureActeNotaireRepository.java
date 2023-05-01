package com.econsan.actesnotaries.repository;

import com.econsan.actesnotaries.model.NatureActeNotaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NatureActeNotaireRepository extends JpaRepository<NatureActeNotaire,Integer> {
}
