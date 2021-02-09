package Utilities;



public class ConfigFileReader {

	
	public String getReportConfigPath(){
		 String reportConfigPath = System.getProperty("user.dir")+"\\src\\test\\java\\Configs\\extent-config.xml";
		 return reportConfigPath; 
		}
}
