package ballot;

public class BallotFactory {
	private static BallotFactory bf = null;
	
	private BallotFactory() {
		
	}
	
	public static BallotFactory getInstance() {
		if(bf == null) {
			bf =  new BallotFactory();
		}
		return bf;
	}
	
	Ballot getBallot(BallotType bt, String name) {
		if(bt.equals(BallotType.COUNTRY_BALLOT)) {
			return new CountryBallot(name);
		}
		else if(bt.equals(BallotType.STATE_BALLOT)) {
			return new StateBallot(name);
		}
		else {
			return new CityBallot(name);
		}
	}
}
