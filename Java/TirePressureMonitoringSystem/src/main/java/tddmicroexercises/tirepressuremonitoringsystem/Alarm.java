package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm
{
	boolean alarmOn = false;
	
    private Sensor sensor = new Sensor();
    private PsiPressureCheckAction pressureCheck = new PsiPressureCheckAction();
    
    public Alarm(){
    }
    
    public Alarm(Sensor sensor){
    	this.sensor=sensor;
    }

    public void check()
    {
        double psiPressureValue = sensor.popNextPressurePsiValue();
        boolean withinTreshold = pressureCheck.isPsiPressureWithinTreshold(psiPressureValue);
        alarmOn = !withinTreshold;
    }

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
    

}
