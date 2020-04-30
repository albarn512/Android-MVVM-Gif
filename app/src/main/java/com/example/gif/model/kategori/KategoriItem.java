package com.example.gif.model.kategori;

import com.google.gson.annotations.SerializedName;

public class KategoriItem {

	@SerializedName("searchterm")
	private String searchterm;

	@SerializedName("path")
	private String path;

	@SerializedName("image")
	private String image;

	@SerializedName("name")
	private String name;

	public void setSearchterm(String searchterm){
		this.searchterm = searchterm;
	}

	public String getSearchterm(){
		return searchterm;
	}

	public void setPath(String path){
		this.path = path;
	}

	public String getPath(){
		return path;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
}