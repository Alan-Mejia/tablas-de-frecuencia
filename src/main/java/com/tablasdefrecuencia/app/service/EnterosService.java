package com.tablasdefrecuencia.app.service;

import com.tablasdefrecuencia.app.app.Clases;

import java.util.List;
import java.util.Map;

public interface EnterosService {
    Integer valorMaximo();
    Integer valorMinimo();
    Integer rango();
    Integer obtenerKporFormulaDeSurges();
    Integer amplitud();
    Map<Integer, Clases> agruparClases();
    Map<Integer, Clases> limitesReales();
    List<Double> puntoMedio();
    List<Integer> frecuenciaAbsoluta();
    List<Integer> frecuenciaAcumulada();
    List<Double> frecuenciaRelativa();
    void mostrarTablaDeFrecuenciaCompleta();

}
