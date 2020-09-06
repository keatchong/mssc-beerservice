package guru.springframework.msscbeerservice.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import guru.springframework.msscbeerservice.web.model.BeerStylenum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Beer {

	@Id
	@GeneratedValue(generator =  "UUID")
	@GenericGenerator(name="UUID",strategy="org.hibernate.UUIDGenerator")
	@Column(length = 36, columnDefinition="varchar", updatable = false, nullable = false)
	private UUID id;

	@Version
	private Integer version;

	@CreationTimestamp
	@Column(updatable = false)
	private Timestamp createDate;
	
	@UpdateTimestamp
	private Timestamp lastModifiedDate;
	
	private String beerName;
	
	private BeerStylenum beerStyle;
	
	@Column(unique = true)
	private Long upc;
	
	private BigDecimal price;
	
	private Integer minOnHand;
	
	
	private Integer quantityToBrew;
	
}	
