package no.uib.gre002.info233.v2015.oblig2.gui.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import no.uib.gre002.info233.v2015.oblig2.gui.ScreenPane;

/**
 * This is the controller for the startScreen.fxml
 * 
 * @author Gaute Gjerløw Remen
 * @version 1.0
 *
 */
public class StartScreenController implements Initializable, ScreenController {
	private ScreenPane myScreenPane;
	
	/**
	 * The FXML fx:id bldArw_1
	 */
    @FXML
    public ImageView bldArw_1;
	
    /**
     * Handles the FXML onMouseClicked on the cross symbol
     * @param e
     */
	@FXML
	private void handleExitButtonEvent(MouseEvent e) {
		System.out.println("Button is clicked");
		System.exit(0);
	}
	
	/**
	 * Handles the FXML onMouseClicked on the home symbol
	 * @param e
	 */
	@FXML
	private void handleHomeButtonEvent(MouseEvent e) {
		myScreenPane.setScreen("startScreen");
	}
	
	/**
	 * Handles the FXML onMouseClicked on the arrow
	 * 
	 * @param e
	 */
	@FXML
	private void handleNextPageEvent(MouseEvent e) {
			if((ImageView)e.getSource() == bldArw_1) {
				myScreenPane.setScreen("buildingScreen");
			}
            System.out.println("Clicked");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
	
	/**
	 * Sets the new screen
	 */
	@Override
	public void setScreenPane(ScreenPane screenPage) {
		myScreenPane = screenPage;
	}
	
}
