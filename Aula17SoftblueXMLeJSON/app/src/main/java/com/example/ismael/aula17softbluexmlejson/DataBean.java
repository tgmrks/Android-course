package com.example.ismael.aula17softbluexmlejson;

/**
 * Created by ismael on 08/07/15.
 */
public class DataBean {

    private int min;
    private int max;
    private int qtde;

    public DataBean (int min, int max, int qtde) {
        this.min = min;
        this.max = max;
        this.qtde = qtde;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }
}
