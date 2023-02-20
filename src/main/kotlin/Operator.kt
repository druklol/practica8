open class Operator(val operatorName: String, val priceOneMinute: Double, val coverageArea: Double) {

    open fun calculation():Double{
        val Q = 100*coverageArea/priceOneMinute
        return Q
    }
    fun printInfo() {
        println("оператор:$operatorName , цена в минуту:$priceOneMinute , площадь покрытия:$coverageArea, q:${calculation()}")
    }

}