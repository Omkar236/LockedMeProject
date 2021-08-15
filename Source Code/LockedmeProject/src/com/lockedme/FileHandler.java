package com.lockedme;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileHandler 
{
	public static List<String> getAllFiles(String folderpath)
	{
		File f1 = new File(folderpath);
		File[] listOfFiles= f1.listFiles();
		List<String> fileNames= new ArrayList<String>();
		
		for(File f:listOfFiles)
			fileNames.add(f.getName());
		
		return fileNames;
						
	}

	/**
	 * This file will create or append the content into the file.
	 * @param folderpath
	 * @param fileName
	 * @param content
	 * @return boolean
	 */
	public static boolean createFile(String folderpath,String fileName, List<String> content)
	{
		try
		{
			File f1=new File(folderpath,fileName);
			FileWriter fw=new FileWriter(f1);
			
			for(String s:content)
			{
				fw.write(s+"\n");
			}
			fw.close();
			
			return true;
			
		}
		catch(Exception Ex)
		{
			return false;
		}
	}
		/**
		 * This method will delete the file name if it exists 
		 * @param folderpath
		 * @param fileName
		 * @return
		 */
		public static boolean deleteFile(String folderpath,String fileName)
		{
			File file= new File (folderpath+"\\"+fileName); 
			try
			{
				if(file.delete())
					return true;
				else 
					return false;
			}
			catch(Exception Ex)
			{
				return false;
			}
		}
		
		/**
		 * This method will search the file from folder. 
		 * @param folderpath
		 * @param fileName
		 * @return
		 */
		public static boolean searchFile(String folderpath,String fileName)
		{
			File file= new File (folderpath+"\\"+fileName); 
			if(file.exists())
				return true;
			else 
				return false;
			
		}
}
