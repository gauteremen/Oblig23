package no.uib.gre002.info233.v2015.oblig2.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CalendarPopulator {

	private final StringProperty mandag;
	private final StringProperty tirsdag;
	private final StringProperty onsdag;
	private final StringProperty torsdag;
	private final StringProperty fredag;
	
	public CalendarPopulator(String mandag, String tirsdag, String onsdag, String torsdag, String fredag) {
		this.mandag = new SimpleStringProperty(mandag); {
		this.tirsdag = new SimpleStringProperty(tirsdag);
		this.onsdag = new SimpleStringProperty(onsdag);
		this.torsdag = new SimpleStringProperty(torsdag);
		this.fredag = new SimpleStringProperty(fredag);

	}
}
	public StringProperty mandagProperty() {
		return mandag;
	}
	
	public StringProperty tirsdagProperty () {
		return tirsdag;
	}
	
	public StringProperty onsdagProperty() {
		return onsdag;
	}
	
	public StringProperty torsdagProperty() {
		return torsdag;
	}
	
	public StringProperty fredagProperty() {
		return fredag;
	}

	public String getMandag() {
		return mandag.get();
	}

	public String getTirsdag() {
		return tirsdag.get();
	}

	public String getOnsdag() {
		return onsdag.get();
	}

	public String getTorsdag() {
		return torsdag.get();
	}

	public String getFredag() {
		return fredag.get();
	}
	
	public void setMandag(String mandag) {
		this.mandag.set(mandag);
	}
	
	public void setTirsdag(String tirsdag) {
		this.tirsdag.set(tirsdag);
	}
	
	public void setOnsdag(String onsdag) {
		this.onsdag.set(onsdag);
	}
	
	public void setTorsdag(String torsdag) {
		this.torsdag.set(torsdag);
	}
	
	public void setFredag(String fredag) {
		this.fredag.set(fredag);
	}
}