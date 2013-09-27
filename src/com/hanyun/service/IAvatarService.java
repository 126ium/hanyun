package com.hanyun.service;

import java.io.File;

public interface IAvatarService {
	public static final int BUFFER_SIZE = 16 * 1024 ;
	
	/**
	 * Save temp file to file system
	 * @param src
	 * @return
	 * @throws Exception
	 */
	public boolean saveTmpFile(File src, int userId) throws Exception;
	
	/**
	 * Save file to file system
	 * @param src
	 * @return
	 * @throws Exception
	 */
	public boolean saveFile(int x, int y, int width, int height, int userId) throws Exception;
}
