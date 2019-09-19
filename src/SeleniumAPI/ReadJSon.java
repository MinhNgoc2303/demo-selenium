package SeleniumAPI;


	import java.io.BufferedReader;
	import java.io.FileReader;

import com.google.gson.Gson;

import ObjectPageJson.JsonData;

	public class ReadJSon {

	    public static void main(String[] args) {
	    	JsonData commonData;
			String userPath = System.getProperty("user.dir");
			String pathFileJson = userPath.concat("/data/").concat("BankGuru.json");

			commonData = getDataJson(pathFileJson);

			System.out.println("Text = " + commonData.getNewCustomer().getAddress());

		}

		public static String readFile(String filename) {
			String result = "";
			try {
				@SuppressWarnings("resource")
				BufferedReader br = new BufferedReader(new FileReader(filename));
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();
				while (line != null) {
					sb.append(line);
					line = br.readLine();
					System.out.println("value " + line);

				}
				result = sb.toString();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;

		}
		
		public static JsonData getDataJson(String JsonFile) {
			String json = readFile(JsonFile);
			return new Gson().fromJson(json, JsonData.class);
		}
}
