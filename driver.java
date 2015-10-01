

public class driver {
	public static void main(String[] args)
	{
		Experiment e = new Experiment("schellingModel", "comparative");
		Objective o = new Objective("SchellingObjective", "COMPARATIVE");
		e.setDescription("A string");
		e.setO(o);
		
		Design design = new Design("SchellingDesign", Design.Types.OTHERS);
		
		Values factorValue= new Values(70);
		Factor f = new Factor("percentLikeNeighbors", Factor.VariableTypes.NONBINARY, factorValue);
		Response r = new Response("AgentSatisfaction", Response.RTypes.SIMPLE);
		IndependentVariables i = new IndependentVariables(f);
		DependentVariables d = new DependentVariables(r);
		Variables v = new Variables(i, d);
		
		design.setVariables(v);
		
		Values expectedValue = new Values(0.7);
		PerformanceMeasure p = new PerformanceMeasure("SchellingPerformanceMeasure", r,expectedValue);
		
		String []eventList = {"LookingForNewSite","AgentSatisfaction<0.7"};
		Event event = new Event(eventList);
		Query q = new Query(event, Query.temp.until, Query.linkers.is, Query.Exp.TRUE);
		HypothesisTesting h = new HypothesisTesting("MechanisticHypothesis", HypothesisTesting.Patterns.Custom, q);
		System.out.print("Finished");
	}

}
