package zemechers.week37.Assignment_1;


import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class oldApp {

	public final static void main(String[] args) throws Exception {
		handleRequests();
	}

	public static void handleRequests() throws UnsupportedEncodingException {
		Scanner scanner = new Scanner(System.in);
		Console console = System.console();
		String app_id = "47512";
		String api_key = "vslbdjg4k8v8ahq6v75y214x215yr2whybbd9lbd";
		String email = "zekey_05@yahoo.com";
		String password = "EskiLigba#21";
		System.out.println("Enter Application Id");
		app_id = scanner.nextLine();
		System.out.println("Enter API key :");
		api_key = scanner.nextLine();
		System.out.println("Enter email address: ");
		email = scanner.nextLine();
		System.out.println("Enter password: ");
		char[] passWordChar = console.readPassword("Enter your password: ");
		password = new String(passWordChar);
		System.out.println("Password was "+ password);
		
		User user = new User();
		user = getUserInfo(app_id, api_key, email, password);
		System.out.println(user.toString());

	}

	public static User getUserInfo(String app_id, String api_key, String email,
			String password) throws UnsupportedEncodingException {
		User userdata = new User();
		try {
			String tokenVrn = "1";
			String responseFmt = "json";
			String firstUrl = "www.mediafire.com/api/user/get_session_token.php";
			String secondUrl = "www.mediafire.com/api/1.4/user/get_info.php";
			String result, sessiontoken,signature;
			
			signature = email + password + app_id + api_key;
						
			signature = DigestUtils.sha1Hex(signature);
			
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
			nameValuePairs.add(new BasicNameValuePair("application_id", app_id));
			nameValuePairs.add(new BasicNameValuePair("signature", signature));
			nameValuePairs.add(new BasicNameValuePair("email", email));
			nameValuePairs.add(new BasicNameValuePair("password", password));
			nameValuePairs.add(new BasicNameValuePair("token_version", tokenVrn));
			nameValuePairs.add(new BasicNameValuePair("response_format",responseFmt));
			
			URIBuilder builder = new URIBuilder();
			builder.setScheme("HTTPS").setHost(firstUrl)
					.setParameters(nameValuePairs).setCharset(StandardCharsets.UTF_8);

			URI uri = builder.build();
			result = getJsonRsponseFromUrl(uri);
			
			JsonElement jelement1 = new JsonParser().parse(result);
			JsonObject jobject = jelement1.getAsJsonObject();
			jobject = jobject.getAsJsonObject("response");
			sessiontoken = jobject.get("session_token").getAsString();

			nameValuePairs.clear();
			nameValuePairs.add(new BasicNameValuePair("session_token",
					sessiontoken));
			nameValuePairs.add(new BasicNameValuePair("response_format",
					responseFmt));
			nameValuePairs.add(new BasicNameValuePair("signature", signature));

			builder.setScheme("HTTPS").setHost(secondUrl)
					.setParameters(nameValuePairs).setCharset(StandardCharsets.UTF_8);

			uri = builder.build();
           
			result = getJsonRsponseFromUrl(uri);

			JsonElement jelement2 = new JsonParser().parse(result);
			jobject = jelement2.getAsJsonObject();
			jobject = jobject.getAsJsonObject("response");
			jobject = jobject.getAsJsonObject("user_info");

			userdata.setDateOfBirth((jobject.get("birth_date").getAsString()));
			userdata.setDisplayName((jobject.get("display_name").getAsString()));
			userdata.setEmail((jobject.get("email").getAsString()));
			userdata.setFirstName((jobject.get("first_name").getAsString()));
			userdata.setLastName((jobject.get("last_name").getAsString()));
			userdata.setGender((jobject.get("gender").getAsString()));

			
		
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		return userdata;

	}

	public static String getJsonRsponseFromUrl(URI UrlFormat) {
		String temp, output = "";
		try {

			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpGet getRequest = new HttpGet(UrlFormat);

			HttpResponse response = httpClient.execute(getRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(response.getEntity().getContent())));

			while ((temp = br.readLine()) != null) {
					output = output + temp;
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return output;

	}

}
