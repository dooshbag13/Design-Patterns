package Visitor;

public interface Visitor {
	double visit(Liquor liquorItem);
	double visit(Tobacco tobaccoItem);
	double visit(Food foodItem);
}
