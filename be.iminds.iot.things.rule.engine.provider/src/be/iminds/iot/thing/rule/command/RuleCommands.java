package be.iminds.iot.thing.rule.command;

import java.util.UUID;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import be.iminds.iot.things.rule.api.Rule;
import be.iminds.iot.things.rule.api.RuleDTO;
import be.iminds.iot.things.rule.api.RuleEngine;
import be.iminds.iot.things.rule.api.RuleFactory;

@Component(
		service=Object.class,
		property={"osgi.command.scope=rule",
				  "osgi.command.function=rules",
				  "osgi.command.function=templates",
				  "osgi.command.function=add",
				  "osgi.command.function=remove"},
		immediate=true)
public class RuleCommands {

	private RuleEngine engine;
	private RuleFactory factory;
	
	public void rules(){
		int i=0;
		for(Rule r : engine.getRules()){
			System.out.println("["+(i++)+"] "+r.getDescription());
		}
	}
	
	public void templates(){
		for(RuleDTO template : factory.getTemplates()){
			System.out.println("* "+template.type+" - "+template.description);
		}
	}
	
	// only supports simple one-to-one rules for now
	public void add(String type, String sourceId, String destinationId) throws Exception {
		RuleDTO template = new RuleDTO();
		template.type = type;
		template.description = type+" "+sourceId+"->"+destinationId;
		template.sources = new UUID[]{UUID.fromString(sourceId)};
		template.destinations = new UUID[]{UUID.fromString(destinationId)};
		Rule rule = factory.createRule(template);
		engine.addRule(rule);
	}
	
	public void remove(int index){
		engine.removeRule(index);
	}
	
	@Reference
	public void setRuleEngine(RuleEngine re){
		this.engine = re;
	}
	
	@Reference
	public void setRuleFactory(RuleFactory f){
		this.factory = f;
	}
}
