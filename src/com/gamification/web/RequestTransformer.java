package com.gamification.web;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public final class RequestTransformer {
	private static final String WORK_SPACE_PATH = "/Users/boobathiayyasamy/git/GamificationAPI/WebContent";
	
	public static Map<String, String> getInputsAndUploadFile(final HttpServletRequest request, final String serverPath, final String destPath) throws Exception  {
		 
		
		final String uploadPath = serverPath.concat(destPath);
		final Map<String,String> inputs = new HashMap<String,String>();
		if(ServletFileUpload.isMultipartContent(request)) {
			final List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
			for (FileItem item : multiparts) {
				if (!item.isFormField()) {
					final File path = new File(uploadPath);
					if (!path.exists()) {
						path.mkdirs();
					}
					if(item.getName()!=null && !item.getName().isEmpty() && item.getSize() != 0) {
						inputs.put(item.getFieldName(), item.getName());
						item.write( new File(path + "/" + item.getName()) );
						File localPath =  new File(WORK_SPACE_PATH+destPath);
						item.write( new File(localPath + "/" + item.getName()) );
					}
				} else {
					inputs.put(item.getFieldName(), item.getString());
				}
			}
		}
		return inputs;
	}
}
