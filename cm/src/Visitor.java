import java.math.BigDecimal;

public class Visitor implements ICalculate {
    private BigDecimal amountToPay;
    private static final BigDecimal freeCredit = BigDecimal.valueOf(8);
    private static final BigDecimal discount = BigDecimal.valueOf(0.5);

    public BigDecimal calculate(BigDecimal hourlyNormalRate, BigDecimal hourlyReducedRate, int normalRateHours, int reducedRateHours){

        amountToPay = (hourlyNormalRate.multiply(BigDecimal.valueOf(normalRateHours))).add(
                hourlyReducedRate.multiply(BigDecimal.valueOf(reducedRateHours)));

        if(amountToPay.compareTo(freeCredit) > 0){

            return freeCredit.add((amountToPay.subtract(freeCredit)).multiply(discount));
        }
        return  amountToPay;
    }
}
