package com.project;

public class demoFile
{
  private int id;
  
  private String name;
  
  private int parentId;
  
  private int fileType;

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

public demoFile(int id, String name, int parentId, int fileType) {
	super();
	this.id = id;
	this.name = name;
	this.parentId = parentId;
	this.fileType = fileType;
}

public demoFile() 
{
	super();
	// TODO Auto-generated constructor stub
}


  
  
}
