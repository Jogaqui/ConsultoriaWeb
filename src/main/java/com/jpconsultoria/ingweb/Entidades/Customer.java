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
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60, nullable = false)
    private String nombre;

    @Column(length = 60, nullable = false)
    private String apellidos;

    @Column(length = 8, nullable = false)
    private String numDocumento;

    @Column(nullable = false)
    private Integer edad;

    @Column(length = 100)
    private String correo;

    @Column(length = 9)
    private String telefono;

    @OneToMany(mappedBy = "customer")
    private Set<Project> projects;

    
}
