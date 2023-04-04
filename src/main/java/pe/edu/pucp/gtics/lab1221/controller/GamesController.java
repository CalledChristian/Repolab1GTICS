package pe.edu.pucp.gtics.lab1221.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.edu.pucp.gtics.lab1221.entity.Games;
import pe.edu.pucp.gtics.lab1221.entity.Platforms;
import pe.edu.pucp.gtics.lab1221.repository.GamesRepository;
import pe.edu.pucp.gtics.lab1221.repository.PlatformsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class GamesController {

    final GamesRepository gamesRepository;

    public GamesController(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }

    final PlatformsRepository platformsRepository;

    public GamesController(PlatformsRepository platformsRepository) {
        this.platformsRepository = platformsRepository;
    }

    @GetMapping("/juegos/lista")
    public String listaJuegos(Model model){
        List<Games> lista = gamesRepository.findAll();
        model.addAttribute("listaDeJuegos",lista);
        return "juegos/lista";
    }

    @GetMapping("/juegos/editar")

    public String editarJuegos(Model model, @RequestParam("id") int id){

        Optional<Games> optGame = gamesRepository.findById(id);

        if(optGame.isPresent()) {
            Games game = optGame.get();
            List<Platforms> listaPlat = platformsRepository.findAll();
            model.addAttribute("juego", game);
            return "juegos/editar";
        }else{
            return "redirect:/juegos/lista";
            }
        }

    @GetMapping("/juegos/guardar")
    public String guardarJuegos(Games game){
        gamesRepository.save(game);
        return "redirect:/juegos/lista";

    }

}
