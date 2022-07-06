package com.magadiflo.pagination.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

/**
 * @JsonInclude(JsonInclude.Include.NON_DEFAULT), anotada en el NIVEL DE PROPIEDAD, la situación cambia:
 * - Se excluyen todos los valores que se consideran "vacíos" (según NON_EMPTY)
 * - Se excluyen los valores predeterminados primitivos/contenedores (wrappers)
 * - Se excluyen los valores de fecha/hora que tienen milisegundos de '0L'
 * En este caso, esta propiedad lo tenemos anotada en el nivel de clase.
 */

@NoArgsConstructor //Se utiliza para generar el constructor sin argumentos para la clase anotada
@AllArgsConstructor //Genera un constructor con argumentos (todas las propiedades de la clase anotada)
@SuperBuilder //Establece en el constructor las propiedades de las clases padres que hereda
@Getter //Genera métodos getters para todas las propiedades no estáticas de la clase
@Setter //Genera métodos setters para todas las propiedades no estáticas de la clase
@JsonInclude(JsonInclude.Include.NON_DEFAULT)//Anotada en el NIVEL DE CLASE: Excluye propiedades con valores predeterminados. Ejm. El valor int predeterminado es 0, de string es null, etc. No se excluye por ejemplo Integer con 0, Date con 0 milisegundos, una colección vacía: List<String>
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String status;
    private String address;
    private String phone;
    private String imageUrl;

}
