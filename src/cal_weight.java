import java.io.*; 
import java.util.HashMap;


public class cal_weight {

	public static void main(String[] args) {
		
		File file = new File("D:\\temp_workspace\\zhada\\input.txt");
		BufferedReader input;
			
		try {
			
			input = new BufferedReader (new FileReader(file));	
			HashMap<String, Double> weight_table = new HashMap<String, Double>();
			
	        String text;            
	        while((text = input.readLine()) != null)  
	        {
	        	if(text.equals(""))
	        	{
	        		break;
	        	}
	        	
	        	String[] text_split = text.split("=");
	        	text_split[0] = text_split[0].substring(2,text_split[0].length()-1);
	        	text_split[1] = text_split[1].substring(1,text_split[1].length()-2);
	        	
	        	weight_table.put(text_split[0], Double.parseDouble(text_split[1]));
	        	
	        	if(text_split[0].equals("foot"))
	        	{
	        		weight_table.put("feet", Double.parseDouble(text_split[1]));
	        	}
	        	else if(text_split[0].equals("inch"))
	        	{
	        		weight_table.put("inches", Double.parseDouble(text_split[1]));
	        	}
	        	else
	        	{
	        		weight_table.put(text_split[0]+"s", Double.parseDouble(text_split[1]));
	        	}
	        	
	        }
	        
	        String final_output_txt = "zhfkt@hotmail.com\r\n\r\n";
	        
	        while((text = input.readLine()) != null)  
	        {
	        	if(text.equals(""))
	        	{
	        		continue;
	        	}
	        	
	        	int start_index = 0;int stop_index = 0;
	        	double trans_score = 0;
	        	char ing_symbol = '+';

	        	for(int i=0;i<text.length();i++)
	        	{
	        		if(text.charAt(i)=='+' || text.charAt(i) =='-' || i==text.length()-1)
	        		{
	        			if(i==text.length()-1)
	        			{
	        				stop_index = text.length();
	        			}
	        			else
	        			{
	        				stop_index = i-1;
	        			}
	        				
	    	        	String[] text_split = text.substring(start_index, stop_index).split(" ");	    	        	
	    	        	double trans_tmp = weight_table.get(text_split[1])*Double.parseDouble(text_split[0]);

	    	        	if(ing_symbol=='+')
	    	        	{
	    	        		trans_score +=  trans_tmp;
	    	        	}
	    	        	else
	    	        	{
	    	        		trans_score -=  trans_tmp;
	    	        	}
	    	        	
	    	        	ing_symbol = text.charAt(i);
	    	        	start_index = i+2;
	        		}		
	        	}
	        	
	        	final_output_txt +=(String.format("%.2f", trans_score)+" m\r\n");

	        }
	        
	        File output_file = new File("D:\\temp_workspace\\zhada\\output.txt");
        	BufferedWriter output = new BufferedWriter(new FileWriter(output_file));
            output.write(final_output_txt);
            output.close();
	        
	        
	        
	        input.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}
	
	
}
