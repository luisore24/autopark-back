package com.cibertec.autopark.dtos;

import com.cibertec.autopark.model.TipoDocumento;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class ClienteDTO {
    private Long id;
    private TipoDocumentoDTO tipoDocumentoDTO;
    private String dni;
    private String nombres;
    private String apePaterno;
    private String apeMaterno;
    private Date fechaNacimiento;
    private String email;
}
