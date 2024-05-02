package com.cibertec.autopark.service;

import com.cibertec.autopark.dtos.ParqueoCreateDTO;
import com.cibertec.autopark.dtos.ParqueoDTO;
import com.cibertec.autopark.dtos.ParqueoResponseDTO;
import com.cibertec.autopark.mapper.ParqueoMapper;
import com.cibertec.autopark.model.Parqueo;
import com.cibertec.autopark.model.ParqueoDetalle;
import com.cibertec.autopark.repository.ParqueoDetalleRepository;
import com.cibertec.autopark.repository.ParqueoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ParqueoServiceImpl implements IParqueoService {

    @Autowired
    private ParqueoRepository parqueoRepository;

    @Autowired
    private ParqueoDetalleRepository parqueoDetalleRepository;

    @Override
    public List<ParqueoDTO> listarParqueos() {
        List<ParqueoDTO> lista= ParqueoMapper.instancia.listaParqueoAListaParqueoDTO(  parqueoRepository.findAll()  );
        return lista;
    }

    @Override
    public ParqueoDTO obtenerParqueoPorID(long id) {
        Optional<Parqueo> parqueo= parqueoRepository.findById(id);
        ParqueoDTO parqueoDTO= null;
        if ( parqueo.isPresent() ){
            parqueoDTO= ParqueoMapper.instancia.parqueoAParqueoDTO(parqueo.get());
        }
        return parqueoDTO;
    }

    @Override
    @Transactional
    public ParqueoResponseDTO registrarParqueo(ParqueoCreateDTO parqueoCreateDTO) {
        //Registro la cabecera
        Parqueo parqueo= ParqueoMapper.instancia.parqueoCreateDTOAParqueo(parqueoCreateDTO);
        Parqueo respuestaEntity= parqueoRepository.save(parqueo);

        //Registrando el detalle
        for (ParqueoDetalle pd: parqueo.getParqueoDetalle()) {
            pd.setParqueo(respuestaEntity);
            parqueoDetalleRepository.save(pd);
        }

        //armar la respuesta DTO
        ParqueoResponseDTO respuestaDTO = new ParqueoResponseDTO();
        respuestaDTO.setId(respuestaEntity.getId());

        return respuestaDTO;
    }
}