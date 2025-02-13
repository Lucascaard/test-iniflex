package com.iniflex.service;

import com.iniflex.model.*;
import com.iniflex.util.*;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.text.DecimalFormat;
import java.math.BigDecimal;

public class FuncionarioService {
    private List<Funcionario> funcionarios;

    public FuncionarioService() {
        this.funcionarios = new ArrayList<>();
    }

    // 3.1 - Insere todos os funcionários
    public void inserirFuncionarios() {
        funcionarios = FuncionarioUtil.gerarFuncionarios();
    }

    // 3.2 - Remove o funcionário "João"
    public void removerFuncionario() {
        funcionarios.removeIf(f -> f.getNome().equals("João"));
    }

    // Optei por criar esta parte da logica separada para poder utilizar tanto na 3.3 quanto na 3.4
    public void imprimeFuncionarios(){
        DecimalFormat df = new DecimalFormat("#,##0.00");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (Funcionario f : funcionarios) {
            String salarioFormatado = df.format(f.getSalario());
            salarioFormatado = salarioFormatado.replace(",", "X").replace(".", ",").replace("X", ".");

            System.out.printf(
                    "Nome: %s | Data Nasc.: %s | Salário: R$%s | Função: %s%n",
                    f.getNome(),
                    f.getDataNascimento().format(dtf),
                    salarioFormatado,
                    f.getFuncao()
            );
        }
    }

    // 3.3 - Imprime todos os funcionários com formatação
    public void TodosFuncionarios() {
        System.out.println(FuncionarioUtil.Separador());
        System.out.println("3.3 - Imprime todos os funcionários com formatação\n");
        imprimeFuncionarios();
    }

    // 3.4 - Atualiza salários (10% de aumento)
    public void atualizarSalarios() {

        System.out.println(FuncionarioUtil.Separador());
        System.out.println("3.4 - Atualiza salários (10% de aumento)\n");
        for (Funcionario f : funcionarios) {
            BigDecimal aumento = f.getSalario().multiply(new BigDecimal("0.10"));
            f.setSalario(f.getSalario().add(aumento));
        }
        System.out.println("Todos os salarios receberam 10% de aumento, aqui esta a lista atualizada: \n");
        imprimeFuncionarios();
    }

    // 3.5 - Agrupa funcionários por função
    public Map<String, List<Funcionario>> agruparPorFuncao() {
        Map<String, List<Funcionario>> mapa = new HashMap<>();
        for (Funcionario f : funcionarios) {
            mapa.computeIfAbsent(f.getFuncao(), k -> new ArrayList<>()).add(f);
        }
        return mapa;
    }

    // 3.6 - Imprimir funcionários agrupados por função
    public void imprimirAgrupadosPorFuncao() {
        System.out.println(FuncionarioUtil.Separador());
        System.out.println("3.5 e 3.6 - Agrupa e imprime por função");
        Map<String, List<Funcionario>> mapa = agruparPorFuncao();

        for (Map.Entry<String, List<Funcionario>> entry : mapa.entrySet()) {
            System.out.printf("\n=== %s ===%n", entry.getKey());
            for (Funcionario f : entry.getValue()) {
                System.out.printf("  - %s%n", f.getNome());
            }
        }
    }

    // 3.8 - Imprime aniversariantes de outubro e dezembro
    public void imprimirAniversariantesMes() {
        System.out.println(FuncionarioUtil.Separador());
        System.out.println("3.8 - Imprime aniversariantes de outubro e dezembro\n");
        System.out.println("Aniversariantes em Outubro e Dezembro:");
        for (Funcionario f : funcionarios) {
            int mes = f.getDataNascimento().getMonthValue();
            if (mes == 10 || mes == 12) {
                System.out.printf("%s - %s%n",
                        f.getNome(),
                        f.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                );
            }
        }
    }

    // 3.9 - Encontra o funcionário mais velho
    public void encontrarMaisVelho() {
        System.out.println(FuncionarioUtil.Separador());
        System.out.println("3.9 - Encontra o funcionário mais velho");
        Funcionario maisVelho = Collections.max(
                funcionarios,
                Comparator.comparing(Pessoa::calcularIdade)
        );

        System.out.printf("\nFuncionário mais velho: %s (%d anos)%n",
                maisVelho.getNome(),
                maisVelho.calcularIdade()
        );
    }

    // 3.10 - Ordena lista alfabeticamente e imprime
    public void ordenarAlfabetica() {
        System.out.println(FuncionarioUtil.Separador());
        System.out.println("3.10 - Ordena lista alfabeticamente e imprime\n");
        Collections.sort(funcionarios,
                Comparator.comparing(Funcionario::getNome));
        for (Funcionario f : funcionarios) {
            System.out.printf("%s%n", f.getNome());
        }
    }

    // 3.11 - Calcula total de salários e imprime
    public void totalSalarios() {
        System.out.println(FuncionarioUtil.Separador());
        System.out.println("3.11 - Calcula total de salários e imprime");

        BigDecimal total = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // Formata o número com ponto como separador de milhar e vírgula como decimal
        DecimalFormat df = new DecimalFormat("#,##0.00");
        String totalFormatado = df.format(total);
        totalFormatado = totalFormatado.replace(",", ".");

        System.out.printf("\nTotal de salários: R$%s%n", totalFormatado);
    }

    // 3.12 - Calcula quantos salários mínimos cada funcionário ganha
    public void quantidadeSalariosMinimo() {
        System.out.println(FuncionarioUtil.Separador());
        System.out.println("3.12 - Calcula quantos salários mínimos cada funcionário ganha\n");
        BigDecimal salarioMinimo = new BigDecimal("1212.00");

        // Ordena a lista de funcionários pelo salário (maior para menor)
        Collections.sort(funcionarios,
                Comparator.comparing(Funcionario::getSalario)
                        .reversed());

        // Imprime cada funcionário com sua quantidade de salários mínimos
        for (Funcionario f : funcionarios) {
            BigDecimal quantidade = f.getSalario()
                    .divide(salarioMinimo, 2, RoundingMode.HALF_UP);

            System.out.printf(
                    "%s ganha %.2f salários mínimos%n",
                    f.getNome(), quantidade
            );
        }
    }
}