package com.cibertec.autopark.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class ParqueoCreateDTO {

    private Date fechaParqueo;
    private ClienteDTO clienteDTO;
   private EmpleadoDTO empleadoDTO;
    private Set<ParqueoDetalleCreateDTO> parqueoDetalleCreateDTO;
}
