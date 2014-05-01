package com.tracker.model;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;



@XmlAccessorType(XmlAccessType.FIELD)
public class Result {
	
	@XmlElement(name="geometry")
	Geometry geo;

	public Geometry getGeo() {
		return geo;
	}

	public void setGeo(Geometry geo) {
		this.geo = geo;
	}
	
			


}
