package com.tablasdefrecuencia.app.app;

import com.tablasdefrecuencia.app.service.EnterosService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CalculosConEnteros implements EnterosService {

    private List<Integer> arregloDeNumeros = new ArrayList<>();

    public CalculosConEnteros(List<Integer> arregloDeNumeros) {
        this.arregloDeNumeros = arregloDeNumeros;
    }

    @Override
    public Integer valorMaximo() {
        Integer numeroMasGrande = arregloDeNumeros.get(0);
        for (int i = 0; i < arregloDeNumeros.size(); i++) {
            if (arregloDeNumeros.get(i) > numeroMasGrande) {
                numeroMasGrande = arregloDeNumeros.get(i);
            }
        }
        return numeroMasGrande;
    }

    @Override
    public Integer valorMinimo() {
        Integer numeroMasPequenio = arregloDeNumeros.get(0);
        for (int i = 0; i < arregloDeNumeros.size(); i++) {
            if (arregloDeNumeros.get(i) < numeroMasPequenio) {
                numeroMasPequenio = arregloDeNumeros.get(i);
            }
        }
        return numeroMasPequenio;
    }

    @Override
    public Integer rango() {
        return valorMaximo() - valorMinimo();
    }

    @Override
    public Integer obtenerKporFormulaDeSurges() {
        Integer k = 0;
        while (Math.pow(2,k) < arregloDeNumeros.size()){
            k++;
        }
        return k;
    }

    @Override
    public Integer amplitud(){
        Float amplitud = (float)(rango()/(obtenerKporFormulaDeSurges()*1.0));
        while (Math.round(amplitud) * obtenerKporFormulaDeSurges() < rango()){
            amplitud++;
        }
        return Math.round(amplitud);
    }

    @Override
    public Map<Integer, Clases> agruparClases() {
        HashMap<Integer,Clases> arregloDeClases = new HashMap<Integer,Clases>();
        Integer claves=0;

        Integer desde = valorMinimo();
        Integer hasta = valorMinimo() + amplitud();
        final Integer salto = 1;

        for(int i = 0; i < obtenerKporFormulaDeSurges(); i++){
            // Clave se va a ir incrementando
            claves++;
            Clases clases = new Clases();
            clases.setDesde(desde);
            clases.setHasta(hasta);
            arregloDeClases.put(claves,clases);
            desde = hasta + salto;
            hasta = desde + amplitud();
        }

        return arregloDeClases;
    }

    @Override
    public Map<Integer, Clases> limitesReales() {
        Map<Integer, Clases> arregloDeClases = agruparClases();
        Integer claves=0;
        for(int i = valorMinimo(); i <= (((amplitud()-1)*(obtenerKporFormulaDeSurges())) + valorMinimo() + (obtenerKporFormulaDeSurges()-1)) ; i+= (amplitud()-1)){
            // Clave se va a ir incrementando
            claves++;

            Clases clase=new Clases();
            clase.setDesde(i-0.5);
            clase.setHasta(((i)+(amplitud()-1)) + 0.5);

            arregloDeClases.put(claves,clase);

            //Salto de 1 unidad entre clases
            i++;
        }
        return arregloDeClases;
    }

    @Override
    public List<Double> puntoMedio() {
        List<Double> puntosMedios = new ArrayList<Double>();
        Map<Integer,Clases> clases = agruparClases();
        Integer clave = 1;
        for(int i=0;i<obtenerKporFormulaDeSurges();i++){
            Double limiteInferior = Double.parseDouble(String.valueOf(clases.get(clave).getDesde()));
            Double limiteSuperior = Double.parseDouble(String.valueOf(clases.get(clave).getHasta()));
            puntosMedios.add(i,((limiteInferior+limiteSuperior)/2.0));
            clave++;
        }
        return puntosMedios;
    }

    @Override
    public List<Integer> frecuenciaAbsoluta() {
        Map<Integer,Clases> clases = agruparClases();
        Integer numeroDeNumerosEnIntervalo =0;
        Integer clave =1;

        List<Integer> frecuenciaAbsoluta = new ArrayList<>();
        for(int i=0;i<obtenerKporFormulaDeSurges();i++){
            for(int j=0;j<arregloDeNumeros.size();j++){
                if(arregloDeNumeros.get(j) >= Integer.parseInt(String.valueOf(clases.get(clave).getDesde()))
                        && arregloDeNumeros.get(j) <= Integer.parseInt(String.valueOf(clases.get(clave).getHasta()))){
                    numeroDeNumerosEnIntervalo++;
                }
            }
            frecuenciaAbsoluta.add(i,numeroDeNumerosEnIntervalo);
            numeroDeNumerosEnIntervalo = 0;
            clave++;
        }
        return frecuenciaAbsoluta;
    }


    @Override
    public List<Integer> frecuenciaAcumulada() {
        List<Integer> frecuenciaAcumulada = new ArrayList<>();
        List<Integer> frecuenciaAbsoluta = frecuenciaAbsoluta();
        Integer suma;
        Integer agregarEnLista;
        for(int i=0;i<frecuenciaAbsoluta.size();i++){
            if(i == 0){
                frecuenciaAcumulada.add(i,frecuenciaAbsoluta.get(i));
            }else{
                // La suma del actual mas el anterior
                suma = (frecuenciaAbsoluta.get(i))+(frecuenciaAbsoluta.get(i-1));
                // Actualizamos la suma en el arreglo para irla acumulando
                frecuenciaAbsoluta.set(i,suma);
                // Definimos una variable auxiliar
                agregarEnLista = frecuenciaAbsoluta.set(i,suma);
                frecuenciaAcumulada.add(i,agregarEnLista);
            }
        }
        return frecuenciaAcumulada;
    }

    @Override
    public List<Double> frecuenciaRelativa() {
        List<Integer> frecuenciaAbsoluta = frecuenciaAbsoluta();
        List<Double> frecuenciaRelativa = new ArrayList<>();
        for(int i=0; i<frecuenciaAbsoluta.size(); i++){
            frecuenciaRelativa.add(i,(frecuenciaAbsoluta.get(i)/(arregloDeNumeros.size()*1.0)));
        }
        return frecuenciaRelativa;
    }

    @Override
    public void mostrarTablaDeFrecuenciaCompleta() {
        double clases = obtenerKporFormulaDeSurges();
        Map<Integer, Clases> clasesYlimites = agruparClases();
        Map<Integer, Clases> clasesYlimitesReales = limitesReales();
        List<Double> puntosMedios = puntoMedio();
        List<Integer> frecuenciasAbsolutas = frecuenciaAbsoluta();
        List<Integer> frecuenciasAcumuladas = frecuenciaAcumulada();
        List<Double> frecuenciasRelativas = frecuenciaRelativa();
        Integer clave = 1;
        System.out.println("Class" + "\t" + "Lim" + "\t\t\t" + "Lim R" + "\t\t" + "Xi" + "\t\t" + "Fi" + "\t" + "fi" + "\t\t" +  "FR");
        for (int i = 0; i < clases; i++) {
            System.out.print(i + 1 + "\t" + "[" + clasesYlimites.get(clave).getDesde() + " - " + clasesYlimites.get(clave).getHasta() + "]" + "\t"
                    + "[" + clasesYlimitesReales.get(clave).getDesde() + " - " + clasesYlimitesReales.get(clave).getHasta() + "]" + "\t"
                    + puntosMedios.get(i) + "\t" + frecuenciasAbsolutas.get(i) + "\t" + frecuenciasAcumuladas.get(i) + "\t" + frecuenciasRelativas.get(i));
            clave++;
            System.out.println();
        }
    }









}
