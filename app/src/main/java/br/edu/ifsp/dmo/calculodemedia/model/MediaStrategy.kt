package br.edu.ifsp.dmo.calculodemedia.model

interface MediaStrategy {
    fun calcular(valores: List<Double>, pesos: List<Double>? = null): Double
}