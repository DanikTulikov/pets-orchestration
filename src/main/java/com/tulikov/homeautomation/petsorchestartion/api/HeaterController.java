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

import com.tulikov.homeautomation.petsorchestartion.model.Heater;
import com.tulikov.homeautomation.petsorchestartion.service.HeaterService;

@RestController
@RequestMapping("/heaters")
public class HeaterController {

  private HeaterService heaterService;

  @Autowired
  public HeaterController(HeaterService heaterService) {
    this.heaterService = heaterService;
  }

  @PostMapping
  public void save(@RequestBody Heater heater) {
    heaterService.add(heater);
  }

  @GetMapping("/{id}")
  public Heater get(@PathVariable Long id) {
    return heaterService.get(id);
  }

  @PutMapping("/{id}")
  public void update(@PathVariable Long id, @RequestBody Heater heater) {
    heaterService.update(id, heater);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    heaterService.delete(id);
  }

  @GetMapping
  public List<Heater> getAll() {
    return heaterService.getAll();
  }
}
