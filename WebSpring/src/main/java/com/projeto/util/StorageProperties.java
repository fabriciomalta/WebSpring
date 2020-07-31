package com.projeto.util;

import java.nio.file.Path;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties("local.storage")
public class StorageProperties {

	private Local local = new Local();
		
	public class Local {
		
		private Path diretorioFotos;

		public Path getDiretorioFotos() {
			return diretorioFotos;
		}

		public void setDiretorioFotos(Path diretorioFotos) {
			this.diretorioFotos = diretorioFotos;
		}
		
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}
	
	
}
