package no.uib.gre002.info233.v2015.oblig2.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import no.uib.gre002.info233.v2015.oblig2.models.UIBbuilding;
import no.uib.gre002.info233.v2015.oblig2.models.UIBroom;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * This class parses though the url given, placing each regex-cleaned text into
 * an object.
 * 
 * @author Gaute Gjerløw Remen
 * @version 1.0
 *
 */

public class BuildingParser {

	Pattern pattern;
	Matcher matcher;
	List<UIBbuilding> uibBuildings = new ArrayList<UIBbuilding>();
	List<UIBroom> uibRooms = new ArrayList<UIBroom>();

	public BuildingParser(String url) throws IOException {
		createBuilding(getValueFromHTML(url));
	}

	/**
	 * Find the buildings in the HTML document
	 * 
	 * @throws IOException
	 */
	public Elements getValueFromHTML(String url) throws IOException {

		Document doc = Jsoup.connect(url).get();
		Elements realTimeValues = doc.select("option[value*=:]");

		return realTimeValues;
		// createBuilding(realTimeValues);
		// createRooms(realTimeValues);
	}

	/**
	 * Cleans the building tags for special characters and unnecessary text,
	 * using regex, and creates objects from the output.
	 * 
	 * @param buildings
	 */
	private void createBuilding(Elements buildings) {
		for (Element building : buildings) {

			pattern = Pattern.compile("([^)]+:\\S+\\D++)");
			matcher = pattern.matcher(building.text());

			if (matcher.find()) {
				UIBbuilding uib_building = new UIBbuilding(matcher.group(0));
				uibBuildings.add(uib_building);
			}

		}
	}

	public List<UIBbuilding> getBuildings() {
		return uibBuildings;
	}

}
