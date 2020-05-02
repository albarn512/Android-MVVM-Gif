package com.example.gif.model.search.goodnight;

import com.google.gson.annotations.SerializedName;

public class MediaItem{

	@SerializedName("mp4")
	private Mp4 mp4;

	@SerializedName("tinygif")
	private Tinygif tinygif;

	@SerializedName("tinywebm")
	private Tinywebm tinywebm;

	@SerializedName("gif")
	private Gif gif;

	@SerializedName("nanogif")
	private Nanogif nanogif;

	@SerializedName("mediumgif")
	private Mediumgif mediumgif;

	@SerializedName("tinymp4")
	private Tinymp4 tinymp4;

	@SerializedName("nanomp4")
	private Nanomp4 nanomp4;

	@SerializedName("nanowebm")
	private Nanowebm nanowebm;

	@SerializedName("loopedmp4")
	private Loopedmp4 loopedmp4;

	@SerializedName("webm")
	private Webm webm;

	public void setMp4(Mp4 mp4){
		this.mp4 = mp4;
	}

	public Mp4 getMp4(){
		return mp4;
	}

	public void setTinygif(Tinygif tinygif){
		this.tinygif = tinygif;
	}

	public Tinygif getTinygif(){
		return tinygif;
	}

	public void setTinywebm(Tinywebm tinywebm){
		this.tinywebm = tinywebm;
	}

	public Tinywebm getTinywebm(){
		return tinywebm;
	}

	public void setGif(Gif gif){
		this.gif = gif;
	}

	public Gif getGif(){
		return gif;
	}

	public void setNanogif(Nanogif nanogif){
		this.nanogif = nanogif;
	}

	public Nanogif getNanogif(){
		return nanogif;
	}

	public void setMediumgif(Mediumgif mediumgif){
		this.mediumgif = mediumgif;
	}

	public Mediumgif getMediumgif(){
		return mediumgif;
	}

	public void setTinymp4(Tinymp4 tinymp4){
		this.tinymp4 = tinymp4;
	}

	public Tinymp4 getTinymp4(){
		return tinymp4;
	}

	public void setNanomp4(Nanomp4 nanomp4){
		this.nanomp4 = nanomp4;
	}

	public Nanomp4 getNanomp4(){
		return nanomp4;
	}

	public void setNanowebm(Nanowebm nanowebm){
		this.nanowebm = nanowebm;
	}

	public Nanowebm getNanowebm(){
		return nanowebm;
	}

	public void setLoopedmp4(Loopedmp4 loopedmp4){
		this.loopedmp4 = loopedmp4;
	}

	public Loopedmp4 getLoopedmp4(){
		return loopedmp4;
	}

	public void setWebm(Webm webm){
		this.webm = webm;
	}

	public Webm getWebm(){
		return webm;
	}
}