package cloudstorage;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.net.ftp.*;
import java.util.Vector;
//import android.content.Context;
//import android.util.Log;

public class MyFTPClient3 {
	
	//Now, declare a public FTP client object.

	private static final String TAG = "MyFTPClient";
	public FTPClient mFTPClient = null; 
        
        public MyFTPClient3()
        {
            boolean status=ftpConnect("ftp.drivehq.com","email@gmail.com","password",0);
		if (status==true)
		{
			
		
			System.out.println("logged in..");
			
			
			
			
			
		}
		
		else
		System.out.println("login error..");
		
        }
        
        public boolean upload(String path,String fname)
        {
            boolean s1=ftpUpload(path,fname,".");
				
			if(s1)
			System.out.println("upload success..");
			else
			System.out.println("upload fail..");
                        
                        return s1;
        }
        
        public boolean download(String drive,String path)
        {
            boolean s1=ftpDownload(drive,path);
            if(s1)
			System.out.println("Download success..");
			else
			System.out.println("Download fail..");
            return s1;
        }

	//Method to connect to FTP server:
	public boolean ftpConnect(String host, String username,
	                          String password, int port)
	{
	    try {
	        mFTPClient = new FTPClient();
	        // connecting to the host
	        mFTPClient.connect(host);

	        // now check the reply code, if positive mean connection success
	        if (FTPReply.isPositiveCompletion(mFTPClient.getReplyCode())) {
	            // login using username & password
	            boolean status = mFTPClient.login(username, password);

	            /* Set File Transfer Mode
	             *
	             * To avoid corruption issue you must specified a correct
	             * transfer mode, such as ASCII_FILE_TYPE, BINARY_FILE_TYPE,
	             * EBCDIC_FILE_TYPE .etc. Here, I use BINARY_FILE_TYPE
	             * for transferring text, image, and compressed files.
	             */
	            mFTPClient.setFileType(FTP.ASCII_FILE_TYPE);
	            mFTPClient.enterLocalPassiveMode();

	            return status;
	        }
	    } catch(Exception e) {
//	        Log.d(TAG, "Error: could not connect to host " + host );
	    }

	    return false;
	} 

	//Method to disconnect from FTP server:

	public boolean ftpDisconnect()
	{
	    try {
	        mFTPClient.logout();
	        mFTPClient.disconnect();
	        return true;
	    } catch (Exception e) {
//	        Log.d(TAG, "Error occurred while disconnecting from ftp server.");
	    }

	    return false;
	} 
        
        
        	//Method to list all files in a directory:

	public Vector ftpPrintFilesList(String dir_path)
	{
            Vector v=new Vector();
            String dir="";
	    try {
	    	ftpChangeDirectory(dir_path);
	        FTPFile[] ftpFiles = mFTPClient.listFiles(dir_path);
	        int length = ftpFiles.length;

	        for (int i = 0; i < length; i++) {
	            String name = ftpFiles[i].getName();
	            boolean isFile = ftpFiles[i].isFile();

	            if (isFile) {
                         v.add(name);
	                System.out.println( "File : " + name);
	            }
	            else {
                        dir=name;
	                System.out.println( "Directory : " + name);
                       
                            
	            }
	        }
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
            return v;
	} 

	//Method to get current working directory:

	public String ftpGetCurrentWorkingDirectory()
	{
	    try {
	        String workingDir = mFTPClient.printWorkingDirectory();
	        return workingDir;
	    } catch(Exception e) {
//	        Log.d(TAG, "Error: could not get current working directory.");
	    }

	    return null;
	} 

	//Method to change working directory:

	public boolean ftpChangeDirectory(String directory_path)
	{
	    try {
	        mFTPClient.changeWorkingDirectory(directory_path);
	    } catch(Exception e) {
//	        Log.d(TAG, "Error: could not change directory to " + directory_path);
	    }

	    return false;
	} 





	//Method to delete/remove a directory:

	public boolean ftpRemoveDirectory(String dir_path)
	{
	    try {
	        boolean status = mFTPClient.removeDirectory(dir_path);
	        return status;
	    } catch(Exception e) {
	   //     Log.d(TAG, "Error: could not remove directory named " + dir_path);
	    }

	    return false;
	} 

	//Method to delete a file:

	public boolean ftpRemoveFile(String filePath)
	{
	    try {
	        boolean status = mFTPClient.deleteFile(filePath);
	        return status;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return false;
	} 

	//Method to rename a file:

	public boolean ftpRenameFile(String from, String to)
	{
	    try {
	        boolean status = mFTPClient.rename(from, to);
	        return status;
	    } catch (Exception e) {
//	        Log.d(TAG, "Could not rename file: " + from + " to: " + to);
	    }

	    return false;
	} 

	//Method to download a file from FTP server:

	/**
	 * mFTPClient: FTP client connection object (see FTP connection example)
	 * srcFilePath: path to the source file in FTP server
	 * desFilePath: path to the destination file to be saved in sdcard
	 */
	public boolean ftpDownload(String srcFilePath, String desFilePath)
	{
	    boolean status = false;
	    try {
	        FileOutputStream desFileStream = new FileOutputStream(desFilePath);;
	        status = mFTPClient.retrieveFile(srcFilePath, desFileStream);
	        desFileStream.close();

	        return status;
	    } catch (Exception e) {
//	        Log.d(TAG, "download failed");
	    }

	    return status;
	} 

	//Method to upload a file to FTP server:

	/**
	 * mFTPClient: FTP client connection object (see FTP connection example)
	 * srcFilePath: source file path in sdcard
	 * desFileName: file name to be stored in FTP server
	 * desDirectory: directory path where the file should be upload to
	 */
	public boolean ftpUpload(String srcFilePath, String desFileName,
	                         String desDirectory)
	{
	    boolean status = false;
	    try {
	        FileInputStream srcFileStream = new FileInputStream(srcFilePath);
	        
	       // FileInputStream srcFileStream = context.openFileInput(srcFilePath);

	        // change working directory to the destination directory
	        //if (ftpChangeDirectory(desDirectory)) {
	            status = mFTPClient.storeFile(desFileName, srcFileStream);
	        //}

	        srcFileStream.close();
	        return status;
	    } 
	    catch (Exception e) {
//	        Log.d(TAG, "upload failed: " + e);
	    }

	    return status;
	}
	
	
	
}
