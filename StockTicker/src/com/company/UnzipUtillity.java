package com.company;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;



public class UnzipUtillity {
		//To abstract the code from 2 operations : 1.) Downloading zip file 2.)unzipping the downloaded zip file
		
	
		private static final int S_BYTE_SIZE = 4096;
	
		public static List<String> downloadAndUnzip(String urlString, String zipFilePath, String destDirectory) throws IOException
		{
			
			URL tariff = new URL(urlString);
			
			String myUserAgentString ="Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36";
			
			java.net.URLConnection c = tariff.openConnection();
			c.setRequestProperty("User-Agent", myUserAgentString);
			
			ReadableByteChannel zipByteChannel = Channels.newChannel(c.getInputStream());
			FileOutputStream fos = new FileOutputStream(zipFilePath);
			fos.getChannel().transferFrom(zipByteChannel, 0, Long.MAX_VALUE);
			//these 3 line save the downloaded url to local hard disk (to the path specified by 'zipFilePath')
			
			
			// now lets unzip the file using function defined below
			
			return unzip(zipFilePath, destDirectory);
		}
		
		public static List<String> unzip(String zipFilePath, String destDirectory) throws IOException
		{
			List<String> unzippedFileList = new ArrayList<>();
			
			File destDir = new File(destDirectory);
			if (!destDir.exists()){
				destDir.mkdirs(); //create destination directory if it doesnt exists
			}
			
			ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
			
			ZipEntry zipEntry = zipIn.getNextEntry();
			while (zipEntry!=null){
				String filePath = destDirectory+File.separator+zipEntry.getName(); //construct path where we wish to extract //using concatation			
				
				if(!zipEntry.isDirectory()){						
					String OneUnzippedFile = extractFile(zipIn, filePath); //calling extractFile function//If zipEntry is a file
					unzippedFileList.add(OneUnzippedFile);
				}
				else
				{
					File dir = new File(filePath); //If zipEntry is Directory than create same directory - mkdirs
					dir.mkdirs();
				}
				
				zipEntry = zipIn.getNextEntry(); //to next next value else above loop will go into infinite loop
				
			}
			
			return unzippedFileList;
			
		}
		
		private static String extractFile(ZipInputStream zipIn, String filePath) throws IOException
		{
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
			
			byte[] bytesIn = new byte[S_BYTE_SIZE];
			//we need to create (binary) files in chunks of bytes. those chunks needs to be in powers of 2. we choose 4096.
			
			int read = 0;
			
			while ((read=zipIn.read(bytesIn))!= -1) {
				//Extracting one single file from inside that zip file, and saving it bute-by-byte into the corresponding unzipped file in location
				
				bos.write(bytesIn, 0, read);
			}
			
			bos.close();
			
			return filePath;
			
		}
		
}
