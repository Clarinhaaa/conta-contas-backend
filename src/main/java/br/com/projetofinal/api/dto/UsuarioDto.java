package br.com.projetofinal.api.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.projetofinal.api.model.UsuarioModel;

public class UsuarioDto implements Serializable {
    private int idUsuario;
    private String nomeUsuario;
    private String cpfUsuario;
    private String emailUsuario;
    private String loginUsuario;
    private String senhaUsuario;
    private int idEndereco;
    private int idTelefone;

    public static UsuarioDto converter(UsuarioModel usuModel) {
        UsuarioDto usuDto = new UsuarioDto();
        usuDto.setIdUsuario(usuModel.getIdUsuario());
        usuDto.setNomeUsuario(usuModel.getNomeUsuario());
        usuDto.setCpfUsuario(usuModel.getCpfUsuario());
        usuDto.setEmailUsuario(usuModel.getEmailUsuario());
        usuDto.setLoginUsuario(usuModel.getLoginUsuario());
        usuDto.setSenhaUsuario(usuModel.getSenhaUsuario());
        usuDto.setIdEndereco(usuModel.getEnderecoUsuario().getIdEndereco());
        usuDto.setIdTelefone(usuModel.getTelefoneUsuario().getIdTelefone());

        return usuDto;
    }

    public static List<UsuarioDto> converterLista(List<UsuarioModel> listModel) {
        List<UsuarioDto> listDto = new ArrayList<UsuarioDto>();
        for (UsuarioModel usu : listModel) {
            listDto.add(UsuarioDto.converter(usu));
        }
        return listDto;
    }

    public UsuarioDto() {}

    public UsuarioDto(int idUsuario, String nomeUsuario, String cpfUsuario, String emailUsuario, String loginUsuario,
            String senhaUsuario, int idEndereco, int idTelefone) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.cpfUsuario = cpfUsuario;
        this.emailUsuario = emailUsuario;
        this.loginUsuario = loginUsuario;
        this.senhaUsuario = senhaUsuario;
        this.idEndereco = idEndereco;
        this.idTelefone = idTelefone;
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

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public int getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(int idTelefone) {
        this.idTelefone = idTelefone;
    }

    @Override
    public String toString() {
        return "UsuarioDto [idUsuario=" + idUsuario + ", nomeUsuario=" + nomeUsuario + ", cpfUsuario=" + cpfUsuario
                + ", emailUsuario=" + emailUsuario + ", loginUsuario=" + loginUsuario + ", senhaUsuario=" + senhaUsuario
                + ", idEndereco=" + idEndereco + ", idTelefone=" + idTelefone + "]";
    }
}
