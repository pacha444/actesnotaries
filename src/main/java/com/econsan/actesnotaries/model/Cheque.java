package com.econsan.actesnotaries.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="Cheque")
public class Cheque {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codeMatriculeCheque")
    private Integer codeMatriculeCheque;
    @NonNull
    @Column(name = "numeroCheque")
    private String numeroCheque;
    @NonNull
    @Column(name = "banque")
    private String banque;
    @NonNull
    @Column(name = "montant")
    private Float montant;
    @JoinColumn(name = " codeActeNotaire", referencedColumnName = "codeActeNotaire")
    @ManyToOne
    private ActeNotaire codeActeNotaire;

}
