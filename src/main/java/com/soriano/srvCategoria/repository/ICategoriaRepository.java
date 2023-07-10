package com.soriano.srvCategoria.repository;

import com.soriano.model.entities.categoriaProducto.CategoriaProductoDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepository extends JpaRepository<CategoriaProductoDAO, Long> {
    @Query("SELECT categoriaDAO FROM CategoriaProductoDAO categoriaDAO where categoriaDAO.categoriaProductoNombre = ?1")
    CategoriaProductoDAO obtenerCategoriaNombre(String nombre);
}
