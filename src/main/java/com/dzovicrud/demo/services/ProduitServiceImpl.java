package com.dzovicrud.demo.services;

import com.dzovicrud.demo.model.Produit;
import com.dzovicrud.demo.repository.ProduitRepository;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProduitServiceImpl implements ProduitService {

    private final ProduitRepository produitRepository;

    @Override
    public Produit createProduct(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public List<Produit> getProducts() {
        return produitRepository.findAll();
    };

    @Override
    public Produit updateProduct(Long id, Produit produit) {
        return produitRepository.findById(id).map(p -> {
            p.setPrix(produit.getPrix());
            p.setDescription(produit.getDescription());
            p.setNom(produit.getNom());
            return produitRepository.save(p);
        }).orElseThrow(() -> new RuntimeException("Product Not Found"));
    };

    @Override
    public String deleteProduct(Long id) {
        produitRepository.deleteById(id);
        return "Product deleted!!!";
    };
}
