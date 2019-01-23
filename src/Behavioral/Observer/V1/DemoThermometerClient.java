package Behavioral.Observer.V1;

public class DemoThermometerClient implements Observer { 
	
	@Override
	public void update(Observable o) {
		Thermometer t = (Thermometer) o;
		System.out.println(
				"Observer is showing temperature :\n "
				+ "\t"
				+ t.getTemperatureCelsius()
				+ ", "
				+ t.getTemperatureKelvin()
				+ ", "
				+ t.getTemperatureFahrenheit()
		);
	}
	
	public static void main(String[] args) {
		
		Thermometer thermometer 	 = new Thermometer();
		Driver driver 				 = new Driver(thermometer);
		DemoThermometerClient client = new DemoThermometerClient();

		thermometer.addObserver(client);

		driver.start();
		
		try { 
			Thread.sleep(20_000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.shutdown();
	}
}

