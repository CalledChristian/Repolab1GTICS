package pe.edu.pucp.gtics.lab1221.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.pucp.gtics.lab1221.entity.Distributors;

//Recordar que los repositorios ahora son como los DAOS.

public interface DistributorsRepository extends JpaRepository<Distributors,Integer> {


}
