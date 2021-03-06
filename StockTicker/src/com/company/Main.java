package com.company;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try{
			String urlString = "https://www.nseindia.com/content/historical/EQUITIES/2016/JUL/cm19JUL2016bhav.csv.zip";
			String zipFilePath = "/Users/rishabh/Desktop/parsing stock ticker data/DownloadsNSE/boo.zip";
			String destinationDirectory = "/Users/rishabh/Desktop/parsing stock ticker data/DownloadsNSE/";

			List<String> unzippedFileList	= UnzipUtillity.downloadAndUnzip(urlString, zipFilePath, destinationDirectory);

			if (unzippedFileList!= null){
				//only if we unzipped anything 
				String csvFile = unzippedFileList.get(0);
				OneDayMarketAction odma = new OneDayMarketAction(csvFile);
				//use constructor of the class we defined

				List<OneDayMarketAction.OneTickerOneDay> listOfMovers = odma.getSortedMovers();
				//inner class is referred in the List
				for (OneDayMarketAction.OneTickerOneDay otod:listOfMovers){
					System.out.println("Ticker="+otod.getM_ticker()+", Moved by" + otod.getPctChange()*100+"%");
				}
			}
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
	}

}
