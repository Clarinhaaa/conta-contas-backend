package br.com.projetofinal.api.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import br.com.projetofinal.api.model.ParcelaModel;

public class ParcelaDto implements Serializable {
    private int idParcela;
    private Date dataVencimentoParcela;
    private int numeroParcela;
    private float valorParcela;
    private String statusParcela;
    private int idConta;

    public static ParcelaDto converter(ParcelaModel parModel) {
        ParcelaDto parDto = new ParcelaDto();
        parDto.setIdParcela(parModel.getIdParcela());
        parDto.setDataVencimentoParcela(parModel.getDataVencimentoParcela());
        parDto.setNumeroParcela(parModel.getNumeroParcela());
        parDto.setValorParcela(parModel.getValorParcela());
        parDto.setStatusParcela(parModel.getStatusParcela());
        parDto.setIdConta(parModel.getContaParcela().getIdConta());

        return parDto;
    }

    public static List<ParcelaDto> converterLista(List<ParcelaModel> listModel) {
        List<ParcelaDto> listDto = new ArrayList<ParcelaDto>();
        for (ParcelaModel par : listModel) {
            listDto.add(ParcelaDto.converter(par));
        }
        return listDto;
    }

    public ParcelaDto() {}

    public ParcelaDto(int idParcela, Date dataVencimentoParcela, int numeroParcela, float valorParcela,
            String statusParcela, int idConta) {
        this.idParcela = idParcela;
        this.dataVencimentoParcela = dataVencimentoParcela;
        this.numeroParcela = numeroParcela;
        this.valorParcela = valorParcela;
        this.statusParcela = statusParcela;
        this.idConta = idConta;
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

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    @Override
    public String toString() {
        return "ParcelaDto [idParcela=" + idParcela + ", dataVencimentoParcela=" + dataVencimentoParcela
                + ", numeroParcela=" + numeroParcela + ", valorParcela=" + valorParcela + ", statusParcela="
                + statusParcela + ", idConta=" + idConta + "]";
    }
}
