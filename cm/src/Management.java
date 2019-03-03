import java.math.BigDecimal;

public class Management implements ICalculate {
    private BigDecimal amountToPay;
    private static final BigDecimal minToPay = BigDecimal.valueOf(3);

    public BigDecimal calculate(BigDecimal hourlyNormalRate, BigDecimal hourlyReducedRate, int normalRateHours, int reducedRateHours){


        amountToPay = (hourlyNormalRate.multiply(BigDecimal.valueOf(normalRateHours))).add(
                hourlyReducedRate.multiply(BigDecimal.valueOf(reducedRateHours)));

        if(amountToPay.compareTo(minToPay) < 0){
            return minToPay;
        }
        return  amountToPay;
    }
}
