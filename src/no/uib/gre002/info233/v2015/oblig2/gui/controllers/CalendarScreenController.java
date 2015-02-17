package no.uib.gre002.info233.v2015.oblig2.gui.controllers;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import no.uib.gre002.info233.v2015.oblig2.gui.ScreenPane;
import no.uib.gre002.info233.v2015.oblig2.io.ActivityParser;
import no.uib.gre002.info233.v2015.oblig2.io.ParserController;
import no.uib.gre002.info233.v2015.oblig2.models.Activity;
import no.uib.gre002.info233.v2015.oblig2.models.CalendarPopulator;

/**
 * This is the controller for the calendarTableScreen.fxml
 * 
 * @author Gaute Gjerl�w Remen & Anders Eide
 *
 */
public class CalendarScreenController implements Initializable,
		ScreenController {

	private List<Activity> activities;
	private ScreenPane myScreenPane;
	private String buildingCode;
	private String roomCode;

	@FXML
	private TableView<CalendarPopulator> calendarPopulator;
	@FXML
	private TableColumn<CalendarPopulator, String> mandagColumn;
	@FXML
	private TableColumn<CalendarPopulator, String> tirsdagColumn;
	@FXML
	private TableColumn<CalendarPopulator, String> onsdagColumn;
	@FXML
	private TableColumn<CalendarPopulator, String> torsdagColumn;
	@FXML
	private TableColumn<CalendarPopulator, String> fredagColumn;
	
        
	/**
	 * Handles the FXML onMouseClicked on the cross symbol
	 * 
	 * @param e
	 */
	@FXML
	private void handleExitButtonEvent(MouseEvent e) {
		System.out.println("Button is clicked");
		System.exit(0);
	}

	/**
	 * Handles the FXML onMouseClicked on the home symbol
	 * 
	 * @param e
	 */
	@FXML
	private void handleHomeButtonEvent(MouseEvent e) {
		myScreenPane.setScreen("startScreen");
	}

	/**
	 * Sets the new screen
	 */
	@Override
	public void setScreenPane(ScreenPane screenPage) {
		myScreenPane = screenPage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void setLocationInfo(String building, String room) {
		this.buildingCode = building;
		this.roomCode = room;
	}

	public void fetchActivityList() {
		String roomURL = ParserController.getRoomURL(buildingCode, roomCode);
		ActivityParser activityParser = new ActivityParser(roomURL, roomCode);

		activities = activityParser.getActivityList();
		for (Activity activity : activities) {
			System.out.println(activity.toString());

		}

	}

}
