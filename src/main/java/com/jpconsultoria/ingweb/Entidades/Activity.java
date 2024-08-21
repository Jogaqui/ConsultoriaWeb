package com.jpconsultoria.ingweb.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.Set;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @ManyToOne
    @JoinColumn(name = "chapter_id", nullable = false)
    private Chapter chapter;

    @Column(length = 225)
    private String descripcion;

    @Temporal(TemporalType.TIME)
    @Column(nullable = false)
    private Date tiempoEstandar;

    @Column(length = 225, nullable = false)
    private String titulo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date fecha;

    @Temporal(TemporalType.TIME)
    @Column(nullable = false)
    private Date horaInicio;

    @Temporal(TemporalType.TIME)
    @Column(nullable = false)
    private Date tiempoTotal;

    @Temporal(TemporalType.TIME)
    @Column(nullable = false)
    private Date horaFin;

    @Lob
    private String justificacion;

    @Column(length = 60)
    private String estado;

    @OneToMany(mappedBy = "activity")
    private Set<Comment> comments;

    @OneToMany(mappedBy = "activity")
    private Set<Notification> notifications;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;
}
