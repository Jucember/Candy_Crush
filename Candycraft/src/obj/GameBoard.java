package obj;


import org.newdawn.slick.SlickException;
import Game.CongfigGame;


public class GameBoard {
	
	public static Candy[][] Board;
	public static int board[][] =new int[CongfigGame.getLengthRow()][CongfigGame.getLengthColum()];
	public int x;
	public int y;
	public int activeX;
	public int activeY;
	public boolean notDetectRight = false;
	public boolean isActive = false;
	public boolean isFalling = false;
	public int [] image= new int[6];
	public boolean notDetectLeft = false;
	public boolean notDetectUp = false;
	public boolean notDetectDown = false ;

	public static Pos[][] locateCandy;
	public GameBoard() throws SlickException {
	
		Board = new Candy[CongfigGame.getLengthRow()][CongfigGame.getLengthColum()];
		locateCandy = new Pos[CongfigGame.getLengthRow()][CongfigGame.getLengthRow()];
		for(int i = 0 ; i < CongfigGame.getLengthColum(); i++) {
			for(int j = 0; j < CongfigGame.getLengthRow(); j++) {
				int type= choosecandy(i,j, Board);
				setMT(i,j,type);
				setPos(i, j);
			}
		}
		showMatrix2D();
		showPos();
	}
	
	public void setPos(int i, int j) {
		Pos newPos = new Pos( 150 + 80 * i, 95 + 80 * j);
		locateCandy[i][j] = newPos; 
	}
	
	public void setMT(int i, int j,int type)
	{
		
		Candy newCandy = new Candy(type , 150 + 80 * i, 95 + 80 * j);
		Board[i][j] = newCandy;
		
	}
	public void swap(int x1,int y1,int x2, int y2)
	{
		Candy old= Board[x1][y1];
		Board[x1][y1]= Board[x2][y2];
		Board[x2][y2]=old;
		
	}
	void checkphai(int i, int j,Candy [][] a)
	{
	    if(j<7)
	    {
	        if(a[i][j+1].typeCandy==a[i][j+2].typeCandy)
	        {
	            image[a[i][j+1].typeCandy]=1;
	        }
	    }
	}
	void checktrai(int i, int j,Candy [][] a)
	{
	    if(j>1)
	    {
	        if(a[i][j-1].typeCandy==a[i][j-2].typeCandy)
	        {
	            image[a[i][j-1].typeCandy]=1;
	        }
	    }
	}
	void checktren(int i, int j,Candy [][] a)
	{
	    if(i>1)
	    {
	        if(a[i-1][j].typeCandy==a[i-2][j].typeCandy)
	        {
	            image[a[i-1][j].typeCandy]=1;
	        }
	    }
	}
	void checkduoi(int i, int j,Candy [][] a)
	{
	    if(i<7)
	    {
	        if(a[i+1][j]==a[i+2][j])
	        {
	            image[a[i+1][j].typeCandy]=1;
	        }
	    }
	}
	int choosecandy(int i, int j,Candy [][] a)
	{
	
	        for(int r=0;r<6;++r)
	        {
	            image[r]=0;
	        }
	        checktrai(i,j,a);
	        checktren(i,j,a);
	        int type = Candy.getTypeCandy()+6;
	        while(image[type%6]==1)
	        {
	            --type;
	        }
	        return type%6;
	    
	}


	public static void showPos() {
		for(int i = 0; i < CongfigGame.getLengthRow(); i++) {
			for(int j = 0; j < CongfigGame.getLengthColum(); j++) {
				System.out.print(locateCandy[i][j].x + "," + locateCandy[i][j].y + "  ") ;
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void showMatrix2D() {
		for(int i = 0; i < CongfigGame.getLengthRow(); i++) {
			for(int j = 0; j < CongfigGame.getLengthRow(); j++) {
				System.out.print(Board[i][j].typeCandy + " ");
			}
			System.out.println();
		}
		System.out.println(" ");
	}

			// GETTER & SETTER

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}



}