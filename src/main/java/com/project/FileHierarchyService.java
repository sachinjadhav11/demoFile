package com.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FileHierarchyService implements FileHierarchyRepository
{
	public FileHierarchyService()
	{

	}
	
    public final String query ="select * from fileOrganization.container";
	
	@Override
	public List<fileHierarchy> getFilesHierarchy()
	{
		List<fileHierarchy> list = new ArrayList<>();
		List<fileHierarchy> result = new ArrayList<>();
		
		 Connection con=null;
		 
		try
		{
			con=ConnectionLoader.getConnection();
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
				fileHierarchy file = new fileHierarchy();
				
				file.setId(rs.getInt(1));
				file.setName(rs.getString(2));
				file.setParentId(rs.getInt(3));
				file.setFileType(rs.getInt(4));
				file.getChildren();
				list.add(file);
			}

			for (fileHierarchy f1 : list)
			{
				// if it is file then 
				if (f1.getFileType() > 0 && f1.getParentId() == 0)
				{
					result.add(f1);
				}
				// if it is parent folder then
				else if (f1.getParentId() == 0)
				{
					// finds its children
					List<fileHierarchy> children = findChildren(f1.getId(), list);
					
					if (!children.isEmpty())
					{
						f1.setChildren(children);
					}
					result.add(f1);
				}

			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	   finally
	   {
		  if(con!= null)
		  {
			  try 
			  {
				con.close();
			  }
			  catch (SQLException e2) 
			  {
				e2.printStackTrace();
			  }
		  }
	   }
		
		return result;
	}

	private List<fileHierarchy> findChildren(int parentId, List<fileHierarchy> list)
	{
		List<fileHierarchy> children = new ArrayList<>();
		
		List<fileHierarchy> children2 = new ArrayList<>();
		
		fileHierarchy file5 = new fileHierarchy();
	
		  for (fileHierarchy f : list)
		  {
		        if (f.getParentId() == parentId)
		        {
		            if (f.getFileType() > 0)
		            {
		            	file5.setId(f.getId());
		            	file5.setName(f.getName());
		            	file5.setParentId(f.getParentId());
		            	file5.setFileType(f.getFileType());
		            	children.add(file5);
		            	
		            	System.out.println("children "+children);
		            }
		            else
		            {
		                List<fileHierarchy> findNestedChildren = findChildren(f.getId(), list);
		                if (!findNestedChildren.isEmpty())
		                {
		                    f.setChildren(findNestedChildren);
		                }
		                children.add(f);
		            }
		        }
		    }
	
		return children;
	
	}

}
