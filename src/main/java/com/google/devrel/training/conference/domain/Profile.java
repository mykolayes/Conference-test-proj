package com.google.devrel.training.conference.domain;

import java.util.ArrayList;
import java.util.List;

import com.google.devrel.training.conference.form.ProfileForm.TeeShirtSize;
import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;


// TODO indicate that this class is an Entity
@Cache
@Entity
public class Profile {
	String displayName;
	String mainEmail;
	TeeShirtSize teeShirtSize;
	private List <String> conferenceKeysToAttend = new ArrayList<> (0);

	// TODO indicate that the userId is to be used in the Entity's key
	@Id String userId;
    
    /**
     * Public constructor for Profile.
     * @param userId The user id, obtained from the email
     * @param displayName Any string user wants us to display him/her on this system.
     * @param mainEmail User's main e-mail address.
     * @param teeShirtSize The User's tee shirt size
     * 
     */
    public Profile (String userId, String displayName, String mainEmail, TeeShirtSize teeShirtSize) {
    	this.userId = userId;
    	this.displayName = displayName;
    	this.mainEmail = mainEmail;
    	this.teeShirtSize = teeShirtSize;
    }
    
	public String getDisplayName() {
		return displayName;
	}

	public String getMainEmail() {
		return mainEmail;
	}

	public TeeShirtSize getTeeShirtSize() {
		return teeShirtSize;
	}

	public String getUserId() {
		return userId;
	}
	
	public void update(String displayName, TeeShirtSize teeShirtSize) {
		this.displayName = displayName;
		this.teeShirtSize = teeShirtSize;
		return;
	}
	
	public List <String> getConferenceKeysToAttend(){
		/*
		List <String> conferenceKeysToAttendCopy = new ArrayList<> (conferenceKeysToAttend.size());
		for (String s : conferenceKeysToAttend) {
			conferenceKeysToAttendCopy.add(s);
		}
		*/
		List <String> conferenceKeysToAttendCopy = new ArrayList<> (conferenceKeysToAttend);
		return conferenceKeysToAttendCopy;
	}
	
	public void addToConferenceKeysToAttend(String key) {
		if (!conferenceKeysToAttend.contains(key)) {
			conferenceKeysToAttend.add(key);
		}
		return;
	}
	
	public void removeConferenceKeyToAttend(String key) {
		if (conferenceKeysToAttend.contains(key)) {
			conferenceKeysToAttend.remove(key);
		}
		return;
	}

	/**
     * Just making the default constructor private.
     */
    private Profile() {}

}
