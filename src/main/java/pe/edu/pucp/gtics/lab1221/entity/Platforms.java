package pe.edu.pucp.gtics.lab1221.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="plataformas")
public class Platforms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idplataforma",nullable = false)
    private Integer idPlataforma;

    @Column(name="nombre",length = 50)
    private String nombre;

    @Column(name="descripcion",length = 200)
    private String descripcion;
}
