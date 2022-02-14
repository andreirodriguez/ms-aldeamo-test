package pe.aldeamo.test.api.response;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ArrayGlassResponse implements Serializable
{

	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	private String answer;
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
