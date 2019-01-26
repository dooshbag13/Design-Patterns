package Behavioral.Visitor;
import java.text.DecimalFormat;

interface Visitor {
	double visitAndCalculate(Liquor liquorItem);
	double visitAndCalculate(Tobacco tobaccoItem);
	double visitAndCalculate(Food foodItem);
}

class TaxVisitor implements Visitor{
	DecimalFormat df = new DecimalFormat("#.##");
	@Override
	public double visitAndCalculate(Liquor liquorItem) {
		System.out.println("Liquor Item: Price with Tax");
		return Double.parseDouble(df.format((liquorItem.getPrice() * .18) + liquorItem.getPrice()));
	}
	@Override
	public double visitAndCalculate(Tobacco tobaccoItem) {
		System.out.println("Tobacco Item: Price with Tax");
		return Double.parseDouble(df.format((tobaccoItem.getPrice() * .32) + tobaccoItem.getPrice()));
	}
	@Override
	public double visitAndCalculate(Food foodItem) {
		System.out.println("Necessity Item: Price with Tax");
		return Double.parseDouble(df.format(foodItem.getPrice()));
	}
}
class TaxHolidayVisitor implements Visitor{
	DecimalFormat df = new DecimalFormat("#.##");
	@Override
	public double visitAndCalculate(Liquor liquorItem) {
		System.out.println("Liquor Item: Price with Tax");
		return Double.parseDouble(df.format((liquorItem.getPrice() * .10) + liquorItem.getPrice()));
	}
	@Override
	public double visitAndCalculate(Tobacco tobaccoItem) {
		System.out.println("Tobacco Item: Price with Tax");
		return Double.parseDouble(df.format((tobaccoItem.getPrice() * .28) + tobaccoItem.getPrice()));
	}
	@Override
	public double visitAndCalculate(Food foodItem) {
		System.out.println("Necessity Item: Price with Tax");
		return Double.parseDouble(df.format(foodItem.getPrice()));
	}
}

interface Visitable {
	double acceptAndCalculate(Visitor visitor);
}
class Tobacco implements Visitable {
	private double price;
	
	public Tobacco(double value) {
		this.price = value;
	}
	@Override
	public double acceptAndCalculate(Visitor visitor) {
		return visitor.visitAndCalculate(this);
	}
	public double getPrice() {
		return this.price;
	}
}
class Liquor implements Visitable {
	private double price;
	
	public Liquor(double value) {
		this.price = value;
	}
	@Override
	public double acceptAndCalculate(Visitor visitor) {
		return visitor.visitAndCalculate(this);
	}
	public double getPrice() {
		return this.price;
	}
}
class Food implements Visitable {
	private double price;
	
	Food(double value){
		this.price = value;
	}
	@Override
	public double acceptAndCalculate(Visitor visitor) {
		return visitor.visitAndCalculate(this);
	}
	public double getPrice() {
		return this.price;
	}
}


public class VisitorDemo {
	public static void main(String[] args) {
		Visitor taxCalc = new TaxVisitor();
		Visitor taxHolidayCalc = new TaxHolidayVisitor();
		
		Food bread = new Food(2.35);
		Liquor brandy = new Liquor(9.85);
		Tobacco kent = new Tobacco(6.25);
		
		System.out.println(bread.acceptAndCalculate(taxCalc));
		System.out.println(brandy.acceptAndCalculate(taxCalc));
		System.out.println(kent.acceptAndCalculate(taxCalc));
		
		System.out.println("TAX HOLIDAY PRICES");
		
		System.out.println(bread.acceptAndCalculate(taxHolidayCalc));
		System.out.println(brandy.acceptAndCalculate(taxHolidayCalc));
		System.out.println(kent.acceptAndCalculate(taxHolidayCalc));
	}
}
