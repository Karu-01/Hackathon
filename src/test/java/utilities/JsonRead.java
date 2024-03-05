package utilities;

import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonRead {
	public static JSONParser parser;
	public static JSONObject jsonObject;
	public static Object obj;
	public static String amount;
	public static String recipientName;
	public static String recipientEmail;
	public static String recipientMobile;
	public static String customerName;
	public static String customerEmail;
	public static String customerWrongEmail;
	public static String customerMobile;
	public static String customerAddress;
	public static String Pin;
	public static String City;
	public static String message;

	public static void readJSONFile() {
		try {
			parser = new JSONParser();
			obj = parser.parse(new FileReader("C:\\Users\\2303842\\eclipse-workspace\\HackathonProject\\src\\test\\resources\\GiftCardInput.json"));
			jsonObject = (JSONObject) obj;

			amount = (String) jsonObject.get("Amount");
			recipientName = (String) jsonObject.get("Recipient_Name");
			recipientEmail = (String) jsonObject.get("Recipient_Email");
			recipientMobile = (String) jsonObject.get("Recipient_Mobile");
			customerName = (String) jsonObject.get("Customer_Name");
			customerWrongEmail = (String) jsonObject.get("Customer_WrongEmail");
			customerEmail = (String) jsonObject.get("Customer_Email");
			customerMobile = (String) jsonObject.get("Customer_Mobile");
			customerAddress = (String) jsonObject.get("Customer_Address");
			Pin = (String) jsonObject.get("Pin");
			City = (String) jsonObject.get("City");
			message = (String) jsonObject.get("Message");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static void writeToJson(String amount, String recipientName, String recipientEmail, String recipientMobile,
			String customerName, String customerEmail, String customerMobile, String customerAddress, String pin,
			String message) {
		JSONObject jsonData = new JSONObject();
		jsonData.put("Amount", amount);
		jsonData.put("Recipient_Name", recipientName);
		jsonData.put("Recipient_Email", recipientEmail);
		jsonData.put("Recipient_Mobile", recipientMobile);
		jsonData.put("Customer_Name", customerName);
		jsonData.put("Customer_Email", customerEmail);
		jsonData.put("Customer_Mobile", customerMobile);
		jsonData.put("Customer_Address", customerAddress);
		jsonData.put("Pin", pin);
		jsonData.put("Message", message);
	}

	public static void CompareData() {
		try (FileWriter file = new FileWriter(".\\src\\test\\resources\\GiftCardOutput.json")) {
			JSONObject jsonData = new JSONObject();
			for (Object key : jsonData.keySet()) {
				file.write("\"" + key + "\": \"" + jsonData.get(key) + "\",\n");
			}
			readJSONFile();

			compareAndPrint("Amount", amount.replace(",", ""));
			compareAndPrint("Recipient_Name", recipientName);
			compareAndPrint("Recipient_Email", recipientEmail);
			compareAndPrint("Recipient_Mobile", recipientMobile);
			compareAndPrint("Customer_Name", customerName);
			compareAndPrint("Customer_Email", customerEmail);
			compareAndPrint("Customer_Mobile", customerMobile);
			compareAndPrint("Customer_Address", customerAddress);
			compareAndPrint("Pin", Pin);
			compareAndPrint("Message", message);
			file.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void compareAndPrint(String key, String expectedValue) {
		if (jsonObject != null && jsonObject.containsKey(key)) {
			String actualValue = (String) jsonObject.get(key);
			if (actualValue.equals(expectedValue)) {
				System.out.println(key + " is equals");
			} else {
				System.out.println(key + " is not equals");
			}
		} else {
			System.out.println("Key '" + key + "' not found in JSON object");
		}
	}
}
