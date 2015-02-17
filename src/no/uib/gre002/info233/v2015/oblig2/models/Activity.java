package no.uib.gre002.info233.v2015.oblig2.models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.jsoup.nodes.Node;

/**
 * Class representing activities, containing information about which subject it
 * belongs to, a description of it and when and where it takes place.
 * 
 * @author Anders
 *
 */
public class Activity implements ActivityInterface, Serializable {

	private static final long serialVersionUID = -4962193791986602328L;
	private Node activityNode;
	private String emne;
	private String description;
	private String roomCode;
	private String weekday;
	private Calendar startCalendar;
	private Calendar endCalendar;

	/**
	 * 
	 * @param activityNode
	 *            Node containing the activity itself
	 * @param emne
	 *            String representing the subject
	 * @param time
	 *            String representation of start and endtime of the activity
	 * @param description
	 *            String description of the activity
	 * @param roomCode
	 *            String representation of the code for the room the activity
	 *            takes place in
	 * @param date
	 *            String representation of the date for the activity
	 */

	public Activity(Node activityNode, String emne, String time,
			String description, String roomCode, String date) {

		weekday = date.substring(0, 7);
		date = date.substring(8, date.length());

		this.startCalendar = parseCalendarDate(date, time.substring(0, 5));
		this.endCalendar = parseCalendarDate(date, time.substring(6, 11));
		this.activityNode = activityNode;
		this.emne = emne;
		this.description = description;
		this.roomCode = roomCode;

	}

	/**
	 * 
	 * @param dateString
	 *            String containing the date for the activity in a dd.mm.yyyy
	 *            format
	 * @param timeString
	 *            String containing the start or endtime for the activity in a
	 *            hh:mm format
	 * @return A Calendar object with the time and date input, or null if either
	 *         parameter is invalid
	 */

	private Calendar parseCalendarDate(String dateString, String timeString) {

		String formatedDateString = timeString + "." + dateString;
		SimpleDateFormat dateformater = new SimpleDateFormat("HH:mm.dd.MM.yyyy");

		try {
			Date date = dateformater.parse(formatedDateString);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			return cal;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Returns a string representation of the object with the date, time and
	 * room code
	 */
	@Override
	public String toString() {
		return roomCode + " " + emne + " " + description + " "
				+ startCalendar.get(Calendar.DAY_OF_MONTH) + "."
				+ startCalendar.get(Calendar.MONTH) + "."
				+ startCalendar.get(Calendar.YEAR) + "  "
				+ startCalendar.get(Calendar.HOUR_OF_DAY) + ":"
				+ startCalendar.get(Calendar.MINUTE);
	}

	/**
	 * Returns the Node object containing the information about this activity
	 */
	@Override
	public Node getNode() {
		return activityNode;
	}

	/**
	 * Returns which subject the activity belongs to
	 */
	@Override
	public String getType() {
		return emne;
	}

	/**
	 * Returns the room code for the room where the activity takes place
	 */
	@Override
	public String getRoom() {
		return roomCode;
	}

	/**
	 * Returns the date and time as a Calendar at which the activity starts
	 */
	@Override
	public Calendar getBeginTime() {
		return startCalendar;
	}

	/**
	 * Returns the date and time as a Calendar at which the activity ends
	 */
	@Override
	public Calendar getEndTime() {
		return endCalendar;
	}

	/**
	 * Returns a string description of the activity (same as getType())
	 */
	@Override
	public String getDescription() {
		return description;
	}

}
