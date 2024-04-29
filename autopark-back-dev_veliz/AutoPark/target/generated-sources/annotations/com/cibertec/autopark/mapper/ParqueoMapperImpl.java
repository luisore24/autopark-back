package com.cibertec.autopark.mapper;

import com.cibertec.autopark.dtos.ClienteDTO;
import com.cibertec.autopark.dtos.ParqueoCreateDTO;
import com.cibertec.autopark.dtos.ParqueoDTO;
import com.cibertec.autopark.dtos.ParqueoDetalleCreateDTO;
import com.cibertec.autopark.dtos.ParqueoDetalleDTO;
import com.cibertec.autopark.model.Cliente;
import com.cibertec.autopark.model.Parqueo;
import com.cibertec.autopark.model.ParqueoDetalle;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-29T02:50:23-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
public class ParqueoMapperImpl implements ParqueoMapper {

    @Override
    public ParqueoDTO parqueoAParqueoDTO(Parqueo parqueo) {
        if ( parqueo == null ) {
            return null;
        }

        ParqueoDTO parqueoDTO = new ParqueoDTO();

        parqueoDTO.setParqueoDetalleDTO( parqueoDetalleSetToParqueoDetalleDTOSet( parqueo.getParqueoDetalle() ) );
        parqueoDTO.setClienteDTO( clienteToClienteDTO( parqueo.getCliente() ) );
        parqueoDTO.setId( parqueo.getId() );
        parqueoDTO.setFechaParqueo( parqueo.getFechaParqueo() );

        return parqueoDTO;
    }

    @Override
    public List<ParqueoDTO> listaParqueoAListaParqueoDTO(List<Parqueo> listaParqueo) {
        if ( listaParqueo == null ) {
            return null;
        }

        List<ParqueoDTO> list = new ArrayList<ParqueoDTO>( listaParqueo.size() );
        for ( Parqueo parqueo : listaParqueo ) {
            list.add( parqueoAParqueoDTO( parqueo ) );
        }

        return list;
    }

    @Override
    public Parqueo parqueoCreateDTOAParqueo(ParqueoCreateDTO parqueoCreateDTO) {
        if ( parqueoCreateDTO == null ) {
            return null;
        }

        Parqueo parqueo = new Parqueo();

        parqueo.setParqueoDetalle( parqueoDetalleCreateDTOSetToParqueoDetalleSet( parqueoCreateDTO.getParqueoDetalleCreateDTO() ) );
        parqueo.setCliente( clienteDTOToCliente( parqueoCreateDTO.getClienteDTO() ) );
        parqueo.setFechaParqueo( parqueoCreateDTO.getFechaParqueo() );

        return parqueo;
    }

    protected Set<ParqueoDetalleDTO> parqueoDetalleSetToParqueoDetalleDTOSet(Set<ParqueoDetalle> set) {
        if ( set == null ) {
            return null;
        }

        Set<ParqueoDetalleDTO> set1 = new LinkedHashSet<ParqueoDetalleDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ParqueoDetalle parqueoDetalle : set ) {
            set1.add( mapParqueoDetalleToParqueoDetalleDTO( parqueoDetalle ) );
        }

        return set1;
    }

    protected ClienteDTO clienteToClienteDTO(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setId( cliente.getId() );
        clienteDTO.setDni( cliente.getDni() );
        clienteDTO.setNombres( cliente.getNombres() );
        clienteDTO.setApePaterno( cliente.getApePaterno() );
        clienteDTO.setApeMaterno( cliente.getApeMaterno() );
        clienteDTO.setFechaNacimiento( cliente.getFechaNacimiento() );
        clienteDTO.setEmail( cliente.getEmail() );

        return clienteDTO;
    }

    protected Set<ParqueoDetalle> parqueoDetalleCreateDTOSetToParqueoDetalleSet(Set<ParqueoDetalleCreateDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<ParqueoDetalle> set1 = new LinkedHashSet<ParqueoDetalle>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ParqueoDetalleCreateDTO parqueoDetalleCreateDTO : set ) {
            set1.add( mapParqueoDetalleCreateDTOToParqueoDetalle( parqueoDetalleCreateDTO ) );
        }

        return set1;
    }

    protected Cliente clienteDTOToCliente(ClienteDTO clienteDTO) {
        if ( clienteDTO == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setId( clienteDTO.getId() );
        cliente.setDni( clienteDTO.getDni() );
        cliente.setNombres( clienteDTO.getNombres() );
        cliente.setApePaterno( clienteDTO.getApePaterno() );
        cliente.setApeMaterno( clienteDTO.getApeMaterno() );
        cliente.setFechaNacimiento( clienteDTO.getFechaNacimiento() );
        cliente.setEmail( clienteDTO.getEmail() );

        return cliente;
    }
}
