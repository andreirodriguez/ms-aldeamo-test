package pe.aldeamo.test.repository.interfaces;

import java.util.Map;

import pe.aldeamo.test.application.domain.ArrayGlass;

public interface ArrayGlassRepository {
	ArrayGlass getSearch(Map<String,Object> parametersJson);
}
