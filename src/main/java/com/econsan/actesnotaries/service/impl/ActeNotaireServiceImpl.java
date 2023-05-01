package com.econsan.actesnotaries.service.impl;

import com.econsan.actesnotaries.exception.ResourceNotFoundException;
import com.econsan.actesnotaries.model.*;
import com.econsan.actesnotaries.repository.*;
import com.econsan.actesnotaries.service.ActeNotaireService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ActeNotaireServiceImpl implements ActeNotaireService {

    @Autowired
    ActeNotaireRepository acteNotaireRepository;
    @Autowired
    ChequeRepository chequeRepository;
    @Autowired
    NatureActeNotaireRepository natureActeNotaireRepository;
    @Autowired
    DocumentActeNotaireRepository documentActeNotaireRepository;
    @Autowired
    FormaliteRepository formaliteRepository;

    private List<Cheque> cheques;
    private List<NatureActeNotaire> natureActeNotaires;
    private List<DocumentActeNotaire> documentActeNotaires;
    private List<Formalite> formalites;


    public ActeNotaireServiceImpl(ActeNotaireRepository acteNotaireRepository, ChequeRepository chequeRepository, NatureActeNotaireRepository natureActeNotaireRepository, DocumentActeNotaireRepository documentActeNotaireRepository, FormaliteRepository formaliteRepository) {
        this.acteNotaireRepository = acteNotaireRepository;
        this.chequeRepository = chequeRepository;
        this.natureActeNotaireRepository = natureActeNotaireRepository;
        this.documentActeNotaireRepository = documentActeNotaireRepository;
        this.formaliteRepository = formaliteRepository;
    }

    @PostConstruct
    public void init()
    {
        cheques=new ArrayList<>();
        natureActeNotaires=new ArrayList<>();
        documentActeNotaires=new ArrayList<>();
    }


    @Override
    public ActeNotaire saveActeNotaire(ActeNotaire acteNotaire) {

        cheques=acteNotaire.getChequesActeNotaire();
        natureActeNotaires=acteNotaire.getNatureActeNotaires();
        documentActeNotaires=acteNotaire.getDocumentActeNotaires();
        if(!cheques.isEmpty() && !natureActeNotaires.isEmpty() && !documentActeNotaires.isEmpty())
        {
            for(Cheque c:cheques)
            {
                c.setCodeActeNotaire(acteNotaire);
                chequeRepository.save(c);

            }
            for(NatureActeNotaire n:natureActeNotaires)
            {
                n.setCodeActeNotaire(acteNotaire);
                natureActeNotaireRepository.save(n);
            }
            for(DocumentActeNotaire d:documentActeNotaires)
            {
                d.setCodeActeNotaire(acteNotaire);
                documentActeNotaireRepository.save(d);
            }
            acteNotaireRepository.save(acteNotaire);
        }


        return acteNotaire;
    }



    @Override
    public ActeNotaire saveFormaliteNatureActe(ActeNotaire acteNotaire,Integer codeactenotaire) {

        ActeNotaire existingActeNotaire = searchActeNotaire(acteNotaire,codeactenotaire);

        natureActeNotaires=existingActeNotaire.getNatureActeNotaires();
        for(NatureActeNotaire n:natureActeNotaires)
        {
            formalites=n.getFormalites();
            for(Formalite f:formalites)
            {
                f.setCodeNatureActeNotaire(n);
                formaliteRepository.save(f);
            }
        }
        acteNotaireRepository.save(existingActeNotaire);
        return existingActeNotaire;
    }


    @Override
    public ActeNotaire searchActeNotaire(ActeNotaire acteNotaire,Integer codeactenotaire) {
        ActeNotaire acteNotairerecherche = acteNotaireRepository.findById(codeactenotaire).orElseThrow(
                () -> new ResourceNotFoundException("ActeNotaire", "codeActeNotaire", codeactenotaire));
        return acteNotairerecherche;
    }

    @Override
    public List<ActeNotaire> searchListActeNotaire(Date date1, Date date2) {
        return acteNotaireRepository.findBydateDepot(date1,date2);
    }

    @Override
    public List<ActeNotaire> searchListActeNotaireNonImpute(Date date1, Date date2, Boolean impute) {
        impute=false;
        return acteNotaireRepository.findActeNotaires(date1,date2,impute);

    }

    @Override
    public List<ActeNotaire> searchListActeNotaireImpute(Date date1, Date date2, Boolean impute) {
        impute=true;
        return acteNotaireRepository.findActeNotaires(date1,date2,impute);

    }

}
