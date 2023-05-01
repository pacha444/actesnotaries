package com.econsan.actesnotaries.repository;

import com.econsan.actesnotaries.model.Formalite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaliteRepository extends JpaRepository<Formalite,Integer> {
}
