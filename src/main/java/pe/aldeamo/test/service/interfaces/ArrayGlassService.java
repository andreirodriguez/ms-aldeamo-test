package pe.aldeamo.test.service.interfaces;

import pe.aldeamo.test.application.domain.ArrayGlass;
import pe.aldeamo.test.application.domain.ArrayGlassLog;

public interface ArrayGlassService {
	ArrayGlass getSelect(int id);
	
	ArrayGlassLog setProcess(ArrayGlassLog process);
}
