package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import abstraction.Arguments;

public class ControllerSubmit implements ActionListener{
	
	private Arguments arg;
	private static JButton ok;
	private JLabel call;
	private JLabel put;
	private JLabel deltaCall;
	private JLabel deltaPut;
	private JLabel gammaCall;
	private JLabel gammaPut;
	private JLabel thetaCall;
	private JLabel thetaPut;
	private JLabel vegaCall;
	private JLabel vegaPut;
	private JLabel rhoCall;
	private JLabel rhoPut;
	
	public static boolean actualValueCompleted=false;
	public static boolean interestRateCompleted=false;
	public static boolean strikePriceCompleted=false;
	public static boolean timeRemainingCompleted=false;
	public static boolean volatilityCompleted=false;
	
	public ControllerSubmit(Arguments arg, JButton ok,JLabel call, JLabel put,
			JLabel deltaCall, JLabel deltaPut, JLabel gammaCall,
			JLabel gammaPut, JLabel thetaCall, JLabel thetaPut,
			JLabel vegaCall, JLabel vegaPut, JLabel rhoCall, JLabel rhoPut) {
		super();
		this.arg = arg;
		ControllerSubmit.ok =ok;
		ControllerSubmit.ok.addActionListener(this);
		this.call=call;
		this.put = put;
		this.deltaCall = deltaCall;
		this.deltaPut = deltaPut;
		this.gammaCall = gammaCall;
		this.gammaPut = gammaPut;
		this.thetaCall = thetaCall;
		this.thetaPut = thetaPut;
		this.vegaCall = vegaCall;
		this.vegaPut = vegaPut;
		this.rhoCall = rhoCall;
		this.rhoPut = rhoPut;
	}
	public static void change(){
		//System.out.println(actualValueCompleted+""+interestRateCompleted+""+strikePriceCompleted+""+timeRemainingCompleted+""+volatilityCompleted);
		if(actualValueCompleted && interestRateCompleted && strikePriceCompleted && timeRemainingCompleted && volatilityCompleted){
			ok.setEnabled(true);
		}
		else{
			ok.setEnabled(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		arg.setD1(arg.calculusd1());
		arg.setD2(arg.calculusd2());
		this.call.setText(arg.call()+"");
		this.deltaCall.setText(arg.deltaCall()+"");
		this.deltaPut.setText(arg.deltaPut()+"");
		this.gammaCall.setText(arg.gamma()+"");
		this.gammaPut.setText(arg.gamma()+"");
		this.put.setText(arg.put()+"");
		this.rhoCall.setText(arg.rhoCall()+"");
		this.rhoPut.setText(arg.rhoPut()+"");
		this.thetaCall.setText(arg.thetaCall()+"");
		this.thetaPut.setText(arg.thetaPut()+"");
		this.vegaCall.setText(arg.vega()+"");
		this.vegaPut.setText(arg.vega()+"");
		ok.setEnabled(false);
	}
	
}