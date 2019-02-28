import java.util.Set;

public class Slide {

	public String[] tags;
	
	public void setTags(String tags0, String tags1, String tags2, String tags3) {
		this.tags[0] = tags0;
		this.tags[1] = tags1;
		this.tags[2] = tags2;
		this.tags[3] = tags3;	
	}
	
	public Slide(int length, String[] tags) {
		this.tags = new String[length];
		this.tags = tags;
	}
	
	
}
