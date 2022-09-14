

import java.util.Scanner;

class Guesser
{
	int guessNum;
	
	public int guessNumber()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Guesser kindly guess the number");
		guessNum=scan.nextInt();
		return guessNum;	
		
	}	

}
class Player
{
	int []pguessNum;
	int NoOfPlayers;
	Player(int x){
		NoOfPlayers=x;
		pguessNum=new int[x];
	}
	public int[] guessNumber()
	{
		Scanner sca=new Scanner(System.in);
		for(int i=0;i<NoOfPlayers;i++)
		{
		System.out.println("Player "+(i+1)+" kindly guess the number");
		pguessNum[i]=sca.nextInt();
		}
		return pguessNum;
	}
}

class Umpire
{
	
	int numFromGuesser;
	int []numFromPlayer;
	int NoOfPlayers;
	int []Winners;
	int Round=1;
	
	public void collectNumFromGuesser()
	{
		System.out.println("Round: "+Round);
		Guesser g=new Guesser();
		numFromGuesser=g.guessNumber();
		
	}
	
	
	public void collectNumFromPlayer()
	{
		
		System.out.println("Enter Number of Players");
		Scanner scan=new Scanner(System.in);
		NoOfPlayers=scan.nextInt();
		Player p=new Player(NoOfPlayers);
		Winners=new int[NoOfPlayers];
		numFromPlayer=p.guessNumber();
		for(int i=0;i<Winners.length;i++)
			Winners[i]=0;
	}
	
	public int compare()
	{
		Scanner scne=new Scanner(System.in);
		int count=0;
		for(int i=0;i<numFromPlayer.length;i++)
		{
			if(numFromGuesser==numFromPlayer[i])
			{
				Winners[i]=1;
				count++;
			}
		}
		if(count!=0) {
			int p;
			p=count;
			System.out.print("CONGRATULATION! ");
			for(int i=0;i<Winners.length;i++)
			{
				if(numFromGuesser==numFromPlayer[i])
				{
					System.out.print("Player"+(i+1)+" ");
					p--;
					if(p==1)
						System.out.print("and ");
				
				}
				
			}
			if(count==1)
			System.out.println("Won the game");
			else
				System.out.println("Won the Round: "+Round);	
			if(count>1)
			{
				while(count!=1) { 
				count=0;
				Round++;
				System.out.println("Round: "+Round);
				System.out.println("Gusser kindly guess the Number for Round "+Round);
				numFromGuesser=scne.nextInt();
				do{

				for(int i=0;i<Winners.length;i++)
				{
					if(Winners[i]==1)
					{
						
						System.out.println("Player"+(i+1)+" kindly Guess the Number");
						numFromPlayer[i]=scne.nextInt();
						if(numFromGuesser==numFromPlayer[i])
							count++;
						
					}		
				}
				if(count==0)
					System.out.println("No One gussed Correctly. Try Again");
				}while(count==0);
				if(count>0)
				{
					p=count;
					System.out.print("CONGRATULATION! ");
					for(int i=0;i<Winners.length;i++)
					{
						if(Winners[i]==1&&numFromGuesser==numFromPlayer[i])
						{
							System.out.print("Player"+(i+1)+" ");
							p--;
							if(p==1)
								System.out.print("and ");
						
						}
						else
							Winners[i]=0;
						
					}
					if(count==1)
						System.out.println("Won the game");
						else
							System.out.println("Won the Round "+Round);	
				}
			}
			}
			
		}
		else
		{
			System.out.println("No Player gussed correctly Press 0 to continue and 1 to exit");
			
			do{
			count=scne.nextInt();
			if(count!=0&&count!=1)
				System.out.println("InValid Input Press 0 to continue and 1 to exit");
			else if(count==1)
				return 1;
			}while(count!=0&&count!=1);
			if(count==0)
				return 0;
		}
		return 1;
	}
		
}

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int r=0;
		Umpire u=new Umpire();

		u.collectNumFromGuesser();
		while(r==0) {
		u.collectNumFromPlayer();  
		r=u.compare();
		}
	}

}
