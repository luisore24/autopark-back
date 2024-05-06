package com.cibertec.autopark.service;

import com.cibertec.autopark.dtos.TarifarioCreateDTO;
import com.cibertec.autopark.dtos.TarifarioDTO;
import com.cibertec.autopark.mapper.TarifarioMapper;
import com.cibertec.autopark.model.Tarifario;
import com.cibertec.autopark.repository.TarifarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TarifarioServiceImpl implements ITarifarioService{

    @Autowired
    private TarifarioRepository tarifarioRepository;

    @Override
    public List<TarifarioDTO> listarTarifarios() {
        return TarifarioMapper.instancia.listarTarifarioAListarTarifarioDTO(tarifarioRepository.findAll());
    }

    @Override
    public TarifarioDTO obtenerTarifarioPorId(Integer id) {
        Optional<Tarifario> tarifarioOptinal = tarifarioRepository.findById(id);
        return tarifarioOptinal.map(TarifarioMapper.instancia::TarifarioATarifarioDTO).orElse(null);
    }

    @Override
    public TarifarioDTO registrarTarifario(TarifarioCreateDTO tarifarioCreateDTO) {
        Tarifario tarifario = TarifarioMapper.instancia.TarifarioCreateDTOATarifario(tarifarioCreateDTO);
        Tarifario respuestaEntity=tarifarioRepository.save(tarifario);
        return TarifarioMapper.instancia.TarifarioATarifarioDTO(respuestaEntity);
    }

    @Override
    public TarifarioDTO actualizarTarifario(TarifarioDTO tarifarioUpdateDTO) {
        Tarifario tarifario = TarifarioMapper.instancia.TarifarioUpdateDTOATarifario(tarifarioUpdateDTO);
        Tarifario respuestaEntity=tarifarioRepository.save(tarifario);
        return TarifarioMapper.instancia.TarifarioATarifarioDTO(respuestaEntity);
    }

    @Override
    public String eliminarTarifario(Integer id) {
        Optional<Tarifario> tarifarioOptional =tarifarioRepository.findById(id);
        if(tarifarioOptional.isPresent()){
            tarifarioRepository.delete(tarifarioOptional.get());
            return "Registro eliminado";
        }else{
            throw new NoSuchElementException("No se pudo realizar la eliminacion por Id");
        }
    }
}