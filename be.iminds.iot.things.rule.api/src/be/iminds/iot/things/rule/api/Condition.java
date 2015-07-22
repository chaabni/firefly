package be.iminds.iot.things.rule.api;

import java.util.UUID;

import be.iminds.iot.things.api.Thing;

public interface Condition {
	
	public UUID getId();
	
	public String getType();
	
	public void setThing(Thing thing);
	
	public boolean trigger(Change change);

}
