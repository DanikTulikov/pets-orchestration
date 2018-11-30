package com.tulikov.homeautomation.petsorchestartion.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tulikov.homeautomation.petsorchestartion.model.Sprinkler;
import com.tulikov.homeautomation.petsorchestartion.service.SprinklerService;

@RestController
@RequestMapping("/sprinklers")
public class SprinklerController {

  private SprinklerService sprinklerService;

  @Autowired
  public SprinklerController(SprinklerService sprinklerService) {
    this.sprinklerService = sprinklerService;
  }

  @PostMapping
  public void save(@RequestBody Sprinkler sprinkler) {
    sprinklerService.add(sprinkler);
  }

  @GetMapping("/{id}")
  public Sprinkler get(@PathVariable Long id) {
    return sprinklerService.get(id);
  }

  @PutMapping("/{id}")
  public void update(@PathVariable Long id, @RequestBody Sprinkler sprinkler) {
    sprinklerService.update(id, sprinkler);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    sprinklerService.delete(id);
  }

  @GetMapping
  public List<Sprinkler> getAll() {
    return sprinklerService.getAll();
  }
}
