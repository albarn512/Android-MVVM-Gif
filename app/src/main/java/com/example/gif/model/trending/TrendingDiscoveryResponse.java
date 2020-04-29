package com.example.gif.model.trending;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TrendingDiscoveryResponse{

	@SerializedName("next")
	private String next;

	@SerializedName("results")
	private ArrayList<TrendingResultsItem> results;

	public void setNext(String next){
		this.next = next;
	}

	public String getNext(){
		return next;
	}

	public void setResults(ArrayList<TrendingResultsItem> results){
		this.results = results;
	}

	public ArrayList<TrendingResultsItem> getResults(){
		return results;
	}
}