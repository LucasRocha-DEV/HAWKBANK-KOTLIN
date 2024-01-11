package br.com.hawkbank

fun main() {
    fun Conta.transferir(valor: Double, destino: Conta): Boolean {
        return if (this.saldo >= valor) {
            this.saldo -= valor
            destino.saldo += valor
            true // transferência bem-sucedida
        } else {
            false // saldo insuficiente
        }
    }
    println("primeira conta:")

    val conta1 = Conta()

    conta1.titular = "Lucas"
    println("Titular: ${conta1.titular}")

    conta1.agencia = 1234
    println("agencia: ${conta1.agencia}")

    conta1.numero = 123456
    println("numero da conta: ${conta1.numero}")

    conta1.saldo = 200.0
    println("saldo inicial: ${conta1.saldo}")

    conta1.saldo += 800
    println("alteração: ${conta1.saldo}")

    conta1.saldo -= 50
    println("atual: ${conta1.saldo}")

    println()
    println()

    // segunda conta
    println("segunda conta:")

    val conta2 = Conta()

    conta2.titular = "Bruna"
    println("Titular: ${conta2.titular}")

    conta2.agencia = 1234
    println("agencia: ${conta2.agencia}")

    conta2.numero = 123456
    println("numero da conta: ${conta2.numero}")

    conta2.saldo = 500.0
    println("saldo inicial: ${conta2.saldo}")

    conta2.saldo += 100
    println("alteração: ${conta2.saldo}")

    conta2.saldo -= 150
    println("atual: ${conta2.saldo}")

    println()
    println()

    println("!!!primeira conta tem: ${conta1.saldo}!!!")
    println("!!!segunda conta tem: ${conta2.saldo}!!!")

    println()
    println()

    if (conta1.transferir(400.0, conta2)) {
        println("Transferência bem-sucedida!")
    } else {
        println("Saldo insuficiente para a transferência.")
    }

    println()
    println()

    println("!!!primeira conta tem: ${conta1.saldo}!!!")
    println("!!!segunda conta tem: ${conta2.saldo}!!!")

    println()
    println()

    if (conta2.transferir(50.0, conta1)) {
        println("Transferência bem-sucedida!")
    } else {
        println("Saldo insuficiente para a transferência.")
    }

    println()
    println()

    println("!!!primeira conta tem: ${conta1.saldo}!!!")
    println("!!!segunda conta tem: ${conta2.saldo}!!!")
}