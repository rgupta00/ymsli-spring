package com.demo;
import java.util.*;
public class MusicGroup {
	private String groupName;
	private List<String>musicianNames;
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	
	
	public List<String> getMusicianNames() {
		return musicianNames;
	}
	public void setMusicianNames(List<String> musicianNames) {
		this.musicianNames = musicianNames;
	}
	
	public void printMGDetails() {
		System.out.println(groupName);
		System.out.println("-----name of musician----------");
		musicianNames.forEach(m-> System.out.println(m));
	}
}
