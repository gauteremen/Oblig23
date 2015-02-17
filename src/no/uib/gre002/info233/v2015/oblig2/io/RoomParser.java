package no.uib.gre002.info233.v2015.oblig2.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import no.uib.gre002.info233.v2015.oblig2.models.UIBroom;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Class used to retrieve a list of rooms from a url
 * @author Gaute Gjerløw Remen
 *
 */
public class RoomParser {

	Pattern pattern;
	Matcher matcher;
	List<UIBroom> uibRooms = new ArrayList<UIBroom>();

	public RoomParser(String url) throws IOException {
		createRooms(getValueFromHTML(url));
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
	}

	public List<UIBroom> getBuildings() {
		return uibRooms;
	}

	/**
	 * Cleans the building tags for special characters and unnecessary text,
	 * using regex, and creates objects from the output.
	 * 
	 * @param rooms
	 */
	private void createRooms(Elements rooms) {

		for (Element room : rooms) {
			pattern = Pattern.compile(":([^)]+)");
			matcher = pattern.matcher(room.text());

			if (matcher.find()) {
				UIBroom uib_room = new UIBroom(matcher.group(1));
				uibRooms.add(uib_room);
			}
		}
	}
}
