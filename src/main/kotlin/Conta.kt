package br.com.hawkbank

class Conta(var agencia: Int, var numero: Int, var titular: String, var saldo: Double) {
    constructor() : this(0, 0, "", 0.0)

    override fun toString(): String {
        return "HAWKBANK: Agencia: $agencia Numero: $numero Titular: $titular saldo: $saldo"
    }
}