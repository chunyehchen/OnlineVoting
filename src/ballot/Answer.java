package ballot;

public class Answer {
	private int num_of_yes = 0;
	private int num_of_no = 0;
	
	public int getNum_of_yes() {
		return num_of_yes;
	}
	
	public int getNum_of_no() {
		return num_of_no;
	}
	
	public void incrementYes() {
		num_of_yes++;
	}
	
	public void incrementNo() {
		num_of_no++;
	}
	
	public String toString() {
		return "Y : " + num_of_yes + ", N : " + num_of_no;
	}
}
