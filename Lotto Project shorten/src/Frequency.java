import java.util.ArrayList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;


public class Frequency {
	private Map<Integer, Integer> number = new TreeMap<Integer,Integer>(); //stores a map for the lotto numbers
	private Map<Integer, Integer> megaN = new TreeMap<Integer,Integer>(); //stores a map for the mega numbrers
	private LottoDay one = null;
	private int mega=0;
	private ArrayList<LottoDay>day =null;
	int index=0; //gets the index
	/** A Frequency constructor that takes an ArrayList<LottoDay> 
	 * and fills both maps
	 * @param list
	 */
	public Frequency(ArrayList<LottoDay> list) {

		fill(list);//fill the maps
	}
	/**Needs an ArrayList of LottoDay to return the 5 most frequent lotto numbers 
	 * @param ArrayList<LottoDay> list
	 * @return highest-- the highest numbers in the list
	 */
	public int [] hotN(ArrayList<LottoDay> list)
	{     
		int high=0;//checks for the highest number
		int[] numF = new int [48];// stores the frequency of each number
		int[] highest= new int [5]; //stores the 5 highest numbers
		int counter =0;
		//hot numbers for 1-47
		for(int i=0; i<list.size();i++)
		{
			one = list.get(i); //get object
			highest = one.getWNum(); //get the first 5 numbers only of that object store in the array
			//gets the frequency for the numbers 1-47
			for(int j=0; j<numF.length;j++)
			{
				for(int k =0; k<highest.length;k++)
				{
					//check the array of for the index
					if(highest[k]==j)
					{ 
						counter++; //add one to count
						numF[j]=counter+numF[j]; //add to the count
						counter=0; //set counter back to zero 
					}
				}
			}
		}
		//check for the highest number and store in highest array 
		for(int j=0; j<highest.length; j++)
		{
			for(int i=0; i<numF.length;i++)
			{
				//if the occurrences beats high 
				if(numF[i]>high)
				{
					high = numF[i]; //new highest occurrence is stored
					highest[j]=i; //store the index in the array
					index=i; //index equals i
				}

			}
			high=0; //high goes back zero once through the entire list
			numF[index]=0; //highest numbers occurrences is now set to zero

		}

		return highest;//return the highest numbers in the list
	}
	/**Needs an ArrayList of LottoDay to return the 5 most frequent mega numbers 
	 * @param ArrayList<LottoDay> list
	 * @return check -- 5 highest mega numbers
	 */
	public int[] hotM(ArrayList<LottoDay> list)
	{
		int [] megaF = new int [28]; //stores number of occurrences for each mega number
		int[] check = new int [5]; //stores the highest mega numbers
		int counter =0; //counts occurrences
		int high=0; //checks for the highest mega numbers

		//fill megaF with the number of occurrences
		for(int i=0; i<list.size();i++)
		{
			one = list.get(i);//get the object
			mega= one.getMega();//get the mega number of that object
			for(int j=0; j<megaF.length;j++)
			{

				if(mega==j)
				{
					counter++; //add one to counter
					megaF[j]=counter+megaF[j]; //store occurrence
					counter=0; //reset counter
				}

			}
		}


		high=0;//reset high
		for( int j=0; j<check.length;j++)
		{
			for(int i=0; i<megaF.length;i++)
			{
				//if occurrence beats high
				if(megaF[i]>high)
				{
					high = megaF[i];//occurrence becomes new high
					check[j]=i;//store the index of highest occurrence
					index=i;//store index


				}

			}
			high=0;//reset high
			megaF[index]=0;//set highest index to zero 
		}


		return check; //return 5 highest mega numbers


	}
	/**Needs an ArrayList of LottoDay to return the 5 least frequent lotto numbers 
	 * @param ArrayList<LottoDay> list
	 * @return check-- 5 lowest numbers
	 */
	public int[] coldN(ArrayList<LottoDay> list)
	{  
		int low=200;//set low to 200
		int[] numF = new int [48]; //create array of occurrences
		int[] check = new int [5]; //create an array for the first five numbers and the five lowest numbers
		int counter =0; //counts number of occurrences
		//cold numbers for 1-47
		for(int i=0; i<list.size();i++)
		{
			one = list.get(i);//get object
			check = one.getWNum();//store the 5 lotto numbers
			for(int j=0; j<numF.length;j++)
			{
				for(int k =0; k<check.length;k++)
				{
					//if lotto number equals the index
					if(check[k]==j)
					{
						counter++; //add one to counter
						numF[j]=counter+numF[j];//add one to occurrence
						counter=0;//reset counter
					}

				}
			}
		}
		//check for lowest number
		for(int j=0; j<check.length; j++)
		{
			for(int i=0; i<numF.length;i++)
			{
				//occurrence isn't zero and is lower than low
				if(numF[i]<low &&numF[i]!=0)
				{
					low = numF[i]; //set low to new low of occurrence
					check[j]=i; //store new low occurrence
					index=i; //store index of occurrence
				}

			}

			low=200;//reset low
			numF[index]=0;//sets the lowest occurrence to zero

		}



		return check;//return 5 lowest numbers


	}
	/**Needs an ArrayList of LottoDay to return the 5 least frequent mega numbers 
	 * @param ArrayList<LottoDay> list
	 * @return check- 5 lowest mega numbers
	 */
	public int[] coldM(ArrayList<LottoDay> list)
	{
		int counter=0; //counts occurrences
		int low=200; //sets low to 200
		int [] megaF = new int [28]; //creates an array to store occurrences of mega numbers
		int[] check = new int [5]; //creates an array to store lowest mega numbers
		for(int i=0; i<list.size();i++)
		{
			one = list.get(i);//get object
			mega= one.getMega();//get the mega number of the object
			for(int j=0; j<megaF.length;j++)
			{
				//if mega number equals index
				if(mega==j)
				{
					counter++; //add one to count
					megaF[j]=counter+megaF[j]; //add one to occurrence
					counter=0; //reset counter
				}

			}
		}


		low=200;//resets low
		//looks for the lowest number in the mega number array
		for(int j=0; j<check.length;j++)
		{
			for(int i=0; i<megaF.length;i++)
			{
				//if mega number is not zero and the occurrence is lower than low
				if(megaF[i]<low &&megaF[i]!=0)
				{
					low = megaF[i]; //occurrence becomes new low
					index=i;//store index
					check[j]=i;//store the mega number
				}

			}
			low=200;//reset low
			megaF[index]=0;//set occurrence of the number to zero
		}
		//return 5 lowest mega numbers
		return check;
	}
	/**Needs an ArrayList of LottoDay to create two maps one for mega numbers and lotto numbers
	 * @param Array<LottoDay> list
	 */
	public void fill(ArrayList<LottoDay> list)
	{
		int[] numF = new int [48];//store occurrences for lotto numbers
		int [] megaF = new int [28];  //store occurrences for mega numbers
		int[] check = new int [5]; // stores each objects 5 numbers
		int counter =0; //counts occurrences
		for(int i=0; i<list.size();i++)
		{
			one = list.get(i); //get object
			check = one.getWNum(); //gets 5 numbers of the object
			for(int j=0; j<numF.length;j++)
			{
				for(int k =0; k<check.length;k++)
				{
					//if number equals index
					if(check[k]==j)
					{
						counter++; //add one to count
						numF[j]=counter+numF[j]; //add one to occurrence
						counter=0;//reset counter
					}
				}
			}
		}
		for(int i=0; i<list.size();i++)
		{
			one = list.get(i);//get object
			mega= one.getMega();//get mega number
			for(int j=0; j<megaF.length;j++)
			{
				// if mega number equals index
				if(mega==j)
				{
					counter++;//add one to count
					megaF[j]=counter+megaF[j]; //add one to occurrence
					counter=0;//reset counter
				}

			}
		}


		for(int i=0; i<numF.length; i++)
		{
			number.put(i,numF[i]);//put all lotto numbers with occurrences

		}
		for(int i=0; i<megaF.length; i++)
		{
			megaN.put(i, megaF[i]);//put all mega numbers with occurrences
		}
	}
	/**Gets a certain mega number occurrences 
	 * @param num - mega number
	 * @return mega number occurrences
	 */
	public int megaO(int num)
	{

		return megaN.get(num);
	}
	/**Gets a certain lotto number occurrences 
	 * @param num - lotto number
	 * @return lotto number occurrences
	 */
	public int numberO(int num)
	{

		return number.get(num);
	}






}
