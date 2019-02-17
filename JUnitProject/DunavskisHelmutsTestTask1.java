package JUnitProject;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Test;

public class DunavskisHelmutsTestTask1 {

	@Test
	public void testCase1() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(0);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(1,2));
		reducedPeriod.add(new Period(2,3));
		
		new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test
	public void testCase2() {
		
		BigDecimal normalRate = new BigDecimal(0);
		BigDecimal reducedRate = new BigDecimal(0);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(1,2));
		reducedPeriod.add(new Period(2,3));
		
		new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCase3() {
		
		BigDecimal normalRate = new BigDecimal(-1);
		BigDecimal reducedRate = new BigDecimal(0);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(1,2));
		reducedPeriod.add(new Period(2,3));
		
		new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCase4() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(2);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(1,2));
		reducedPeriod.add(new Period(2,3));
		
		new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCase5() {
		
		BigDecimal normalRate = null;
		BigDecimal reducedRate = new BigDecimal(2);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(1,2));
		reducedPeriod.add(new Period(2,3));
		
		new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test
	public void testCase6() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(0);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(1,2));
		reducedPeriod.add(new Period(2,3));
		
		new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test
	public void testCase7() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(1,2));
		reducedPeriod.add(new Period(2,3));
		
		new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCase8() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(-1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(1,2));
		reducedPeriod.add(new Period(2,3));
		
		new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCase9() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(2);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(1,2));
		reducedPeriod.add(new Period(2,3));
		
		new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCase10() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = null;
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(1,2));
		reducedPeriod.add(new Period(2,3));
		
		new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCase11() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(1,2));
		reducedPeriod.add(new Period(1,2));
		
		new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test
	public void testCase12() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(1,2));
		reducedPeriod.add(new Period(2,3));
		
		new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCase13() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(-1,2));
		reducedPeriod.add(new Period(1,2));
		
		new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCase14() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(1,-2));
		reducedPeriod.add(new Period(2,3));
		
		new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test
	public void testCase15() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(1,2));
		reducedPeriod.add(new Period(2,3));
		
		new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test
	public void testCase16() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(0,1));
		reducedPeriod.add(new Period(1,2));
		
		new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCase17() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(1,2));
		reducedPeriod.add(new Period(-1,3));
		
		new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCase18() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(1,2));
		reducedPeriod.add(new Period(3,-2));
		
		new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCase19() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(1,1));
		reducedPeriod.add(new Period(2,3));
		
		new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCase20() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(1,2));
		reducedPeriod.add(new Period(2,2));
		
		new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCase21() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(24,0));
		reducedPeriod.add(new Period(3,4));
		
		new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCase22() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(23,24));
		reducedPeriod.add(new Period(3,4));
		
		new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test
	public void testCase23() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(23,0));
		reducedPeriod.add(new Period(3,4));
		
		new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCase24() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(-1,0));
		reducedPeriod.add(new Period(3,4));
		
		new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test
	public void testCase25() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(23,0));
		reducedPeriod.add(new Period(3,4));
		
		new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCase26() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(3,4));
		reducedPeriod.add(new Period(24,0));
		
		new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCase27() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(3,4));
		reducedPeriod.add(new Period(23,24));
		
		new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test
	public void testCase28() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(3,4));
		reducedPeriod.add(new Period(23,0));
		
		new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCase29() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(3,4));
		reducedPeriod.add(new Period(-1,0));
		
		new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test
	public void testCase30() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(3,4));
		reducedPeriod.add(new Period(22,23));
		
		new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test
	public void testCase31() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(3,4));
		reducedPeriod.add(new Period(22,23));
		
		Rate r = new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
		
		assertEquals(1, r.Calculate(normalPeriod.get(0)));
	}
	@Test
	public void testCase32() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(0,0));
		reducedPeriod.add(new Period(22,23));
		
		Rate r = new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
		
		assertEquals(0, r.Calculate(normalPeriod.get(0)));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCase33() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(-2,0));
		reducedPeriod.add(new Period(4,5));
		
		new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
		Rate r = new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
		
		r.Calculate(normalPeriod.get(0));
	}
	@Test
	public void testCase34() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(3,4));
		reducedPeriod.add(new Period(22,23));
		
		Rate r = new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
		
		assertEquals(1, r.Calculate(reducedPeriod.get(0)));
	}
	@Test
	public void testCase35() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(3,4));
		reducedPeriod.add(new Period(0,0));
		
		Rate r = new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
		
		assertEquals(1, r.Calculate(reducedPeriod.get(0)));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCase36() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(1,2));
		reducedPeriod.add(new Period(-2,0));
		
		new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
		Rate r = new Rate(carParkingKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
		
		r.Calculate(reducedPeriod.get(0));
	}

}
