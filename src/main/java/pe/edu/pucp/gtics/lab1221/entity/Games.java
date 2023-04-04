package pe.edu.pucp.gtics.lab1221.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="juegos")
public class Games {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //porque es autoincremental
    @Column(name="idjuego",nullable = false)
    private Integer idJuego;
    @Column(name="nombre",length = 50)
    private String nombre;
    @Column(name="descripcion",length = 200)
    private String descripcion;
    @Column(name="precio")
    private double precio;
    @Column(name="idgenero")
    private int idGenero;
    @Column(name="idplataforma")
    private int idPlataforma;
    @Column(name="ideditora")
    private int idEditora;
    @Column(name="iddistribuidora")
    private int idDistribuidora;
}
