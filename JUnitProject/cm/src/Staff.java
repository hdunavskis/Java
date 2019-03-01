import java.math.BigDecimal;

public class Staff {

    private BigDecimal amountToPay;
    private static final BigDecimal maxPay = BigDecimal.valueOf(16);
    public BigDecimal calculate(BigDecimal hourlyNormalRate, BigDecimal hourlyReducedRate, int normalRateHours, int reducedRateHours){


        amountToPay = (hourlyNormalRate.multiply(BigDecimal.valueOf(normalRateHours))).add(
                hourlyReducedRate.multiply(BigDecimal.valueOf(reducedRateHours)));

        if(amountToPay.compareTo(maxPay) > 0){
            return maxPay;
        }
        return amountToPay;
    }
}
