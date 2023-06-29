package com.cadCompany.desafio.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/cep")
@CrossOrigin(origins = "*")
public class CepController {
    
    @GetMapping("/{cep}")
    public ResponseEntity<String> getCepDetails(@PathVariable String cep) {
        // Faz a chamada à API de CEPs
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "http://cep.la/" + cep;
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);

        // Verifica se a chamada foi bem-sucedida e retorna os dados
        if (response.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.ok(response.getBody());
        } else {
            return ResponseEntity.status(response.getStatusCode()).build();
        }
    }
}
