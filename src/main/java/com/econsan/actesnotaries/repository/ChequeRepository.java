package com.econsan.actesnotaries.repository;

import com.econsan.actesnotaries.model.Cheque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChequeRepository extends JpaRepository<Cheque, Integer> {
}
