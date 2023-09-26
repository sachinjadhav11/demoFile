package com.project;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.project.*;

@Path("/file")
public class FileHierarchyResource
{
   
	private FileHierarchyRepository fileRepository;
	
	public FileHierarchyResource()
	{
		fileRepository = new FileHierarchyService();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<fileHierarchy> getAllFiles()
	{
		System.out.println("Controller "+fileRepository.getFilesHierarchy());
		return fileRepository.getFilesHierarchy();
	}
	
}
