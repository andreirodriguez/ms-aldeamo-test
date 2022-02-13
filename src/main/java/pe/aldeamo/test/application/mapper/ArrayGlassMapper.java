package pe.aldeamo.test.application.mapper;

import pe.aldeamo.test.api.request.ArrayGlassRequest;
import pe.aldeamo.test.application.domain.ArrayGlassLog;

public class ArrayGlassMapper {
	public static ArrayGlassLog FromArrayGlassRequest(ArrayGlassRequest i) {
		ArrayGlassLog o = new ArrayGlassLog();

		o.setArrayId(i.getId());
		o.setIterations(i.getQ());

		return o;
	}
}
