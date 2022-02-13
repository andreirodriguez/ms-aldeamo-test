package pe.aldeamo.test.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.aldeamo.test.api.request.ArrayGlassRequest;
import pe.aldeamo.test.api.response.ArrayGlassResponse;
import pe.aldeamo.test.application.domain.ArrayGlassLog;
import pe.aldeamo.test.application.mapper.ArrayGlassMapper;
import pe.aldeamo.test.service.interfaces.ArrayGlassService;

@RestController
@RequestMapping("/glasses")
public class ArrayGlassController {
	
	@Autowired
	private ArrayGlassService arrayGlassService;	
	
	@PostMapping()
	public ResponseEntity<ArrayGlassResponse> setProcess(@RequestBody ArrayGlassRequest r) {
		ArrayGlassLog i = ArrayGlassMapper.FromArrayGlassRequest(r);

		i = arrayGlassService.setProcess(i);
		
		if(i==null) return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);	

		return new ResponseEntity<ArrayGlassResponse>(new ArrayGlassResponse(),HttpStatus.OK);
	}
}
