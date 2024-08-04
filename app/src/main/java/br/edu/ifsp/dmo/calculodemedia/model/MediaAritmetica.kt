package br.edu.ifsp.dmo.calculodemedia.model

class MediaAritmetica : MediaStrategy {
    override fun calcular(valores: List<Double>, pesos: List<Double>?): Double {
        return valores.sum() / valores.size
    }
}
