package com.tablasdefrecuencia.app.controller;

import com.tablasdefrecuencia.app.app.CalculosConDecimales;
import com.tablasdefrecuencia.app.app.CalculosConEnteros;
import com.tablasdefrecuencia.app.app.Clases;
import com.tablasdefrecuencia.app.entity.TablaDeFrecuencia;
import com.tablasdefrecuencia.app.service.DecimalesService;
import com.tablasdefrecuencia.app.service.EnterosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@CrossOrigin("*")
public class DecimalesController {

    @Autowired
    DecimalesService decimalesService;

    @GetMapping("decimales/{listaDeNumeros}")
    public TablaDeFrecuencia calcularTablaDeFr(@PathVariable List<String> listaDeNumeros){
        List<Double> arregloDeNumeros = new ArrayList<>();
        for (String valor: listaDeNumeros){
            arregloDeNumeros.add(Double.parseDouble(valor));
        }
        CalculosConDecimales calculos = new CalculosConDecimales(arregloDeNumeros);


        TablaDeFrecuencia tabla = new TablaDeFrecuencia();
        Map<Integer,Clases> clasesNumero = calculos.agruparClases();
        Integer numeroDeClases = clasesNumero.size();
        tabla.setNumeroDeClases(numeroDeClases);
        tabla.setClasesAgrupadas(calculos.agruparClases());
        tabla.setLimitesReales(calculos.limitesReales());
        tabla.setPuntosMedios(calculos.puntoMedio());
        tabla.setFrecuenciasAbsolutas(calculos.frecuenciaAbsoluta());
        tabla.setFrecuenciasAcumuladas(calculos.frecuenciaAcumulada());
        tabla.setFrecuenciasRelativas(calculos.frecuenciaRelativa());

        System.out.println("Mapeo con decimales");
        return tabla;
    }
}
