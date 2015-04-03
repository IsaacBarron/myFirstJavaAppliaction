import javax.swing.JOptionPane;

public class Start {
	// http://roseaucountyford.com/Staff.aspx
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		// Getting Domain name
		String site = JOptionPane.showInputDialog(null,"Enter Staff site here:");
		
		
		// Creating Folder
		String folderName = JOptionPane.showInputDialog(null,"Name of folder that will be created on your desktop:");
		Downlaoder filePath  = new Downlaoder();
		Downlaoder.setFilePath(folderName);
		
		
		// Validating Url
		site = Validate.validateSiteUrl(site);
		
		String baseUrl = Validate.gettingBaseUrl(site);
		// Getting site source code into finalhtml
		String finalhtml = Downlaoder.getHTML(site);
		
		// Getting image source from finalhtml
		regexChecker check = new regexChecker("[<](/)?img[^>]*[>]", finalhtml, "src\\s*=\\s*\"(.+?)\"", baseUrl);
		
		
		
	}
}
