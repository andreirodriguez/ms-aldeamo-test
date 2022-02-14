package pe.aldeamo.test.application.mapper;

import pe.aldeamo.test.api.request.ArrayGlassRequest;
import pe.aldeamo.test.api.response.ArrayGlassResponse;
import pe.aldeamo.test.application.domain.ArrayGlassLog;

public class ArrayGlassMapper {
	public static ArrayGlassLog FromArrayGlassRequest(ArrayGlassRequest i) {
		ArrayGlassLog o = new ArrayGlassLog();

		o.setArrayId(i.getId());
		o.setIterations(i.getQ());

		return o;
	}
	
	public static ArrayGlassResponse ToArrayGlassResponse(ArrayGlassLog i) {
		ArrayGlassResponse o = new ArrayGlassResponse();

		o.setId(i.getArrayId());
		
		String answer = "";
		
		if(i.getArrayAnswer().size()>0)
		{
			for(int r:i.getArrayAnswer())
				answer += "," + r;
			
			o.setAnswer(answer.substring(1));
		}

		return o;
	}	
}
