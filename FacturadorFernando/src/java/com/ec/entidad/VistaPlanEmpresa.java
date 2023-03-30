/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Darwin Morocho
 */
@Entity
@Table(name = "plan_empresa_cobro")
public class VistaPlanEmpresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long id;

    @Column(name = "detalle_cobro_plan_contratado")
    private String detalleCobroPlanContratado;
    @Column(name = "documentos")
    private BigDecimal documentos;
    @Transient
    private BigDecimal saldo;
    @Transient
    private BigDecimal total;

    public VistaPlanEmpresa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetalleCobroPlanContratado() {
        return detalleCobroPlanContratado;
    }

    public void setDetalleCobroPlanContratado(String detalleCobroPlanContratado) {
        this.detalleCobroPlanContratado = detalleCobroPlanContratado;
    }

    public BigDecimal getDocumentos() {
        return documentos;
    }

    public void setDocumentos(BigDecimal documentos) {
        this.documentos = documentos;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

}
