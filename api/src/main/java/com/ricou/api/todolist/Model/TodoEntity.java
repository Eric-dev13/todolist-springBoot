package com.ricou.api.todolist.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

// @Data OU @Getter et @Setter // Annotation Lombok : génére les getters et setters
@Data
@Entity
@Table(name = "todo") // Nom de la table associée dans la BDD
public class TodoEntity {
    // identifiant auto-incrémenté
    @Id
    // Défini la stratégie de génération de la clé lors d'une insertion en base de données.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nom des colonnes
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    // Nom des colonnes
    @Column(name = "updated_at", nullable = true)
    private LocalDateTime updatedAt;

    // Nom des colonnes
    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Column(name="content", length = 255, nullable = true)
    private String content;

    /*
    @ManyToOne
    @JoinColumn(name ="user_id", nullable = false)
    private UserEntity user;
    */

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

}
