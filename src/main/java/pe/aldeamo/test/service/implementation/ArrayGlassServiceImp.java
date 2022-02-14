package pe.aldeamo.test.service.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.aldeamo.test.application.domain.ArrayGlass;
import pe.aldeamo.test.application.domain.ArrayGlassLog;
import pe.aldeamo.test.cross.utils.ConvertFormat;
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
				
		//init Array Zero
		process.getArrayA().add(this.getConvertSplit(array.getInputArray()));
	
		this.setChooseGlass(process);
		
		return process;
	}
	private void setChooseGlass(ArrayGlassLog process)
	{
		//init prime numbers		
		int[] arrayP = this.getPrimeNumbers(process.getIterations());
		
		String nextArrayA = null;
		int numberA;
		int[] arrayA;
		int numberPrime;
		for(int q=0;q<process.getIterations();q++){//Iterations
			process.setQ(q+1);
			arrayA = process.getArrayA().get(q);
			nextArrayA = "";
			process.getArrayB().clear();
			numberPrime = arrayP[q];
			
			for(int j=arrayA.length-1;j>=0;j--){//Iterations Array A
				numberA = arrayA[j];
				
				if(numberA % numberPrime == 0)
					process.getArrayB().add(numberA);
				else
					nextArrayA += "," + numberA;
			}

			process.getArrayAnswer().addAll(process.getArrayB());				
			
			if(nextArrayA=="") break;
			
			process.getArrayA().add(this.getConvertSplit(nextArrayA.substring(1)));
		}
		
		if(nextArrayA!="")
		{
			arrayA = this.getConvertSplit(nextArrayA.substring(1));
			
			for(int i:arrayA)
				process.getArrayAnswer().add(i);
		}
		
		System.out.println(ConvertFormat.ObjectToJson(process));		
	}
	
	private int[] getConvertSplit(String inputArray)
	{
		if(ConvertFormat.IsNullOrEmpty(inputArray)) return new int[0];
		
		String[] array = inputArray.split(Pattern.quote(",")); 
		
		//init array zero
		int[] zero = new int[array.length];
		int count = 0;
		for(String i: array)
		{
			zero[count] = Integer.parseInt(i);
			count++;
		}
		
		return zero;
	}
	
	
	private int[] getPrimeNumbers(int n) {
	    int v[] = new int[n];
	    int posicion=0;

	    int divisibles;
	    for(int i=0;posicion<n;i++){
	        divisibles=0;
	        for(int j=1;j<=i;j++){ 
	            if(i%j==0){
	                divisibles++;
	            }
	        }
	        if(divisibles==2){
	            v[posicion]=i; 
	            posicion++; 
	        }
	    }

		return v;
	}
}
