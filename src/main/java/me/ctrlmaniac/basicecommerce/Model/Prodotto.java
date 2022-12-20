package me.ctrlmaniac.basicecommerce.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Prodotto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private String Name;

    @Column(unique=true)
    private String Slug;

    @Column
    private String Description;

    @Column
    private Double Prezzo;

    @OneToMany
    private Categoria categoria;

    public Prodotto() {
    }

    public Prodotto(String name, String slug, String description, Double prezzo, Categoria categoria) {
        Name = name;
        Slug = slug;
        Description = description;
        Prezzo = prezzo;
        this.categoria = categoria;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSlug() {
        return Slug;
    }

    public void setSlug(String slug) {
        Slug = slug;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Double getPrezzo() {
        return Prezzo;
    }

    public void setPrezzo(Double prezzo) {
        Prezzo = prezzo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    
}
