package com.econsan.actesnotaries.service;

import com.econsan.actesnotaries.model.ActeNotaire;

import java.util.Date;
import java.util.List;

public interface ActeNotaireService {
    ActeNotaire saveActeNotaire(ActeNotaire acteNotaire);

    ActeNotaire saveFormaliteNatureActe(ActeNotaire acteNotaire,Integer codeactenotaire);

   ActeNotaire searchActeNotaire(ActeNotaire acteNotaire,Integer codeactenotaire);

    List<ActeNotaire>  searchListActeNotaire(Date date1,Date date2);

    List<ActeNotaire>  searchListActeNotaireNonImpute(Date date1,Date date2,Boolean impute);

    List<ActeNotaire> searchListActeNotaireImpute(Date date1, Date date2, Boolean impute);


}
