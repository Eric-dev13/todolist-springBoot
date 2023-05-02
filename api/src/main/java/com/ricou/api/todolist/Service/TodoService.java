package com.ricou.api.todolist.Service;

import com.ricou.api.todolist.Model.TodoEntity;
import com.ricou.api.todolist.repository.TodoEntityJpaRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

// Grâce à l'annotation @RequiredArgsConstructor Lombok va génèrer un constructeur pour les champs final et NonNull.
@RequiredArgsConstructor
@Data
@Service
//@RequiredArgsConstructor
public class TodoService {

    // Spring Data JPA permet la recupération, l'ajout, la modification, la suppression des données via l'interface CrudRepository

    // Lombok va génèrer un constructeur avec un paramètre pour chaque constante (final)
    private final TodoEntityJpaRepository todoEntityJpaRepository;

    // Renvoie toutes les instances du type.
    public Iterable<TodoEntity> getAll() {
        return todoEntityJpaRepository.findAll();
    }

    // Récupère une entité par son identifiant
    public Optional<TodoEntity> getById(Long id){
        return todoEntityJpaRepository.findById(id);
    }

    /*
    L'ajout et la modification d’un objet sont gérées par les mêmes méthodes save(S entity) et saveAll(Iterable<S> entities).
    Le framework va inspecter le contenu de l’objet que nous lui fournissons,
        et pourra identifier s’il est déjà existant en base ou non, grâce à son identifiant unique (la clé primaire).
        Retourne l'entité enregistrée ; ne sera jamais nul.
    */
    public TodoEntity add(@RequestBody TodoEntity todolistEntity){
        /*
         Pour ajouter une nouvelle taches, les informations sont transmisent au format JSON via le corps de la requête HTTP.
         Ensuite les données doivent être déserialisées (changer le type Json vers le type object de java) avec un mapper via un objet DTO (Data Transfert Object)
        */
        return todoEntityJpaRepository.save(todolistEntity);
    }

    public TodoEntity edit(@RequestBody TodoEntity todolistEntity){
        return todoEntityJpaRepository.save(todolistEntity);
    }

    public void delete(Long id) {
        todoEntityJpaRepository.deleteById(id);
    }
}
