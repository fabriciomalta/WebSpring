package com.projeto.repository.pagination;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;


@Component
public class ConsutaPaginada implements Pagination {
	
	private EntityManager entityManager;
	
	public ConsutaPaginada(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public <T> Page<T> listarDadosPaginados(Class<T> classe, Pageable pageable, String campos, String filtros) {
		List<T> lista = new ArrayList<>();
		TypedQuery<T> query = null;
	  
	    
		int totalRegistrosPorPaginas = pageable.getPageSize();
		int paginaAtual = pageable.getPageNumber();
		int primeiroRegistro = paginaAtual * totalRegistrosPorPaginas;
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(classe);
		Root<T> root = cq.from(classe);
		root.fetch("roles");
		sortQuery(pageable, cb, cq, root);
		Predicate predicate = predicados(cb, root, campos, filtros);
		if (!Objects.isNull(predicate) ) {
			cq.where(predicate);
		}
		query = entityManager.createQuery(cq);
		query.setFirstResult(primeiroRegistro);
		query.setMaxResults(totalRegistrosPorPaginas);
		lista = query.getResultList();
		return new PageImpl<>(lista, pageable, totalRegistro(predicate, classe) );
	}

	private<T> Predicate predicados(CriteriaBuilder cb, Root<T> root, String campos, String filtros) {
		Predicate predicates = null;
		if (!Objects.isNull(campos)) {
			predicates = cb.like(cb.lower(root.get(campos)), "%"+ filtros + "%" );
		}
		return predicates;
	}

	private <T> void sortQuery(Pageable pageable, CriteriaBuilder cb, CriteriaQuery<T> cq, Root<T> root) {
		Sort sort = pageable.getSort();
		if (!sort.isUnsorted()) {
			Sort.Order order = sort.iterator().next();
			String propriedade = order.getProperty();
			cq.orderBy(order.isAscending() ? cb.asc(root.get(propriedade)) : cb.desc(root.get(propriedade)));
		}
	}

	private <T> Long totalRegistro(Predicate predicates,  Class<T> classe) {
		TypedQuery<Long> query = null;
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<T> root = cq.from(classe);
		cq.select(cb.count(root));
		if (!Objects.isNull(predicates) ) {
			cq.where(predicates);
		}
		query = entityManager.createQuery(cq);
		return  query.getSingleResult();
	}

}
