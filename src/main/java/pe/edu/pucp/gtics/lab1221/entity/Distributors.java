package pe.edu.pucp.gtics.lab1221.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="distribuidoras")
public class Distributors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //el name aqui es el nombre del atributo en la BD
    @Column(name="iddistribuidora",nullable = false)
    private Integer idDistribuidora;

    @Column(name="nombre",length = 50)
    private String nombre;

    @Column(name="descripcion",length = 200)
    private String descripcion;

    @Column(name="fundacion",nullable = false)
    private int fundacion;

    @Column(name="sede",length = 45)
    private String sede;

}
