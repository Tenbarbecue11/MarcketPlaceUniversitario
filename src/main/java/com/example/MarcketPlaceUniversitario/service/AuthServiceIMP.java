package com.example.MarcketPlaceUniversitario.service;

import com.example.MarcketPlaceUniversitario.DTO.RegisterRequestDTO;
import com.example.MarcketPlaceUniversitario.DTO.UsuarioResponseDTO;
import com.example.MarcketPlaceUniversitario.model.Usuario;
import com.example.MarcketPlaceUniversitario.model.VerificationCode;
import com.example.MarcketPlaceUniversitario.repository.UsuarioRepository;
import com.example.MarcketPlaceUniversitario.repository.VerificationCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthServiceIMP implements AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private VerificationCodeRepository verificationCodeRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UsuarioResponseDTO register(RegisterRequestDTO dto) {

        String correo = dto.getCorreo().toLowerCase();

        //validar Dominio Institucional
        if (!correo.endsWith("@ucundinamarca.edu.co")) {
            throw new RuntimeException("Correo Inválido");
        }
        //validar Repetido
        if (usuarioRepository.existsByCorreo(correo)) {
            throw new RuntimeException("El Correo ya existe");
        }
        //buscar código
        Optional<VerificationCode> optionalCode =
                verificationCodeRepository
                        .findByCorreoAndCodigo(
                                correo,
                                dto.getCodigo());

        if (optionalCode.isEmpty()) {
            throw new RuntimeException("Código incorreto");
        }

        VerificationCode verificationCode = optionalCode.get();

        //validar expiración
        if (verificationCode
                .getFechaExpiracion()
                .isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Codigo Expirado");
        }

        //validar usado
        if (verificationCode.getUsado()) {
            throw new RuntimeException("El Codigo ya fue Usado");
        }

        //crear Usuario
        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setCorreo(correo);

        //Bycript
        usuario.setPassword(passwordEncoder.encode(dto.getPassword()));

        usuario.setRol("Usuario");

        usuario.setEstado(true);

        usuario.setFechaRegistro(LocalDate.now());

        Usuario guardado = usuarioRepository.save(usuario);

        //marcarcodigo usado
        verificationCode.setUsado(true);
        verificationCodeRepository.save(verificationCode);

        return new UsuarioResponseDTO(
                guardado.getId(),
                guardado.getNombre(),
                guardado.getCorreo(),
                guardado.getRol(),
                guardado.getEstado()
        );
    }
}
