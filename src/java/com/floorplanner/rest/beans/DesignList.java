package com.floorplanner.rest.beans;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DesignList {

	@XmlAttribute
	public static final String type = "array";

	private List<Design> designs;

	public DesignList() {
		designs = new ArrayList<Design>();
	}

	public void setList(List<Design> designs) {
		this.designs = designs;
	}

	@XmlElement(name = "design")
	public List<Design> getList() {
		return designs;
	}
}
