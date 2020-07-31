package com.projeto.repository.pagination;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Pagination {
	
	<T> Page<T> listarDadosPaginados(Class<T> classe,  Pageable pageable, String campo, String filtro);


}
