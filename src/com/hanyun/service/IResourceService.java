package com.hanyun.service;

import java.io.File;

public interface IResourceService {
	
	public static final int BUFFER_SIZE = 16 * 1024 ;
	
	/**
	 * save upload file to file system
	 * @param src
	 * @return true if successful
	 * @throws Exception
	 */
	public boolean saveFile(File src) throws Exception;
	
	/**
	 * delete file from file system
	 * @param path
	 * @return true if successful
	 * @throws Exception
	 */
	public boolean deleteFile(String path) throws Exception;
	
	/**
	 * save information of file to database
	 * @param src
	 * @param filename
	 * @param userId
	 * @return true if successful
	 * @throws Exception
	 */
	public boolean saveToDb(File src, String filename, int userId, String permission) throws Exception;
}
