package ballot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StateBallot implements Ballot {

	private List<CityBallot> cityBallotList;
	private Map<Question,Answer> result;	
	private String name;
	
	public StateBallot(String name) {
		this.name = name;
		result = new HashMap<Question, Answer>();
		cityBallotList = new ArrayList<CityBallot>();
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
		
		for(CityBallot cb : cityBallotList) {
			cb.tally();
		}
		System.out.println();
	}
	
	public void addToCityList(CityBallot cb) {
		cityBallotList.add(cb);
	}
	

}
