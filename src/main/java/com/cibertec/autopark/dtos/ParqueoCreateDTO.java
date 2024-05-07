package com.cibertec.autopark.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class ParqueoCreateDTO {

    private Date fechaParqueo;
    private ClienteDTO clienteDTO;
    private UsuarioDTO usuarioDTO;
    private Set<ParqueoDetalleCreateDTO> parqueoDetalleCreateDTO;
}