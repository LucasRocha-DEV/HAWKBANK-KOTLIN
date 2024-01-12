package br.com.hawkbank

import java.util.Scanner

fun main() {

    val persistenceManager = PersistenceManager()
    val scanner = Scanner(System.`in`)
    var `while` = true

    println("Digite 1 para criar uma nova conta, 2 para carregar contas existentes, 3 para remover uma conta: 4 para encerrar o programa.")
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

            val novaConta = Conta(titular, agencia, numero, saldo)


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
        "3" -> {
            val conta: List<Conta>? = persistenceManager.loadData()
            println("Contas carregadas: $conta")
            println("Digite o número da conta que deseja remover:")
            val numeroContaParaRemover = scanner.nextLine().toInt()

            // Carrega as contas existentes
            val contas: MutableList<Conta> = persistenceManager.loadData()?.toMutableList() ?: mutableListOf()

            // Encontra a conta que corresponde ao número fornecido pelo usuário
            val contaParaRemover = contas.find { it.numero == numeroContaParaRemover }

            if (contaParaRemover != null) {
                // Remove a conta da lista
                contas.remove(contaParaRemover)

                // Salva a lista atualizada
                persistenceManager.saveData(contas)

                println("Conta removida com sucesso!")
            } else {
                println("Conta não encontrada.")
            }
        }
        "4" -> {
            `while` = false
            println("encerrar programa")
        }
        else -> {
            println("Opção inválida!")
        }
    }
}