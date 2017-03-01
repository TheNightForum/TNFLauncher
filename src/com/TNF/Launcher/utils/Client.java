package com.TNF.Launcher.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.TNF.Launcher.Main;

public class Client {

	public static boolean checkIfURLExists(String targetUrl) {
		HttpURLConnection httpUrlConn;
		try {
			httpUrlConn = (HttpURLConnection) new URL(targetUrl)
					.openConnection();

			httpUrlConn.setRequestMethod("HEAD");

			httpUrlConn.setConnectTimeout(30000);
			httpUrlConn.setReadTimeout(30000);

			AppOutput.printLine("Response Code: " + httpUrlConn.getResponseCode());
			AppOutput.printLine("Response Message: " + httpUrlConn.getResponseMessage());

			return (httpUrlConn.getResponseCode() == HttpURLConnection.HTTP_OK);
		} catch (Exception e) {
			AppOutput.printLine(e.getMessage(), AppOutput.ERROR);
			return false;
		}
	}

	public Boolean CheckInternet() {
		try {
			URL url = new URL("http://TheNightForum.github.io/");
			URLConnection connection = url.openConnection();
			connection.connect();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static int isClientUpToDate() {
		String lVersion = getLatestClientVersion();
		return lVersion.equals("Could not connect to webserver.") ? -1 : Main.VERSION.equalsIgnoreCase(getLatestClientVersion()) ? 0 : 1;
	}

	public static String getLatestClientVersion() {
	 try {
		 Connection c = new Connection(new URL(Data.BaseUrl + "/VERSION"));
		 c.createConnection();
		 for (String s: c.readURL()) {
	   return s.trim();
		 }
	 } catch (MalformedURLException ex) {
		 AppOutput.printLine("Could not connect to WebServer", AppOutput.ERROR);
		 return "Could not connect to WebServer";
	 } catch (IOException ex) {
		 AppOutput.printLine("Could not connect to WebServer", AppOutput.ERROR);
		 return "Could not connect to WebServer";
	 }
	 return Main.VERSION;
	}
}