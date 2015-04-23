package ballot;

public aspect BallotLog {
	int voteNum = 0;
	int yesNum = 0;
	int noNum = 0;
	int tallyNum = 0;
	
	pointcut cast():
		call(void Ballot.cast(Question, AnswerType));
		
		after(Question question, AnswerType answer): cast() && args(question, answer){
			System.out.println("A vote is cast as " + answer);
			voteNum++;
			if(answer.equals(AnswerType.YES)) {
				yesNum++;
			}
			else {
				noNum++;
			}
		}
		
	pointcut tally():
		call(void Ballot.tally());
		
		after(): tally(){
			tallyNum++;
			if(thisJoinPoint.getSourceLocation().getFileName().equals("Processor.java")) {
				System.out.println("Number of votes is " + voteNum);
				System.out.println("Number of YES is " + yesNum);
				System.out.println("Number of No is " + noNum);
				System.out.println("Number of ballots processed is " + tallyNum);
			}
		}
		
}
