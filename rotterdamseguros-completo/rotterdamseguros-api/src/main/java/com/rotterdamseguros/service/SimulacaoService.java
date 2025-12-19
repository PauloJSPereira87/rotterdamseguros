package com.rotterdamseguros.service;

import org.springframework.stereotype.Service;

@Service
public class SimulacaoService {

    public double calcularValor(int ano, String plano) {
        double valor = 100;

        if (ano >= 2020) valor += 20;
        else if (ano >= 2015) valor += 30;
        else if (ano >= 2010) valor += 40;
        else valor += 60;

        if ("INTERMEDIARIO".equalsIgnoreCase(plano)) valor += 40;
        if ("COMPLETO".equalsIgnoreCase(plano)) valor += 80;

        return valor;
    }
}