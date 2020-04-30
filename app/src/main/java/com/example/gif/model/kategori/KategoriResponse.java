package com.example.gif.model.kategori;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class KategoriResponse{

	@SerializedName("locale")
	private String locale;

	@SerializedName("tags")
	private ArrayList<KategoriItem> tags;

	public void setLocale(String locale){
		this.locale = locale;
	}

	public String getLocale(){
		return locale;
	}

	public void setTags(ArrayList<KategoriItem> tags){
		this.tags = tags;
	}

	public ArrayList<KategoriItem> getTags(){
		return tags;
	}
}