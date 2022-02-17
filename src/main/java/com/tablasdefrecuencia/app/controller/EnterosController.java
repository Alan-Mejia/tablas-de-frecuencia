package com.tablasdefrecuencia.app.controller;

import com.tablasdefrecuencia.app.app.CalculosConDecimales;
import com.tablasdefrecuencia.app.app.CalculosConEnteros;
import com.tablasdefrecuencia.app.app.Clases;
import com.tablasdefrecuencia.app.entity.TablaDeFrecuencia;
import com.tablasdefrecuencia.app.service.EnterosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class EnterosController {
    @Autowired
    EnterosService enterosService;

//    @GetMapping("decimales/{listaDeNumeros}")
//    public TablaDeFrecuencia calcularTablaDeFr(@PathVariable List<String> listaDeNumeros){
//        List<Double> arregloDeNumeros = new ArrayList<>();
//        for (String valor: listaDeNumeros){
//            arregloDeNumeros.add(Double.parseDouble(valor));
//        }
//        CalculosConDecimales calculos = new CalculosConDecimales(arregloDeNumeros);
//
//
//        TablaDeFrecuencia tabla = new TablaDeFrecuencia();
//        Map<Integer,Clases> clasesNumero = calculos.agruparClases();
//        Integer numeroDeClases = clasesNumero.size();
//        tabla.setNumeroDeClases(numeroDeClases);
//        tabla.setClasesAgrupadas(calculos.agruparClases());
//        tabla.setLimitesReales(calculos.limitesReales());
//        tabla.setPuntosMedios(calculos.puntoMedio());
//        tabla.setFrecuenciasAbsolutas(calculos.frecuenciaAbsoluta());
//        tabla.setFrecuenciasAcumuladas(calculos.frecuenciaAcumulada());
//        tabla.setFrecuenciasRelativas(calculos.frecuenciaRelativa());
//
//        System.out.println("Mapeo con decimales");
//        return tabla;
//    }

    @GetMapping("enteros/{numerosAconvertir}")
    public TablaDeFrecuencia entregarTablaCalculada(@PathVariable List<String> numerosAconvertir){
        System.out.println(numerosAconvertir.size());
        List<Integer> arregloDeNumeros = new ArrayList<>();
        for (String valor: numerosAconvertir){
            arregloDeNumeros.add(Integer.parseInt(valor));
        }

        CalculosConEnteros calculosConEnteros = new CalculosConEnteros(arregloDeNumeros);
        TablaDeFrecuencia tabla = new TablaDeFrecuencia();
        Map<Integer, Clases> clasesNumero = calculosConEnteros.agruparClases();
        Integer numeroDeClases = clasesNumero.size();
        tabla.setNumeroDeClases(numeroDeClases);
        tabla.setClasesAgrupadas(calculosConEnteros.agruparClases());
        tabla.setLimitesReales(calculosConEnteros.limitesReales());
        tabla.setPuntosMedios(calculosConEnteros.puntoMedio());
        tabla.setFrecuenciasAbsolutas(calculosConEnteros.frecuenciaAbsoluta());
        tabla.setFrecuenciasAcumuladas(calculosConEnteros.frecuenciaAcumulada());
        tabla.setFrecuenciasRelativas(calculosConEnteros.frecuenciaRelativa());
        System.out.println("Termina el mapeo");
        return tabla;
    }

}
