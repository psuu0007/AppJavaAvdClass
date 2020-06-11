package com.edu.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Component("fileUtils")
public class FileUtils {

	private static final String FILE_PATH = "D:\\upload";	
	
	public List<Map<String, Object>> parseInsertFileInfo(int parentSeq,
			MultipartHttpServletRequest multipartHttpServletRequest) 
				throws IllegalStateException, IOException{
		
		Iterator<String> iterator = 
			multipartHttpServletRequest.getFileNames();
		
		MultipartFile multipartFile = null;
		
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName = null;
		
		List<Map<String, Object>> fileList = 
			new ArrayList<Map<String,Object>>();
		Map<String, Object> fileInfoMap = null;
		
		File file = new File(FILE_PATH);
		
		if(file.exists() == false) {
			file.mkdirs();
		}
		
		while(iterator.hasNext()) {
			multipartFile = 
				multipartHttpServletRequest.getFile(iterator.next());
			
			if(multipartFile.isEmpty() == false) {
				originalFileName = multipartFile.getOriginalFilename();
				originalFileExtension = 
					originalFileName.substring(
						originalFileName.lastIndexOf("."));
				storedFileName = CommonUtils.getRandomString() 
						+ originalFileExtension;
				 
				file = new File(FILE_PATH, storedFileName);
				multipartFile.transferTo(file);
				
				fileInfoMap = new HashMap<String, Object>();
				fileInfoMap.put("parent_seq", parentSeq);
				fileInfoMap.put("original_file_name", originalFileName);
				fileInfoMap.put("stored_file_name", storedFileName);
				fileInfoMap.put("file_size", multipartFile.getSize());
				
				fileList.add(fileInfoMap);
			}
			
		} // while end 
		
		
		return fileList;
	}

	public void parseUpdateFileInfo(Map<String, Object> tempFileMap) 
		throws Exception{
		// TODO Auto-generated method stub
		
		String storedFileName 
			= (String)tempFileMap.get("STORED_FILE_NAME");
		
		File file = new File(FILE_PATH + "/" + storedFileName);
		
		if(file.exists()) {
			file.delete();
		}else {
			System.out.println("파일이 존재하지 않습니다.");
			throw new Exception();
		}
		
		
	}
	
}
