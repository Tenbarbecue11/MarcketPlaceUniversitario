package com.example.MarcketPlaceUniversitario.service;

import com.example.MarcketPlaceUniversitario.DTO.DtoPrincipales.PurchaseRequestDTO;
import com.example.MarcketPlaceUniversitario.DTO.DtoPrincipales.PurchaseResponseDTO;
import com.example.MarcketPlaceUniversitario.model.Posts;
import com.example.MarcketPlaceUniversitario.model.PurchaseRequest;
import com.example.MarcketPlaceUniversitario.model.Usuario;
import com.example.MarcketPlaceUniversitario.repository.PostRepository;
import com.example.MarcketPlaceUniversitario.repository.PurchaseRequestRepository;
import com.example.MarcketPlaceUniversitario.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseRequestServiceIMP implements PurchaseRequestService {

    private final PurchaseRequestRepository purchaseRequestRepository;
    private final UsuarioRepository usuarioRepository;
    private final PostRepository postRepository;

    public PurchaseRequestServiceIMP(PurchaseRequestRepository purchaseRequestRepository,
                                     UsuarioRepository usuarioRepository,
                                     PostRepository postRepository) {
        this.purchaseRequestRepository = purchaseRequestRepository;
        this.usuarioRepository = usuarioRepository;
        this.postRepository = postRepository;
    }

    @Override
    public PurchaseResponseDTO save(PurchaseRequestDTO dto) {
        Posts post = postRepository.findById(dto.getPostId())
                .orElseThrow(() -> new RuntimeException("Post no encontrado"));
        Usuario buyer = usuarioRepository.findById(dto.getBuyerId())
                .orElseThrow(() -> new RuntimeException("Comprador no encontrado"));
        Usuario seller = usuarioRepository.findById(dto.getSellerId())
                .orElseThrow(() -> new RuntimeException("Vendedor no encontrado"));

        PurchaseRequest pr = new PurchaseRequest();
        pr.setPosts(post);
        pr.setBuyer(buyer);
        pr.setSeller(seller);
        pr.setEstado(dto.getEstado() != null ? dto.getEstado() : "pendiente");
        pr.setFecha(LocalDate.now());

        return toDTO(purchaseRequestRepository.save(pr));
    }

    @Override
    public PurchaseResponseDTO findById(long id) {
        return toDTO(purchaseRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada")));
    }

    @Override
    public List<PurchaseResponseDTO> findAllPurchaseRequests() {
        return purchaseRequestRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public PurchaseResponseDTO update(PurchaseRequestDTO dto, long id) {
        PurchaseRequest existente = purchaseRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
        if (dto.getEstado() != null) existente.setEstado(dto.getEstado());
        return toDTO(purchaseRequestRepository.save(existente));
    }

    @Override
    public void delete(long id) {
        purchaseRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
        purchaseRequestRepository.deleteById(id);
    }

    private PurchaseResponseDTO toDTO(PurchaseRequest pr) {
        return new PurchaseResponseDTO(
                pr.getId(), pr.getEstado(), pr.getFecha(),
                pr.getPosts() != null ? pr.getPosts().getId() : null,
                pr.getPosts() != null ? pr.getPosts().getTitulo() : null,
                pr.getBuyer() != null ? pr.getBuyer().getId() : null,
                pr.getBuyer() != null ? pr.getBuyer().getNombre() : null,
                pr.getSeller() != null ? pr.getSeller().getId() : null,
                pr.getSeller() != null ? pr.getSeller().getNombre() : null
        );
    }
}