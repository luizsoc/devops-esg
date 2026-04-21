package com.example.crud_oracle.validation;

import com.example.crud_oracle.domain.CategoriaESG;
import com.example.crud_oracle.domain.IniciativaESG;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class IniciativaValidator {

    public void validar(IniciativaESG iniciativa) {
        // Regra 1: título obrigatório (extra de segurança)
        if (iniciativa.getTitulo() == null || iniciativa.getTitulo().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Título é obrigatório.");
        }

        // Regra 2: se categoria for AMBIENTAL, meta de redução é obrigatória e > 0
        if (iniciativa.getCategoria() == CategoriaESG.AMBIENTAL) {
            if (iniciativa.getMetaReducaoCo2() == null) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Para iniciativas AMBIENTAIS, a meta de redução de CO2 é obrigatória."
                );
            }
            if (iniciativa.getMetaReducaoCo2().signum() <= 0) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "A meta de redução deve ser maior que zero."
                );
            }
        }

        // Regra 3: status não pode ser nulo
        if (iniciativa.getStatus() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Status é obrigatório."
            );
        }
    }
}
