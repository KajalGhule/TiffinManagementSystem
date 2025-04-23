package com.app.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.TiffinDetailDao;
import com.app.dtos.DtoEntityConverter;
import com.app.dtos.TiffinDetailDto;
import com.app.pojos.TiffinDetails;

@Service
@Transactional
public class TiffinDetailsService {

	@Autowired
	private TiffinDetailDao tiffindetaildao; 
	 
	@Autowired
	private DtoEntityConverter converter;
	
	public List<TiffinDetailDto> getAllTiffinDetails(){
		
		List<TiffinDetails> tiffinDetails=tiffindetaildao.findAll();
		System.out.println(tiffinDetails);
		
		List<TiffinDetailDto> tiffindetaildto=new ArrayList<>();
		
		for(TiffinDetails t:tiffinDetails) {
			tiffindetaildto.add(converter.TiffinDetailstoTiffinDetailDto(t));
		}
		return tiffindetaildto;
	}

//	public TiffinDetailDto getTiffinDetailsById(int id) {
//		TiffinDetailDto tiffinDetail= tiffindetaildao.findById(id);
//		return tiffinDetail;
//	}	
	
	
	public TiffinDetails saveTiffinDetails(TiffinDetails details) {
		
		return tiffindetaildao.save(details);
	}

	public int deleteTiffinById(int id) {
		// TODO Auto-generated method stub
		if(tiffindetaildao.existsById(id)) {
			tiffindetaildao.deleteById(id);
			return 1;
		}
		return 0;
	}
	
	public TiffinDetails getTiffinDetailsById(int id) {
	
		if(tiffindetaildao.existsById(id)) {
			return tiffindetaildao.findByTiffinId(id);
			
		}
		return null;
	}
	
	
	public TiffinDetails updateTiffinDetails(int id,TiffinDetailDto tiffindetailsdto) {
		
		 TiffinDetails tiffin=tiffindetaildao.findById(id).orElse(null);
		 
		 tiffin.setTiffinName(tiffindetailsdto.getTiffinName());
		 tiffin.setTiffinPrice(tiffindetailsdto.getTiffinPrice());
		 tiffin.setDescription(tiffindetailsdto.getDescription());
		 
		 
		
		return tiffindetaildao.save(tiffin);
	}
}
