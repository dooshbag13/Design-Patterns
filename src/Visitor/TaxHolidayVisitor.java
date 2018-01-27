package Visitor;

import java.text.DecimalFormat;

public class TaxHolidayVisitor implements Visitor{
	
	DecimalFormat df = new DecimalFormat("#.##");
	
	public TaxHolidayVisitor() {
		
	}

	@Override
	public double visit(Liquor liquorItem) {
		
		System.out.println("Liquor Item: Price with Tax");
  
		return Double.parseDouble(df.format((liquorItem.getPrice() * .10) + liquorItem.getPrice()));
	}

	@Override
	public double visit(Tobacco tobaccoItem) {
		
		System.out.println("Tobacco Item: Price with Tax");

		return Double.parseDouble(df.format((tobaccoItem.getPrice() * .28) + tobaccoItem.getPrice()));
	}

	@Override
	public double visit(Food foodItem) {
		
		System.out.println("Necessity Item: Price with Tax");

		return Double.parseDouble(df.format(foodItem.getPrice()));
	}
	
	
	
}
