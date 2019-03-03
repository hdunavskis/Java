import java.math.BigDecimal;

public class Student implements ICalculate {
    private BigDecimal amountToPay;
    private static final BigDecimal discountStartingRate = BigDecimal.valueOf(5.5);
    private static final BigDecimal discount = BigDecimal.valueOf(0.25);

    public BigDecimal calculate(BigDecimal hourlyNormalRate, BigDecimal hourlyReducedRate, int normalRateHours, int reducedRateHours){

        amountToPay = (hourlyNormalRate.multiply(BigDecimal.valueOf(normalRateHours))).add(
                hourlyReducedRate.multiply(BigDecimal.valueOf(reducedRateHours)));

        if(amountToPay.compareTo(discountStartingRate) > 0){
            BigDecimal dis = amountToPay.subtract(discountStartingRate);

            amountToPay = discountStartingRate.add((dis.subtract(dis.multiply(discount))));
            return amountToPay.setScale(2);
        }
        return amountToPay;
    }
}
