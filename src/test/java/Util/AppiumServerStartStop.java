package Util;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServerStartStop {

	static int port = 4723;
	static String osName = System.getProperty("os.name");
	static String nodeJSPath = "C:\\Program Files\\nodejs\\node.exe";
	static String appiumJSPath = "C:\\Users\\CODIGO DEL SUR\\AppData\\Roaming\\npm\\node_modules\\appium\\lib\\appium.js";
	static AppiumDriverLocalService appiumService;
	static String service_url;
	static boolean flag = checkIfServerIsRunnning(port);

	public static void appiumStart() throws Exception {

			Log.info("**** STARTING APIUM SERVER ***********");
			if (osName.contains("Mac")) {
				AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
				// Use any port, in case the default 4723 is already taken (maybe by another
				// Appium server)
				serviceBuilder.withIPAddress("127.0.0.1").usingPort(port);
				// Tell serviceBuilder where node is installed. Or set this path in an
				// environment variable named NODE_PATH
				serviceBuilder.usingDriverExecutable(new File("/usr/local/bin/node"));
				// Tell serviceBuilder where Appium is installed. Or set this path in an
				// environment variable named APPIUM_PATH
				serviceBuilder.withAppiumJS(new File("/usr/local/bin/appium"));
				// The XCUITest driver requires that a path to the Carthage binary is in the
				// PATH variable. I have this set for my shell, but the Java process does not
				// see it. It can be inserted here.
				serviceBuilder.withLogFile(new File(("build/appium.log")));
				HashMap<String, String> environment = new HashMap<String, String>();
				environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));
				serviceBuilder.withEnvironment(environment);
				appiumService = AppiumDriverLocalService.buildService(serviceBuilder);
			}

			else if (osName.contains("Windows")) {
				AppiumServiceBuilder serviceBuilder1 = new AppiumServiceBuilder();
				// Use any port, in case the default 4723 is already taken (maybe by another
				// Appium server)
				serviceBuilder1.withIPAddress("127.0.0.1").usingPort(port);
				// Tell serviceBuilder where node is installed. Or set this path in an
				// environment variable named NODE_PATH
				serviceBuilder1.usingDriverExecutable(new File(nodeJSPath));
				// Tell serviceBuilder where Appium is installed. Or set this path in an
				// environment variable named APPIUM_PATH
				serviceBuilder1.withAppiumJS(new File(appiumJSPath));
				serviceBuilder1.withLogFile(new File(("build/appium.log")));
				serviceBuilder1.withEnvironment(System.getenv());
				appiumService = AppiumDriverLocalService.buildService(serviceBuilder1);

			}
			
			try {
				appiumService.start();
				Thread.sleep(25000);
				service_url = appiumService.getUrl().toString();
				Log.info("Server started on Port - " + port);
			} catch (Exception e) {
				Log.info("Appium Server already running on Port - " + port);
			}
			
	}

	public static boolean checkIfServerIsRunnning(int port) {

		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);

			serverSocket.close();
		} catch (IOException e) {
			// If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	public static String getURL() {
		return service_url;

	}

	public static Integer getPort() {
		return port;

	}

	public static void appiumStop() throws Exception {

		Log.info("**** STOPING APIUM SERVER ***********");

		try {
				Log.info("Trying to stop the server...");
				appiumService.stop();
				Log.info("Success, Server stopped.");
			
		} catch (Exception e) {
			Log.info("Appium server could not be stopped.");
		}

	}
}
