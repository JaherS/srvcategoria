package com.soriano.srvCategoria.web.api.rest;

import com.soriano.model.dto.categoriaProducto.CategoriaProductoDTO;
import com.soriano.model.dto.generic.GenericResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface ICategoriaController {

    ResponseEntity<GenericResponseDTO> crearCategoria(@Valid @RequestBody CategoriaProductoDTO categoriaDTO) throws Exception;


}
