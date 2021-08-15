package com.lockedme;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class LockedMe 
{
	static final String folderpath="A:\\OMKAR\\java\\Project Files";
	public static void main(String[] args)
	{
		int proceed=1;
		do 
		{
			//Variable Declaration
			Scanner obj=new Scanner(System.in);
			int ch;
			
			//Menu
			displayMenu();
			System.out.println("Enter Your choice:");
			ch=Integer.parseInt(obj.nextLine());
			
			switch(ch)
			{
				case 1:getAllFiles();
				break;
				case 2:createFiles();
						break;
				case 3:deleteFile();
						break;
		//		case 4:searchFile();
		//				break;
				case 5:System.exit(0);
						break;
				default:
						System.out.println("Invalid Option");
						break;
			
			}
			
		}while(proceed>0);	
		
		
		
					
	}
	
	public static void displayMenu()
	{
		//Displaying Menu
		System.out.println("************************************************");
		System.out.println("\t\tLockedMe.com");
		System.out.println("************************************************");
				
		System.out.println("1) Display all files");
		System.out.println("2) Add new file");
		System.out.println("3) Delete a file");
		System.out.println("4) Search a file");
		System.out.println("5) Exit");
		
		System.out.println("------------------------------------------------");
	}
	public static void getAllFiles()
	{
		
		//Get File names
		List<String> fileNames=FileHandler.getAllFiles(folderpath);
		
		if(fileNames.size()==0)
			System.out.println("Empty Folder");
		else
		{
			System.out.println("List of Files:");
			for(String f:fileNames)
				System.out.println(f);
		}
	}
	

	public static void createFiles()
	{
		// Variable Declaration
		Scanner obj=new Scanner(System.in);
		String fileName;
		int linesCount;
		List<String> content = new ArrayList<String>(); 
				
		//Read filename from user
		System.out.println("Enter file Name:");
		fileName=obj.nextLine();
				
		//Read number of lines from user
		System.out.println("Enter no of lines in file:");
		linesCount=Integer.parseInt(obj.nextLine());
				
				
		//Read lines from user
		for(int i=1;i<=linesCount;i++)
		{
			System.out.println("Enter line "+i+":");
			content.add(obj.nextLine());
		}
				
		//Save content to the file
		boolean isSaved= FileHandler.createFile(folderpath, fileName, content);
				
		if(isSaved)
			System.out.println("File and data saved succesfully.");
		else
			System.out.println("Some error occured. Please contact admin");
				
	}
	
	public static void deleteFile()
	{
		// Code for deleting the file
		String fileName;
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter filename to be deleted:");
		fileName=obj.nextLine();
		
		boolean isDeleted= FileHandler.deleteFile(folderpath, fileName);
		if(isDeleted)
			System.out.println("File deleted Succesfully....!");
		else
			System.out.println("File not found.");
	}

	/*public static void searchFile()
	{
		// Code for searching the file
		String fileName;
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter filename to be searched:");
		fileName=obj.nextLine();
		
		boolean isFound= FileHandler.searchFile(folderpath, fileName);
		if(isFound)
			System.out.println("File is present in the folder....!");
		else
			System.out.println("File not found.");
	}
*/
}
