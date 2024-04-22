package com.desafioitau.api.transferencia.controller;

import com.desafioitau.api.transferencia.dto.TransferenciaRequestDTO;
import com.desafioitau.api.transferencia.dto.TransferenciaResponseDTO;
import com.desafioitau.api.transferencia.mappers.TransferenciaMapper;
import com.desafioitau.api.transferencia.service.TransferenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class TransferenciaController {

    public TransferenciaService transferenciaService;

    @PostMapping("/transferencia")
    public ResponseEntity<TransferenciaResponseDTO> efetuarTransferencia(@RequestBody TransferenciaRequestDTO transferenciaRequestDTO)
    {
        transferenciaService.executarTransferencia(TransferenciaMapper.transferenciaRequestDTOtoTransferencia(transferenciaRequestDTO));

        // retornar o idTransferencia
        UUID uuid = UUID.randomUUID();
        TransferenciaResponseDTO transferenciaResponseDTO = new TransferenciaResponseDTO();
        transferenciaResponseDTO.setIdTransferencia(uuid);
        return ResponseEntity.ok().body(transferenciaResponseDTO);
    }
}
