package guru.springframework.msscbeerservice.services;

import java.util.UUID;



import guru.springframework.msscbeerservice.web.model.BeerDto;

public interface BeerService {

	public BeerDto getById(UUID beerId);
	
	public BeerDto saveNewBeer(BeerDto beerDto);

	public BeerDto updateBeerById(UUID beerId, BeerDto beerDto);

}
