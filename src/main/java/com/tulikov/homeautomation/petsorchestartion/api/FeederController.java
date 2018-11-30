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

import com.tulikov.homeautomation.petsorchestartion.model.Feeder;
import com.tulikov.homeautomation.petsorchestartion.service.FeederService;

@RestController
@RequestMapping("/feeders")
public class FeederController {

  private FeederService feederService;

  @Autowired
  public FeederController(FeederService feederService) {
    this.feederService = feederService;
  }

  @PostMapping
  public void add(@RequestBody Feeder feeder) {
    feederService.add(feeder);
  }

  @GetMapping("/{id}")
  public Feeder get(@PathVariable Long id) {
    return feederService.get(id);
  }

  @PutMapping("/{id}")
  public void update(@PathVariable Long id, @RequestBody Feeder feeder) {
    feederService.update(id, feeder);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    feederService.delete(id);
  }

  @GetMapping
  public List<Feeder> getAll() {
    return feederService.getAll();
  }

}
