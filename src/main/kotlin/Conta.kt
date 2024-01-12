package br.com.hawkbank

data class Conta(val titular: String, val agencia: Int, val numero: Int, val saldo: Double) {
    override fun toString(): String {
        return "Conta(titular='$titular', agencia=$agencia, numero=$numero, saldo=$saldo)"
    }
}