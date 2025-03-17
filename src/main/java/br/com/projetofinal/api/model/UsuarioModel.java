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
    @Column(name = "id_usuario")
    private int idUsuario;

    @Column(name = "nome_usuario", nullable = true)
    private String nomeUsuario;

    @Column(name = "cpf_usuario", nullable = true)
    private String cpfUsuario;

    @Column(name = "email_usuario", nullable = true)
    private String emailUsuario;

    @Column(name = "senha_usuario", nullable = true)
    private String senhaUsuario;

    //* Endereço */
    @ManyToOne
    @JoinColumn(name = "endereco_idendereco", nullable = false)
    private EnderecoModel enderecoUsuario;

    //* Telefone */
    @OneToOne
    @JoinColumn(name = "telefone_idtelefone", nullable = false)
    private TelefoneModel telefoneUsuario;

    //* Conta */
    @OneToMany(mappedBy = "usuarioConta", cascade = CascadeType.ALL)
    private List<ContaModel> contas;

    public UsuarioModel() {}

    public UsuarioModel(int idUsuario, String nomeUsuario, String cpfUsuario, String emailUsuario,
            String senhaUsuario, EnderecoModel enderecoUsuario, TelefoneModel telefoneUsuario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.cpfUsuario = cpfUsuario;
        this.emailUsuario = emailUsuario;
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
                + ", emailUsuario=" + emailUsuario + ", senhaUsuario=" + senhaUsuario
                + ", enderecoUsuario=" + enderecoUsuario + ", telefoneUsuario=" + telefoneUsuario + "]";
    }
}
