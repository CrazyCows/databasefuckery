/**
 * This class handles loading from a CSV data file.
 *
 * @author Giovanni Meroni
 * @author Thorbjørn Konstantinovitz
 *
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loaders {

	public static final String SEMICOLON_DELIMITER = ";";
	private final String delimiter = SEMICOLON_DELIMITER;


	public String loadTopic(String filename) throws FileNotFoundException, IOException {
		BufferedReader in = null;
		BufferedReader lineCount = null;
		StringBuilder output = new StringBuilder();
		output.append("INSERT INTO Topic VALUES");
		try {
			in = new BufferedReader(new FileReader(filename));
			in.readLine();
			lineCount = new BufferedReader(new FileReader(filename));
			lineCount.readLine();
			lineCount.readLine();
			String line;
			int lineNbr = 0;
			while ((line = in.readLine()) != null) {
				lineNbr++;
				List<String> values = new ArrayList<String>();
				try (Scanner rowScanner = new Scanner(line)) {
					rowScanner.useDelimiter(delimiter);
					while (rowScanner.hasNext()) {
						values.add(rowScanner.next());
					}
					if (values.size() == 0) {
						continue;
					}
					String topicTitle = values.get(0);
					String briefDescription = values.get(1);
					Topic topic = new Topic(topicTitle, briefDescription);
					output.append(topic);
					if(lineCount.readLine() != null){
						output.append(",");
					}
				}

			}
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (Exception e) { /* Ignore */ }
			;
		}
		output.append(";");
		return output.toString();
	}

	public String loadPhone(String filename) throws FileNotFoundException, IOException {
		BufferedReader in = null;
		BufferedReader lineCount = null;
		StringBuilder output = new StringBuilder();
		output.append("INSERT INTO Phone VALUES");
		try {
			in = new BufferedReader(new FileReader(filename));
			in.readLine();
			lineCount = new BufferedReader(new FileReader(filename));
			lineCount.readLine();
			lineCount.readLine();
			String line;
			int lineNbr = 0;
			while ((line = in.readLine()) != null) {
				lineNbr++;
				List<String> values = new ArrayList<String>();
				try (Scanner rowScanner = new Scanner(line)) {
					rowScanner.useDelimiter(delimiter);
					while (rowScanner.hasNext()) {
						values.add(rowScanner.next());
					}
					if (values.size() == 0) {
						continue;
					}
					int CPR = Integer.parseInt(values.get(0));
					int phoneNumber = Integer.parseInt(values.get(1));
					String Descriptor = values.get(2);
					Phone phone = new Phone(CPR,phoneNumber,Descriptor);
					output.append(phone);
					if(lineCount.readLine() != null){
						output.append(",");
					}
				}
			}
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (Exception e) { /* Ignore */ }
			;
		}
		output.append(";");
		return output.toString();
	}

	public String loadEdition(String filename) throws FileNotFoundException, IOException{
		BufferedReader in = null;
		BufferedReader lineCount = null;
		StringBuilder output = new StringBuilder();
		output.append("INSERT INTO Edition VALUES");
		try {
			in = new BufferedReader(new FileReader(filename));
			in.readLine();
			lineCount = new BufferedReader(new FileReader(filename));
			lineCount.readLine();
			lineCount.readLine();
			String line;
			int lineNbr = 0;
			while ((line = in.readLine()) != null) {
				lineNbr++;
				List<String> values = new ArrayList<String>();
				try (Scanner rowScanner = new Scanner(line)) {
					rowScanner.useDelimiter(delimiter);
					while (rowScanner.hasNext()) {
						values.add(rowScanner.next());
					}
					if (values.size() == 0) {
						continue;
					}
					String date = values.get(0);
					Integer duration = Integer.parseInt(values.get(1));
					Integer cpr = Integer.parseInt(values.get(2));
					Edition topic = new Edition(date, duration, cpr);
					output.append(topic);
					if(lineCount.readLine() != null){
						output.append(",");
					}
				}

			}
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (Exception e) { /* Ignore */ }
			;
		}
		output.append(";");
		return output.toString();
	}

	public String loadEmail(String filename) throws FileNotFoundException, IOException {
		BufferedReader in = null;
		BufferedReader lineCount = null;
		StringBuilder output = new StringBuilder();
		output.append("INSERT INTO Email VALUES");
		try {
			in = new BufferedReader(new FileReader(filename));
			in.readLine();
			lineCount = new BufferedReader(new FileReader(filename));
			lineCount.readLine();
			lineCount.readLine();
			String line;
			while ((line = in.readLine()) != null) {
				List<String> values = new ArrayList<String>();
				try (Scanner rowScanner = new Scanner(line)) {
					rowScanner.useDelimiter(delimiter);
					while (rowScanner.hasNext()) {
						values.add(rowScanner.next());
					}
					if (values.size() == 0) {
						continue;
					}
					int CPR = Integer.parseInt(values.get(0));
					String emaill = values.get(1);
					String Descriptor = values.get(2);
					Email email  = new Email(CPR,emaill,Descriptor);
					output.append(email);
					if(lineCount.readLine() != null){
						output.append(",");
					}
				}
			}
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (Exception e) { /* Ignore */ }
			;
		}
		output.append(";");
		return output.toString();
	}

	public String loadRoles(String filename) throws FileNotFoundException, IOException {
		BufferedReader in = null;
		BufferedReader lineCount = null;
		StringBuilder output = new StringBuilder();
		output.append("INSERT INTO Roles VALUES");
		try {
			in = new BufferedReader(new FileReader(filename));
			in.readLine();
			lineCount = new BufferedReader(new FileReader(filename));
			lineCount.readLine();
			lineCount.readLine();
			String line;
			while ((line = in.readLine()) != null) {
				List<String> values = new ArrayList<String>();
				try (Scanner rowScanner = new Scanner(line)) {
					rowScanner.useDelimiter(delimiter);
					while (rowScanner.hasNext()) {
						values.add(rowScanner.next());
					}
					if (values.size() == 0) {
						continue;
					}
					String topic = values.get(0);
					Integer cpr = Integer.parseInt(values.get(1));
					String role = values.get(2);

					Roles item  = new Roles(topic,cpr,role);
					output.append(item);
					if(lineCount.readLine() != null){
						output.append(",");
					}
				}
			}
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (Exception e) { /* Ignore */ }
			;
		}
		output.append(";");
		return output.toString();
	}

	public String loadItem(String filename) throws FileNotFoundException, IOException {
		BufferedReader in = null;
		BufferedReader lineCount = null;
		StringBuilder output = new StringBuilder();
		output.append("INSERT INTO Item VALUES");
		try {
			in = new BufferedReader(new FileReader(filename));
			in.readLine();
			lineCount = new BufferedReader(new FileReader(filename));
			lineCount.readLine();
			lineCount.readLine();
			String line;
			while ((line = in.readLine()) != null) {
				List<String> values = new ArrayList<String>();
				try (Scanner rowScanner = new Scanner(line)) {
					rowScanner.useDelimiter(delimiter);
					while (rowScanner.hasNext()) {
						values.add(rowScanner.next());
					}
					if (values.size() == 0) {
						continue;
					}

					String time = values.get(0);
					String topicTitle = values.get(1);
					String itemDescription = values.get(2);
					int numberOfViewers = Integer.parseInt(values.get(3));
					String footageTitle = values.get(4);


					Item item  = new Item(time,topicTitle,itemDescription,numberOfViewers,footageTitle);
					output.append(item);
					if(lineCount.readLine() != null){
						output.append(",");
					}
				}
			}
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (Exception e) { /* Ignore */ }
			;
		}
		output.append(";");
		return output.toString();
	}

	public String loadJournalist(String filename) throws FileNotFoundException, IOException {
		BufferedReader in = null;
		BufferedReader lineCount = null;
		StringBuilder output = new StringBuilder();
		output.append("INSERT INTO Journalist VALUES");
		try {
			in = new BufferedReader(new FileReader(filename));
			in.readLine();
			lineCount = new BufferedReader(new FileReader(filename));
			lineCount.readLine();
			lineCount.readLine();
			String line;
			while ((line = in.readLine()) != null) {
				List<String> values = new ArrayList<String>();
				try (Scanner rowScanner = new Scanner(line)) {
					rowScanner.useDelimiter(delimiter);
					while (rowScanner.hasNext()) {
						values.add(rowScanner.next());
					}
					if (values.size() == 0) {
						continue;
					}
					Integer CPR = Integer.parseInt(values.get(0));
					String firstName = values.get(1);
					String secondName = values.get(2);
					String streetName = values.get(3);
					Integer civicNumber = Integer.parseInt(values.get(4));
					String city = values.get(5);
					Integer zip = Integer.parseInt(values.get(7));
					String country = values.get(8);
					Journalist journalist = new Journalist(CPR,firstName,secondName, streetName, civicNumber, city, zip, country);
					output.append(journalist);
					if(lineCount.readLine() != null){
						output.append(",");
					}
				}
			}
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (Exception e) { /* Ignore */ }
			;
		}
		output.append(";");
		return output.toString();
	}

	public String loadFootage(String filename) throws FileNotFoundException, IOException {
		BufferedReader in = null;
		BufferedReader lineCount = null;
		StringBuilder output = new StringBuilder();
		output.append("INSERT INTO Footage VALUES");
		try {
			in = new BufferedReader(new FileReader(filename));
			in.readLine();
			lineCount = new BufferedReader(new FileReader(filename));
			lineCount.readLine();
			lineCount.readLine();
			String line;
			while ((line = in.readLine()) != null) {
				List<String> values = new ArrayList<String>();
				try (Scanner rowScanner = new Scanner(line)) {
					rowScanner.useDelimiter(delimiter);
					while (rowScanner.hasNext()) {
						values.add(rowScanner.next());
					}
					if (values.size() == 0) {
						continue;
					}
					String title = values.get(0);
					String dor = values.get(1);
					int duration = Integer.parseInt(values.get(2));
					String cpr = values.get(3);

					Footage footage  = new Footage(title,dor,duration,cpr);
					output.append(footage);
					if(lineCount.readLine() != null){
						output.append(",");
					}
				}
			}
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (Exception e) { /* Ignore */ }
			;
		}
		output.append(";");
		return output.toString();
	}
}

