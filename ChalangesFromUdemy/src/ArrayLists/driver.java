package ArrayLists;

import java.util.Scanner;

public class driver {
	
	private static Scanner scanner = new Scanner(System.in);
	private static MobilePhone mobile = new MobilePhone("name", "12345");
	
	private static void printActions() {
		
		System.out.println("\nAvailable actions:\npress:");
		System.out.println("0 - to shutdown");
		System.out.println("1 - to print contacts");
		System.out.println("2 - to add a new contact");
		System.out.println("3 - to update existing contact");
		System.out.println("4 - to remove an existing contact");
		System.out.println("5 - query if an existing contact exists");
		System.out.println("6 - to print a list of available actions.");
		System.out.println("Choose your action: ");
		
		
	}
	
	public static void addNewContact() {
		
		System.out.print("Enter name");
		String name = scanner.next();
		System.out.println("Enter phone number");
		String number = scanner.next();
		
		Contacts newContact = Contacts.createContact(name, number);
		if(mobile.addNew(newContact)) {
			
			System.out.println("New contact addded: " + name + " phone " + number);
		
		} else {
			
			System.out.println("Cant add. Name alredy exist.");
			
		}
	}
	
	public static void updateContact() {
		
		System.out.println("Enter contact you want to update: ");
		String oldContact = scanner.next();
		Contacts existingContact = mobile.queryContacts(oldContact);
		
		if(existingContact == null) {
			System.out.println("Contact not found!");
			return;
		}
		
		
		System.out.println("Enter new name for contact: ");
		String newContact = scanner.next();
		System.out.println("Enter new phone number: ");
		String newNumber = scanner.next();
		
		Contacts newContacts = Contacts.createContact(newContact, newNumber);
		
		if(mobile.updateContact(existingContact, newContacts)) {
			System.out.println("Successfully updated record!");
		} else {
			
			System.out.println("Record was not updated.");
		}
		
	}

	public static void removeContact() {
		
		System.out.println("Enter contact you want delete ");
		String name = scanner.next();
		
		Contacts deleteContact = mobile.queryContacts(name);
	
		if(deleteContact == null) {
			
			System.out.println("Contact not found!");
			return;
	
		} 
		
		mobile.removeContact(deleteContact);
		System.out.println("Record deleted successfully!");
		
	}
	
	public static void queryContact() {
		
		System.out.println("Enter name of contact you are looking for: ");
		String name = scanner.next();
		
		Contacts queryContact = mobile.queryContacts(name);
		
		if(queryContact == null) {
			
			System.out.println("Contact not found!");
			return;
		}
		
		System.out.println("Phone number for " + queryContact.getName() + " is: " + queryContact.getPhoneNumber());
		
		
		
	}
	public static void main(String[] args) {
	
		boolean quit = false;
	
		printActions();
		
		
		
		while(!quit) {
			
			System.out.println("Enter action: (6 to show available actions)");
			int action = scanner.nextInt();
			
			switch(action) {
			
			case 0:
				System.out.println("Shutting down");
				quit = true;
				break;
			case 1:
				mobile.printContacts();
				break;
				
			case 2:
				addNewContact();
				break;
				
			case 3:
				updateContact();
				break;
				
			case 4:
				removeContact();
				break;
				
			case 5:
				queryContact();
				break;
				
			case 6:
				printActions();
				break;
				
				
			}
			
			
		}
		
	}

}
