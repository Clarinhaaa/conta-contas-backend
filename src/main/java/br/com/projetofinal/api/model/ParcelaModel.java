package br.com.projetofinal.api.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Parcela")
public class ParcelaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idParcela")
    private int idParcela;

    @Column(name = "dataVencimentoParcela", nullable = true)
    private Date dataVencimentoParcela;

    @Column(name = "numeroParcela", nullable = true)
    private int numeroParcela;

    @Column(name = "valorParcela", nullable = true)
    private float valorParcela;

    @Column(name = "statusParcela", nullable = true)
    private String statusParcela;

    //* Conta */
    @ManyToOne
    @JoinColumn(name = "Conta_idConta", nullable = false)
    private ContaModel contaParcela;

    public ParcelaModel() {}

    public ParcelaModel(int idParcela, Date dataVencimentoParcela, int numeroParcela, float valorParcela,
            String statusParcela, ContaModel contaParcela) {
        this.idParcela = idParcela;
        this.dataVencimentoParcela = dataVencimentoParcela;
        this.numeroParcela = numeroParcela;
        this.valorParcela = valorParcela;
        this.statusParcela = statusParcela;
        this.contaParcela = contaParcela;
    }

    public int getIdParcela() {
        return idParcela;
    }

    public void setIdParcela(int idParcela) {
        this.idParcela = idParcela;
    }

    public Date getDataVencimentoParcela() {
        return dataVencimentoParcela;
    }

    public void setDataVencimentoParcela(Date dataVencimentoParcela) {
        this.dataVencimentoParcela = dataVencimentoParcela;
    }

    public int getNumeroParcela() {
        return numeroParcela;
    }

    public void setNumeroParcela(int numeroParcela) {
        this.numeroParcela = numeroParcela;
    }

    public float getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(float valorParcela) {
        this.valorParcela = valorParcela;
    }

    public String getStatusParcela() {
        return statusParcela;
    }

    public void setStatusParcela(String statusParcela) {
        this.statusParcela = statusParcela;
    }

    public ContaModel getContaParcela() {
        return contaParcela;
    }

    public void setContaParcela(ContaModel contaParcela) {
        this.contaParcela = contaParcela;
    }

    @Override
    public String toString() {
        return "ParcelaModel [idParcela=" + idParcela + ", dataVencimentoParcela=" + dataVencimentoParcela
                + ", numeroParcela=" + numeroParcela + ", valorParcela=" + valorParcela + ", statusParcela="
                + statusParcela + ", contaParcela=" + contaParcela.getDescricaoConta() + "]";
    }
}
