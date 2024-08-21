package com.jpconsultoria.ingweb.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "institution_id", nullable = false)
    private Institution institution;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Servicio servicio;

    @ManyToOne
    @JoinColumn(name = "area_id", nullable = false)
    private Area area;

    @ManyToOne
    @JoinColumn(name = "profession_id", nullable = false)
    private Profession profession;

    private String plan;
    private String estadoPago;
    private String estadoTrabajo;
    

    @Temporal(TemporalType.DATE)
    private Date fechacontactoUltima;

    private String linkDrive;
    private String observaciones;

    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Institution getInstitution() { return institution; }
    public void setInstitution(Institution institution) { this.institution = institution; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public Servicio getServicio() { return servicio; }
    public void setServicio(Servicio servicio) { this.servicio = servicio; }
    public Area getArea() { return area; }
    public void setArea(Area area) { this.area = area; }
    public Profession getProfession() { return profession; }
    public void setProfession(Profession profession) { this.profession = profession; }
    public String getPlan() { return plan; }
    public void setPlan(String plan) { this.plan = plan; }
    public String getEstadoPago() { return estadoPago; }
    public void setEstadoPago(String estadoPago) { this.estadoPago = estadoPago; }
    public String getEstadoTrabajo() { return estadoTrabajo; }
    public void setEstadoTrabajo(String estadoTrabajo) { this.estadoTrabajo = estadoTrabajo; }
    public Date getFechacontactoUltima() { return fechacontactoUltima; }
    public void setFechacontactoUltima(Date fechacontactoUltima) { this.fechacontactoUltima = fechacontactoUltima; }
    public String getLinkDrive() { return linkDrive; }
    public void setLinkDrive(String linkDrive) { this.linkDrive = linkDrive; }
    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
    public Date getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(Date fechaInicio) { this.fechaInicio = fechaInicio; }
    public Date getFechaFin() { return fechaFin; }
    public void setFechaFin(Date fechaFin) { this.fechaFin = fechaFin; }
}
