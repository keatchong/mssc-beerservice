package guru.springframework.msscbeerservice.bootstrap;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.repositories.BeerRepository;
import guru.springframework.msscbeerservice.web.model.BeerStylenum;

@Component
public class BeerLoader implements CommandLineRunner {

	private final BeerRepository beerRepository;
	
	
	
	public BeerLoader(BeerRepository beerRepository) {

		this.beerRepository = beerRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		loadBeerObjects();
	}

	private void loadBeerObjects() {
		
		if ( beerRepository.count() == 0 ) {
			beerRepository.save(Beer.builder()
				.beerName("Mango Bobs")
				.beerStyle("IPA")
				.quantityToBrew(200)
				.minOnHand(12)
				.upc(33701000001L)
				.price(new BigDecimal("12.95"))
				.build()		
			);
		
		}
		
		System.out.println("Loaded Beers: " + beerRepository.count());
	}
}
