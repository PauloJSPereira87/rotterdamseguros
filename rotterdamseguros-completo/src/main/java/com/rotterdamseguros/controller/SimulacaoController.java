package com.rotterdamseguros.controller;

import com.rotterdamseguros.model.Lead;
import com.rotterdamseguros.repository.LeadRepository;
import com.rotterdamseguros.service.SimulacaoService;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SimulacaoController {

    private final SimulacaoService service;
    private final LeadRepository repository;

    public SimulacaoController(SimulacaoService service, LeadRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @PostMapping("/simulacao")
    public Map<String, Object> simular(@RequestBody Lead lead) {
        double valor = service.calcularValor(lead.getAno(), lead.getPlano());
        lead.setValorEstimado(valor);
        repository.save(lead);

        String msg = "Olá! Fiz uma simulação no RotterdamSeguros.com\n" +
                "Nome: " + lead.getNome() + "\n" +
                "Veículo: " + lead.getMarca() + " " + lead.getModelo() + " " + lead.getAno() + "\n" +
                "Plano: " + lead.getPlano() + "\n" +
                "Valor estimado: R$ " + valor;

        String whatsappLink = "https://wa.me/55" + lead.getWhatsapp() +
                "?text=" + URLEncoder.encode(msg, StandardCharsets.UTF_8);

        return Map.of(
                "valorEstimado", valor,
                "whatsappLink", whatsappLink
        );
    }
}