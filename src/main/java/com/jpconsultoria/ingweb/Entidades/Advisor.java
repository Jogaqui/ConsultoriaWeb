package com.jpconsultoria.ingweb.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Advisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(length = 60, nullable = false)
    private String nombres;

    @Column(length = 8, nullable = false)
    private String dni;

    @Column(nullable = false)
    private Integer edad;

    @Column(length = 60, nullable = false)
    private String apellidos;

    @Column(length = 225)
    private String bancaria;

    @Column(length = 225)
    private String interbancaria;

    @OneToMany(mappedBy = "advisor")
    private Set<Notification> notifications;
}
