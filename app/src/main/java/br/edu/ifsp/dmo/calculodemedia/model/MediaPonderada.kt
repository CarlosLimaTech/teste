package br.edu.ifsp.dmo.calculodemedia.model

class MediaPonderada : MediaStrategy {
    override fun calcular(valores: List<Double>, pesos: List<Double>?): Double {
        val somatorioPesos = pesos?.sum() ?: 1.0
        return valores.zip(pesos!!).sumOf { it.first * it.second } / somatorioPesos
    }
}
