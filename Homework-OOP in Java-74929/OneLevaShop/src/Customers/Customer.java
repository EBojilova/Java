package Customers;

import Messages.Messages;


public class Customer {
	private String name;
	private int age;
	private double balance;
	
	public Customer(String name, int age, double balance) {
		super();
		this.setName(name);
		this.setAge(age);
		this.setBalance(balance);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.length() == 0) {
			throw new IllegalArgumentException(Messages.invalidCustomerName);
		}
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age < 0) {
			throw new IllegalArgumentException(Messages.invalidCustomerAge);
		}
		this.age = age;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		if (balance < 0) {
			throw new IllegalArgumentException(Messages.invalidCustomerBalance);
		}
		this.balance = balance;
	}
	
	public void exetutePayment(double productPrice) {
		if (productPrice > this.getBalance()) {
			throw new IllegalArgumentException(Messages.notEnoughMoney);
		}
		this.balance -= productPrice;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(String.format("Customer name: %s\nCustomer age: %d\nCustomer balance: %.2f\n", 
				this.name, this.age, this.balance));
		return result.toString();
	}

}
