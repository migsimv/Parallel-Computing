import java.math.BigDecimal;

class GeometricProgression{
    BigDecimal value, ratio, temp;
//    temp = value;
    public synchronized void padidinti() {
//        Kritine sritis
        value = value.multiply(ratio);
    }
}