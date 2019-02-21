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
		
		new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test
	public void testCase2() {
		
		BigDecimal normalRate = new BigDecimal(0);
		BigDecimal reducedRate = new BigDecimal(0);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(1,2));
		reducedPeriod.add(new Period(2,3));
		
		new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCase3() {
		
		BigDecimal normalRate = new BigDecimal(-1);
		BigDecimal reducedRate = new BigDecimal(0);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(1,2));
		reducedPeriod.add(new Period(2,3));
		
		new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test
	public void testCase4() {
		
		BigDecimal normalRate = new BigDecimal(0);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(1,2));
		reducedPeriod.add(new Period(2,3));
		
		new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCase5() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(2);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(1,2));
		reducedPeriod.add(new Period(2,3));
		
		new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test
	public void testCase6() {
		
		BigDecimal normalRate = new BigDecimal(2);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(1,2));
		reducedPeriod.add(new Period(2,3));
		
		new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCase7() {
		
		BigDecimal normalRate = null;
		BigDecimal reducedRate = new BigDecimal(2);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(1,2));
		reducedPeriod.add(new Period(2,3));
		
		new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCase8() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(-1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(1,2));
		reducedPeriod.add(new Period(2,3));
		
		new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCase9() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = null;
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(1,2));
		reducedPeriod.add(new Period(2,3));
		
		new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test
	public void testCase10() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(1,2));
		reducedPeriod.add(new Period(2,3));
		
		new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test
	public void testCase11() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(0);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(1,2));
		reducedPeriod.add(new Period(2,3));
		
		new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCase12() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(1,2));
		reducedPeriod.add(new Period(1,2));
		
		new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test
	public void testCase13() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(1,2));
		reducedPeriod.add(new Period(2,3));
		
		new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
	}
	@Test
	public void testCase14() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(3,4));
		reducedPeriod.add(new Period(22,23));
		
		Rate r = new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
		assertEquals(1, r.calculate(normalPeriod.get(0)));
	}
	@Test
	public void testCase15() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(0,0));
		reducedPeriod.add(new Period(22,23));
		
		Rate r = new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
		assertEquals(0, r.calculate(normalPeriod.get(0)));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCase16() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(-2,0));
		reducedPeriod.add(new Period(2,3));
		
		Rate r = new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
		r.calculate(normalPeriod.get(0));
	}
	@Test
	public void testCase17() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(3,4));
		reducedPeriod.add(new Period(22,23));
		
		Rate r = new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
		assertEquals(1, r.calculate(reducedPeriod.get(0)));
	}
	@Test
	public void testCase18() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(3,4));
		reducedPeriod.add(new Period(0,0));
		
		Rate r = new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
		assertEquals(0, r.calculate(reducedPeriod.get(0)));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCase19() {
		
		BigDecimal normalRate = new BigDecimal(1);
		BigDecimal reducedRate = new BigDecimal(1);
		ArrayList<Period> normalPeriod = new ArrayList<Period>();
		ArrayList<Period> reducedPeriod = new ArrayList<Period>();
		
		normalPeriod.add(new Period(1,2));
		reducedPeriod.add(new Period(-2,0));
		
		Rate r = new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
		r.calculate(reducedPeriod.get(0));
	}
	

}
