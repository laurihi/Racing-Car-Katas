package tddmicroexercises.tirepressuremonitoringsystem;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TestAlarm {

    private static final Double LOW_PRESSURE_TRESHOLD = 17d;
    private static final Double HIGH_PRESSURE_TRESHOLD = 21d;

    private Sensor sensor;
	private Alarm alarm;

	@Before
	public void setUp(){
		sensor = mock(Sensor.class);
		alarm = new Alarm(sensor);
	}
	
	@Test
    public void shouldBeOffAsDefault() {
        assertEquals(false, alarm.isAlarmOn());
    }
    
    @Test
	public void shouldBeOnWhenValueAboveTheHighPressureTreshold() throws Exception {
		
		Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(22d);
		alarm.check();
		assertEquals(true, alarm.isAlarmOn());
		
	}
    
    @Test
	public void shouldBeOnWhenValueBelowTheLowPressureTreshold() throws Exception {
		Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(1d);
		alarm.check();
		assertEquals(true, alarm.isAlarmOn());
	}
    
    @Test
	public void shouldBeOffWhenAtTheLowPressureTreshold() throws Exception {
    	Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE_TRESHOLD);
		alarm.check();
		assertEquals(false, alarm.isAlarmOn());
	}
    
    @Test
	public void shouldBeOffWhenAtTheHighPressureTreshold() throws Exception {
    	Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(HIGH_PRESSURE_TRESHOLD);
		alarm.check();
		assertEquals(false, alarm.isAlarmOn());
	}
}
