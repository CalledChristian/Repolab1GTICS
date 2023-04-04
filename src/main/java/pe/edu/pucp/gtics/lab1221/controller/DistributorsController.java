package pe.edu.pucp.gtics.lab1221.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.edu.pucp.gtics.lab1221.entity.Distributors;
import pe.edu.pucp.gtics.lab1221.repository.DistributorsRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class DistributorsController {

    final DistributorsRepository distributorsRepository;

    public DistributorsController(DistributorsRepository distributorsRepository){
        this.distributorsRepository= distributorsRepository;
    }

    @GetMapping("/distribuidoras/lista")
    public String listaDistribuidoras (Model model){
        List<Distributors> lista = distributorsRepository.findAll();
        model.addAttribute("listaDistribuidores",lista);
        return "distribuidoras/lista";
    }

    @GetMapping("/distribuidoras/editar")
    public String editarDistribuidoras(Model model, @RequestParam("id") int id){
        Optional<Distributors> optDistributor = distributorsRepository.findById(id);

        if (optDistributor.isPresent()) {
            Distributors distributor = optDistributor.get();
            model.addAttribute("distribuidor", distributor);
            return "distribuidoras/editar";
        } else {
            return "distribuidoras/lista";
        }

    }

    @GetMapping("/distribuidoras/nuevo")
    public String nuevaDistribuidora(){
        return "distribuidoras/nuevo";
    }

    @PostMapping("/distribuidoras/guardar")
    public String guardarDistribuidora(Distributors distributors){
        distributorsRepository.save(distributors);
        return "redirect:/distribuidoras/lista";
    };

    public String borrarDistribuidora(){
        return "";
    };

}
