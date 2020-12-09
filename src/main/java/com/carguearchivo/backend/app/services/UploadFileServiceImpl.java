package com.carguearchivo.backend.app.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileServiceImpl implements IUploadFileService{

	@Override
	public void upload(MultipartFile file) throws IOException {
		Path path = Paths.get("archivos");
		String url = path.toFile().getAbsolutePath();
		byte[] bytes = file.getBytes();
		Path ruta = Paths.get(url + "/" + file.getOriginalFilename());
		validarArchivo(ruta);
		Files.write(ruta, bytes);
	}
	
	@Override
	public void validarArchivo(Path path) {
		File file = new File(path.toUri());
		if(file.exists()) {
			file.delete();
		}
	}
	
}
