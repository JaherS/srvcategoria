package com.soriano.srvCategoria.web.api.rest;

import com.soriano.model.dto.categoriaProducto.CategoriaProductoDTO;
import com.soriano.model.dto.generic.GenericResponseDTO;
import com.soriano.srvCategoria.service.ICategoriaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1")
@CrossOrigin
public class CategoriaController implements ICategoriaController{

    @Autowired
    private ICategoriaService iCategoriaService;

    @Override
    @PostMapping(path = "/crearcategoria", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "Crea una Categoria en el sistema", notes = "Diseñada por Jaher Soriano")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "La creacion fue exitosa", response = GenericResponseDTO.class)})
    public ResponseEntity<GenericResponseDTO> crearCategoria(@Valid @RequestBody @ApiParam(type = "CategoriaProductoDTO", value = "{\n" +
            "\"categoriaProductoNombre\": \"Lacteos\",\n" +
            "\"categoriaProductoActualizacion\": \"2022-07-1902:10:12\"\n" +
            "}", required = true) CategoriaProductoDTO categoriaDTO) throws Exception{
        System.out.println("Fecha ingresada" + categoriaDTO.getCategoriaProductoActualizacion());
        GenericResponseDTO genericResponseDTO = iCategoriaService.crearCategoriaProducto(categoriaDTO);
        return new ResponseEntity(
                genericResponseDTO, HttpStatus.valueOf(genericResponseDTO.getStatusCode())
        );

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GenericResponseDTO> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        //Map<String, String> errors = MensajeGenerico.generarMensajeErrorRequest(logger, ex);
        Map<String, String> errores = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errores.put(error.getField(), error.getDefaultMessage()));
        return new ResponseEntity<>(
                GenericResponseDTO.builder().message("Error en los datos ingresados").objectResponse(errores).statusCode(HttpStatus.NOT_FOUND.value()).build(), HttpStatus.NOT_FOUND
        );
    }

}
