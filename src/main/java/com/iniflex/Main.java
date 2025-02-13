package com.iniflex;

import com.iniflex.service.FuncionarioService;

public class Main {
    public static void main(String[] args) {
        FuncionarioService service = new FuncionarioService();

        // 3.1 - Inserir funcionários (void)
        service.inserirFuncionarios();

        // 3.2 - Remover João (void)
        service.removerFuncionario();

        // 3.3 - Imprimir todos os Funcionarios
        service.TodosFuncionarios();

        // 3.4 - Atualizar salários
        service.atualizarSalarios();

        // 3.5 e 3.6 - Agrupar e imprimir por função
        service.imprimirAgrupadosPorFuncao();

        // 3.8 - Imprimir aniversariantes
        service.imprimirAniversariantesMes();

        // 3.9 - Encontrar mais velho
        service.encontrarMaisVelho();

        // 3.10 - Ordenar alfabeticamente
        service.ordenarAlfabetica();

        // 3.11 - Total de salários
        service.totalSalarios();

        // 3.12 - Quantidade de salários mínimos
        service.quantidadeSalariosMinimo();
    }
}