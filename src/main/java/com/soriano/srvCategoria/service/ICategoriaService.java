package com.soriano.srvCategoria.service;

import com.soriano.model.dto.categoriaProducto.CategoriaProductoDTO;
import com.soriano.model.dto.generic.GenericResponseDTO;

public interface ICategoriaService {
    GenericResponseDTO consultarCategoriaNombre(String Nombre) throws Exception;

    GenericResponseDTO crearCategoriaProducto(CategoriaProductoDTO categoriaDTO) throws Exception;
}
