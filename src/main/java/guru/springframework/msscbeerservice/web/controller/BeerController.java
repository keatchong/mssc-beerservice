package guru.springframework.msscbeerservice.web.controller;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.msscbeerservice.services.BeerService;
import guru.springframework.msscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;

@RequestMapping("/api/v1/beer")
@RestController
@RequiredArgsConstructor
public class BeerController {
	
	private final BeerService beerService;

	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDto> getBeerbyId(@PathVariable("beerId") UUID beerId) {
		/*return new ResponseEntity<>(BeerDto.builder().beerName("BeerName")
				.id(UUID.randomUUID())
				.createdDate(OffsetDateTime.now())
				.lastModifiedDate(OffsetDateTime.now())
				.price(new BigDecimal("12.99"))
				.upc(12312121222L)
				.build(),HttpStatus.OK);*/
		
		return new ResponseEntity<>(beerService.getById(beerId),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity saveNewBeer(@RequestBody @Validated BeerDto beerDto) {
		
		return new ResponseEntity<>(beerService.saveNewBeer(beerDto),HttpStatus.CREATED);
	}	
	
	@PutMapping("/{beerId}")
	public ResponseEntity updateBeerById(@PathVariable("beerId") UUID beerId,@RequestBody @Validated BeerDto beerDto) {
		return new ResponseEntity<>(beerService.updateBeerById(beerId,beerDto),HttpStatus.NO_CONTENT);
	}

}
