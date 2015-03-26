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
	public void cast(Question q, String ans) {
		Answer a = null;
		if(result.containsKey(q)) {
			a = result.get(q);			
		} else {
			a = new Answer();
		}		
		
		if(ans.equals("Yes")) {
			a.incrementYes();
		} else if (ans.equals("No")) {
			a.incrementNo();
		}
		
		result.put(q,a);
	}

	@Override
	public void tally() {
		
		System.out.println(name);
		for(Map.Entry<Question, Answer> entry: result.entrySet()) {
			Question q = entry.getKey();
			Answer a = entry.getValue();
			System.out.println(q);
			System.out.println(a);
		}		
		
		for(CityBallot cb : cityBallotList) {
			cb.tally();
		}
		
	}
	
	public void addToCityList(CityBallot cb) {
		cityBallotList.add(cb);
	}
	

}
