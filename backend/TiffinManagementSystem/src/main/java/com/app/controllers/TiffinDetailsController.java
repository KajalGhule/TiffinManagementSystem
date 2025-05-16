package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.DtoEntityConverter;
import com.app.dtos.Response;
import com.app.dtos.TiffinDetailDto;
import com.app.dtos.TiffinFormDto;
import com.app.pojos.TiffinDetails;
import com.app.services.StorageService;
import com.app.services.TiffinDetailsService;

@CrossOrigin(origins="*")
@RestController
public class TiffinDetailsController {

	@Autowired
	private TiffinDetailsService tiffinservice;
	
	@Autowired
	private DtoEntityConverter converter;
	
	@Autowired
	private StorageService storageservice;
	
	public TiffinDetailsController() {
		// TODO Auto-generated constructor stub
		System.out.println("constructor of "+getClass());
	}

	@GetMapping("/tiffin/details")
	public ResponseEntity<?> getAllTiffinDetails(){
		System.out.println("inside the getalltiffindetails method");
		
		List<TiffinDetailDto> tiffindetailDto =tiffinservice.getAllTiffinDetails();
		
		return Response.success(tiffindetailDto);
	} 
	
//	@GetMapping("/tiffin/{id}")
//	public ResponseEntity<?> getTiffinDeatilById(){
//		TiffinDetailDto tiffinDetail= tiffinservice.getTiffinDetailsById();
//		return Response.success(tiffinDetail);
//	}
	
	
	@PostMapping("/tiffin/addTiffin")
	public ResponseEntity<?> addTiffin(TiffinFormDto tiffinformdto){
		
		
		TiffinDetails tiffin=converter.toTiffinDetails(tiffinformdto);
		String thumbnail=storageservice.store(tiffinformdto.getTiffinImage());
		tiffin.setTiffinImage(thumbnail);
		TiffinDetails persisttiffin=tiffinservice.saveTiffinDetails(tiffin);
		if(persisttiffin!=null) {
			return Response.success(tiffin);
		}
		return Response.error(tiffin);
	}
	
	
	@DeleteMapping("/tiffin/delete/{id}")
	public ResponseEntity<?> deleteTiffin(@PathVariable int id){
		TiffinDetails tiffin=tiffinservice.getTiffinDetailsById(id);
		
		storageservice.delete(tiffin.getTiffinImage());
		
		int count=tiffinservice.deleteTiffinById(id);	
		
		return Response.success(count);
	}
	
	@GetMapping("/tiffinDetail/{id}")
	public ResponseEntity<?> gettiffinDetailById(@PathVariable int id){
		
		return  Response.success(tiffinservice.getTiffinDetailsById(id));
	}
	
	@PutMapping("/tiffin/updateTiffin/{id}")
	public ResponseEntity<?> updateTiffin(@PathVariable int id,@RequestBody TiffinDetailDto tiffindto)
	{
		TiffinDetails tiffindetil=tiffinservice.updateTiffinDetails(id,tiffindto);
		return Response.success(tiffindetil);
	}
}
