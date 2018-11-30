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

import com.tulikov.homeautomation.petsorchestartion.model.Illuminator;
import com.tulikov.homeautomation.petsorchestartion.service.IlluminatorService;

@RestController
@RequestMapping("/illuminators")
public class IlluminatorController {

  private IlluminatorService illuminatorService;

  @Autowired
  public IlluminatorController(IlluminatorService illuminatorService) {
    this.illuminatorService = illuminatorService;
  }

  @PostMapping
  public void save(@RequestBody Illuminator illuminator) {
    illuminatorService.add(illuminator);
  }

  @GetMapping("/{id}")
  public Illuminator get(@PathVariable Long id) {
    return illuminatorService.get(id);
  }

  @PutMapping("/{id}")
  public void update(@PathVariable Long id, @RequestBody Illuminator illuminator) {
    illuminatorService.update(id, illuminator);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    illuminatorService.delete(id);
  }

  @GetMapping
  public List<Illuminator> getAll() {
    return illuminatorService.getAll();
  }
}
