package com.SGSRveiculo.frameworkPDS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SGSRveiculo.frameworkPDS.models.MarcaModeloF;

@Repository
public interface MarcaModeloRepository extends JpaRepository<MarcaModeloF, Long>{

	@Query("SELECT m.modelo FROM MarcaModeloF m WHERE m.marca =:marca ")
	public List<String> buscarModelosPorMarca(@Param("marca")String marca);
	
	@Query("SELECT m FROM MarcaModeloF m WHERE m.marca =:marca AND m.modelo =:modelo")
	public MarcaModeloF buscarPorMarcaModelo(@Param("marca")String marca, @Param("modelo")String modelo);
	
	
	@Query("SELECT DISTINCT(m.marca) FROM MarcaModeloF m ")
	public List<String> buscarModelos();

	
}
