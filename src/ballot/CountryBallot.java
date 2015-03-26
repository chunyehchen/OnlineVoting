package ballot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountryBallot implements Ballot {

	private List<StateBallot> stateBallotList;
	private Map<Question,Answer> result;	
	private String name;
	
	public CountryBallot(String name) {
		this.name = name;
		result = new HashMap<Question, Answer>();
		stateBallotList = new ArrayList<StateBallot>();
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
		
		for(StateBallot sb : stateBallotList) {
			sb.tally();
		}
		System.out.println();
	}
	
	public void addToStateList(StateBallot sb) {
		stateBallotList.add(sb);
	}
	

}
