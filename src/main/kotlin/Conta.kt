package br.com.hawkbank

class Conta {
    var saldo: Double = 100.0
    var agencia: Int = 0
    var numero: Int = 0
    var titular: String = ""


    fun depositar(valor: Double) {
        saldo += valor
    }

    fun sacar(valor: Double): Boolean {
        return if (saldo >= valor) {
            saldo -= valor
            println("Saque Bem-sucedido.")
            true // saque bem-sucedido
        } else {
            false
        }
    }

    override fun toString(): String {
        return "Conta com saldo: $saldo"
    }
}