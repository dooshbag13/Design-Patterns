package Behavioral.Observer;

import java.util.HashSet;
import java.util.Set;

abstract class Observable {
	private Set<Observer> observers;
	
	public Observable() {
		this.observers = new HashSet<Observer>();
	}
	public void addObserver(Observer o) {
		this.observers.add(o);
	}
	public void removeObserver(Observer o) {
		this.observers.remove(o);
	}
	protected void notifyObservers() {
		for(Observer observer : observers) {
			observer.update(this);
		}
	}
}

class Thermometer extends Observable{
	public double temperatureInKelvin = -1.0;
	private final String KELVIN_FORMAT = "%,.1fK";
	private final String CELSIUS_FORMAT = "%,.1fC";
	private final String FAHRENHEIT_FORMAT = "%,.1fF";
	
	void setNewValue(long value) {
		this.temperatureInKelvin = value;
		super.notifyObservers();
	}
	public String getKelvin() {
		return String.format(KELVIN_FORMAT, this.temperatureInKelvin);
	}
	public String getFahrenheit() {
		return String.format(CELSIUS_FORMAT, (this.temperatureInKelvin - 273.15));
	}
	public String getCelsius() {
		return String.format(FAHRENHEIT_FORMAT, (this.temperatureInKelvin*9/5 - 459.67));
	}
}

interface Observer {
	public void update(Observable o);
}

class TempDisplay implements Observer { 
	@Override
	public void update(Observable o) {
		Thermometer t = (Thermometer) o;
		System.out.println("Temp: "+t.getCelsius()+", "+t.getKelvin()+", "+t.getFahrenheit());
	}
}

public class ObserverDemo {
	public static void main(String[] args) {
		Thermometer thermometer = new Thermometer();
		TempDisplay tempDisplay = new TempDisplay();

		thermometer.addObserver(tempDisplay);
		thermometer.setNewValue(234);
		thermometer.setNewValue(442);
	}
}

