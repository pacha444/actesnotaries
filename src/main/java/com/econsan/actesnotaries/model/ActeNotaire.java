package com.econsan.actesnotaries.model;

import com.econsan.actesnotaries.enumerateur.TypeActeNotaire;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="ActeNotaire")
public class ActeNotaire{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codeActeNotaire")
    private Integer codeActeNotaire;
    @NonNull
    @Column(name = "dateDepot")
    private Date dateDepot;
    @Column(name = "dateRetrait")
    private Date dateRetrait;
    @NonNull
    @Column(name = "lot")
    private String lot;
    @NonNull
    @Column(name = "origine")
    private String origine;
    @NonNull
    @Column(name = "titreFoncier")
    private String titreFoncier;
    @Column(name = "impute")
    private Boolean impute;
    @Column(name = "typeActeNotaire")
    private TypeActeNotaire typeActeNotaire;
    @OneToMany(mappedBy = "codeActeNotaire")
    List<Cheque>  chequesActeNotaire;
    @OneToMany(mappedBy = "codeActeNotaire")
    List<NatureActeNotaire> natureActeNotaires;
    @OneToMany(mappedBy = "codeActeNotaire")
    List<DocumentActeNotaire> documentActeNotaires;

}
