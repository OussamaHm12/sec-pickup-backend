package com.backend.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "assistantes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Assistante extends BaseEntity {
    private String nom;
    private String prenom;
    private String cni;
    private String email;


    @ManyToOne
    @JoinColumn(name = "ecole_id")
    private Ecole ecole;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "trajet_id")
    private Trajet trajet;
}
