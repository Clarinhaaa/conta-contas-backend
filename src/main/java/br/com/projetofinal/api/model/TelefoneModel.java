package br.com.projetofinal.api.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity(name = "Telefone")
@Table(name = "Telefone")
public class TelefoneModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telefone")
    private int idTelefone;

    @Column(name = "numero_telefone", nullable = true)
    private String numeroTelefone;

    @Column(name = "descricao_telefone", nullable = true)
    private String descricaoTelefone;

    //* Usuário */
    @OneToOne(mappedBy = "telefoneUsuario", cascade = CascadeType.ALL)
    private UsuarioModel usuarioTelefone;

    public TelefoneModel() {}

    public TelefoneModel(int idTelefone, String numeroTelefone, String descricaoTelefone) {
        this.idTelefone = idTelefone;
        this.numeroTelefone = numeroTelefone;
        this.descricaoTelefone = descricaoTelefone;
    }

    public int getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(int idTelefone) {
        this.idTelefone = idTelefone;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getDescricaoTelefone() {
        return descricaoTelefone;
    }

    public void setDescricaoTelefone(String descricaoTelefone) {
        this.descricaoTelefone = descricaoTelefone;
    }

    @Override
    public String toString() {
        return "TelefoneModel [idTelefone=" + idTelefone + ", numeroTelefone=" + numeroTelefone + ", descricaoTelefone="
                + descricaoTelefone + "]";
    }
}
