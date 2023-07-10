package com.soriano.srvCategoria.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soriano.model.dto.categoriaProducto.CategoriaProductoDTO;
import com.soriano.model.dto.generic.GenericResponseDTO;
import com.soriano.model.entities.categoriaProducto.CategoriaProductoDAO;
import com.soriano.srvCategoria.commons.converter.CategoriaConverter;
import com.soriano.srvCategoria.repository.ICategoriaRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService implements  ICategoriaService{

    private ICategoriaRepository iCategoriaRepository;

    private final ModelMapper modelMapper;

    private final CategoriaConverter categoriaConverter;

    private static final Logger logger =    LoggerFactory.getLogger(CategoriaService.class);

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public CategoriaService(ICategoriaRepository iCategoriaRepository, ModelMapper modelMapper, CategoriaConverter categoriaConverter) {
        this.iCategoriaRepository = iCategoriaRepository;
        this.modelMapper = modelMapper;
        this.categoriaConverter = categoriaConverter;
    }

    @Override
    public GenericResponseDTO consultarCategoriaNombre(String nombreCategoria) throws Exception{
        try {

            CategoriaProductoDAO categoriaDAO = iCategoriaRepository.obtenerCategoriaNombre(nombreCategoria);
            logger.info(mapper.writeValueAsString(categoriaDAO));
            CategoriaProductoDTO categoriaDTO = categoriaConverter.categoriaDAOtoDTO(categoriaDAO, modelMapper);
            return GenericResponseDTO.builder().message("Categoria Producto Encontrada").objectResponse(categoriaDTO).statusCode(HttpStatus.OK.value()).build();
        }catch(Exception e){
            logger.error(e.getMessage());
            return GenericResponseDTO.builder().message("Error, no se encontro la categoria").objectResponse(null).statusCode(HttpStatus.NOT_FOUND.value()).build();
        }

    }

    @Override
    public GenericResponseDTO crearCategoriaProducto(CategoriaProductoDTO categoriaDTO) throws Exception {
        try{
            CategoriaProductoDAO categoriaDAO = categoriaConverter.categoriaDTOtoDAO(categoriaDTO, modelMapper);
            System.out.println("FECHA REGISTRO: "+ categoriaDAO.getCategoriaProductoActualizacion());
            logger.info(mapper.writeValueAsString(categoriaDAO));

            iCategoriaRepository.save(categoriaDAO);

            CategoriaProductoDTO categoriaDTORespuesta = categoriaConverter.categoriaDAOtoDTO(categoriaDAO, modelMapper);
            logger.info(mapper.writeValueAsString(categoriaDTORespuesta));
            return GenericResponseDTO.builder().message("Se registro la categoria").objectResponse(categoriaDTORespuesta).statusCode(HttpStatus.OK.value()).build();
        }catch(Exception e){
            logger.error(e.getMessage());
            return GenericResponseDTO.builder().message("Error al registrar categoria").objectResponse(null).statusCode(HttpStatus.BAD_REQUEST.value()).build();
        }
    }
}
