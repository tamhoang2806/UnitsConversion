package ca.bcit.comp2052.hoang4.unitsconversion;

public class Converter {
	public Converter()
	{
		
	}

    public double lbtokg(double input)
    {
    	double output = input / (double)2.2 ;
    	return output;
    }
    public double kgtolb(double input)
    {
    	double output = input * (double)2.2;
    	return output;
    }
    public double ftoc(double input)
    {
    	double output = (input - 32)*5/9;
    	return output;
    }
    public double ctof(double input)
    {
    	double output = input * 9 / 5 +32;
    	return output;
    }
    public double kmtomiles(double input)
    {
    	double output = input/(double)1.609;
    	return output;
    
    }
    public double milestokm(double input)
    {
    	double output = input*(double)1.609;
    	return output;
    
    }
}
