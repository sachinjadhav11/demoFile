package com.project;

import java.util.List;

public class fileHierarchy 
{
	  private int id;
	  
	  private String name;
	  
	  private int parentId;
	  
	  private int fileType;
	  
	  List<fileHierarchy> children;
	  
	public fileHierarchy(int id, String name, int parentId, int fileType, List<fileHierarchy> children)
	{
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.fileType = fileType;
		this.children = children;
	}
	
	public fileHierarchy(int id, String name, int parentId, int fileType) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.fileType = fileType;
	}

	public fileHierarchy()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getFileType() {
		return fileType;
	}

	public void setFileType(int fileType) {
		this.fileType = fileType;
	}

	public List<fileHierarchy> getChildren() {
		return children;
	}

	public void setChildren(List<fileHierarchy> children)
	{
		this.children = children;
	}
	
	@Override
	public String toString()
	{
		return " id=" + id + ", name=" + name + ", parentId=" + parentId + ", fileType=" + fileType
				+ ", children=" + children + "";
	}

	

	
	
	
	
	
	  
	  
	  
}
