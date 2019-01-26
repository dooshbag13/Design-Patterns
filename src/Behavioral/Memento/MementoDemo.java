package Behavioral.Memento;

import java.util.Stack;

class Employee {
	private String name;
	private String address;
	private String phone;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public EmployeeMemento save() {
		return new EmployeeMemento(name, phone);
	}
	public void revert(EmployeeMemento emem) {
		this.name = emem.getName();
		this.phone = emem.getPhone();
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", address=" + address + ", phone=" + phone + "]";
	}
}

class EmployeeMemento {
	private final String name;
	private final String phone;
	
	public EmployeeMemento(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
}

class CareTaker {
	private final Stack<EmployeeMemento> history = new Stack<>();
	
	public void save(Employee emp) {
		history.push(emp.save());
	}
	public void revert(Employee emp) {
		emp.revert(history.pop());
	}
}

public class MementoDemo {
	public static void main(String[] args) {
		CareTaker caretaker = new CareTaker();
		Employee emp = new Employee();
		
		emp.setName("Sally Cooper");
		emp.setAddress("111 Main Street");
		emp.setPhone("08876654238");
		
		System.out.println("Before save: " + emp);
		caretaker.save(emp);
		
		emp.setPhone("2222222222");
		
		caretaker.revert(emp);
		System.out.println("After revert: " + emp);
	}

}
