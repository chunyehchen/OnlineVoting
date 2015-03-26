package ballot;

import java.util.HashMap;
import java.util.Map;

public class CityBallot implements Ballot {

	private Map<Question,Answer> result;	
	private String name;
	
	public CityBallot(String name) {
		this.name = name;
		result = new HashMap<Question, Answer>();
	}
	
	@Override
	public void cast(Question q, AnswerType ans) {
		Answer a = null;
		if(result.containsKey(q)) {
			a = result.get(q);			
		} else {
			a = new Answer();
		}		
		
		if(AnswerType.YES.equals(ans)) {
			a.incrementYes();
		} else if (AnswerType.NO.equals(ans)) {
			a.incrementNo();
		}
		
		result.put(q,a);
	}

	@Override
	public void tally() {
		System.out.println(name);
		System.out.println("----------------");
		for(Map.Entry<Question, Answer> entry: result.entrySet()) {
			Question q = entry.getKey();
			Answer a = entry.getValue();
			System.out.println(q);
			System.out.println(a);
		}
		System.out.println();
	}

}
