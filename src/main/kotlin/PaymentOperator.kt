class PaymentOperator( operatorName: String, priceOneMinute:Double, coverageArea:Double,var P:Boolean):Operator(operatorName, priceOneMinute, coverageArea) {

    override fun calculation(): Double {
        val q:Double=100*coverageArea/priceOneMinute
        if(P) {
            val Qp: Double = 0.7 *q
            return Qp
        }
        else {
            val Qp = 1.5 * q
            return Qp
        }
    }

}
