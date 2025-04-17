package com.annapurna.pojos;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="t_tiffin_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TiffinDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tiffin_id")
	private int tiffinId;
	
	@Column(name="tiffin_name")
	private String tiffinName;
	
	@Lob
	@Column(name="tiffin_image")
	private String tiffinImage;
	
	@Column(name="tiffin_price")
	private int tiffinPrice;
	
	@Column(name="description")
	private String description;
	
	public TiffinDetails(int tiffinId) {
		this.tiffinId=tiffinId;
	}

}
