package br.com.hawkbank

import java.util.Scanner

fun main() {

    val persistenceManager = PersistenceManager()
    val scanner = Scanner(System.`in`)

    println("Digite 1 para criar uma nova conta, 2 para carregar contas existentes:")
    when (scanner.nextLine()) {
        "1" -> {
            println("Digite a agência da conta:")
            val agencia = scanner.nextLine().toInt()

            println("Digite o número da conta:")
            val numero = scanner.nextLine().toInt()

            println("Digite o titular da conta:")
            val titular = scanner.nextLine()

            println("Digite o saldo inicial da conta:")
            val saldo = scanner.nextLine().toDouble()

            val novaConta = Conta(agencia, numero, titular, saldo)

            // Carrega as contas existentes, se houver
            val contas: MutableList<Conta> = persistenceManager.loadData()?.toMutableList() ?: mutableListOf()

            // Adiciona a nova conta à lista
            contas.add(novaConta)

            // Salva a lista atualizada
            persistenceManager.saveData(contas)

            println("Conta criada e salva com sucesso!")
        }
        "2" -> {
            val contas: List<Conta>? = persistenceManager.loadData()
            if (contas != null) {
                for (conta in contas) {
                    println("Conta carregada: $conta")
                }
            } else {
                println("Nenhuma conta encontrada.")
            }
        }
        else -> {
            println("Opção inválida!")
        }
    }
}