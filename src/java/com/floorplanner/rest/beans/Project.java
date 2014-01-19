package com.floorplanner.rest.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Project {

	private String name, description, externalIentifier, id;
	private FloorList floors;

	public Project() {
		setFloors(new FloorList());
	}

	public String getDescription() {
		return description;
	}

	public String getExternalIentifier() {
		return externalIentifier;
	}

	public FloorList getFloors() {
		return floors;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setFloors(FloorList floors) {
		this.floors = floors;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
}
