package com.econsan.actesnotaries.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="ActeNotaireNature")
public class NatureActeNotaire {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodeNatureActeNotaire")
    private Integer CodeNatureActeNotaire;
    @Basic(optional = false)
    @NonNull
    @Column(name = "contenu")
    private String contenu;
    @Column(name = "obsconservateur")
    private String obsconservateur;
    @Column(name = "obsdestinataire")
    private String obsdestinataire;
   @OneToMany(mappedBy = "CodeNatureActeNotaire")
    List<Formalite> formalites;
    @JoinColumn(name = " codeActeNotaire", referencedColumnName = "codeActeNotaire")
    @ManyToOne
    private ActeNotaire codeActeNotaire;
}
