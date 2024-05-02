package com.cibertec.autopark.dtos;

import com.cibertec.autopark.model.Rol;
import com.cibertec.autopark.model.TipoDocumento;
import lombok.Data;

@Data
public class UsuarioDTO {

    private Integer idUsuario;

    private String name;

    private String lastname;

    private TipoDocumentoDTO tipoDocumentoDTO;

    private String nroDocumento;

    private String correo;

    private String telefono;

    private RolDTO rolDTO;

    private String username;

    private String password;

}