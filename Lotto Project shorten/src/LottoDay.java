
public class LottoDay {
	int [] win = new int[6];//stores the lotto day numbers 
	/**
	 * Constructor for LottoDay stores the lotto numbers and the mega number
	 * @param first
	 * @param second
	 * @param third
	 * @param fourth
	 * @param fifth
	 * @param mega
	 */
	public LottoDay(int first, int second, int third , int fourth, int fifth ,int mega) 
	{

		win[0]=first;
		win[1] =second;
		win[2]=third;
		win[3]=fourth;
		win[4]=fifth;
		win[5]=mega;

	}
	/**Gets the mega number
	 * @return mega number
	 */
	public int getMega()
	{
		return win[5];	
	}

	/**Gets the lotto numbers
	 * @return array of lotto numbers
	 */
	public int [] getWNum()
	{
		int [] winning = new int[5];
		for(int i=0;i<5;i++)
		{
			winning[i]=win[i];
		}
		return winning;
	}
	/**Returns a string of the lotto numbers and mega number
	 * @return nums
	 */
	public String toString()
	{
		String nums = "";
		for(int i=0;i<6;i++)
		{
			nums=nums +win[i]+ " ";
		}
		return nums;
	}




}
