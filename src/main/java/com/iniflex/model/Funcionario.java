package com.iniflex.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    // Construtor
    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    // Getters e Setters
    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    // Método para formatar o salário no padrão brasileiro
    public String getSalarioFormatado() {
        NumberFormat formatador = NumberFormat.getInstance(new Locale("pt", "BR"));
        return formatador.format(salario);
    }

    @Override
    public String toString() {
        return super.toString() + ", Função: " + funcao + ", Salário: R$ " + getSalarioFormatado();
    }
}
