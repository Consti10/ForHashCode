import java.util.ArrayList;
import java.util.List;

public class Slide {

	public List<String> tags;


	public Slide(List<String> tags) {

		this.tags = new ArrayList<>(tags);
	}



	@Override
	public String toString(){
		StringBuilder builder=new StringBuilder();
		for(final String tag:tags){
			builder.append(tag).append(" ");
		}
		return builder.toString();
	}
	
	
}
