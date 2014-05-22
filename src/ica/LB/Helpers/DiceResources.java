package ica.LB.Helpers;

/**
 * Created by jcapuano on 5/18/2014.
 */
public class DiceResources {
	public static int getWhiteBlack(int die) {
		int res = ica.LB.R.drawable.whiteb1;
		switch (die)
		{
			case 2:
				res = ica.LB.R.drawable.whiteb2;
				break;
			case 3:
				res = ica.LB.R.drawable.whiteb3;
				break;
			case 4:
				res = ica.LB.R.drawable.whiteb4;
				break;
			case 5:
				res = ica.LB.R.drawable.whiteb5;
				break;
			case 6:
				res = ica.LB.R.drawable.whiteb6;
				break;
			case 1:					
			default:
				break;
		}
		return res;
	}

	public static int getRedWhite(int die) {
		int res = ica.LB.R.drawable.redw1;
		switch (die)
		{
			case 2:
				res = ica.LB.R.drawable.redw2;
				break;
			case 3:
				res = ica.LB.R.drawable.redw3;
				break;
			case 4:
				res = ica.LB.R.drawable.redw4;
				break;
			case 5:
				res = ica.LB.R.drawable.redw5;
				break;
			case 6:
				res = ica.LB.R.drawable.redw6;
				break;
			case 1:					
			default:
				break;
		}
		return res;
	}
	
	public static int getBlackWhite(int die) {
		int res = ica.LB.R.drawable.blackw1;
		switch (die)
		{
			case 2:
				res = ica.LB.R.drawable.blackw2;
				break;
			case 3:
				res = ica.LB.R.drawable.blackw3;
				break;
			case 4:
				res = ica.LB.R.drawable.blackw4;
				break;
			case 5:
				res = ica.LB.R.drawable.blackw5;
				break;
			case 6:
				res = ica.LB.R.drawable.blackw6;
				break;
			case 1:					
			default:
				break;
		}
		return res;
	}
	
	public static int getBlackRed(int die) {
		int res = ica.LB.R.drawable.blackr1;
		switch (die)
		{
			case 2:
				res = ica.LB.R.drawable.blackr2;
				break;
			case 3:
				res = ica.LB.R.drawable.blackr3;
				break;
			case 4:
				res = ica.LB.R.drawable.blackr4;
				break;
			case 5:
				res = ica.LB.R.drawable.blackr5;
				break;
			case 6:
				res = ica.LB.R.drawable.blackr6;
				break;
			case 1:					
			default:
				break;
		}
		return res;
	}

	public static int getBlue(int die) {
		int res = ica.LB.R.drawable.blue1;
		switch (die)
		{
			case 2:
				res = ica.LB.R.drawable.blue2;
				break;
			case 3:
				res = ica.LB.R.drawable.blue3;
				break;
			case 4:
				res = ica.LB.R.drawable.blue4;
				break;
			case 5:
				res = ica.LB.R.drawable.blue5;
				break;
			case 6:
				res = ica.LB.R.drawable.blue6;
				break;
			case 1:					
			default:
				break;
		}
		return res;
	}

}
