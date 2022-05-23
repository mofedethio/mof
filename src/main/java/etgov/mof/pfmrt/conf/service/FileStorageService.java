package etgov.mof.pfmrt.conf.service;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileStorageService{
	private Path fileStoragePath;
	private String fileStorageLocation;

	public FileStorageService(@Value ("${myApp.folder:temp}") String fileStorageLocation) {
		
		this.fileStorageLocation=fileStorageLocation;
		
		fileStoragePath= Paths.get(fileStorageLocation).toAbsolutePath().normalize();
		try {
			Files.createDirectories(fileStoragePath);
		} catch (IOException e) {
			throw new RuntimeException("Issue in creating file directory");
		}
		
	}

	public String storeFile(MultipartFile file) {
		String docname = StringUtils.cleanPath(file.getOriginalFilename());
		Path filePath= Paths.get(fileStoragePath+ "\\"+docname);
		
		
		try {
			Files.copy(file.getInputStream(), filePath,StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			throw new RuntimeException("Issue in storing the file");
			
		}
		
		
		return docname;
	}

	public Resource downloadFile(String docname) throws IOException {
		
		Path path = Paths.get(fileStorageLocation).toAbsolutePath().resolve(docname);
		Resource resource;
		resource =
		new UrlResource(path.toUri());
		
		if(resource.exists() && resource.isReadable())
		{
			return resource;

		}else {
			throw new RuntimeException("The file doesnot exist");
		}
	}

}
