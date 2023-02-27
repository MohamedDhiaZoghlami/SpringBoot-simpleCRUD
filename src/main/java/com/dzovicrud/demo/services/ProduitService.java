package com.dzovicrud.demo.services;

import java.util.List;

import com.dzovicrud.demo.model.Produit;

public interface ProduitService {
    Produit createProduct(Produit produit);

    List<Produit> getProducts();

    Produit updateProduct(Long id, Produit produit);

    String deleteProduct(Long id);

}
