package ballot;

public interface Ballot {
	public void cast(Question q, AnswerType ans);
	public void tally();
}
