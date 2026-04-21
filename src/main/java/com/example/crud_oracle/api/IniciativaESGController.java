package com.example.crud_oracle.api;

import com.example.crud_oracle.domain.IniciativaESG;
import com.example.crud_oracle.service.IniciativaESGService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/iniciativas")
public class IniciativaESGController {

    private final IniciativaESGService service;

    public IniciativaESGController(IniciativaESGService service) {
        this.service = service;
    }

    // Test
    @GetMapping("/ping")
    public String ping() {
        return "ok";
    }

    // 1) GET /api/iniciativas
    @GetMapping
    public List<IniciativaESG> listar() {
        return service.listar();
    }

    // 2) GET /api/iniciativas/{id}
    @GetMapping("/{id}")
    public IniciativaESG buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // 3) POST /api/iniciativas
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IniciativaESG criar(@RequestBody @Valid IniciativaESG iniciativa) {
        return service.criar(iniciativa);
    }

    // 4) PUT /api/iniciativas/{id}
    @PutMapping("/{id}")
    public IniciativaESG atualizar(@PathVariable Long id,
                                   @RequestBody @Valid IniciativaESG iniciativa) {
        return service.atualizar(id, iniciativa);
    }

    // 5) DELETE /api/iniciativas/{id}
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
