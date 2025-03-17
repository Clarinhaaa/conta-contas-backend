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

@Entity(name = "Endereco")
@Table(name = "Endereco")
public class EnderecoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private int idEndereco;

    @Column(name = "numero_casa", nullable = true)
    private int numeroCasa;

    @Column(name = "rua", nullable = true)
    private String rua;

    @Column(name = "bairro", nullable = true)
    private String bairro;

    @Column(name = "cidade", nullable = true)
    private String cidade;

    @Column(name = "estado", nullable = true)
    private String estado;

    @Column(name = "cep", nullable = true)
    private String cep;

    //* Usuário */
    @OneToMany(mappedBy = "enderecoUsuario", cascade = CascadeType.ALL)
    private List<UsuarioModel> usuarios;

    public EnderecoModel () {}

    public EnderecoModel(int idEndereco, int numeroCasa, String rua, String bairro, String cidade, String estado,
            String cep) {
        this.idEndereco = idEndereco;
        this.numeroCasa = numeroCasa;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "EnderecoModel [idEndereco=" + idEndereco + ", numeroCasa=" + numeroCasa + ", rua=" + rua + ", bairro="
                + bairro + ", cidade=" + cidade + ", estado=" + estado + ", cep=" + cep + "]";
    }
    
}
