package com.cibertec.autopark.service;

import com.cibertec.autopark.dtos.VehiculoCreateDTO;
import com.cibertec.autopark.dtos.VehiculoDTO;
import com.cibertec.autopark.dtos.VehiculoUpdateDTO;

import java.util.HashMap;
import java.util.List;

public interface VehiculoService {
    List<VehiculoDTO>  listarVehiculos();
    VehiculoDTO obtenerVehiculoPorID(Integer id);
    VehiculoDTO registrarVehiculo(VehiculoCreateDTO vehiculoCreateDTO);
    VehiculoDTO actualizarVehiculo(VehiculoUpdateDTO vehiculoUpdateDTO);
    String eliminarVehiculo(Integer id);
}
