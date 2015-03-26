package ballot;

public interface Ballot {
	public void cast(Question q, String ans);
	public void tally();
}
