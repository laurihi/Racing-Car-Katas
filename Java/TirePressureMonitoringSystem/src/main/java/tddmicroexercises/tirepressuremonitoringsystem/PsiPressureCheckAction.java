package tddmicroexercises.tirepressuremonitoringsystem;

public class PsiPressureCheckAction {

    private final double LowPressureTreshold = 17;
    private final double HighPressureTreshold = 21;
    
    public boolean isPsiPressureWithinTreshold(double psiPressureValue){
    	
    	boolean result = true;
    	if (psiPressureValue < LowPressureTreshold || HighPressureTreshold < psiPressureValue)
    	{
    		result = false;
    	}
    	return result;
    }
}
