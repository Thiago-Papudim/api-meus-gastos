package com.example.meusgastos.dto.dashboard;

import java.util.List;

import com.example.meusgastos.dto.titulo.TituloResponseDto;

public class DashboardResponseDto {
    private Double totalAPagar;
    private Double totalAReceber;
    private Double saldo;

    private List<TituloResponseDto> titulosAPagar;
    private List<TituloResponseDto> titulosAReceber;

    public DashboardResponseDto() {
    }

    public DashboardResponseDto(Double totalAPagar, Double totalAReceber, Double saldo,
            List<TituloResponseDto> titulosAPagar, List<TituloResponseDto> titulosAReceber) {
        this.totalAPagar = totalAPagar;
        this.totalAReceber = totalAReceber;
        this.saldo = saldo;
        this.titulosAPagar = titulosAPagar;
        this.titulosAReceber = titulosAReceber;
    }

    public Double getTotalAPagar() {
        return totalAPagar;
    }

    public void setTotalAPagar(Double totalAPagar) {
        this.totalAPagar = totalAPagar;
    }

    public Double getTotalAReceber() {
        return totalAReceber;
    }

    public void setTotalAReceber(Double totalAReceber) {
        this.totalAReceber = totalAReceber;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public List<TituloResponseDto> getTitulosAPagar() {
        return titulosAPagar;
    }

    public void setTitulosAPagar(List<TituloResponseDto> titulosAPagar) {
        this.titulosAPagar = titulosAPagar;
    }

    public List<TituloResponseDto> getTitulosAReceber() {
        return titulosAReceber;
    }

    public void setTitulosAReceber(List<TituloResponseDto> titulosAReceber) {
        this.titulosAReceber = titulosAReceber;
    }

}
