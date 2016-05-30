package tddmicroexercises.tirepressuremonitoringsystem;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.mockito.Mockito;

public class TestAlarm {

    
	@Test
    public void shouldBeOffAsDefault() {
        Alarm alarm = new Alarm();
        assertEquals(false, alarm.isAlarmOn());
    }
    
    @Test
	public void shouldBeOnWhenValueAboveTheHighPressureTreshold() throws Exception {
		
    	Sensor sensor = mock(Sensor.class);
		Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(22d);
		
		Alarm alarm = new Alarm(sensor);
		alarm.check();
		assertEquals(true, alarm.isAlarmOn());
		
	}
    
    @Test
	public void shouldBeOnWhenValueBelowTheLowPressureTreshold() throws Exception {
		Sensor sensor = mock(Sensor.class);
		Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(1d);
		
		Alarm alarm = new Alarm(sensor);
		alarm.check();
		assertEquals(true, alarm.isAlarmOn());
	}
}
