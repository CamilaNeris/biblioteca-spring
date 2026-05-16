package com.camila.biblioteca.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private String isbn;
    private Integer ano;
}
