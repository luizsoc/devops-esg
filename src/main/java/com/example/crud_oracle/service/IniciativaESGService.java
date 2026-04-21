package com.example.crud_oracle.service;

import com.example.crud_oracle.domain.IniciativaESG;
import com.example.crud_oracle.repository.IniciativaESGRepository;
import com.example.crud_oracle.validation.IniciativaValidator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class IniciativaESGService {

    private final IniciativaESGRepository repository;
    private final IniciativaValidator validator;

    public IniciativaESGService(IniciativaESGRepository repository, IniciativaValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    public List<IniciativaESG> listar() {
        return repository.findAll();
    }

    public IniciativaESG buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Iniciativa não encontrada"));
    }

    public IniciativaESG criar(IniciativaESG iniciativa) {
        validator.validar(iniciativa);
        return repository.save(iniciativa);
    }

    public IniciativaESG atualizar(Long id, IniciativaESG dados) {
        IniciativaESG existente = buscarPorId(id);
        existente.setTitulo(dados.getTitulo());
        existente.setCategoria(dados.getCategoria());
        existente.setResponsavel(dados.getResponsavel());
        existente.setMetaReducaoCo2(dados.getMetaReducaoCo2());
        existente.setStatus(dados.getStatus());

        validator.validar(existente);

        return repository.save(existente);
    }

    public void excluir(Long id) {
        IniciativaESG existente = buscarPorId(id);
        repository.delete(existente);
    }
}
