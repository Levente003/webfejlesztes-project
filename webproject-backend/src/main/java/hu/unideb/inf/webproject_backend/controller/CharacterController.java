package hu.unideb.inf.webproject_backend.controller;

import hu.unideb.inf.webproject_backend.service.CharacterService;
import hu.unideb.inf.webproject_backend.service.dto.CharacterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/character")
public class CharacterController {
    @Autowired
    private CharacterService service;

    @GetMapping("/allCharacters")
    public List<CharacterDto> getAllCharacters() {
        return service.findAll();
    }

    @DeleteMapping("/delete")
    public void deleteCharacter(@RequestParam long id) {
        service.delete(id);
    }

    @PutMapping("/edit")
    public CharacterDto editCharacter(@RequestBody CharacterDto dto) {
        return service.update(dto);
    }

    @PostMapping("/add")
    public CharacterDto addCharacter(@RequestBody CharacterDto dto) {
        return service.addCharacter(dto);
    }
}
