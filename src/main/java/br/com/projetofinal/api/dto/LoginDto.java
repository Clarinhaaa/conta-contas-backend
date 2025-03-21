package br.com.projetofinal.api.dto;

import java.io.Serializable;

public class LoginDto implements Serializable {
    private String email;
    private String senha;

    public LoginDto() {}

    public LoginDto(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "LoginDto [email=" + email + ", senha=" + senha + "]";
    }
}
