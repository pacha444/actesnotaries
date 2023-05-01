package com.econsan.actesnotaries.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="DocumentActeNotaire")
public class DocumentActeNotaire {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddocactnot")
    private Integer iddocactnot;
    @NonNull
    @Column(name = "nomdocactnot")
    private String nomdocactnot;
    @JoinColumn(name = " codeActeNotaire", referencedColumnName = "codeActeNotaire")
    @ManyToOne
    private ActeNotaire codeActeNotaire;
}
