package org.descentmanager.repository;

import java.util.List;

import org.descentmanager.model.JugadorObjeto;
import org.descentmanager.model.pk.JugadorObjetoPk;
import org.descentmanager.repository.projection.JugadorObjetoProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "jugadorObjeto", path = "jugadorObjeto", excerptProjection = JugadorObjetoProjection.class)
public interface JugadorObjetoRepository extends PagingAndSortingRepository<JugadorObjeto, JugadorObjetoPk> {

	/**
	 * Método que devuelve el listado de objetos pertenecientes a un jugador
	 * @param jugadorId Identificador de jugador
	 * @param pageable Paginable
	 * @return Listado de objetos que pertenecen al jugador
	 */
	@RestResource(path = "findByJugador", rel = "findByJugador")
	List<JugadorObjeto> findByIdJugadorId(@Param("jugadorId") Integer jugadorId);

	/**
	 * Método que devuelve el listado de objetos asignables (no pertenecientes) a un jugador
	 * @param jugadorId Identificador de jugador
	 * @param pageable Paginable
	 * @return Listado de objetos asignables al jugador
	 */
	@RestResource(path = "findByNotJugador", rel = "findByNotJugador")
	List<JugadorObjeto> findByIdJugadorIdIsNot(@Param("jugadorId") Integer jugadorId);
}
