package com.floorplanner.rest.beans;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FloorList {

	@XmlAttribute
	public static final String type = "array";

	private List<Floor> floors;

	public FloorList() {
		this.floors = new ArrayList<Floor>();
	}

	public FloorList(List<Floor> floors) {
		this.floors = floors;
	}

	public void setList(List<Floor> floors) {
		this.floors = floors;
	}

	@XmlElement(name = "floor")
	public List<Floor> getList() {
		return floors;
	}
}
