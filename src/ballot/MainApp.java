package ballot;

public class MainApp {
	public static void main(String[] args) {
		Question q1 = new Question("Do you support free bus?");
		Question q2 = new Question("Do you support nuclear power?");
		Question q3 = new Question("Do you support gay marriage?");
		
		BallotFactory ballotFactory = BallotFactory.getInstance();
		
		CityBallot ballotRaleigh = (CityBallot) ballotFactory.getBallot(BallotType.CITY_BALLOT, "Raleigh");
		CityBallot ballotChapelHill = (CityBallot) ballotFactory.getBallot(BallotType.CITY_BALLOT, "Chapel Hill");
		CityBallot ballotColumbia = (CityBallot) ballotFactory.getBallot(BallotType.CITY_BALLOT, "Columbia");
		CityBallot ballotCharleston = (CityBallot) ballotFactory.getBallot(BallotType.CITY_BALLOT, "Charleston");
		
		StateBallot ballotNC = (StateBallot) ballotFactory.getBallot(BallotType.STATE_BALLOT, "North Carolina");
		ballotNC.addToCityList(ballotRaleigh);
		ballotNC.addToCityList(ballotChapelHill);
		
		StateBallot ballotSC = (StateBallot) ballotFactory.getBallot(BallotType.STATE_BALLOT, "South Carolina");
		ballotSC.addToCityList(ballotColumbia);
		ballotSC.addToCityList(ballotCharleston);
		
		CountryBallot ballotUSA = (CountryBallot) ballotFactory.getBallot(BallotType.COUNTRY_BALLOT, "USA");
		ballotUSA.addToStateList(ballotNC);
		ballotUSA.addToStateList(ballotSC);
		
		ballotRaleigh.cast(q1, AnswerType.YES);
		ballotRaleigh.cast(q1, AnswerType.YES);
		ballotRaleigh.cast(q2, AnswerType.NO);
		ballotRaleigh.cast(q2, AnswerType.NO);
		ballotRaleigh.cast(q2, AnswerType.YES);
		
		ballotChapelHill.cast(q1, AnswerType.NO);
		ballotChapelHill.cast(q1, AnswerType.YES);
		ballotChapelHill.cast(q2, AnswerType.YES);
		
		ballotNC.cast(q3, AnswerType.YES);
		ballotNC.cast(q3, AnswerType.NO);
		
		ballotSC.cast(q3, AnswerType.NO);
		
		ballotUSA.tally();
	}
}
