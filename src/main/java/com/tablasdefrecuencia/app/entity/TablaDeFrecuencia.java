package com.tablasdefrecuencia.app.entity;

import com.tablasdefrecuencia.app.app.Clases;

import java.util.List;
import java.util.Map;

public class TablaDeFrecuencia {
    Integer numeroDeClases;
    Map<Integer, Clases> clasesAgrupadas;
    Map<Integer, Clases> limitesReales;
    List<Double> puntosMedios;
    List<Integer> frecuenciasAbsolutas;
    List<Integer> frecuenciasAcumuladas;
    List<Double> frecuenciasRelativas;

    public TablaDeFrecuencia(Integer numeroDeClases, Map<Integer, Clases> clasesAgrupadas, Map<Integer, Clases> limitesReales, List<Double> puntosMedios, List<Integer> frecuenciasAbsolutas, List<Integer> frecuenciasAcumuladas, List<Double> frecuenciasRelativas) {
        this.numeroDeClases = numeroDeClases;
        this.clasesAgrupadas = clasesAgrupadas;
        this.limitesReales = limitesReales;
        this.puntosMedios = puntosMedios;
        this.frecuenciasAbsolutas = frecuenciasAbsolutas;
        this.frecuenciasAcumuladas = frecuenciasAcumuladas;
        this.frecuenciasRelativas = frecuenciasRelativas;
    }

    public TablaDeFrecuencia() {
    }

    public Map<Integer, Clases> getClasesAgrupadas() {
        return clasesAgrupadas;
    }

    public void setClasesAgrupadas(Map<Integer, Clases> clasesAgrupadas) {
        this.clasesAgrupadas = clasesAgrupadas;
    }

    public Map<Integer, Clases> getLimitesReales() {
        return limitesReales;
    }

    public void setLimitesReales(Map<Integer, Clases> limitesReales) {
        this.limitesReales = limitesReales;
    }

    public List<Double> getPuntosMedios() {
        return puntosMedios;
    }

    public void setPuntosMedios(List<Double> puntosMedios) {
        this.puntosMedios = puntosMedios;
    }

    public List<Integer> getFrecuenciasAbsolutas() {
        return frecuenciasAbsolutas;
    }

    public void setFrecuenciasAbsolutas(List<Integer> frecuenciasAbsolutas) {
        this.frecuenciasAbsolutas = frecuenciasAbsolutas;
    }

    public List<Integer> getFrecuenciasAcumuladas() {
        return frecuenciasAcumuladas;
    }

    public void setFrecuenciasAcumuladas(List<Integer> frecuenciasAcumuladas) {
        this.frecuenciasAcumuladas = frecuenciasAcumuladas;
    }

    public List<Double> getFrecuenciasRelativas() {
        return frecuenciasRelativas;
    }

    public void setFrecuenciasRelativas(List<Double> frecuenciasRelativas) {
        this.frecuenciasRelativas = frecuenciasRelativas;
    }

    public Integer getNumeroDeClases() {
        return numeroDeClases;
    }

    public void setNumeroDeClases(Integer numeroDeClases) {
        this.numeroDeClases = numeroDeClases;
    }
}
