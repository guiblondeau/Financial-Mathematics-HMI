package test;

import org.apache.commons.math3.distribution.NormalDistribution;

import presentation.Window;

public class Test {

	public static void main (String[] args){
		NormalDistribution n= new NormalDistribution();
		double d = n.cumulativeProbability(0);
		System.out.println(d);
		
		Window w=new Window();
	}
}
