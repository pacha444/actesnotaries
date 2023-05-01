package com.econsan.actesnotaries.repository;

import com.econsan.actesnotaries.model.ActeNotaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ActeNotaireRepository extends JpaRepository<ActeNotaire,Integer> {

    @Query("select a from ActeNotaire  a where a.dateDepot  BETWEEN :?1 AND :?2")
    List<ActeNotaire> findBydateDepot(Date date1, Date date2);

    @Query("select a from ActeNotaire  a where a.dateDepot  BETWEEN :?1 AND :?2 and a.impute=:impute")
    List<ActeNotaire> findActeNotaires(Date date1, Date date2, @Param("impute") Boolean impute);
}
