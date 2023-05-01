package com.econsan.actesnotaries.repository;

import com.econsan.actesnotaries.model.DocumentActeNotaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentActeNotaireRepository extends JpaRepository<DocumentActeNotaire,Integer> {
}
