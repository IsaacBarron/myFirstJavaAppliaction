import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

public class Downlaoder {
	@SuppressWarnings("unused")
	private String src;
	private static String folderPath;
	private static final String rootPath = System.getProperty("user.home")
			+ "/Desktop/";

	public static void setFilePath(String folderName){
		folderPath = rootPath + "Staff/" + folderName;
		System.out.println("step 1 complete: folderpath = " + folderPath);
		File file = new File(folderPath);

		if (!file.exists()) {
			if (file.mkdir()) {
				System.out.println("Directory is created!");
			} else {
				System.out.println("Failed to create directory!");
			}
		}

	}

	public String getFolderPath() {
		return folderPath;
	}

	public static void push(String src, String folderPath) throws IOException {
		 
		int indexname = src.lastIndexOf("/");

		if (indexname == src.length()) {

			src = src.substring(1, indexname);
		}

		indexname = src.lastIndexOf("/");
		String name = src.substring(indexname, src.length());

		System.out.println(name);

		// Open a URL Stream

		URL url = new URL(src);

		InputStream in = url.openStream();

		OutputStream out = new BufferedOutputStream(new FileOutputStream(
				folderPath + name));

		for (int b; (b = in.read()) != -1;) {

			out.write(b);

		}
		out.close();
		in.close();

	}

	public Downlaoder() {
		// TODO Auto-generated constructor stub
	}

	public static String getHTML(String site) throws IOException {
		/**
		 * Trying to connect to url
		 */
		URL url = new URL(site);
		URLConnection spoof = url.openConnection();

		// Spoof the connection so we look like a web browser
		spoof.setRequestProperty("User-Agent",
				"Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0;    H010818)");
		BufferedReader in = new BufferedReader(new InputStreamReader(
				spoof.getInputStream()));

		String strLine = "";
		String finalHTML = "";
		// Loop through every line in the source
		while ((strLine = in.readLine()) != null) {

			finalHTML += strLine;
		}
		return finalHTML;
	}

}
