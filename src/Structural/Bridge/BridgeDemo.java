package Structural.Bridge;

import java.util.ArrayList;
import java.util.List;

class Movie {
	private String classification;
	private String runtime;
	private String title;
	private String year;
	public Movie(String classification, String runtime, String title, String year) {
		this.classification = classification;
		this.runtime = runtime;
		this.title = title;
		this.year = year;
	}
	public String getClassification() {
		return classification;
	}
	public String getRuntime() {
		return runtime;
	}
	public String getTitle() {
		return title;
	}
	public String getYear() {
		return year;
	}
}
class Detail {
	private String label;
	private String value;
	public Detail(String label, String value) {
		this.label = label;
		this.value = value;
	}
	public String getLabel() {
		return label;
	}
	public String getValue() {
		return value;
	}
}

abstract class Printer {
	public String print(Formatter formatter) {
		return formatter.format(getHeader(), getDetails());
	}
	protected abstract List<Detail> getDetails();
	protected abstract String getHeader();
}

class MoviePrinter extends Printer {
	private Movie movie;

	public MoviePrinter(Movie movie) {
		this.movie = movie;
	}
	@Override
	protected List<Detail> getDetails() {
		List<Detail> details = new ArrayList<>();
		details.add(new Detail("Title",   movie.getTitle()));
		details.add(new Detail("Year",    movie.getYear()));
		details.add(new Detail("Runtime", movie.getRuntime()));
		return details;
	}
	@Override
	protected String getHeader() {
		return movie.getClassification();
	}
}

interface Formatter {
	String format(String header, List<Detail> details);
}

class PrintFormatter implements Formatter {
	@Override
	public String format(String header, List<Detail> details) {
		StringBuilder builder = new StringBuilder();
		builder.append(header);
		builder.append("\n");
		for(Detail detail : details) {
			builder.append(detail.getLabel());
			builder.append(":");
			builder.append(detail.getValue());
			builder.append("\n");
		}
		return builder.toString();
	}
}

class HtmlFormatter implements Formatter {
	@Override
	public String format(String header, List<Detail> details) {
		StringBuilder builder = new StringBuilder();
		builder.append("<HTML TAG>");
		builder.append(header);
		for(Detail detail : details) {
			builder.append(detail.getLabel());
			builder.append(":");
			builder.append(detail.getValue());
		}
		builder.append("</HTML TAG>");
		return builder.toString();
	}
	
}

public class BridgeDemo {
	public static void main(String[] args) {
		Movie movie = new Movie("Action", "2.45", "Avatar", "2010");
		
		Formatter printFormatter = new PrintFormatter();
		Formatter htmlFormatter = new HtmlFormatter();
		
		Printer moviePrinter = new MoviePrinter(movie);
		
		String printedMaterial = moviePrinter.print(printFormatter);
		String printedHTMLMaterial = moviePrinter.print(htmlFormatter);
		
		System.out.println(printedMaterial);
		System.out.println(printedHTMLMaterial);
	}
}
