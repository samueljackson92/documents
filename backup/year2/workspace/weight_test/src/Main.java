import java.util.ArrayList;


public class Main {
	
	public static void main(String[] args) {
		new Main().calcSlot(7);
	}
	
	public int calcSlot(int priority) {
		//list of jobs
		ArrayList<Object> queue = new ArrayList<Object>();
		
		//our list of weights
		ArrayList<Double> weights = new ArrayList<Double>();
	
		//calculate the min and max priorities yourself
		//just using these as an example
		int priorityMin = 2;
		int priorityMax = 14;
		
		//calculate the range
		int range = priorityMax - priorityMin;
		
		//total weight, used to calculate random weighted priority later.
		double totalWeight = 0;
		
		//scale the priority to be on the same scale as the number
		//of slots in the queue
		double scaledPriority = (double)(priority - priorityMin);
		scaledPriority = (scaledPriority / range) * (queue.size()-1);
		
		//Generate the weights for each 'slot'
		for (int i = 0; i < queue.size(); i++) {
			
			//Next two lines are pure math wizardry. This is what i think you
			//were looking for earlier...
			
			//Select find 'pivot-point' a which weights flip.
			double pivot = (scaledPriority < ((double)queue.size()-1/2)) ? ((queue.size()-1) - scaledPriority) *2 : scaledPriority*2;

			//generate weight for this slot.
			double w = 1 - Math.abs(scaledPriority - i) / (pivot * 0.5);
			
			//as we go, sum our weights, saves doing it later.
			totalWeight += w;
			
			//add to the list of weights
			weights.add(w);
		}
		
		//Select an index based on weights
		//This bit is mostly lifted from a StackOverflow question:
		//http://stackoverflow.com/questions/6737283/weighted-randomness-in-java
		double random = Math.random() * totalWeight;
		for (int i = 0; i < queue.size(); ++i)
		{
		    random -= weights.get(i);
		    if (random <= 0)
		    {
		    	//return the random slot (array index)
		        return i;
		    }
		}
	}

}
