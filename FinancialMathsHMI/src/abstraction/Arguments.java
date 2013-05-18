package abstraction;

import org.apache.commons.math3.distribution.NormalDistribution;

public class Arguments {

	private double actualValue;
	private double timeRemaining;
	private double strikePrice;
	private double interestRate;
	private double volatility;
	private double d1;
	private double d2;
	private NormalDistribution nd;
	
	public Arguments(double actualValue, double timeRemaining,
			double strikePrice, double interestRate, double volatility) {
		super();
		this.nd = new NormalDistribution();
		this.actualValue = actualValue;
		this.timeRemaining = timeRemaining;
		this.strikePrice = strikePrice;
		this.interestRate = interestRate;
		this.volatility = volatility;
		this.d1 = calculusd1();
		this.d2 = calculusd2();
	}
	
	public double calculusd1(){
		return (1/(this.volatility*Math.sqrt(timeRemaining)))*(Math.log(actualValue/strikePrice)+(interestRate+0.5*Math.pow(volatility, 2))*timeRemaining);
	}
	
	public double calculusd2(){
		return d1-volatility*Math.sqrt(timeRemaining);
	}
	
	public double call(){
		double part1 = actualValue*nd.cumulativeProbability(d1);
		double part2 = strikePrice*Math.exp(-interestRate*timeRemaining)*nd.cumulativeProbability(d2);
		return part1+part2;
	}
	
	public double put(){
		double part1 = -actualValue*nd.cumulativeProbability(-d1);
		double part2 = strikePrice*Math.exp(-interestRate*timeRemaining)*nd.cumulativeProbability(-d2);
		return part1+part2;
	}
	
	public double deltaCall(){
		return nd.cumulativeProbability(d1);
	}
	
	public double deltaPut(){
		return nd.cumulativeProbability(d1)-1;
	}
	
	public double gamma(){
		double part1 = Math.exp(-0.5*Math.pow(d1, 2));
		double part2 = actualValue*volatility*Math.sqrt(2*Math.PI*timeRemaining);
		return part1/part2;
	}
	
	public double thetaCall(){
		double part1 = -actualValue*volatility*Math.exp(-0.5*Math.pow(d1, 2))/(2*Math.sqrt(2*Math.PI*timeRemaining));
		double part2 = -interestRate*strikePrice*Math.exp(-interestRate*timeRemaining)*nd.cumulativeProbability(d2);
		return part1+part2;
	}
	
	public double thetaPut(){
		double part1 = actualValue*volatility*Math.exp(-0.5*Math.pow(d1, 2))/(2*Math.sqrt(2*Math.PI*timeRemaining));
		double part2 = interestRate*strikePrice*Math.exp(-interestRate*timeRemaining)*nd.cumulativeProbability(d2);
		return part1+part2;
	}
	
	public double rhoCall(){
		return strikePrice*timeRemaining*Math.exp(-interestRate*timeRemaining)*nd.cumulativeProbability(d2);
	}
	
	public double rhoPut(){
		return -strikePrice*timeRemaining*Math.exp(-interestRate*timeRemaining)*nd.cumulativeProbability(-d2);
	}
	
	public double vega(){
		return actualValue*Math.sqrt(timeRemaining)*Math.exp(-0.5*Math.pow(d1, 2))/(Math.sqrt(2*Math.PI));
	}
}
