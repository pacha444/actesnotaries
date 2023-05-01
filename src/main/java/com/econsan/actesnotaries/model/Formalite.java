package com.econsan.actesnotaries.model;
import com.econsan.actesnotaries.enumerateur.TypeActeNotaire;
import com.econsan.actesnotaries.enumerateur.TypeFormalite;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="Formalite")
public class Formalite {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idformalite")
    private Integer idformalite;
    @Column(name = "datearrivee")
    private Date datearrivee;
    @Column(name = "datedepart")
    private Date datedepart;
    @Column(name = "enreg")
    private String enreg;
    @Column(name = "pubfoncier")
    private String pubfoncier;
    @Column(name = "observation")
    private String observation;
    @Column(name = "typeFormalite")
    private TypeFormalite typeFormalite;
   @ManyToOne(optional = false, fetch = FetchType.LAZY)
   @JoinColumn(name = "CodeNatureActeNotaire", referencedColumnName = "CodeNatureActeNotaire")
   private NatureActeNotaire CodeNatureActeNotaire;

}
