package br.com.projetofinal.api.model;

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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity(name = "Usuario")
@Table(name = "Usuario")
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private int idUsuario;

    @Column(name = "nomeusuario", nullable = true)
    private String nomeUsuario;

    @Column(name = "cpfusuario", nullable = true)
    private String cpfUsuario;

    @Column(name = "emailusuario", nullable = true)
    private String emailUsuario;

    @Column(name = "loginusuario", nullable = true)
    private String loginUsuario;

    @Column(name = "senhausuario", nullable = true)
    private String senhaUsuario;

    //* Endereço */
    @ManyToOne
    @JoinColumn(name = "Endereco_idEndereco", nullable = false)
    private EnderecoModel enderecoUsuario;

    //* Telefone */
    @OneToOne
    @JoinColumn(name = "Telefone_idTelefone", nullable = false)
    private TelefoneModel telefoneUsuario;

    //* Conta */
    @OneToMany(mappedBy = "usuarioConta", cascade = CascadeType.ALL)
    private List<ContaModel> contas;

    public UsuarioModel() {}

    public UsuarioModel(int idUsuario, String nomeUsuario, String cpfUsuario, String emailUsuario, String loginUsuario,
            String senhaUsuario, EnderecoModel enderecoUsuario, TelefoneModel telefoneUsuario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.cpfUsuario = cpfUsuario;
        this.emailUsuario = emailUsuario;
        this.loginUsuario = loginUsuario;
        this.senhaUsuario = senhaUsuario;
        this.enderecoUsuario = enderecoUsuario;
        this.telefoneUsuario = telefoneUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public EnderecoModel getEnderecoUsuario() {
        return enderecoUsuario;
    }

    public void setEnderecoUsuario(EnderecoModel enderecoUsuario) {
        this.enderecoUsuario = enderecoUsuario;
    }

    public TelefoneModel getTelefoneUsuario() {
        return telefoneUsuario;
    }

    public void setTelefoneUsuario(TelefoneModel telefoneUsuario) {
        this.telefoneUsuario = telefoneUsuario;
    }

    @Override
    public String toString() {
        return "UsuarioModel [idUsuario=" + idUsuario + ", nomeUsuario=" + nomeUsuario + ", cpfUsuario=" + cpfUsuario
                + ", emailUsuario=" + emailUsuario + ", loginUsuario=" + loginUsuario + ", senhaUsuario=" + senhaUsuario
                + ", enderecoUsuario=" + enderecoUsuario.getCep() + ", telefoneUsuario=" + telefoneUsuario.getNumeroTelefone() + "]";
    }
}
