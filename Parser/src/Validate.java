import java.net.URI;
import java.net.URISyntaxException;

public class Validate {

	public static String validateSiteUrl(String url) {

		String[] bad = { "www\".", "https:\"/\"/", "http://" };

		url.replaceAll(bad[0], "");
		url.replaceAll(bad[1], "");
		if (!url.startsWith(bad[2])) {
			url = bad[2] + url;
			System.out.println(url);
		}

		return url;
	}

	public static String imgValidation(String url, String domainName) {
		// TODO Validate image for http
		String[] bad = { "www\".", "https:\"/\"/", "http://" };

		if (url.contains("^[a-zA-Z0-9\\-\\.]+\\.(com|org|net|mil|edu|COM|ORG|NET|MIL|EDU)$") == false) {
			url.replaceAll(bad[0], "");
			url.replaceAll(bad[1], "");
			if (!url.startsWith(bad[2])) {
				url = bad[2] + url;
			}
			int right = url.indexOf("?");

			if (url.indexOf("?") > 0 && !(url.indexOf(".ashx") > 0)) {
				url = url.substring(0, right);
			}
			System.out.println(url);
			System.out.println("You're good!!");
		} else {
			System.out.println("No Domain name found");
			System.out.println("Fixing...");
			url.replaceAll(bad[0], "");
			url.replaceAll(bad[1], "");
			if (!url.startsWith(bad[2])) {
				url = bad[2] + domainName + url;
			}
		}

		url.replaceAll(bad[0], "");
		url.replaceAll(bad[1], "");
		if (!url.startsWith(bad[2])) {
			url = bad[2] + url;
			System.out.println(url);
		}
		return url;

	}

	public static String gettingBaseUrl(String url) throws URISyntaxException {
		URI s = new URI(url);
		String host = s.getHost();
		System.out.println("host :" + host);
		return host;
	}
}
