package com.ait.practice;

public enum Lecturer {
	Al(18),
	L(16),
	SL(10);
	
	Lecturer(int contactHoursPerWeek){
		this.contactHoursPerWeek = contactHoursPerWeek;
	}
	private int contactHoursPerWeek;
	private int yearService;
	private boolean hasMasters;
	private boolean hasPhd;

	public String toString() {
		StringBuilder s = new StringBuilder();
		switch(contactHoursPerWeek) {
			case 18:
				s.append("Assistant Lecurer:\n");
				break;
			case 16:
				s.append("Lecurer:\n");
				break;
			case 10:
				s.append("Senior Lecturer:\n");
				break;
			default:
				return null;
		}
		s.append(hasMasters? "Has a Masters.\n": "Does not have a Masters.\n");
		s.append(hasPhd? "Does have a PhD:\n": "Does not have a PhD:\n");
		s.append(contactHoursPerWeek + " contact hours/week;\n");
		s.append(getYearsService() + " years of service");
		return s.toString();
	}
	public int getContactHoursPerWeek() {
		return contactHoursPerWeek;
	}
	public int getYearsService() {
		return yearService;
	}
	public boolean hasMasters() {
		return hasMasters;
	}
	public boolean hasPhd() {
		return hasPhd;
	}
	public void setYears(int years) {
		this.yearService = years;
	}
	public void setMasters(boolean masters) {
		this.hasMasters = masters;
	}
	public void setPhd(boolean phd) {
		this.hasPhd = phd;
	}

}
