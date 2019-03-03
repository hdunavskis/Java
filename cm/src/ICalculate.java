import java.math.BigDecimal;

public interface ICalculate {
    BigDecimal calculate  (BigDecimal hourlyNormalRate, BigDecimal hourlyReducedRate, int normalRateHours, int reducedRateHours);
   // BigDecimal calculate  (Period period);
}
