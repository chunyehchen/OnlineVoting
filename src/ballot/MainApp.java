package ballot;

public class MainApp {
	public static void main(String[] args) {
		Question q1 = new Question("Do you support free bus?");
		Question q2 = new Question("Do you support nuclear power?");
		Question q3 = new Question("Do you support gay marriage?");
		
		BallotFactory bf = BallotFactory.getInstance();
		
		CityBallot raleigh = (CityBallot) bf.getBallot(BallotType.CITY_BALLOT, "Raleigh");
		CityBallot chapel_hill = (CityBallot) bf.getBallot(BallotType.CITY_BALLOT, "Chapel Hill");
		CityBallot columbia = (CityBallot) bf.getBallot(BallotType.CITY_BALLOT, "Columbia");
		CityBallot charleston = (CityBallot) bf.getBallot(BallotType.CITY_BALLOT, "Charleston");
		
		StateBallot nc = (StateBallot) bf.getBallot(BallotType.STATE_BALLOT, "North Carolina");
		nc.addToCityList(raleigh);
		nc.addToCityList(chapel_hill);
		
		StateBallot sc = (StateBallot) bf.getBallot(BallotType.STATE_BALLOT, "South Carolina");
		sc.addToCityList(columbia);
		sc.addToCityList(charleston);
		
		CountryBallot usa = (CountryBallot) bf.getBallot(BallotType.COUNTRY_BALLOT, "USA");
		usa.addToStateList(nc);
		usa.addToStateList(sc);
		
		raleigh.cast(q1, "Yes");
		raleigh.cast(q1, "Yes");
		raleigh.cast(q2, "No");
		raleigh.cast(q2, "No");
		raleigh.cast(q2, "Yes");
		
		chapel_hill.cast(q1, "No");
		chapel_hill.cast(q1, "Yes");
		chapel_hill.cast(q2, "Yes");
		
		nc.cast(q3, "Yes");
		nc.cast(q3, "No");
		
		sc.cast(q3, "No");
		
		usa.tally();
	}
}
