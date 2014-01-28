package com.floorplanner.rest.beans;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;


@XmlRootElement
public class User {

	private String username, email, id, countryCode, externalIdentifier, createdAt, measurement, profile, url, accountType, company, currentToken;
    
	public String getAccountType() {
		return accountType;
	}

	public String getCompany() {
		return company;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public String getCurrentToken() {
		return currentToken;
	}

	public String getEmail() {
		return email;
	}

	public String getExternalIdentifier() {
		return externalIdentifier;
	}

	public String getId() {
		return id;
	}

	public String getMeasurement() {
		return measurement;
	}

	public String getProfile() {
		return profile;
	}

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	@XmlElement(name = "account-type")
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@XmlElement(name = "country-code")
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@XmlElement(name = "current-token")
	public void setCurrentToken(String currentToken) {
		this.currentToken = currentToken;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@XmlElement(name = "external-identifier")
	public void setExternalIdentifier(String externalIdentifier) {
		this.externalIdentifier = externalIdentifier;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
