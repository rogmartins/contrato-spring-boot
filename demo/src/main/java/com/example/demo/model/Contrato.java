package com.example.demo.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Contrato {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="contratante_id")
    private Pessoa contratante;
    public Pessoa getContratante() {
        return contratante;
    }
    public void setContratante(Pessoa contratante) {
        this.contratante = contratante;
    }
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="contratada_id")
    private Pessoa contratada;
    public Pessoa getContratada() {
        return contratada;
    }
    public void setContratada(Pessoa contratada) {
        this.contratada = contratada;
    }

    private BigDecimal valorContratado;
    public BigDecimal getValorContratado() {
        return valorContratado;
    }
    public void setValorContratado(BigDecimal valorContratado) {
        this.valorContratado = valorContratado;
    }

    private Date dtInicio;
    public Date getDtInicio() {
        return dtInicio;
    }
    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    private Date dtFim;
    public Date getDtFim() {
        return dtFim;
    }
    public void setDtFim(Date dtFim) {
        this.dtFim = dtFim;
    }
}
