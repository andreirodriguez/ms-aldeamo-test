package pe.aldeamo.test.api.request;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ArrayGlassRequest implements Serializable
{

	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	private int q;
	public int getQ() {
		return q;
	}
	public void setQ(int q) {
		this.q = q;
	}	

}