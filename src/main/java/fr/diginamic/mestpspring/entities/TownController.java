package fr.diginamic.mestpspring.entities;


import fr.diginamic.mestpspring.services.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/towns")
public class TownController {

    @Autowired
    private TownService townService;

    @GetMapping
    public List<Town> getTowns() {
        return townService.extractTowns();
    }

    @GetMapping("/{id}")
    public Town getTownById(@PathVariable int id) {
        return townService.extractTown(id);
    }

    @GetMapping("/search")
    public Town getTownByName(@RequestParam String name) {
        return townService.extractTown(name);
    }

    @PostMapping
    public List<Town> addTown(@RequestBody Town town) {
        return townService.insertTown(town);
    }

    @PutMapping("/{id}")
    public List<Town> updateTown(@PathVariable int id, @RequestBody Town town) {
        return townService.modifyTown(id, town);
    }

    @DeleteMapping("/{id}")
    public List<Town> deleteTown(@PathVariable int id) {
        return townService.deleteTown(id);
    }
}
