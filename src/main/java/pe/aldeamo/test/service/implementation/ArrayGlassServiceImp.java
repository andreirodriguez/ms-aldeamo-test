package pe.aldeamo.test.service.implementation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.aldeamo.test.application.domain.ArrayGlass;
import pe.aldeamo.test.application.domain.ArrayGlassLog;
import pe.aldeamo.test.repository.interfaces.ArrayGlassRepository;
import pe.aldeamo.test.service.interfaces.ArrayGlassService;

@Service
public class ArrayGlassServiceImp implements ArrayGlassService {

	@Autowired
	private ArrayGlassRepository arrayGlassRepository;	
	
	@Override
	public ArrayGlass getSelect(int id) {
		Map<String, Object> parameters = new HashMap<String, Object>();

		parameters.put("id",id);

		return arrayGlassRepository.getSearch(parameters);
	}

	@Override
	public ArrayGlassLog setProcess(ArrayGlassLog process) {
		ArrayGlass array = this.getSelect(process.getArrayId());
		
		if(array==null) return null;
		
		return process;
	}

}
