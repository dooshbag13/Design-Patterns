package Behavioral.Visitor.V1;

public interface Visitor {
	double calculate(Liquor liquorItem);
	double calculate(Tobacco tobaccoItem);
	double calculate(Food foodItem);
}
