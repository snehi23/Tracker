package com.tracker.model;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name="GeocodeResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class FetchLatLong {
	
	@XmlElement(name="result")
	Result result;

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}
	
	
    
}
