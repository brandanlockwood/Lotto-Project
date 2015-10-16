import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class ReadFile {
	private String text; //stores name of the file
	private ArrayList<LottoDay> list = new ArrayList<LottoDay>();//creates lottoDay ArrayList
	private String reader="";  //store file
	private String next ="";   //store next line of file
	private LottoDay day =null; //create new object of LottoDay
	private int [] num = new int[6]; //store all lotto numbers
	private Frequency check= null; //create null Frequency object
	int [] hotN; //store 5 most frequent lotto numbers
	int [] hotM; //store 5 most frequent mega numbers
	int [] coldN; //store 5 least frequent lotto  numbers
	int [] coldM; //store 5 least freqent mega numbers
	/**ReadFile constructor
	 * @param-fileName file to be read
	 */
	public ReadFile(String fileName) {
		text =fileName; //file to read

	}
	/**Reads the file and returns an ArrayList of Lotto Day Objects
	 * I used the ArrayList for the index of the objects. Has methods
	 *  to obtain the object easily.
	 * @return ArrayList<LottoDay>
	 */
	public ArrayList<LottoDay> read()
	{
		int i=0;

		try {
			File inputText = new File(text);  //store file
			Scanner input = new Scanner(inputText); //scan file
			while(input.hasNextLine())
			{
				reader=input.nextLine(); //store the next line

				Scanner line = new Scanner(reader); //read line

				while(line.hasNextLine())
				{
					//ignore data
					if(i<3)
					{
						line.nextLine();
						i++;
					}
					else
					{


						while(line.hasNext())
						{
							//ignore more data
							line.next();
							line.next();
							line.next();
							line.next();
							line.next();
							while(line.hasNextInt())
							{
								//store lotto numbers
								num[0]=line.nextInt();
								num[1] =line.nextInt();
								num[2]=line.nextInt();
								num[3]=line.nextInt();
								num[4]=line.nextInt();
								num[5]=line.nextInt();
							}
						}

						day = new LottoDay(num[0],num[1],num[2],num[3],num[4],num[5]);//create new object with lotto numbers
						list.add(day); //add to array

						line.nextLine(); //go to the next line


					}
				}

			}// end of loop
			//if no file 
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		check= new Frequency(list);//create new Frequency object
		coldN=check.coldN(list);//creates least frequent 5 lotto number array
		coldM=check.coldM(list); //creates least frequent 5 mega number array
		hotN= check.hotN(list); //creates most frequent 5 lotto number array
		hotM= check.hotM(list); //creates most frequent 5 mega number array
		return list; //return list
	}
	/**Prints all arrays in ascending order
	 */
	public void printA()
	{


		//reads hot lotto number array backwards
		for(int i=hotN.length-1; i>=0; i--)
		{   if(i==hotN.length-1)
		{
			System.out.println("Ascending order: 5 most frequent NUMBERS");
		}
		if(i<hotN.length-1&& check.numberO(hotN[i])==check.numberO(hotN[i+1]))
		{
			System.out.println(hotN[i]+"- "+check.numberO(hotN[i]) + " tie");
		}
		else
		{
			System.out.println(hotN[i]+"- "+check.numberO(hotN[i]));
		}


		}
		System.out.println();
		//reads hot mega array backwards
		for(int i=hotM.length-1; i>=0; i--)
		{
			if(i==hotM.length-1)
			{
				System.out.println("Ascending order: 5 most frequent MEGA-NUMBERS");
			}
			if(i<hotM.length-1&& check.megaO(hotM[i])==check.megaO(hotM[i+1]))
			{
				System.out.println(hotM[i]+"- "+check.megaO(hotM[i]) + " tie");
			}
			else
			{
				System.out.println(hotM[i]+"- "+check.megaO(hotM[i]));
			}

		}
		System.out.println();
		//reads cold lotto number array 
		for(int i=0; i<coldN.length; i++)
		{   if(i==0)
		{
			System.out.println("Ascending order: 5 least frequent NUMBERS ");
		}
		if(i>1&&check.numberO(coldN[i])==check.numberO(coldN[i-1]))
		{
			System.out.println(coldN[i]+"- "+check.numberO(coldN[i]) + " tie");
		}
		else
		{
			System.out.println(coldN[i]+ "- "+check.numberO(coldN[i]));

		}


		}
		System.out.println();
		//reads cold mega number array
		for(int i=0; i<coldM.length; i++)
		{
			if(i==0)
			{
				System.out.println("Ascending order: 5 least frequent MEGA-NUMBERS ");
			}
			if(i>1&&check.megaO(coldM[i])==check.megaO(coldM[i-1]))
			{
				System.out.println(coldM[i]+"- "+check.megaO(coldM[i]) + " tie");
			}
			else
			{
				System.out.println(coldM[i]+ "- "+check.megaO(coldM[i]));

			}

		}
	}
	/**Prints all arrays in descending order
	 */
	public void printD()
	{

		//reads hot lotto number array 
		for(int i=0; i<hotN.length; i++)
		{   if(i==0)
		{
			System.out.println("Descending order: 5 most frequent NUMBERS ");
		}
		if(i>1&&check.numberO(hotN[i])==check.numberO(hotN[i-1]))
		{
			System.out.println(hotN[i]+"- "+check.numberO(hotN[i]) + " tie");
		}
		else
		{
			System.out.println(hotN[i]+ "- "+check.numberO(hotN[i]));

		}
		}
		System.out.println();
		//reads hot mega number array
		for(int i=0; i<hotM.length; i++)
		{   if(i==0)
		{
			System.out.println("Descending order: 5 most frequent MEGA-NUMBERS");
		}
		if(i>1&&check.megaO(hotM[i])==check.megaO(hotM[i-1]))
		{
			System.out.println(hotM[i]+"- "+check.megaO(hotM[i]) + " tie");
		}
		else
		{
			System.out.println(hotM[i]+ "- "+check.megaO(hotM[i]));

		}
		}
		System.out.println();
		//read cold number array backwards
		for(int i=coldN.length-1; i>=0; i--)
		{   if(i==coldN.length-1)
		{
			System.out.println("Descending order: 5 least frequent NUMBERS ");
		}
		if(i<coldN.length-1&& check.numberO(coldN[i])==check.numberO(coldN[i+1]))
		{
			System.out.println(coldN[i]+"- "+check.numberO(coldN[i]) + " tie");
		}
		else
		{
			System.out.println(coldN[i]+"- "+check.numberO(coldN[i]));
		}	
		}
		System.out.println();
		//read cold mega number array backward
		for(int i=coldM.length-1; i>=0; i--)
		{   if(i==coldM.length-1)
		{
			System.out.println("Descending order: 5 least frequent MEGA-NUMBERS ");
		}
		if(i<coldM.length-1&& check.megaO(coldM[i])==check.megaO(coldM[i+1]))
		{
			System.out.println(coldM[i]+"- "+check.megaO(coldM[i]) + " tie");
		}
		else
		{
			System.out.println(coldM[i]+"- "+check.megaO(coldM[i]));
		}	
		}
		System.out.println();
	}
	/**Gets a certain lotto number occurrences 
	 * @param num - lotto number
	 * @return number of lotto number occurrences
	 */
	public int nLook(int num)
	{
		return check.numberO(num);
	}
	/**Gets a certain mega number occurrences 
	 * @param num - mega number
	 * @return number of mega number occurrences
	 */
	public int mLook(int num)
	{
		return check.megaO(num);
	}
	/**Prints out the 5 most and least mega and lotto numbers
	 * @param none
	 * @return none
	 */
	public void printReport()
	{
		//reads hot lotto number array 
		for(int i=0; i<hotN.length; i++)
		{   if(i==0)
		{
			System.out.println("5 most frequent NUMBERS ");
		}
		if(i>1&&check.numberO(hotN[i])==check.numberO(hotN[i-1]))
		{
			System.out.println("   "+hotN[i]+"- "+check.numberO(hotN[i]) + " tie");
		}
		else
		{
			System.out.println((i+1)+") "+hotN[i]+ "- "+check.numberO(hotN[i]));

		}
		}
		System.out.println();
		//reads hot mega number array
		for(int i=0; i<hotM.length; i++)
		{   if(i==0)
		{
			System.out.println("5 most frequent MEGA-NUMBERS");
		}
		if(i>1&&check.megaO(hotM[i])==check.megaO(hotM[i-1]))
		{
			System.out.println("   "+hotM[i]+"- "+check.megaO(hotM[i]) + " tie");
		}
		else
		{
			System.out.println((i+1)+") "+hotM[i]+ "- "+check.megaO(hotM[i]));

		}
		}
		System.out.println();
		//reads cold lotto number array 
		for(int i=0; i<coldN.length; i++)
		{   if(i==0)
		{
			System.out.println("5 least frequent NUMBERS ");
		}
		if(i>1&&check.numberO(coldN[i])==check.numberO(coldN[i-1]))
		{
			System.out.println("   "+coldN[i]+"- "+check.numberO(coldN[i]) + " tie");
		}
		else
		{
			System.out.println((i+1)+") "+coldN[i]+ "- "+check.numberO(coldN[i]));

		}


		}
		System.out.println();
		//reads cold mega number array
		for(int i=0; i<coldM.length; i++)
		{
			if(i==0)
			{
				System.out.println("5 least frequent MEGA-NUMBERS ");
			}
			if(i>1&&check.megaO(coldM[i])==check.megaO(coldM[i-1]))
			{
				System.out.println("   "+coldM[i]+"- "+check.megaO(coldM[i]) + " tie");
			}
			else
			{
				System.out.println((i+1)+") "+coldM[i]+ "- "+check.megaO(coldM[i]));

			}

		}
	}


}
