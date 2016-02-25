package org.descentmanager.repository;

import org.descentmanager.model.Habilidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('ROLE_USER')")
@RepositoryRestResource(collectionResourceRel = "habilidades", path = "habilidades")
public interface HabilidadRepository extends PagingAndSortingRepository<Habilidad, Integer> {

	/**
	 * Método que devuelve el listado de habilidades pertenecientes a una clase
	 * @param claseId Identificador de la clase
	 * @return Listado de habilidades
	 */
	@RestResource(path = "findByClaseId", rel = "findByClaseId")
	Page<Habilidad> findByClaseId(@Param("claseId") Integer claseId, Pageable pageable);
}