package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OneDayMarketAction {
	//NSE market action for ONE day
	
	public static class OneTickerOneDay{
		//Market action for 1 stock for 1 day
		
		private String m_ticker;
		private String m_series;
		private double m_open;
		private double m_close;
		private double m_high;
		private double m_low;
		private double m_prevClose;
		
		public OneTickerOneDay(String[] oneQuote){
			setM_ticker(oneQuote[0]);
			setM_series(oneQuote[1]);
			setM_open(Double.parseDouble(oneQuote[2]));
			setM_close(Double.parseDouble(oneQuote[3]));
			setM_high(Double.parseDouble(oneQuote[4]));
			setM_low(Double.parseDouble(oneQuote[5]));
			setM_prevClose(Double.parseDouble(oneQuote[6]));
			
		}
		
		//All getters and setters
		public String getM_ticker() {
			return m_ticker;
		}

		public void setM_ticker(String m_ticker) {
			this.m_ticker = m_ticker;
		}

		public String getM_series() {
			return m_series;
		}

		public void setM_series(String m_series) {
			this.m_series = m_series;
		}

		public double getM_open() {
			return m_open;
		}

		public void setM_open(double m_open) {
			this.m_open = m_open;
		}
		
		public double getM_close() {
			return m_close;
		}

		public void setM_close(double m_close) {
			this.m_close = m_close;
		}

		public double getM_high() {
			return m_high;
		}

		public void setM_high(double m_high) {
			this.m_high = m_high;
		}

		public double getM_low() {
			return m_low;
		}

		public void setM_low(double m_low) {
			this.m_low = m_low;
		}

		public double getM_prevClose() {
			return m_prevClose;
		}

		public void setM_prevClose(double m_prevClose) {
			this.m_prevClose = m_prevClose;
		}
		
		
		public double getPctChange(){
			if (this.getM_prevClose()!= 0){
			return (this.getM_close()-this.getM_prevClose())/this.getM_prevClose();
			}
			return Double.NaN;
		
		}

	}

	
	private Map<String,OneTickerOneDay> mapOfTickers = new HashMap<>();
			//gives the market action today for ticker=XYZ // a Map - which is a key-value pair
	
	private String m_fileName; //data came from this file
	
	
	public OneDayMarketAction(String csvFile){
		//COnstructor to:
		//1.) parse csv file which we got from UnZipUtillity
		//2.)go thru that file line-by-line and create objects of class OneTickerOneDay
		//3.) populate internal map we just setup
		
		//1.)
		this.m_fileName = csvFile;
		BufferedReader br = null;
		String line = null;
		String csvSplitBy = ",";
		int lineNum = 0;
		
		try{
			br = new BufferedReader(new FileReader(csvFile));
			while ((line=br.readLine())!= null){
				lineNum++; //to skip the header for first time and increment to next line everytime loop runs
				if(lineNum>1){
					String[] oneQuote = line.split(csvSplitBy); //split line into array of strings. separated by ","
					
					OneDayMarketAction.OneTickerOneDay otod = new OneDayMarketAction.OneTickerOneDay(oneQuote); //stocker movement for one ticker for one day //constructor initiated
					
					if (otod.getM_series().compareTo("EQ")==0){
						//only Equity "EQ" type we are interested into. Other type like warrants,etc we dont want to deal with right now.
						
						mapOfTickers.put(oneQuote[0], otod);
					}
				}
			}
		}
		
		catch (Exception e){
			e.printStackTrace();
		}
		
		finally {
			try{
				br.close();
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
		
	}
	
	
	public List<OneTickerOneDay> getSortedMovers(){
		//create and unsorted array
		
		List<OneTickerOneDay> ListOfMarketAction = new ArrayList<>(this.mapOfTickers.values());
		// creating list of values from a map(key-value pair)
		
		Collections.sort(ListOfMarketAction, new StockMoveComparator());
		
		return ListOfMarketAction;
	}
	
	///////////////////
	public static class StockMoveComparator implements Comparator<OneTickerOneDay> {
		
		public int compare(OneTickerOneDay t1, OneTickerOneDay t2) {
			double pctChange1 = t1.getPctChange();
			double pctChange2 = t2.getPctChange();
			if(pctChange1>pctChange2){
				return 1;
			}
			else if (pctChange2>pctChange1){
				return -1;
			}
			else {
				return 0;
			}
		}
	}
	
}