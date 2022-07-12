package com.entidad.citse.service.ServiceImp;

import com.entidad.citse.dao.EntidadDao;
import com.entidad.citse.entity.Entidad;
import com.entidad.citse.feignClients.TipoFeignClient;
import com.entidad.citse.models.Tipo;
import com.entidad.citse.service.EntidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntidadServiceImp implements EntidadService {

    @Autowired
    private EntidadDao entidadDao;

    @Autowired
    private TipoFeignClient tipoFeignClient;

    @Override
    public List<Entidad> findAll() {
        return entidadDao.findAll();
    }

    @Override
    public Entidad findById(Integer id) {
        Entidad e = entidadDao.findById(id).orElse(null);
        if(e!=null){
            Tipo tipoEntidad = tipoFeignClient.findById(e.getIdTipoEntidad()).getBody();
            e.setTipoEntidad(tipoEntidad);
        }
        return e;
    }

    @Override
    public void deleteById(Integer id) {
        entidadDao.deleteById(id);
    }

    @Override
    public List<Entidad> findByAlias(String alias){
        return entidadDao.findTop10ByAliasContains(alias);
    }

    @Override
    public List<Entidad> findByNombre(String nombre) {
        return entidadDao.findTop10ByNombreContains(nombre);
    }

    @Override
    public Entidad save(Entidad entidad) {
        return entidadDao.save(entidad);
    }
}
