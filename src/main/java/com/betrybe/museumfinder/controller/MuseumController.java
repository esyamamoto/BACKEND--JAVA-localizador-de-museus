package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.dto.MuseumCreationDto;
import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.util.ModelDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Museum CONtroller.
 */

@RestController
@RequestMapping("/museums")
public class MuseumController {
  @Autowired
  private final MuseumServiceInterface museumService;

  public MuseumController(MuseumServiceInterface museumService) {
    this.museumService = museumService;
  }

  /**
   * novo museu.
   */
  @PostMapping
  public ResponseEntity<MuseumDto> createMuseum(@RequestBody MuseumCreationDto newMuseum) {
    Museum museum = ModelDtoConverter.dtoToModel(newMuseum); // dto --> objeto do museum
    Museum createMuseum = museumService.createMuseum(museum); // chama o service para criar museum
    MuseumDto createMuseumDto = ModelDtoConverter.modelToDto(createMuseum);  // museum pra dto
    return ResponseEntity.status(HttpStatus.CREATED).body(createMuseumDto);
  }

  /**
   * acha museu.
   */
  @GetMapping("/closest")
  public ResponseEntity<MuseumDto> findClosestMuseum(
      @RequestParam("lat") Double latitude,
      @RequestParam("lng") Double longitude,
      @RequestParam("max_dist_km") Double maxDistente) {

    Coordinate coordinate = new Coordinate(latitude, longitude);
    Museum closest = museumService.getClosestMuseum(coordinate, maxDistente);
    MuseumDto museumDto = ModelDtoConverter.modelToDto(closest); // museum pra dto
    return ResponseEntity.ok(museumDto);
  }
}