package com.soriano.srvCategoria.commons.converter;

import com.soriano.model.dto.categoriaProducto.CategoriaProductoDTO;
import com.soriano.model.entities.categoriaProducto.CategoriaProductoDAO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoriaConverter {

    public CategoriaProductoDAO categoriaDTOtoDAO(CategoriaProductoDTO categoriaProductoDTO, ModelMapper modelMapper) {
        CategoriaProductoDAO categoriaProductoDAO = new CategoriaProductoDAO();
        modelMapper.map(categoriaProductoDTO, categoriaProductoDAO);
        return categoriaProductoDAO;
    }


    public CategoriaProductoDTO categoriaDAOtoDTO(CategoriaProductoDAO categoriaProductoDAO, ModelMapper modelMapper) {
        CategoriaProductoDTO categoriaProductoDTO = new CategoriaProductoDTO();
        modelMapper.map(categoriaProductoDAO, categoriaProductoDTO);
        return categoriaProductoDTO;
    }
}