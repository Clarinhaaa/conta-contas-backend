package br.com.projetofinal.api.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name = "Categoria")
@Table(name = "Categoria")
public class CategoriaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcategoria")
    private int idCategoria;

    @Column(name = "descricaocategoria", nullable = true)
    private String descricaoCategoria;

    @Column(name = "tipocategoria", nullable = true)
    private String tipoCategoria;

    //* Conta */
    @OneToMany(mappedBy = "categoriaConta", cascade = CascadeType.ALL)
    private List<ContaModel> contas;

    public CategoriaModel() {}

    public CategoriaModel(int idCategoria, String descricaoCategoria, String tipoCategoria) {
        this.idCategoria = idCategoria;
        this.descricaoCategoria = descricaoCategoria;
        this.tipoCategoria = tipoCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescricaoCategoria() {
        return descricaoCategoria;
    }

    public void setDescricaoCategoria(String descricaoCategoria) {
        this.descricaoCategoria = descricaoCategoria;
    }

    public String getTipoCategoria() {
        return tipoCategoria;
    }

    public void setTipoCategoria(String tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }

    @Override
    public String toString() {
        return "CategoriaModel [idCategoria=" + idCategoria + ", descricaoCategoria=" + descricaoCategoria
                + ", tipoCategoria=" + tipoCategoria + "]";
    }
}
