import java.io.IOException;
import java.util.regex.Matcher;


public class regexChecker {

	private String theRegex, str2Check, secRex;
	private String[] img;
	
	
	
	
public regexChecker(String theRegex, String str2Check, String secRex, String Host) throws IOException {
		super();
		this.setTheRegex(theRegex);
		this.setStr2Check(str2Check);
		this.setSecRex(secRex);
		
		java.util.regex.Pattern checkRegex = java.util.regex.Pattern
				.compile(theRegex);
		java.util.regex.Pattern seccheckRegex = java.util.regex.Pattern
				.compile(secRex);

		Matcher regexMatcher = checkRegex.matcher(str2Check);

		int count = 0;
		while (regexMatcher.find()) {
			if (regexMatcher.group().length() != 0) {
				System.out.println(regexMatcher.group());
				Matcher regexMatcher2 = seccheckRegex.matcher(regexMatcher
						.group());

				while (regexMatcher2.find()) {
					if (regexMatcher2.group().length() != 0) {
						
						
						String src = regexMatcher2.group().trim();
						System.out.println(src);
						src = src.replaceAll("\"", "");
						src = src.replaceAll("src=", "");
						System.out.println(src);
						count++;
						System.out.println(count);
						
						//Validating img url
						src = Validate.imgValidation(src, Host);
						
						Downlaoder filePath  = new Downlaoder();
						 String filepath = filePath.getFolderPath();
						 
						 Downlaoder.push(src, filepath);
						System.out.println(" regex class: "+ filepath);
						
					}
					
				}
			}

		}
	}




public String getStr2Check() {
	return str2Check;
}




public void setStr2Check(String str2Check) {
	this.str2Check = str2Check;
}




public String getTheRegex() {
	return theRegex;
}




public void setTheRegex(String theRegex) {
	this.theRegex = theRegex;
}




public String getSecRex() {
	return secRex;
}




public void setSecRex(String secRex) {
	this.secRex = secRex;
}




public String[] getImg() {
	return img;
}




public void setImg(String[] img) {
	this.img = img;
}




//public void regexChecker(String theRegex, String str2Check,
//			String secRex) {
//
//		java.util.regex.Pattern checkRegex = java.util.regex.Pattern
//				.compile(theRegex);
//		java.util.regex.Pattern seccheckRegex = java.util.regex.Pattern
//				.compile(secRex);
//
//		Matcher regexMatcher = checkRegex.matcher(str2Check);
//
//		while (regexMatcher.find()) {
//			if (regexMatcher.group().length() != 0) {
//				Matcher regexMatcher2 = seccheckRegex.matcher(regexMatcher
//						.group());
//
//				while (regexMatcher2.find()) {
//					if (regexMatcher2.group().length() != 0) {
//						String src = regexMatcher2.group().trim();
//						src = src.replaceAll("\"", "");
//						src = src.replaceAll("src=", "");
//						System.out.println(src);
//					}
//				}
//			}
//
//		}
//		
//		
//	}
}

