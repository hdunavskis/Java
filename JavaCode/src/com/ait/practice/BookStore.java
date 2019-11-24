package com.ait.practice;

public class BookStore {
	public BookStore() {
		System.out.println("Creating the BookStore class...");
	}
	public Book getABook(String r, String s, boolean b, int i) {
		
		return new BookImpl(r, s, b, i);
	}
	class BookImpl implements Book{

		private String title;
		private String author;
		private boolean isBestSeller;
		private int howManyLanguages;
		
		BookImpl(String r, String s, boolean b, int i){
			System.out.println("Creating the private inner class object accessible via an interfaces reference...");
			this.title = r;
			this.author = s;
			this.isBestSeller  = b;
			this.howManyLanguages = i;
		}
		@Override
		public int howManyLanguages() {
			return howManyLanguages;
		}

		@Override
		public boolean isBestSeller() {
			
			return isBestSeller;
		}
		
	}
}
