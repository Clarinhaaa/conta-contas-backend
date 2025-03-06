package br.com.projetofinal.api.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Conta")
public class ContaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idConta")
    private int idConta;

    @Column(name = "descricaoConta", nullable = true)
    private String descricaoConta;

    @Column(name = "valorConta", nullable = true)
    private float valorConta;

    @Column(name = "dataVencimentoConta", nullable = true)
    private Date dataVencimentoConta;

    @Column(name = "dataPagamentoConta", nullable = true)
    private Date dataPagamentoConta;

    @Column(name = "tipoConta", nullable = true)
    private String tipoConta;

    @Column(name = "statusConta", nullable = true)
    private boolean statusConta;

    //* Categoria */
    @ManyToOne
    @JoinColumn(name = "Categoria_idCategoria", nullable = false)
    private CategoriaModel categoriaConta;

    //* Parcela */
    @OneToMany(mappedBy = "contaParcela", cascade = CascadeType.ALL)
    private List<ParcelaModel> parcelas;

    public ContaModel() {}

    public ContaModel(int idConta, String descricaoConta, float valorConta, Date dataVencimentoConta,
            Date dataPagamentoConta, String tipoConta, boolean statusConta, CategoriaModel categoriaConta) {
        this.idConta = idConta;
        this.descricaoConta = descricaoConta;
        this.valorConta = valorConta;
        this.dataVencimentoConta = dataVencimentoConta;
        this.dataPagamentoConta = dataPagamentoConta;
        this.tipoConta = tipoConta;
        this.statusConta = statusConta;
        this.categoriaConta = categoriaConta;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public String getDescricaoConta() {
        return descricaoConta;
    }

    public void setDescricaoConta(String descricaoConta) {
        this.descricaoConta = descricaoConta;
    }

    public float getValorConta() {
        return valorConta;
    }

    public void setValorConta(float valorConta) {
        this.valorConta = valorConta;
    }

    public Date getDataVencimentoConta() {
        return dataVencimentoConta;
    }

    public void setDataVencimentoConta(Date dataVencimentoConta) {
        this.dataVencimentoConta = dataVencimentoConta;
    }

    public Date getDataPagamentoConta() {
        return dataPagamentoConta;
    }

    public void setDataPagamentoConta(Date dataPagamentoConta) {
        this.dataPagamentoConta = dataPagamentoConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public boolean isStatusConta() {
        return statusConta;
    }

    public void setStatusConta(boolean statusConta) {
        this.statusConta = statusConta;
    }

    public CategoriaModel getCategoriaConta() {
        return categoriaConta;
    }

    public void setCategoriaConta(CategoriaModel categoriaConta) {
        this.categoriaConta = categoriaConta;
    }

    @Override
    public String toString() {
        return "ContaModel [idConta=" + idConta + ", descricaoConta=" + descricaoConta + ", valorConta=" + valorConta
                + ", dataVencimentoConta=" + dataVencimentoConta + ", dataPagamentoConta=" + dataPagamentoConta
                + ", tipoConta=" + tipoConta + ", statusConta=" + statusConta + ", categoriaConta=" + categoriaConta.getDescricaoCategoria()
                + "]";
    }
}
