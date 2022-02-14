package pe.aldeamo.test.application.domain;

import java.util.ArrayList;
import java.util.List;

public class ArrayGlassLog {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	private int arrayId;
	public int getArrayId() {
		return arrayId;
	}
	public void setArrayId(int arrayId) {
		this.arrayId = arrayId;
	}

	private int iterations;
	public int getIterations() {
		return iterations;
	}
	public void setIterations(int iterations) {
		this.iterations = iterations;
	}	
	
	private int q;	
	public int getQ() {
		return q;
	}
	public void setQ(int q) {
		this.q = q;
	}

	private List<int[]> arrayA = new ArrayList<int[]>();
	public List<int[]> getArrayA() {
		return arrayA;
	}
	public void setArrayA(List<int[]> arrayA) {
		this.arrayA = arrayA;
	}
	
	private List<Integer> arrayB = new ArrayList<Integer>();
	public List<Integer> getArrayB() {
		return arrayB;
	}
	public void setArrayB(List<Integer> arrayB) {
		this.arrayB = arrayB;
	}
	
	private List<Integer> arrayAnswer = new ArrayList<Integer>();
	public List<Integer> getArrayAnswer() {
		return arrayAnswer;
	}
	public void setArrayAnswer(List<Integer> arrayAnswer) {
		this.arrayAnswer = arrayAnswer;
	}
}
