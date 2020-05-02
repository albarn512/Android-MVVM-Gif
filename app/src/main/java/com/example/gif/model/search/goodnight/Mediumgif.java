package com.example.gif.model.search.goodnight;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Mediumgif{

	@SerializedName("preview")
	private String preview;

	@SerializedName("dims")
	private List<Integer> dims;

	@SerializedName("size")
	private int size;

	@SerializedName("url")
	private String url;

	public void setPreview(String preview){
		this.preview = preview;
	}

	public String getPreview(){
		return preview;
	}

	public void setDims(List<Integer> dims){
		this.dims = dims;
	}

	public List<Integer> getDims(){
		return dims;
	}

	public void setSize(int size){
		this.size = size;
	}

	public int getSize(){
		return size;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}
}