package com.example.crud_oracle.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name= "INICIATIVA_ESG")
public class IniciativaESG {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "TITULO", nullable = false, length = 150)
    private String titulo;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORIA", nullable = false, length = 20)
    private CategoriaESG categoria;

    @NotBlank 
    @Column(name = "RESPONSAVEL", nullable = false, length = 100)
    private String responsavel;

    @DecimalMin(value = "0.0", inclusive = true)
    @Column(name = "META_REDUCAO_CO2", precision = 18, scale = 2)
    private BigDecimal  metaReducaoCo2;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false, length = 20)
    private StatusIniciativa status = StatusIniciativa.PLANEJADA;

    public IniciativaESG() {
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public CategoriaESG getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaESG categoria) {
        this.categoria = categoria;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public BigDecimal getMetaReducaoCo2() {
        return metaReducaoCo2;
    }

    public void setMetaReducaoCo2(BigDecimal metaReducaoCo2) {
        this.metaReducaoCo2 = metaReducaoCo2;
    }

    public StatusIniciativa getStatus() {
        return status;
    }

    public void setStatus(StatusIniciativa status) {
        this.status = status;
    }
}
