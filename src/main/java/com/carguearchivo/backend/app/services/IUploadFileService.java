package com.carguearchivo.backend.app.services;

import java.io.IOException;
import java.nio.file.Path;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadFileService {

	public void upload(MultipartFile file) throws IOException;
	
	public void validarArchivo(Path path);
	
}
