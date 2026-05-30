package org.aguzman.springcloud.msvc.usuarios.services;

import org.aguzman.springcloud.msvc.usuarios.models.entity.Usuario;
import org.aguzman.springcloud.msvc.usuarios.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicesImpl implements UsuarioService{
    @Autowired
    private UsuarioRepository repository;

    @Override
    @Transactional
    public List<Usuario> listar(){
        return (List<Usuario>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> porId(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Usuario guardar(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public void eliminar(Long id) {

    }

    @Transactional
    @Override
    public void elimninar(Long id){
        repository.deleteById(id);
    }

}
