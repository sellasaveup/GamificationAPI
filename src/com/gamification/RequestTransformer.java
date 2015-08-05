package com.gamification;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public final class RequestTransformer {
	
	public static Map<String, String> getInputsAndUploadFile(final HttpServletRequest request, final String uploadPath) throws Exception  {
    	final Map<String,String> inputs = new HashMap<String,String>();
    	if(ServletFileUpload.isMultipartContent(request)) {
    		final List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
    		for (FileItem item : multiparts) {
    			if (!item.isFormField()) {
    				final File path = new File(uploadPath);
    				if (!path.exists()) {
    					path.mkdirs();
    				}
    				inputs.put(item.getFieldName(), item.getName());
    				final File uploadedFile = new File(path + "/" + item.getName());
    				System.out.println(uploadedFile.getAbsolutePath());
    				item.write(uploadedFile);
    			} else {
    				inputs.put(item.getFieldName(), item.getString());
    			}
    		}
    	}
    	System.out.println(inputs);
    	return inputs;
    }
}
