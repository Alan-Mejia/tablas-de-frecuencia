package com.tablasdefrecuencia.app.app;

public class Clases <T> {
    private T desde;
    private T hasta;

    public Clases() {
    }

    public T getDesde() {
        return desde;
    }

    public void setDesde(T desde) {
        this.desde = desde;
    }

    public T getHasta() {
        return hasta;
    }

    public void setHasta(T hasta) {
        this.hasta = hasta;
    }
}
