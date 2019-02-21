package JUnitProject;

import java.math.BigDecimal;
import java.util.ArrayList;;

public class Rate {
	
	private CarParkKind kind;
	private BigDecimal normalRate;
	private BigDecimal reducedRate;
	private ArrayList<Period> reducedPeriods;
	private ArrayList<Period> normalPeriods;
	
	public Rate(CarParkKind kind, BigDecimal normalRate, BigDecimal reducedRate, ArrayList<Period> reducedPeriods,
			ArrayList<Period> normalPeriods) {
		
		this.kind = kind;
		this.normalRate = normalRate;
		this.reducedRate = reducedRate;
		this.reducedPeriods = reducedPeriods;
		this.normalPeriods = normalPeriods;
	}
	
	
public BigDecimal calculate(Period periodStay) {
	return BigDecimal.TEN;
}

}
