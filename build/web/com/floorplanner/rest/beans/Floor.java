package com.floorplanner.rest.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Floor {

	private String name, height, level, id;
	private DesignList designs;

	public Floor() {
		this.designs = new DesignList();
	}

	public DesignList getDesigns() {
		return designs;
	}

	public String getHeight() {
		return height;
	}

	public String getId() {
		return id;
	}

	public String getLevel() {
		return level;
	}

	public String getName() {
		return name;
	}

	public void setDesigns(DesignList designs) {
		this.designs = designs;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public void setName(String name) {
		this.name = name;
	}
}
