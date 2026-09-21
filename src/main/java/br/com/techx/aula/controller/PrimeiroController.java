package br.com.techx.aula.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aula")
public class PrimeiroController {


    @GetMapping("/ola")
    public String ola(){
        return "Olá Spring boot";
    }
}
