package com.floorplanner.rest.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Design {

	private String id, name, designType, createdAt, updatedAt, projectId, floorId;

	public String getCreatedAt() {
		return createdAt;
	}

	public String getDesignType() {
		return designType;
	}

	public String getFloorId() {
		return floorId;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getProjectId() {
		return projectId;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public void setDesignType(String designType) {
		this.designType = designType;
	}

	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
