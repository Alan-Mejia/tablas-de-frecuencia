package com.tablasdefrecuencia.app.service;

import com.tablasdefrecuencia.app.app.Clases;

import java.util.List;
import java.util.Map;

public interface DecimalesService {
    Double valorMinimo();
    Double valorMaximo();
    Integer obtenerKporFormulaDeSurges();

    // No se redondea
    Double rango();

    // No se redondea
    // La clave va a estar aqui, dependendiendo de cuantos numeros despues del punto tomemos, van a ser los numero con decimales que va a soportar nuestro programa
    Double amplitud();

    // Los atributos de las clases deben de ser Double
    // Aqui se va sumando la frecuencia completa
    Map<Integer, Clases> agruparClases();
    Map<Integer, Clases> limitesReales();
    List<Double> puntoMedio();
    List<Integer> frecuenciaAbsoluta();
    List<Integer> frecuenciaAcumulada();
    List<Double> frecuenciaRelativa();
    void mostrarTablaDeFrecuenciaCompleta();
}
