package com.projeto.service.storage;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.projeto.service.FotoStorageService;
import com.projeto.service.exceptions.StorageException;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;


@Service
public class LocalFotoStorageService implements FotoStorageService {

	@Value("${local.diretorio-fotos}")
	private Path diretorioFotos;
	
	@Override
	public InputStream recuperar(String nomeArquivo) {
		try {
			Path arquivoPath = getArquivoPath(nomeArquivo);

			return Files.newInputStream(arquivoPath);
		} catch (Exception e) {
			throw new StorageException("Não foi possível recuperar arquivo.", e);
		}
	}
	
	@Override
	public void armazenar(Foto foto) {
		try {
			Path arquivoPath = getArquivoPath(foto.getNomeArquivo());
			FileCopyUtils.copy(foto.getInputStream(), Files.newOutputStream(arquivoPath));
			Thumbnails.of(arquivoPath.toString()).size(50, 78).toFiles(Rename.PREFIX_DOT_THUMBNAIL);
			
		} catch (Exception e) {
			throw new StorageException("Não foi possível armazenar arquivo.", e);
		}  
	}
	
	@Override
	public boolean remover(String nomeArquivo) {
        boolean toReturn = false;
		try {
			Path arquivoPath = getArquivoPath(nomeArquivo);
			Files.deleteIfExists(arquivoPath);
			toReturn = true;
		} catch (Exception e) {
			throw new StorageException("Não foi possível excluir arquivo.", e);
		}
		return toReturn;
	}

	@Override
	public byte[] recuperarFoto(String nomeArquivo) {
		try {
			return Files.readAllBytes(getArquivoPath(nomeArquivo));
		} catch (IOException e) {
			throw new RuntimeException("Erro lendo a foto", e);
		}
	}
	
	private Path getArquivoPath(String nomeArquivo) {
		return diretorioFotos.resolve(Paths.get(nomeArquivo));
	}

}
