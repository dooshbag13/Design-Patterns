package Structural.Flyweight;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

// Immutable State Object
class Item {
	private final String name;

	public Item(String name) {
		this.name = name;
	}
	public String toString() {
		return name;
	}
}
// FactoryObject
class ItemsCatalog {
	private final Map<String, Item> items = new HashMap<>();
	
	public Item lookup(String itemName) {
		if (!items.containsKey(itemName)) {
			items.put(itemName, new Item(itemName));
		}
		return items.get(itemName);
	}
	public int totalItemsMade() {
		return items.size();
	}
}

class Order {
	private final int orderNumber;
	private final Item item;

	public Order(int orderNumber, Item item) {
		this.orderNumber = orderNumber;
		this.item = item;
	}
	void processOrder() {
		System.out.println("Ordering " + item + " for numuber " + orderNumber);
	}
}

class InventorySystem {
	private final ItemsCatalog catalog = new ItemsCatalog();
	private final List<Order> orders = new CopyOnWriteArrayList<>();

	void takeOrder(String itemName, int orderNumber) {
		Item item = catalog.lookup(itemName);
		Order order = new Order(orderNumber, item);
		orders.add(order);
	}
	void process() {
		for (Order order : orders) {
			order.processOrder();
			orders.remove(order);
		}
	}
	String report() {
		return "\nTotal Item objects made: " + catalog.totalItemsMade();
	}
}

public class FlyweightDemo {
	public static void main(String[] args) {
		InventorySystem ims = new InventorySystem();

		ims.takeOrder("Computer", 312);
		ims.takeOrder("Drone", 1334);
		ims.takeOrder("Computer", 312);
		ims.takeOrder("Drone", 1334);
		ims.takeOrder("Food", 4512);
		ims.takeOrder("Computer", 312);
		ims.takeOrder("Food", 4512);

		ims.process();

		System.out.println(ims.report());
	}
}
