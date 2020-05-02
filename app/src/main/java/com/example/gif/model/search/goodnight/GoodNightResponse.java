package com.example.gif.model.search.goodnight;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class GoodNightResponse{

	@SerializedName("next")
	private String next;

	@SerializedName("weburl")
	private String weburl;

	@SerializedName("results")
	private ArrayList<IsiItem> results;

	public void setNext(String next){
		this.next = next;
	}

	public String getNext(){
		return next;
	}

	public void setWeburl(String weburl){
		this.weburl = weburl;
	}

	public String getWeburl(){
		return weburl;
	}

	public void setResults(ArrayList<IsiItem> results){
		this.results = results;
	}

	public ArrayList<IsiItem> getResults(){
		return results;
	}
}