package br.edu.ifsp.dmo.calculodemedia.model

class MediaHarmonica : MediaStrategy {
    override fun calcular(valores: List<Double>, pesos: List<Double>?): Double {
        return valores.size / valores.sumOf { 1 / it }
    }
}
