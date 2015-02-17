package no.uib.gre002.info233.v2015.oblig2.testing;

import static org.junit.Assert.assertEquals;
import no.uib.gre002.info233.v2015.oblig2.io.ActivityParser;
import no.uib.gre002.info233.v2015.oblig2.models.Activity;

import org.junit.Before;
import org.junit.Test;

public class ActivityTest {
	private ActivityParser parser;
	

	@Before
	public void setup(){
		String url = "http://rom.app.uib.no/ukesoversikt/?entry=byggrom&building=SV%3A&room=SV%3AAS";
		parser = new ActivityParser(url, "AAS");
		
	}
	
	@Test
	public void testRoomCodeShouldReturnSV105() {
		assertEquals("AAS", parser.getActivityList().get(1).getRoom());
	}
	
	@Test
	public void testFirstActivity(){
		Activity testActivity = parser.getActivityList().get(1);
		assertEquals("ECON110", testActivity.getType());
		assertEquals("10:15", testActivity.getBeginTime().HOUR_OF_DAY + ":" + testActivity.getBeginTime().MINUTE);
	}

}
