package com.company.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;

@Controller("home")
@SessionScope
public class AppController {
  private String teste = "Ola, tudo certo";


  @PostConstruct
  public void init(){
    this.teste = "Ola, tudo certo";
    System.out.println("================= // =========================");
    }

  public String getTeste() {
    return teste;
  }

  public void setTeste(String teste) {
    this.teste = teste;
  }
}
