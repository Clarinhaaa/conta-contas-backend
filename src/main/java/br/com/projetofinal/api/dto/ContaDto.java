package br.com.projetofinal.api.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import br.com.projetofinal.api.model.ContaModel;

public class ContaDto implements Serializable {
    private int idConta;
    private String descricaoConta;
    private float valorConta;
    private Date dataVencimentoConta;
    private Date dataPagamentoConta;
    private String tipoConta;
    private boolean statusConta;
    private int idUsuario;
    private int idCategoria;

    public static ContaDto converter(ContaModel conModel) {
        ContaDto conDto = new ContaDto();
        conDto.setIdConta(conModel.getIdConta());
        conDto.setDescricaoConta(conModel.getDescricaoConta());
        conDto.setValorConta(conModel.getValorConta());
        conDto.setDataVencimentoConta(conModel.getDataVencimentoConta());
        conDto.setDataPagamentoConta(conModel.getDataPagamentoConta());
        conDto.setTipoConta(conModel.getTipoConta());
        conDto.setStatusConta(conModel.isStatusConta());
        conDto.setIdUsuario(conModel.getUsuarioConta().getIdUsuario());
        conDto.setIdCategoria(conModel.getCategoriaConta().getIdCategoria());

        return conDto;
    }

    public static List<ContaDto> converterLista(List<ContaModel> listModel) {
        List<ContaDto> listDto = new ArrayList<ContaDto>();
        for (ContaModel con : listModel) {
            listDto.add(ContaDto.converter(con));
        }
        return listDto;
    }

    public ContaDto() {}

    public ContaDto(int idConta, String descricaoConta, float valorConta, Date dataVencimentoConta,
            Date dataPagamentoConta, String tipoConta, boolean statusConta, int idUsuario, int idCategoria) {
        this.idConta = idConta;
        this.descricaoConta = descricaoConta;
        this.valorConta = valorConta;
        this.dataVencimentoConta = dataVencimentoConta;
        this.dataPagamentoConta = dataPagamentoConta;
        this.tipoConta = tipoConta;
        this.statusConta = statusConta;
        this.idUsuario = idUsuario;
        this.idCategoria = idCategoria;
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public String toString() {
        return "ContaDto [idConta=" + idConta + ", descricaoConta=" + descricaoConta + ", valorConta=" + valorConta
                + ", dataVencimentoConta=" + dataVencimentoConta + ", dataPagamentoConta=" + dataPagamentoConta
                + ", tipoConta=" + tipoConta + ", statusConta=" + statusConta + ", idUsuario=" + idUsuario
                + ", idCategoria=" + idCategoria + "]";
    }
}
