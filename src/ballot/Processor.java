package ballot;

public class Processor {

	private String type;
	public Processor next = null;

	public Processor(String type) {
		this.type = type;
	}

	public void setNext(Processor p) {
		next = p;
	}
	
	private void add( Processor nextP ) {
        if (next != null) next.add( nextP );
        else next = nextP;
    }
	
	private void wrapAround( Processor firstP ) {
        if (next != null) next.wrapAround( firstP );
        else next = firstP;
    }
	
	public void tally(Ballot ballot) {
		if(type.equals("city")) {
			String className = ballot.getClass().getSimpleName();
			if(className.equals("CityBallot")) {
				System.out.println("City Processor is processing the tally.");
				ballot.tally();
			}
			else {
				System.out.println("City Processor cannot process " + className + " level tally.");
				next.tally(ballot);
			}
		}
		else if(type.equals("state")) {
			String className = ballot.getClass().getSimpleName();
			if(className.equals("StateBallot")) {
				System.out.println("State Processor is processing the tally.");
				ballot.tally();
			}
			else {
				System.out.println("State Processor cannot process " + className + " level tally.");
				next.tally(ballot);
			}
		}
		else if(type.equals("country")) {
			String className = ballot.getClass().getSimpleName();
			if(className.equals("CountryBallot")) {
				System.out.println("Country Processor is processing the tally.");
				ballot.tally();
			}
			else {
				System.out.println("Country Processor cannot process " + className + " level tally.");
				next.tally(ballot);
			}
		}
	}
	
	public static Processor setUpChain() {
		Processor chain = new Processor("city");
		
		chain.add(new Processor("state"));
		chain.add(new Processor("country"));
		
		chain.wrapAround(chain);
		
		return chain;
	}
}
