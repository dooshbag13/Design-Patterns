package Behavioral.Visitor.V1;

public class DemoVisitor {
	public static void main(String[] args) {

		TaxVisitor taxCalc = new TaxVisitor();
		TaxHolidayVisitor taxHolidayCalc = new TaxHolidayVisitor();
		
		Food bread = new Food(2.35);
		Liquor brandy = new Liquor(9.85);
		Tobacco kent = new Tobacco(6.25);
		
		System.out.println(bread.calculate(taxCalc));
		System.out.println(brandy.calculate(taxCalc));
		System.out.println(kent.calculate(taxCalc));
		
		System.out.println("TAX HOLIDAY PRICES");
		
		System.out.println(bread.calculate(taxHolidayCalc));
		System.out.println(brandy.calculate(taxHolidayCalc));
		System.out.println(kent.calculate(taxHolidayCalc));
		
	}
}
