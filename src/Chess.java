import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;


//Sound

public class Chess extends JPanel implements MouseListener
{
	private static final long serialVersionUID = 1L;
	Image Title;
    Image background;
    Image xImage;
    Image oImage;

    Image WhitePawn;
    Image WhiteRook;
    Image WhiteQueen;
    Image WhiteKing;
    Image WhiteKnight;
    Image WhiteBishop;
    Image BlackPawn;
    Image BlackRook;
    Image BlackQueen;
    Image BlackKing;
    Image BlackKnight;
    Image BlackBishop;

    int screen = 1;
    int players;
    int cconfirm = 0;
    Color ivory = new Color (254, 234, 204);//254, 234, 204
    Color darkerbrown = new Color (153, 92, 0); //153, 92, 0
    int click = 0;
    boolean check;
    char checkchar;
    
    int kmoved = 0;
    
    int incheck = 0;
    
    int bkmoved = 0;
    
    int krow = 7;
    int kcol = 4;
    
    int bkrow = 0;
    int bkcol = 4;
    
    Scanner scan = new Scanner(System.in);


    int turn = 1; //1 = white 2 = black
    Integer row1 = 0;
    Integer col1 = 0;
    Integer row2 = 0;
    Integer col2 = 0;

    char[][] board = new char [8][8];

    public Chess()
    {
        addMouseListener(this);
        board[0][0] = 'H';// H = Black Rook
        board[0][7] = 'H';

        board[0][1] = 'J';// J = Black Knight
        board[0][6] = 'J';

        board[0][2] = 'V';// V = Black Bishop
        board[0][5] = 'V';

        board[0][4] = 'M';// M = Black King
        board[0][3] = 'F';

        board[1][0] = 'L';// L = Black Pawn
        board[1][1] = 'L';
        board[1][2] = 'L';
        board[1][3] = 'L';
        board[1][4] = 'L';
        board[1][5] = 'L';
        board[1][6] = 'L';
        board[1][7] = 'L';
        // WHITE VVVV
        board[6][0] = 'P'; 
        board[6][1] = 'P';
        board[6][2] = 'P';
        board[6][3] = 'P';
        board[6][4] = 'P';
        board[6][5] = 'P';
        board[6][6] = 'P';
        board[6][7] = 'P';

        board[7][4] = 'K';// K = Black King
        board[7][3] = 'Q';

        board[7][0] = 'R';
        board[7][7] = 'R';

        board[7][1] = 'N';// N == Knight
        board[7][6] = 'N';

        board[7][2] = 'B';
        board[7][5] = 'B';
        //empty VVV
        board[2][0] = ' ';
        board[2][1] = ' ';
        board[2][2] = ' ';
        board[2][3] = ' ';
        board[2][4] = ' ';
        board[2][5] = ' ';
        board[2][6] = ' ';
        board[2][7] = ' ';

        board[3][0] = ' ';
        board[3][1] = ' ';
        board[3][2] = ' ';
        board[3][3] = ' ';
        board[3][4] = ' ';
        board[3][5] = ' ';
        board[3][6] = ' ';
        board[3][7] = ' ';

        board[4][0] = ' ';
        board[4][1] = ' ';
        board[4][2] = ' ';
        board[4][3] = ' ';
        board[4][4] = ' ';
        board[4][5] = ' ';
        board[4][6] = ' ';
        board[4][7] = ' ';

        board[5][0] = ' ';
        board[5][1] = ' ';
        board[5][2] = ' ';
        board[5][3] = ' ';
        board[5][4] = ' ';
        board[5][5] = ' ';
        board[5][6] = ' ';
        board[5][7] = ' ';

        try
        {
        	Title = ImageIO.read(new File("Title.png"));
            WhitePawn = ImageIO.read(new File("WhitePawn.png"));
            WhiteRook = ImageIO.read(new File("WhiteRook.png"));
            WhiteQueen = ImageIO.read(new File("WhiteQueen.png"));
            WhiteKing = ImageIO.read(new File("WhiteKing.png"));
            WhiteBishop = ImageIO.read(new File("WhiteBishop.png"));
            WhiteKnight = ImageIO.read(new File("WhiteKnight.png"));
            BlackPawn = ImageIO.read(new File("BlackPawn.png"));
            BlackRook = ImageIO.read(new File("BlackRook.png"));
            BlackQueen = ImageIO.read(new File("BlackQueen.png"));
            BlackKing = ImageIO.read(new File("BlackKing.png"));
            BlackBishop = ImageIO.read(new File("BlackBishop.png"));
            BlackKnight = ImageIO.read(new File("BlackKnight.png"));
        }
        catch (IOException e)
        {
        }
    }

    public void paint(Graphics g)
    {
        if (screen == 1)
        {
            startScreen(g);
            
        }
        else if (screen == 2)
        {
            drawBoard(g);
        }
        else if (screen == 3)
        {
            drawBoard(g);
        }
    }

    public void startScreen (Graphics g)
    {
        g.drawImage(Title, -8, -8, null);

    }

    public void drawBoard (Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect(0, 0, 900, 900);

        g.setColor(Color.black);
        g.fillRect( 20, 20, 810, 810);

        drawSquaresB(g, 0); // ROW 1
        drawSquares(g, 100); // ROW 2
        drawSquaresB(g, 200); // ETC.
        drawSquares(g, 300);
        drawSquaresB(g, 400);
        drawSquares(g, 500);
        drawSquaresB(g, 600);
        drawSquares(g, 700);
        
        
        //Coords below
        g.setColor(ivory);
        g.drawString("A", 100, 810);
        g.setColor(darkerbrown);
        g.drawString("B", 200, 810);
        g.setColor(ivory);
        g.drawString("C", 300, 810);
        g.setColor(darkerbrown);
        g.drawString("D", 400, 810);
        g.setColor(ivory);
        g.drawString("E", 500, 810);
        g.setColor(darkerbrown);
        g.drawString("F", 600, 810);
        g.setColor(ivory);
        g.drawString("G", 700, 810);
        g.setColor(darkerbrown);
        g.drawString("H", 800, 810);
        
        
        g.setColor(ivory);
        g.drawString("1", 38, 750);
        g.setColor(darkerbrown);
        g.drawString("2", 38, 650);
        g.setColor(ivory);
        g.drawString("3", 38, 550);
        g.setColor(darkerbrown);
        g.drawString("4", 38, 450);
        g.setColor(ivory);
        g.drawString("5", 38, 350);
        g.setColor(darkerbrown);
        g.drawString("6", 38, 250);
        g.setColor(ivory);
        g.drawString("7", 38, 150);
        g.setColor(darkerbrown);
        g.drawString("8", 38, 50);

        drawPieces(g);
    }

    public void drawSquares (Graphics g, int y) //these draw the board squares, used in method & repeated to save space in code.
    {
        g.setColor(darkerbrown);
        g.fillRect(25, 25+y, 100, 100);
        g.fillRect(225, 25+y, 100, 100);
        g.fillRect(425, 25+y, 100, 100);
        g.fillRect(625, 25+y, 100, 100);
        g.setColor(ivory);
        g.fillRect(125, 25+y, 100, 100);
        g.fillRect(325, 25+y, 100, 100);
        g.fillRect(525, 25+y, 100, 100);
        g.fillRect(725, 25+y, 100, 100);
    }

    public void drawSquaresB (Graphics g, int y)
    {
        g.setColor(ivory);
        g.fillRect(25, 25+y, 100, 100);
        g.fillRect(225, 25+y, 100, 100);
        g.fillRect(425, 25+y, 100, 100);
        g.fillRect(625, 25+y, 100, 100);
        g.setColor(darkerbrown);
        g.fillRect(125, 25+y, 100, 100);
        g.fillRect(325, 25+y, 100, 100);
        g.fillRect(525, 25+y, 100, 100);
        g.fillRect(725, 25+y, 100, 100);
    }

    public void CoordtoArray(int x, int y)
    {
        if (screen == 2) // Board
        {

        }
    }

    public void mouseClicked(MouseEvent e)
    {

    }

    public void mousePressed(MouseEvent e)
    {
        int x = e.getX();
        int y = e.getY();

        if (screen == 1) // Title
        {
        	/*
        	 *         g.fillRect(110, 630, 250, 125);
        g.setColor(Color.white);
        g.drawString("RANDOM", 210, 655);

        g.setColor(Color.blue);
        g.fillRect(490, 630, 250, 125);
        	 */
            if (x >= 490 && x <= 740 && y >= 630 && y <= 755)
            {
                screen = 2; // Board
                players = 2;
            }

            if (x >= 110 && x <= 360 && y >= 630 && y <= 755)
            {
                screen = 3; // Board
                players = 2;
            }
        }
        
        else if (screen == 3)
        {
            board[0][0] = ' ';
            board[0][1] = ' ';
            board[0][6] = ' ';
            board[0][2] = ' ';
            board[0][5] = ' ';
            board[0][4] = 'M';
            board[0][3] = ' ';
            board[1][0] = ' ';
            board[1][1] = ' ';
            board[1][2] = ' ';
            board[1][3] = ' ';
            board[1][4] = ' ';
            board[1][5] = ' ';
            board[1][6] = ' ';
            board[1][7] = ' ';
            board[6][0] = ' '; 
            board[6][1] = ' ';
            board[6][2] = ' ';
            board[6][3] = ' ';
            board[6][4] = ' ';
            board[6][5] = ' ';
            board[6][6] = ' ';
            board[6][7] = ' ';
            board[7][4] = 'K';// K = White king
            board[7][3] = ' ';
            board[7][0] = ' ';
            board[7][7] = ' ';
            board[7][1] = ' ';
            board[7][6] = ' ';
            board[7][2] = ' ';
            board[7][5] = ' ';
            board[2][0] = ' ';
            board[2][1] = ' ';
            board[2][2] = ' ';
            board[2][3] = ' ';
            board[2][4] = ' ';
            board[2][5] = ' ';
            board[2][6] = ' ';
            board[2][7] = ' ';
            board[3][0] = ' ';
            board[3][1] = ' ';
            board[3][2] = ' ';
            board[3][3] = ' ';
            board[3][4] = ' ';
            board[3][5] = ' ';
            board[3][6] = ' ';
            board[3][7] = ' ';
            board[4][0] = ' ';
            board[4][1] = ' ';
            board[4][2] = ' ';
            board[4][3] = ' ';
            board[4][4] = ' ';
            board[4][5] = ' ';
            board[4][6] = ' ';
            board[4][7] = ' ';
            board[5][0] = ' ';
            board[5][1] = ' ';
            board[5][2] = ' ';
            board[5][3] = ' ';
            board[5][4] = ' ';
            board[5][5] = ' ';
            board[5][6] = ' ';
            board[5][7] = ' ';
            repaint();
        	for(int loop = 0;loop <= 7; loop++)
        	{
				int RNDM = (int)(24*Math.random() + 1);
				if(RNDM > 5)
				{
					board[6][loop] = 'P'; 
				}
				else if(RNDM == 5)
				{
					board[6][loop] = 'P'; 
				}
				else if(RNDM == 4)
				{
					board[6][loop] = 'P'; 
				}
				else if(RNDM == 3)
				{
					board[6][loop] = 'B'; 
				}
				else if(RNDM == 2)
				{
					board[6][loop] = 'N'; 
				}
				else if(RNDM == 1)
				{
					board[6][loop] = 'R'; 
				}
        	}
        	for(int loop = 0;loop <= 7; loop++)
        	{
				int RNDM = (int)(4*Math.random() + 1);

				if(RNDM == 4)
				{
					board[7][loop] = 'Q'; 
				}
				else if(RNDM == 3)
				{
					board[7][loop] = 'B'; 
				}
				else if(RNDM == 2)
				{
					board[7][loop] = 'N'; 
				}
				else if(RNDM == 1)
				{
					board[7][loop] = 'R'; 
				}
				board[7][4] = 'K'; 
        	}
        	for(int loop = 0;loop <= 7; loop++)
        	{
				int RNDM = (int)(24*Math.random() + 1);
				if(RNDM > 5)
				{
					board[1][loop] = 'L'; 
				}
				else if(RNDM == 5)
				{
					board[1][loop] = 'L'; 
				}
				else if(RNDM == 4)
				{
					board[1][loop] = 'L'; 
				}
				else if(RNDM == 3)
				{
					board[1][loop] = 'V'; 
				}
				else if(RNDM == 2)
				{
					board[1][loop] = 'J'; 
				}
				else if(RNDM == 1)
				{
					board[1][loop] = 'H'; 
				}
        	}
        	for(int loop = 0;loop <= 7; loop++)
        	{
				int RNDM = (int)(4*Math.random() + 1);

				if(RNDM == 4)
				{
					board[0][loop] = 'F'; 
				}
				else if(RNDM == 3)
				{
					board[0][loop] = 'V'; 
				}
				else if(RNDM == 2)
				{
					board[0][loop] = 'J'; 
				}
				else if(RNDM == 1)
				{
					board[0][loop] = 'H'; 
				}
				board[0][4] ='M';
        	}
        	repaint();
        	screen = 2;
        }

        else if (screen == 2)
        {

            click++;

            if(click % 2 == 1)
            {
                row1 = (y - 25)/100;
                col1 = (x - 25)/100;

                row2 = null;
                col2 = null;
            }
            else
            {
                row2 = (y - 25)/100;
                col2 = (x - 25)/100;
            }
            //TURN ONE
            if (board[row1][col1] == ' ')
            {
                row1 = null;
                col1 = null;
                click = 0;
            }
            if (turn == 1)
            {
                
                for (int i = 0; i <= 7; i++)
                {
                    for (int j = 0; j <= 7; j++)
                    {
                        if (board[i][j] == 'E')
                        {
                            board[i][j] = 'P';
                        }
                    }
                }
                
                
                //PAWN WHITE
                if (board[row1][col1] == 'P')
                {
                    if(row2 == 0)//PROMOTION SQUARE
                    {
                        if (row2 == row1-1 && col1 == col2 && board[row2][col2] == ' ') //Up one empty square TO PROMOTE
                        {
                            checkchar = board[row2][col2];
                            board[row2][col2] = 'P';
                            board[row1][col1] = ' ';
                            if (KingCheck(krow, kcol) == true)
                            {
                                board[row1][col1] = 'P';
                                board[row2][col2] = checkchar;
                                click = 0;
                            }
                            else
                            {
                                board[row2][col2] = 'P';
                                board[row1][col1] = ' ';
                                String Wpromotion = JOptionPane.showInputDialog(null, "What Piece?");
                                
                                if (Wpromotion.equalsIgnoreCase("Queen"))
                                {
                                    board[row2][col2] = 'Q';
                                    board[row1][col1] = ' ';
                                    turn = 2;
                                }
                                else if (Wpromotion.equalsIgnoreCase("Rook"))
                                {
                                    board[row2][col2] = 'C';
                                    board[row1][col1] = ' ';
                                    turn = 2;
                                }
                                else if (Wpromotion.equalsIgnoreCase("Bishop"))
                                {
                                    board[row2][col2] = 'B';
                                    board[row1][col1] = ' ';
                                    turn = 2;
                                }
                                else if (Wpromotion.equalsIgnoreCase("Knight") || Wpromotion.equalsIgnoreCase("night" ) || Wpromotion.equalsIgnoreCase("horse"))
                                {
                                    board[row2][col2] = 'N';
                                    board[row1][col1] = ' ';
                                    turn = 2;
                                }
                                else
                                {
                                    board[row2][col2] = 'Q';
                                    board[row1][col1] = ' ';
                                    turn = 2;
                                }
                            }
                        }

                        else if (row2 == row1-1 && col2 == col1-1 || col2 == col1+1 && row2 == row1-1) //If a piece is upwards one square diagonal to pawn you are able to take it
                        {
                            if (board[row2][col2] == 'L' || board[row2][col2] == 'F' || 
                                board[row2][col2] == 'V' || board[row2][col2] == 'J' || 
                                board[row2][col2] == 'H' || board[row2][col2] == 'Y' || 
                                board[row2][col2] == 'Z')
                            {
                                if (board[row2][col2] == ' ')
                                {
                                    board[row1][col1] = 'P';
                                    board[row2][col2] = board[row2][col2];
                                    turn = 1;
                                    click = 0;
                                }
                                else
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'P';
                                    board[row1][col1] = ' ';
                                    if (KingCheck(krow, kcol) == true)
                                    {
                                        board[row1][col1] = 'P';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'P';
                                        board[row1][col1] = ' ';
                                        String Wpromotion = JOptionPane.showInputDialog(null, "What Piece?");
                                        
                                        if (Wpromotion.equalsIgnoreCase("Queen"))
                                        {
                                            board[row2][col2] = 'Q';
                                            board[row1][col1] = ' ';
                                            turn = 2;
                                        }
                                        else if (Wpromotion.equalsIgnoreCase("Rook"))
                                        {
                                            board[row2][col2] = 'C';
                                            board[row1][col1] = ' ';
                                            turn = 2;
                                        }
                                        else if (Wpromotion.equalsIgnoreCase("Bishop"))
                                        {
                                            board[row2][col2] = 'B';
                                            board[row1][col1] = ' ';
                                            turn = 2;
                                        }
                                        else if (Wpromotion.equalsIgnoreCase("Knight") || Wpromotion.equalsIgnoreCase("night" ) || Wpromotion.equalsIgnoreCase("horse"))
                                        {
                                            board[row2][col2] = 'N';
                                            board[row1][col1] = ' ';
                                            turn = 2;
                                        }
                                        else
                                        {
                                            board[row2][col2] = 'Q';
                                            board[row1][col1] = ' ';
                                            turn = 2;
                                        }
                                    }
                                }
                            }   
                        }
                    }
                    else if (row2 == row1-1 && col1 == col2 && board[row2][col2] == ' ') //Up one empty square and if not promtion square
                    {
                        checkchar = board[row2][col2];
                        board[row2][col2] = 'P';
                        board[row1][col1] = ' ';
                        if (KingCheck(krow, kcol) == true)
                        {
                            board[row1][col1] = 'P';
                            board[row2][col2] = checkchar;
                            click = 0;
                        }
                        else
                        {
                            board[row2][col2] = 'P';
                            board[row1][col1] = ' ';
                            turn = 2;
                        }
                    }

                    else if (row2 == row1-1 && col2 == col1-1 || col2 == col1+1 && row2 == row1-1) //If a piece is upwards one square diagonal to pawn you are able to take it
                    {
                        if (board[row2][col2] == 'L' || board[row2][col2] == 'F' || 
                            board[row2][col2] == 'V' || board[row2][col2] == 'J' || 
                            board[row2][col2] == 'H' || board[row2][col2] == 'Y' || 
                            board[row2][col2] == 'Z' || board[row2][col2] == ' ')
                        {
                            if(board[row2+1][col2] == 'Y' && row2+1 == 3)
                            {

                                if (KingCheck(krow, kcol) == true)
                                {
                                    board[row1][col1] = 'P';
                                    board[row2][col2] = ' ';
                                    board[row2+1][col2] = 'Y';
                                    click = 0;
                                }
                                else
                                {
                                    board[row2][col2] = 'E';
                                    board[row1][col1] = ' ';
                                    board[row2+1][col2] = ' ';
                                    turn = 2;
                                }
                            }
                            else if (board[row2][col2] == ' ') //If it is an empty square to capture, return to original position
                            {
                                board[row1][col1] = 'P';
                                board[row2][col2] = board[row2][col2];
                                turn = 1;
                                click = 0;
                            }

                            else //If the square is one of the pieces mentioned above
                            {
                                checkchar = board[row2][col2];
                                board[row2][col2] = 'P';
                                board[row1][col1] = ' ';
                                if (KingCheck(krow, kcol) == true)
                                {
                                    board[row1][col1] = 'P';
                                    board[row2][col2] = checkchar;
                                    click = 0;
                                }
                                else
                                {
                                    board[row2][col2] = 'P';
                                    board[row1][col1] = ' ';
                                    turn = 2;
                                }
                            }
                        }   
                    }

                    else if (row2 == 4 && board[row1][col1] == board[6][col1] && col2 == col1)// Two spaces upwards/downwards if first move
                    {
                        if (board[5][col1] == ' ' && board[4][col1] == ' ')
                        {
                            checkchar = board[row2][col2];
                            board[row2][col2] = 'P';
                            board[row1][col1] = ' ';
                            if (KingCheck(krow, kcol) == true)
                            {
                                board[row1][col1] = 'P';
                                board[row2][col2] = checkchar;
                                click = 0;
                            }
                            else
                            {
                                board[row2][col2] = 'E';
                                board[row1][col1] = ' ';
                                turn = 2;
                            }
                        }
                    }
                    else if (!(row2 == row1-1 && col2 == col1-1 || col2 == col1+1))
                    {
                        board[row1][col1] = 'P';
                        board[row2][col2] = board[row2][col2];
                        turn = 1;
                        click = 0;
                    }

                }

                if (board[row1][col1] == 'E')// EN PASSANT PAWN
                {
                    if (row2 == row1-1 && col1 == col2 && board[row2][col2] == ' ') //Up one empty square and if not promtion square
                    {
                        checkchar = board[row2][col2];
                        board[row2][col2] = 'P';
                        board[row1][col1] = ' ';
                        if (KingCheck(krow, kcol) == true)
                        {
                            board[row1][col1] = 'P';
                            board[row2][col2] = checkchar;
                            click = 0;
                        }
                        else
                        {
                            board[row2][col2] = 'P';
                            board[row1][col1] = ' ';
                            turn = 2;
                        }
                    }

                    else if (row2 == row1-1 && col2 == col1-1 || col2 == col1+1 && row2 == row1-1) //If a piece is upwards one square diagonal to pawn you are able to take it
                    {
                        if (board[row2][col2] == 'L' || board[row2][col2] == 'F' || 
                            board[row2][col2] == 'V' || board[row2][col2] == 'J' || 
                            board[row2][col2] == 'H' || board[row2][col2] == ' ' || 
                            board[row2][col2] == 'Y' || board[row2][col2] == 'Z')
                        {
                            if(board[row2+1][col2] == 'Y' && row2+1 == 3)
                            {
                                if (KingCheck(krow, kcol) == true)
                                {
                                    board[row1][col1] = 'P';
                                    board[row2][col2] = ' ';
                                    board[row2+1][col2] = 'Y';
                                    click = 0;
                                }
                                else
                                {
                                    board[row2][col2] = 'E';
                                    board[row1][col1] = ' ';
                                    turn = 2;
                                }
                            }
                            else if (board[row2][col2] == ' ') //If it is an empty square to capture, return to original position
                            {
                                board[row1][col1] = 'P';
                                board[row2][col2] = board[row2][col2];
                                turn = 1;
                                click = 0;
                            }

                            else //If the square is one of the pieces mentioned above
                            {
                                checkchar = board[row2][col2];
                                board[row2][col2] = 'P';
                                board[row1][col1] = ' ';
                                if (KingCheck(krow, kcol) == true)
                                {
                                    board[row1][col1] = 'P';
                                    board[row2][col2] = checkchar;
                                    click = 0;
                                }
                                else
                                {
                                    board[row2][col2] = 'P';
                                    board[row1][col1] = ' ';
                                    turn = 2;
                                }
                            }
                        }   
                    }

                    else if (row2 == 4 && board[row1][col1] == board[6][col1] && col2 == col1)// Two spaces upwards/downwards if first move
                    {
                        if (board[5][col1] == ' ' && board[4][col1] == ' ')
                        {
                            checkchar = board[row2][col2];
                            board[row2][col2] = 'P';
                            board[row1][col1] = ' ';
                            if (KingCheck(krow, kcol) == true)
                            {
                                board[row1][col1] = 'P';
                                board[row2][col2] = checkchar;
                                click = 0;
                            }
                            else
                            {
                                board[row2][col2] = 'E';
                                board[row1][col1] = ' ';
                                turn = 2;
                            }
                        }
                    }
                    else if (!(row2 == row1-1 && col2 == col1-1 || col2 == col1+1))
                    {
                        board[row1][col1] = 'P';
                        board[row2][col2] = board[row2][col2];
                        turn = 1;
                        click = 0;
                    }
                }

                //WHITE ROOK

                if (board[row1][col1] == 'R')
                {
                    int RMoveCC = 0;
                    if (row2 == row1 || col2 == col1)
                    {
                        //Up 
                        if(row2 < row1)
                        {
                            for (int RMoveC = row1-1; RMoveC > row2; RMoveC--)// Rook Move Check = RMoveC
                            {
                                if (board[RMoveC][col1] != ' ')
                                {
                                    RMoveCC -= 10;
                                }

                                else
                                {
                                    RMoveCC++;
                                }
                            }

                            if (RMoveCC < 0)
                            {
                                board[row1][col1] = 'R';
                                board[row2][col2] = board[row2][col2];
                                click = 0;
                            }

                            else
                            {
                                if (board[row2][col2] == 'Q' || board[row2][col2] == 'K' || 
                                    board[row2][col2] == 'B' || board[row2][col2] == 'N' || 
                                    board[row2][col2] == 'R' || board[row2][col2] == 'P' || 
                                    board[row2][col2] == 'E' || board[row2][col2] == 'C')
                                {
                                    board[row1][col1] = 'R';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'R';
                                    board[row1][col1] = ' ';
                                    if (KingCheck(krow, kcol) == true)
                                    {
                                        board[row1][col1] = 'R';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'C';
                                        board[row1][col1] = ' ';
                                        turn = 2;
                                    }
                                }
                            }
                        }
                        //Down
                        if(row2 > row1)
                        {
                            for (int RMoveC = row1+1; RMoveC < row2; RMoveC++)// Rook Move Check = RMoveC
                            {
                                if (board[RMoveC][col1] != ' ')
                                {
                                    RMoveCC -= 10;
                                }
                                else
                                {
                                    RMoveCC++;
                                }
                            }

                            if (RMoveCC < 0)
                            {
                                board[row1][col1] = 'R';
                                board[row2][col2] = board[row2][col2];
                                click = 0;
                            }
                            else
                            {
                                if (board[row2][col2] == 'Q' || board[row2][col2] == 'K' || 
                                    board[row2][col2] == 'B' || board[row2][col2] == 'N' || 
                                    board[row2][col2] == 'R' || board[row2][col2] == 'P' || 
                                    board[row2][col2] == 'E' || board[row2][col2] == 'C')
                                {
                                    board[row1][col1] = 'R';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'R';
                                    board[row1][col1] = ' ';
                                    if (KingCheck(krow, kcol) == true)
                                    {
                                        board[row1][col1] = 'R';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'C';
                                        board[row1][col1] = ' ';
                                        turn = 2;
                                    }
                                }
                            }
                        }
                        //Left
                        if(col2 < col1)
                        {
                            for (int RMoveC = col1-1; RMoveC > col2; RMoveC--)// Rook Move Check = RMoveC
                            {
                                if (board[row1][RMoveC] != ' ')
                                {
                                    RMoveCC -= 10;
                                }
                                else
                                {
                                    RMoveCC++;
                                }
                            }

                            if (RMoveCC < 0)
                            {
                                board[row1][col1] = 'R';
                                board[row2][col2] = board[row2][col2];
                                click = 0;
                            }
                            else
                            {
                                if (board[row2][col2] == 'Q' || board[row2][col2] == 'K' || 
                                    board[row2][col2] == 'B' || board[row2][col2] == 'N' || 
                                    board[row2][col2] == 'R' || board[row2][col2] == 'P' || 
                                    board[row2][col2] == 'E' || board[row2][col2] == 'C')
                                {
                                    board[row1][col1] = 'R';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'R';
                                    board[row1][col1] = ' ';
                                    if (KingCheck(krow, kcol) == true)
                                    {
                                        board[row1][col1] = 'R';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'C';
                                        board[row1][col1] = ' ';
                                        turn = 2;
                                    }
                                }
                            }
                        }
                        //Right
                        if(col2 > col1)
                        {
                            for (int RMoveC = col1+1; RMoveC < col2; RMoveC++)// Rook Move Check = RMoveC
                            {
                                if (board[row1][RMoveC] != ' ')
                                {
                                    RMoveCC -= 10;
                                }
                                else
                                {
                                    RMoveCC++;
                                }
                            }

                            if (RMoveCC < 0)
                            {
                                board[row1][col1] = 'R';
                                board[row2][col2] = board[row2][col2];
                                click = 0;
                            }
                            else
                            {
                                if (board[row2][col2] == 'Q' || board[row2][col2] == 'K' || 
                                    board[row2][col2] == 'B' || board[row2][col2] == 'N' || 
                                    board[row2][col2] == 'R' || board[row2][col2] == 'P' || 
                                    board[row2][col2] == 'E' || board[row2][col2] == 'C')
                                {
                                    board[row1][col1] = 'R';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'R';
                                    board[row1][col1] = ' ';
                                    if (KingCheck(krow, kcol) == true)
                                    {
                                        board[row1][col1] = 'R';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'C';
                                        board[row1][col1] = ' ';
                                        turn = 2;
                                    }
                                }
                            }
                        }
                    }
                }

                if (board[row1][col1] == 'C') // NON-CASTLEABLE ROOK
                {
                    int RMoveCC = 0;
                    if (row2 == row1 || col2 == col1)
                    {
                        //Up 
                        if(row2 < row1)
                        {
                            for (int RMoveC = row1-1; RMoveC > row2; RMoveC--)// Rook Move Check = RMoveC
                            {
                                if (board[RMoveC][col1] != ' ')
                                {
                                    RMoveCC -= 10;
                                }

                                else
                                {
                                    RMoveCC++;
                                }
                            }

                            if (RMoveCC < 0)
                            {
                                board[row1][col1] = 'C';
                                board[row2][col2] = board[row2][col2];
                                click = 0;
                            }

                            else
                            {
                                if (board[row2][col2] == 'Q' || board[row2][col2] == 'K' || 
                                    board[row2][col2] == 'B' || board[row2][col2] == 'N' || 
                                    board[row2][col2] == 'R' || board[row2][col2] == 'P' || 
                                    board[row2][col2] == 'E' || board[row2][col2] == 'C')
                                {
                                    board[row1][col1] = 'R';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'C';
                                    board[row1][col1] = ' ';
                                    if (KingCheck(krow, kcol) == true)
                                    {
                                        board[row1][col1] = 'C';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'C';
                                        board[row1][col1] = ' ';
                                        turn = 2;
                                    }
                                }
                            }
                        }
                        //Down
                        if(row2 > row1)
                        {
                            for (int RMoveC = row1+1; RMoveC < row2; RMoveC++)// Rook Move Check = RMoveC
                            {
                                if (board[RMoveC][col1] != ' ')
                                {
                                    RMoveCC -= 10;
                                }
                                else
                                {
                                    RMoveCC++;
                                }
                            }

                            if (RMoveCC < 0)
                            {
                                board[row1][col1] = 'C';
                                board[row2][col2] = board[row2][col2];
                                click = 0;
                            }
                            else
                            {
                                if (board[row2][col2] == 'Q' || board[row2][col2] == 'K' || 
                                    board[row2][col2] == 'B' || board[row2][col2] == 'N' || 
                                    board[row2][col2] == 'R' || board[row2][col2] == 'P' || 
                                    board[row2][col2] == 'E' || board[row2][col2] == 'C')
                                {
                                    board[row1][col1] = 'C';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'C';
                                    board[row1][col1] = ' ';
                                    if (KingCheck(krow, kcol) == true)
                                    {
                                        board[row1][col1] = 'C';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'C';
                                        board[row1][col1] = ' ';
                                        turn = 2;
                                    }
                                }
                            }
                        }
                        //Left
                        if(col2 < col1)
                        {
                            for (int RMoveC = col1-1; RMoveC > col2; RMoveC--)// Rook Move Check = RMoveC
                            {
                                if (board[row1][RMoveC] != ' ')
                                {
                                    RMoveCC -= 10;
                                }
                                else
                                {
                                    RMoveCC++;
                                }
                            }

                            if (RMoveCC < 0)
                            {
                                board[row1][col1] = 'C';
                                board[row2][col2] = board[row2][col2];
                                click = 0;
                            }
                            else
                            {
                                if (board[row2][col2] == 'Q' || board[row2][col2] == 'K' || 
                                    board[row2][col2] == 'B' || board[row2][col2] == 'N' || 
                                    board[row2][col2] == 'R' || board[row2][col2] == 'P' || 
                                    board[row2][col2] == 'E' || board[row2][col2] == 'C')
                                {
                                    board[row1][col1] = 'C';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'C';
                                    board[row1][col1] = ' ';
                                    if (KingCheck(krow, kcol) == true)
                                    {
                                        board[row1][col1] = 'C';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'C';
                                        board[row1][col1] = ' ';
                                        turn = 2;
                                    }
                                }
                            }
                        }
                        //Right
                        if(col2 > col1)
                        {
                            for (int RMoveC = col1+1; RMoveC < col2; RMoveC++)// Rook Move Check = RMoveC
                            {
                                if (board[row1][RMoveC] != ' ')
                                {
                                    RMoveCC -= 10;
                                }
                                else
                                {
                                    RMoveCC++;
                                }
                            }

                            if (RMoveCC < 0)
                            {
                                board[row1][col1] = 'C';
                                board[row2][col2] = board[row2][col2];
                                click = 0;
                            }
                            else
                            {
                                if (board[row2][col2] == 'Q' || board[row2][col2] == 'K' || 
                                    board[row2][col2] == 'B' || board[row2][col2] == 'N' || 
                                    board[row2][col2] == 'R' || board[row2][col2] == 'P' || 
                                    board[row2][col2] == 'E' || board[row2][col2] == 'C')
                                {
                                    board[row1][col1] = 'C';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'C';
                                    board[row1][col1] = ' ';
                                    if (KingCheck(krow, kcol) == true)
                                    {
                                        board[row1][col1] = 'C';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'C';
                                        board[row1][col1] = ' ';
                                        turn = 2;
                                    }
                                }
                            }
                        }
                    }
                }
                
                
                //WHITE BISHOP

                if (board[row1][col1] == 'B')
                {
                    int BMoveCC = 0;
                    if(col2 < col1 && row2 < row1) //LEFT UP
                    {
                        int BMoveY = row1-1;
                        int BMoveX = col1-1;
                        int count = col1-1;

                        for(int BDCY = row1-1;BDCY >= 0; BDCY--) //BDCY = Bishop Diagonal Check Y
                        {
                            int BDCX = col1-1;
                            for(BDCX = col1-1; BDCX > count; BDCX--){ 

                            }
                            count--;
                            if(row2 == BDCY && col2 == BDCX)
                            {

                                for (BMoveX = col1-1; BMoveX > col2; BMoveX--)// Bishop Move Check = BMoveX, x coordinate --- LEFT UP
                                {
                                    if (board[BMoveY][BMoveX] == ' ')
                                    {
                                        BMoveCC++; //If there isnt a SQUARE occupied with a piece before the second click then keep going
                                    }

                                    else
                                    {
                                        BMoveCC -= 10; //If there is a SQUARE occupied with a piece before the second click 
                                        //then final verdict wont allow for piece to be placed
                                    }
                                    BMoveY--;
                                }
                                if (BMoveCC < 0) //if there is a piece between bishop and destination
                                {
                                    board[row1][col1] = 'B';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else if(board[row2][col2] == 'L' || board[row2][col2] == 'F' || 
                                        board[row2][col2] == 'V' || board[row2][col2] == 'J' || 
                                        board[row2][col2] == 'H' || board[row2][col2] == 'Y' || 
                                        board[row2][col2] == 'Z')
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'B';
                                    board[row1][col1] = ' ';
                                    if (KingCheck(krow, kcol) == true)
                                    {
                                        board[row1][col1] = 'B';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'B';
                                        board[row1][col1] = ' ';
                                        turn = 2;
                                    }
                                }
                                else if(board[row2][col2] == 'P' || board[row2][col2] == 'B' || 
                                        board[row2][col2] == 'R' || board[row2][col2] == 'K' || 
                                        board[row2][col2] == 'Q' || board[row2][col2] == 'N' || 
                                        board[row2][col2] == 'C' || board[row2][col2] == 'E')
                                {
                                    board[row1][col1] = 'B';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else //if there isnt a piece between bishop and destination
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'B';
                                    board[row1][col1] = ' ';
                                    if (KingCheck(krow, kcol) == true)
                                    {
                                        board[row1][col1] = 'B';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'B';
                                        board[row1][col1] = ' ';
                                        turn = 2;
                                    }
                                }
                            }
                        }
                    }
                    if(col2 > col1 && row2 > row1) //RIGHT DOWN
                    {
                        int BMoveY = row1+1;
                        int BMoveX = col1+1;
                        int count = col1+1;

                        for(int BDCY = row1+1;BDCY <= 7; BDCY++) //BDCY = Bishop Diagonal Check Y
                        {
                            int BDCX = col1+1;
                            for(BDCX = col1+1; BDCX < count; BDCX++){
                            }
                            count++;
                            if(row2 == BDCY && col2 == BDCX)
                            {

                                for (BMoveX = col1+1; BMoveX < col2; BMoveX++)// Bishop Move Check = BMoveX, x coordinate --- LEFT UP
                                {
                                    if (board[BMoveY][BMoveX] == ' ')
                                    {
                                        BMoveCC++; //If there isnt a SQUARE occupied with a piece before the second click then keep going
                                    }

                                    else
                                    {
                                        BMoveCC -= 10; //If there is a SQUARE occupied with a piece before the second click 
                                        //then final verdict wont allow for piece to be placed
                                    }
                                    BMoveY++;
                                }
                                if (BMoveCC < 0) //if there is a piece between bishop and destination
                                {
                                    board[row1][col1] = 'B';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else if(board[row2][col2] == 'L' || board[row2][col2] == 'F' || 
                                        board[row2][col2] == 'V' || board[row2][col2] == 'J' || 
                                        board[row2][col2] == 'H' || board[row2][col2] == 'Y' || 
                                        board[row2][col2] == 'Z')
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'B';
                                    board[row1][col1] = ' ';
                                    if (KingCheck(krow, kcol) == true)
                                    {
                                        board[row1][col1] = 'B';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'B';
                                        board[row1][col1] = ' ';
                                        turn = 2;
                                    }
                                }
                                else if(board[row2][col2] == 'P' || board[row2][col2] == 'B' || 
                                        board[row2][col2] == 'R' || board[row2][col2] == 'K' || 
                                        board[row2][col2] == 'Q' || board[row2][col2] == 'N' || 
                                        board[row2][col2] == 'C' || board[row2][col2] == 'E')
                                {
                                    board[row1][col1] = 'B';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else //if there isnt a piece between bishop and destination
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'B';
                                    board[row1][col1] = ' ';
                                    if (KingCheck(krow, kcol) == true)
                                    {
                                        board[row1][col1] = 'B';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'B';
                                        board[row1][col1] = ' ';
                                        turn = 2;
                                    }
                                }

                            }
                        }
                    }
                    if(col2 > col1 && row2 < row1) //RIGHT UP
                    {
                        int BMoveY = row1-1;
                        int BMoveX = col1+1;
                        int count = col1+1;

                        for(int BDCY = row1-1;BDCY >= 0; BDCY--) //BDCY = Bishop Diagonal Check Y
                        {
                            int BDCX = col1+1;
                            for(BDCX = col1+1; BDCX < count; BDCX++){
                            }
                            count++;
                            if(row2 == BDCY && col2 == BDCX)
                            {

                                for (BMoveX = col1+1; BMoveX < col2; BMoveX++)// Bishop Move Check = BMoveX, x coordinate --- LEFT UP
                                {
                                    if (board[BMoveY][BMoveX] == ' ')
                                    {
                                        BMoveCC++; //If there isnt a SQUARE occupied with a piece before the second click then keep going
                                    }

                                    else
                                    {
                                        BMoveCC -= 10; //If there is a SQUARE occupied with a piece before the second click 
                                        //then final verdict wont allow for piece to be placed
                                    }
                                    BMoveY--;
                                }
                                if (BMoveCC < 0) //if there is a piece between bishop and destination
                                {
                                    board[row1][col1] = 'B';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else if(board[row2][col2] == 'L' || board[row2][col2] == 'F' || 
                                        board[row2][col2] == 'V' || board[row2][col2] == 'J' || 
                                        board[row2][col2] == 'H' || board[row2][col2] == 'Y' || 
                                        board[row2][col2] == 'Z')
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'B';
                                    board[row1][col1] = ' ';
                                    if (KingCheck(krow, kcol) == true)
                                    {
                                        board[row1][col1] = 'B';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'B';
                                        board[row1][col1] = ' ';
                                        turn = 2;
                                    }
                                }
                                else if(board[row2][col2] == 'P' || board[row2][col2] == 'B' || 
                                        board[row2][col2] == 'R' || board[row2][col2] == 'K' || 
                                        board[row2][col2] == 'Q' || board[row2][col2] == 'N' || 
                                        board[row2][col2] == 'C' || board[row2][col2] == 'E')
                                {
                                    board[row1][col1] = 'B';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else //if there isnt a piece between bishop and destination
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'B';
                                    board[row1][col1] = ' ';
                                    if (KingCheck(krow, kcol) == true)
                                    {
                                        board[row1][col1] = 'B';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'B';
                                        board[row1][col1] = ' ';
                                        turn = 2;
                                    }
                                }

                            }
                        }
                    }
                    if(col2 < col1 && row2 > row1) //LEFT DOWN
                    {
                        int BMoveY = row1+1;
                        int BMoveX = col1-1;
                        int count = col1-1;

                        for(int BDCY = row1+1;BDCY <= 7; BDCY++) //BDCY = Bishop Diagonal Check Y
                        {
                            int BDCX = col1-1;
                            for(BDCX = col1-1; BDCX > count; BDCX--){
                            }
                            count--;
                            if(row2 == BDCY && col2 == BDCX)
                            {

                                for (BMoveX = col1-1; BMoveX > col2; BMoveX--)// Bishop Move Check = BMoveX, x coordinate --- LEFT UP
                                {
                                    if (board[BMoveY][BMoveX] == ' ')
                                    {
                                        BMoveCC++; //If there isnt a SQUARE occupied with a piece before the second click then keep going
                                    }

                                    else
                                    {
                                        BMoveCC -= 10; //If there is a SQUARE occupied with a piece before the second click 
                                        //then final verdict wont allow for piece to be placed
                                    }
                                    BMoveY++;
                                }
                                if (BMoveCC < 0) //if there is a piece between bishop and destination
                                {
                                    board[row1][col1] = 'B';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else if(board[row2][col2] == 'L' || board[row2][col2] == 'F' || 
                                        board[row2][col2] == 'V' || board[row2][col2] == 'J' || 
                                        board[row2][col2] == 'H' || board[row2][col2] == 'Y' || 
                                        board[row2][col2] == 'Z')
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'B';
                                    board[row1][col1] = ' ';
                                    if (KingCheck(krow, kcol) == true)
                                    {
                                        board[row1][col1] = 'B';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'B';
                                        board[row1][col1] = ' ';
                                        turn = 2;
                                    }
                                }
                                else if(board[row2][col2] == 'P' || board[row2][col2] == 'B' || 
                                        board[row2][col2] == 'R' || board[row2][col2] == 'K' || 
                                        board[row2][col2] == 'Q' || board[row2][col2] == 'N' || 
                                        board[row2][col2] == 'C' || board[row2][col2] == 'E')
                                {
                                    board[row1][col1] = 'B';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else //if there isnt a piece between bishop and destination
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'B';
                                    board[row1][col1] = ' ';
                                    if (KingCheck(krow, kcol) == true)
                                    {
                                        board[row1][col1] = 'B';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'B';
                                        board[row1][col1] = ' ';
                                        turn = 2;
                                    }
                                }

                            }
                        }
                    }
                }
                //WHITE QUEEN
                if(board[row1][col1] == 'Q')
                {
                    int BMoveCC = 0;
                    int RMoveCC = 0;
                    if(col2 < col1 && row2 < row1) //LEFT UP
                    {
                        int BMoveY = row1-1;
                        int BMoveX = col1-1;
                        int count = col1-1;

                        for(int BDCY = row1-1;BDCY >= 0; BDCY--) //BDCY = Bishop Diagonal Check Y
                        {
                            int BDCX = col1-1;
                            for(BDCX = col1-1; BDCX > count; BDCX--){
                            }
                            count--;
                            if(row2 == BDCY && col2 == BDCX)
                            {

                                for (BMoveX = col1-1; BMoveX > col2; BMoveX--)// Bishop Move Check = BMoveX, x coordinate --- LEFT UP
                                {
                                    if (board[BMoveY][BMoveX] == ' ')
                                    {
                                        BMoveCC++; //If there isnt a SQUARE occupied with a piece before the second click then keep going
                                    }

                                    else
                                    {
                                        BMoveCC -= 10; //If there is a SQUARE occupied with a piece before the second click 
                                        //then final verdict wont allow for piece to be placed
                                    }
                                    BMoveY--;
                                }
                                if (BMoveCC < 0) //if there is a piece between bishop and destination
                                {
                                    board[row1][col1] = 'Q';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else if(board[row2][col2] == 'L' || board[row2][col2] == 'F' || 
                                        board[row2][col2] == 'V' || board[row2][col2] == 'J' || 
                                        board[row2][col2] == 'H' || board[row2][col2] == 'Y' || 
                                        board[row2][col2] == 'Z')
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'Q';
                                    board[row1][col1] = ' ';
                                    if (KingCheck(krow, kcol) == true)
                                    {
                                        board[row1][col1] = 'Q';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'Q';
                                        board[row1][col1] = ' ';
                                        turn = 2;
                                    }
                                }
                                else if(board[row2][col2] == 'P' || board[row2][col2] == 'B' || 
                                        board[row2][col2] == 'R' || board[row2][col2] == 'K' || 
                                        board[row2][col2] == 'Q' || board[row2][col2] == 'N' || 
                                        board[row2][col2] == 'C' || board[row2][col2] == 'E')
                                {
                                    board[row1][col1] = 'Q';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else //if there isnt a piece between bishop and destination
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'Q';
                                    board[row1][col1] = ' ';
                                    if (KingCheck(krow, kcol) == true)
                                    {
                                        board[row1][col1] = 'Q';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'Q';
                                        board[row1][col1] = ' ';
                                        turn = 2;
                                    }
                                }
                            }
                        }
                    }
                    if(col2 > col1 && row2 > row1) //RIGHT DOWN
                    {
                        int BMoveY = row1+1;
                        int BMoveX = col1+1;
                        int count = col1+1;

                        for(int BDCY = row1+1;BDCY <= 7; BDCY++) //BDCY = Bishop Diagonal Check Y
                        {
                            int BDCX = col1+1;
                            for(BDCX = col1+1; BDCX < count; BDCX++){
                            }
                            count++;
                            if(row2 == BDCY && col2 == BDCX)
                            {

                                for (BMoveX = col1+1; BMoveX < col2; BMoveX++)// Bishop Move Check = BMoveX, x coordinate --- LEFT UP
                                {
                                    if (board[BMoveY][BMoveX] == ' ')
                                    {
                                        BMoveCC++; //If there isnt a SQUARE occupied with a piece before the second click then keep going
                                    }

                                    else
                                    {
                                        BMoveCC -= 10; //If there is a SQUARE occupied with a piece before the second click 
                                        //then final verdict wont allow for piece to be placed
                                    }
                                    BMoveY++;
                                }
                                if (BMoveCC < 0) //if there is a piece between bishop and destination
                                {
                                    board[row1][col1] = 'Q';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else if(board[row2][col2] == 'L' || board[row2][col2] == 'F' || 
                                        board[row2][col2] == 'V' || board[row2][col2] == 'J' || 
                                        board[row2][col2] == 'H' || board[row2][col2] == 'Y' ||
                                        board[row2][col2] == 'Z')
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'Q';
                                    board[row1][col1] = ' ';
                                    if (KingCheck(krow, kcol) == true)
                                    {
                                        board[row1][col1] = 'Q';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'Q';
                                        board[row1][col1] = ' ';
                                        turn = 2;
                                    }
                                }
                                else if(board[row2][col2] == 'P' || board[row2][col2] == 'B' || 
                                        board[row2][col2] == 'R' || board[row2][col2] == 'K' || 
                                        board[row2][col2] == 'Q' || board[row2][col2] == 'N' || 
                                        board[row2][col2] == 'C' || board[row2][col2] == 'E')
                                {
                                    board[row1][col1] = 'Q';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else //if there isnt a piece between bishop and destination
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'Q';
                                    board[row1][col1] = ' ';
                                    if (KingCheck(krow, kcol) == true)
                                    {
                                        board[row1][col1] = 'Q';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'Q';
                                        board[row1][col1] = ' ';
                                        turn = 2;
                                    }
                                }

                            }
                        }
                    }
                    if(col2 > col1 && row2 < row1) //RIGHT UP
                    {
                        int BMoveY = row1-1;
                        int BMoveX = col1+1;
                        int count = col1+1;

                        for(int BDCY = row1-1;BDCY >= 0; BDCY--) //BDCY = Bishop Diagonal Check Y
                        {
                            int BDCX = col1+1;
                            for(BDCX = col1+1; BDCX < count; BDCX++){
                            }
                            count++;
                            if(row2 == BDCY && col2 == BDCX)
                            {

                                for (BMoveX = col1+1; BMoveX < col2; BMoveX++)// Bishop Move Check = BMoveX, x coordinate --- LEFT UP
                                {
                                    if (board[BMoveY][BMoveX] == ' ')
                                    {
                                        BMoveCC++; //If there isnt a SQUARE occupied with a piece before the second click then keep going
                                    }

                                    else
                                    {
                                        BMoveCC -= 10; //If there is a SQUARE occupied with a piece before the second click 
                                        //then final verdict wont allow for piece to be placed
                                    }
                                    BMoveY--;
                                }
                                if (BMoveCC < 0) //if there is a piece between bishop and destination
                                {
                                    board[row1][col1] = 'Q';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else if(board[row2][col2] == 'L' || board[row2][col2] == 'F' || 
                                        board[row2][col2] == 'V' || board[row2][col2] == 'J' || 
                                        board[row2][col2] == 'H' || board[row2][col2] == 'Y' ||
                                        board[row2][col2] == 'Z')
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'Q';
                                    board[row1][col1] = ' ';
                                    if (KingCheck(krow, kcol) == true)
                                    {
                                        board[row1][col1] = 'Q';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'Q';
                                        board[row1][col1] = ' ';
                                        turn = 2;
                                    }
                                }
                                else if(board[row2][col2] == 'P' || board[row2][col2] == 'B' || 
                                        board[row2][col2] == 'R' || board[row2][col2] == 'K' || 
                                        board[row2][col2] == 'Q' || board[row2][col2] == 'N' || 
                                        board[row2][col2] == 'C' || board[row2][col2] == 'E')
                                {
                                    board[row1][col1] = 'Q';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else //if there isnt a piece between bishop and destination
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'Q';
                                    board[row1][col1] = ' ';
                                    if (KingCheck(krow, kcol) == true)
                                    {
                                        board[row1][col1] = 'Q';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'Q';
                                        board[row1][col1] = ' ';
                                        turn = 2;
                                    }
                                }
                            }
                        }
                    }
                    if(col2 < col1 && row2 > row1) //LEFT DOWN
                    {
                        int BMoveY = row1+1;
                        int BMoveX = col1-1;
                        int count = col1-1;

                        for(int BDCY = row1+1;BDCY <= 7; BDCY++) //BDCY = Bishop Diagonal Check Y
                        {
                            int BDCX = col1-1;
                            for(BDCX = col1-1; BDCX > count; BDCX--){
                            }
                            count--;
                            if(row2 == BDCY && col2 == BDCX)
                            {

                                for (BMoveX = col1-1; BMoveX > col2; BMoveX--)// Bishop Move Check = BMoveX, x coordinate --- LEFT UP
                                {
                                    if (board[BMoveY][BMoveX] == ' ')
                                    {
                                        BMoveCC++; //If there isnt a SQUARE occupied with a piece before the second click then keep going
                                    }

                                    else
                                    {
                                        BMoveCC -= 10; //If there is a SQUARE occupied with a piece before the second click 
                                        //then final verdict wont allow for piece to be placed
                                    }
                                    BMoveY++;
                                }
                                if (BMoveCC < 0) //if there is a piece between bishop and destination
                                {
                                    board[row1][col1] = 'Q';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else if(board[row2][col2] == 'L' || board[row2][col2] == 'F' || 
                                        board[row2][col2] == 'V' || board[row2][col2] == 'J' || 
                                        board[row2][col2] == 'H' || board[row2][col2] == 'Y' ||
                                        board[row2][col2] == 'Z')
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'Q';
                                    board[row1][col1] = ' ';
                                    if (KingCheck(krow, kcol) == true)
                                    {
                                        board[row1][col1] = 'Q';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'Q';
                                        board[row1][col1] = ' ';
                                        turn = 2;
                                    }
                                }
                                else if(board[row2][col2] == 'P' || board[row2][col2] == 'B' || 
                                        board[row2][col2] == 'R' || board[row2][col2] == 'K' || 
                                        board[row2][col2] == 'Q' || board[row2][col2] == 'N' || 
                                        board[row2][col2] == 'C' || board[row2][col2] == 'E')
                                {
                                    board[row1][col1] = 'Q';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else //if there isnt a piece between bishop and destination
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'Q';
                                    board[row1][col1] = ' ';
                                    if (KingCheck(krow, kcol) == true)
                                    {
                                        board[row1][col1] = 'Q';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'Q';
                                        board[row1][col1] = ' ';
                                        turn = 2;
                                    }
                                }

                            }
                        }
                    }
                    if (row2 == row1 || col2 == col1)
                    {
                        //Up 
                        if(row2 < row1)
                        {
                            for (int RMoveC = row1-1; RMoveC > row2; RMoveC--)// Rook Move Check = RMoveC
                            {
                                if (board[RMoveC][col1] != ' ')
                                {
                                    RMoveCC -= 10;
                                }

                                else
                                {
                                    RMoveCC++;
                                }
                            }

                            if (RMoveCC < 0)
                            {
                                board[row1][col1] = 'Q';
                                board[row2][col2] = board[row2][col2];
                                click = 0;
                            }

                            else
                            {
                                if (board[row2][col2] == 'P' || board[row2][col2] == 'B' || 
                                    board[row2][col2] == 'R' || board[row2][col2] == 'K' || 
                                    board[row2][col2] == 'Q' || board[row2][col2] == 'N' || 
                                    board[row2][col2] == 'C' || board[row2][col2] == 'E')
                                {
                                    board[row1][col1] = 'Q';
                                    board[row2][col2] = board[row2][col2];
                                }
                                else
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'Q';
                                    board[row1][col1] = ' ';
                                    if (KingCheck(krow, kcol) == true)
                                    {
                                        board[row1][col1] = 'Q';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'Q';
                                        board[row1][col1] = ' ';
                                        turn = 2;
                                    }

                                }
                            }
                        }
                        //Down
                        if(row2 > row1)
                        {
                            for (int RMoveC = row1+1; RMoveC < row2; RMoveC++)// Rook Move Check = RMoveC
                            {
                                if (board[RMoveC][col1] != ' ')
                                {
                                    RMoveCC -= 10;
                                }
                                else
                                {
                                    RMoveCC++;
                                }
                            }

                            if (RMoveCC < 0)
                            {
                                board[row1][col1] = 'Q';
                                board[row2][col2] = board[row2][col2];
                                click = 0;
                            }
                            else
                            {
                                if (board[row2][col2] == 'P' || board[row2][col2] == 'B' || 
                                    board[row2][col2] == 'R' || board[row2][col2] == 'K' || 
                                    board[row2][col2] == 'Q' || board[row2][col2] == 'N' || 
                                    board[row2][col2] == 'C' || board[row2][col2] == 'E')
                                {
                                    board[row1][col1] = 'Q';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'Q';
                                    board[row1][col1] = ' ';
                                    if (KingCheck(krow, kcol) == true)
                                    {
                                        board[row1][col1] = 'Q';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'Q';
                                        board[row1][col1] = ' ';
                                        turn = 2;
                                    }
                                }
                            }
                        }
                        //Left
                        if(col2 < col1)
                        {
                            for (int RMoveC = col1-1; RMoveC > col2; RMoveC--)// Rook Move Check = RMoveC
                            {
                                if (board[row1][RMoveC] != ' ')
                                {
                                    RMoveCC -= 10;
                                }
                                else
                                {
                                    RMoveCC++;
                                }
                            }

                            if (RMoveCC < 0)
                            {
                                board[row1][col1] = 'Q';
                                board[row2][col2] = board[row2][col2];
                                click = 0;
                            }
                            else
                            {
                                if (board[row2][col2] == 'P' || board[row2][col2] == 'B' || 
                                    board[row2][col2] == 'R' || board[row2][col2] == 'K' || 
                                    board[row2][col2] == 'Q' || board[row2][col2] == 'N' || 
                                    board[row2][col2] == 'C' || board[row2][col2] == 'E')
                                {
                                    board[row1][col1] = 'Q';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'Q';
                                    board[row1][col1] = ' ';
                                    if (KingCheck(krow, kcol) == true)
                                    {
                                        board[row1][col1] = 'Q';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'Q';
                                        board[row1][col1] = ' ';
                                        turn = 2;
                                    }
                                }
                            }
                        }
                        //Right
                        if(col2 > col1)
                        {
                            for (int RMoveC = col1+1; RMoveC < col2; RMoveC++)// Rook Move Check = RMoveC
                            {
                                if (board[row1][RMoveC] != ' ')
                                {
                                    RMoveCC -= 10;
                                }
                                else
                                {
                                    RMoveCC++;
                                }
                            }

                            if (RMoveCC < 0)
                            {
                                board[row1][col1] = 'Q';
                                board[row2][col2] = board[row2][col2];
                                click = 0;
                            }
                            else
                            {
                                if (board[row2][col2] == 'P' || board[row2][col2] == 'B' || 
                                    board[row2][col2] == 'R' || board[row2][col2] == 'K' || 
                                    board[row2][col2] == 'Q' || board[row2][col2] == 'N' || 
                                    board[row2][col2] == 'C' || board[row2][col2] == 'E')
                                {
                                    board[row1][col1] = 'Q';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'Q';
                                    board[row1][col1] = ' ';
                                    if (KingCheck(krow, kcol) == true)
                                    {
                                        board[row1][col1] = 'Q';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'Q';
                                        board[row1][col1] = ' ';
                                        turn = 2;
                                    }
                                }
                            }
                        }
                    }
                }
                //WHITE KNIGHT
                if(board[row1][col1] == 'N')
                {
                    if(row2 == row1-2 && col2 == col1-1) //UpLeftVert
                    {
                        if(board[row2][col2] == ' ' || board[row2][col2] == 'L'
                        || board[row2][col2] == 'F' || board[row2][col2] == 'V' 
                        || board[row2][col2] == 'J' || board[row2][col2] == 'H' 
                        || board[row2][col2] == 'Y' || board[row2][col2] == 'Z' )
                        {
                            checkchar = board[row2][col2];
                            board[row2][col2] = 'N';
                            board[row1][col1] = ' ';
                            if (KingCheck(krow, kcol) == true)
                            {
                                board[row1][col1] = 'N';
                                board[row2][col2] = checkchar;
                                click = 0;
                            }
                            else
                            {
                                board[row2][col2] = 'N';
                                board[row1][col1] = ' ';
                                turn = 2;
                            }
                        }
                    }
                    else if(row2 == row1-1 && col2 == col1-2) //UpLeftDiag
                    {
                        if(board[row2][col2] == ' ' || board[row2][col2] == 'L'
                        || board[row2][col2] == 'F' || board[row2][col2] == 'V' 
                        || board[row2][col2] == 'J' || board[row2][col2] == 'H' 
                        || board[row2][col2] == 'Y' || board[row2][col2] == 'Z' )
                        {
                            checkchar = board[row2][col2];
                            board[row2][col2] = 'N';
                            board[row1][col1] = ' ';
                            if (KingCheck(krow, kcol) == true)
                            {
                                board[row1][col1] = 'N';
                                board[row2][col2] = checkchar;
                                click = 0;
                            }
                            else
                            {
                                board[row2][col2] = 'N';
                                board[row1][col1] = ' ';
                                turn = 2;
                            }
                        }
                    }
                    else if(row2 == row1-2 && col2 == col1+1) //UpRightVert
                    {
                        if(board[row2][col2] == ' ' || board[row2][col2] == 'L'
                        || board[row2][col2] == 'F' || board[row2][col2] == 'V' 
                        || board[row2][col2] == 'J' || board[row2][col2] == 'H' 
                        || board[row2][col2] == 'Y' || board[row2][col2] == 'Z' )
                        {
                            checkchar = board[row2][col2];
                            board[row2][col2] = 'N';
                            board[row1][col1] = ' ';
                            if (KingCheck(krow, kcol) == true)
                            {
                                board[row1][col1] = 'N';
                                board[row2][col2] = checkchar;
                                click = 0;
                            }
                            else
                            {
                                board[row2][col2] = 'N';
                                board[row1][col1] = ' ';
                                turn = 2;
                            }
                        }
                    }
                    else if(row2 == row1-1 && col2 == col1+2) //UpRightDiag
                    {
                        if(board[row2][col2] == ' ' || board[row2][col2] == 'L'
                        || board[row2][col2] == 'F' || board[row2][col2] == 'V' 
                        || board[row2][col2] == 'J' || board[row2][col2] == 'H' 
                        || board[row2][col2] == 'Y' || board[row2][col2] == 'Z' )
                        {
                            checkchar = board[row2][col2];
                            board[row2][col2] = 'N';
                            board[row1][col1] = ' ';
                            if (KingCheck(krow, kcol) == true)
                            {
                                board[row1][col1] = 'N';
                                board[row2][col2] = checkchar;
                                click = 0;
                            }
                            else
                            {
                                board[row2][col2] = 'N';
                                board[row1][col1] = ' ';
                                turn = 2;
                            }
                        }
                    }

                    else if(row2 == row1+1 && col2 == col1-2) //DownLeftDiag
                    {
                        if(board[row2][col2] == ' ' || board[row2][col2] == 'L'
                        || board[row2][col2] == 'F' || board[row2][col2] == 'V' 
                        || board[row2][col2] == 'J' || board[row2][col2] == 'H' 
                        || board[row2][col2] == 'Y' || board[row2][col2] == 'Z' )
                        {
                            checkchar = board[row2][col2];
                            board[row2][col2] = 'N';
                            board[row1][col1] = ' ';
                            if (KingCheck(krow, kcol) == true)
                            {
                                board[row1][col1] = 'N';
                                board[row2][col2] = checkchar;
                                click = 0;
                            }
                            else
                            {
                                board[row2][col2] = 'N';
                                board[row1][col1] = ' ';
                                turn = 2;
                            }
                        }
                    }
                    else if(row2 == row1+2 && col2 == col1-1) //DownLeftVert
                    {
                        if(board[row2][col2] == ' ' || board[row2][col2] == 'L'
                        || board[row2][col2] == 'F' || board[row2][col2] == 'V' 
                        || board[row2][col2] == 'J' || board[row2][col2] == 'H' 
                        || board[row2][col2] == 'Y' || board[row2][col2] == 'Z' )
                        {
                            checkchar = board[row2][col2];
                            board[row2][col2] = 'N';
                            board[row1][col1] = ' ';
                            if (KingCheck(krow, kcol) == true)
                            {
                                board[row1][col1] = 'N';
                                board[row2][col2] = checkchar;
                                click = 0;
                            }
                            else
                            {
                                board[row2][col2] = 'N';
                                board[row1][col1] = ' ';
                                turn = 2;
                            }
                        }
                    }
                    else if(row2 == row1+1 && col2 == col1+2) //DownRightDiag
                    {
                        if(board[row2][col2] == ' ' || board[row2][col2] == 'L'
                        || board[row2][col2] == 'F' || board[row2][col2] == 'V' 
                        || board[row2][col2] == 'J' || board[row2][col2] == 'H' 
                        || board[row2][col2] == 'Y' || board[row2][col2] == 'Z' )
                        {
                            checkchar = board[row2][col2];
                            board[row2][col2] = 'N';
                            board[row1][col1] = ' ';
                            if (KingCheck(krow, kcol) == true)
                            {
                                board[row1][col1] = 'N';
                                board[row2][col2] = checkchar;
                                click = 0;
                            }
                            else
                            {
                                board[row2][col2] = 'N';
                                board[row1][col1] = ' ';
                                turn = 2;
                            }
                        }
                    }
                    else if(row2 == row1+2 && col2 == col1+1) //DownRightVert
                    {
                        if(board[row2][col2] == ' ' || board[row2][col2] == 'L'
                        || board[row2][col2] == 'F' || board[row2][col2] == 'V' 
                        || board[row2][col2] == 'J' || board[row2][col2] == 'H' 
                        || board[row2][col2] == 'Y' || board[row2][col2] == 'Z' )
                        {
                            checkchar = board[row2][col2];
                            board[row2][col2] = 'N';
                            board[row1][col1] = ' ';
                            if (KingCheck(krow, kcol) == true)
                            {
                                board[row1][col1] = 'N';
                                board[row2][col2] = checkchar;
                                click = 0;
                            }
                            else
                            {
                                board[row2][col2] = 'N';
                                board[row1][col1] = ' ';
                                turn = 2;
                                
                            }
                        }
                    }
                    else
                    {
                        board[row1][col1] = 'N';
                        board[row2][col2] = board[row2][col2];
                        turn = 1;
                        click = 0;
                    }
                }
                if(board[row1][col1] == 'K' && turn == 1)
                {
                	WhiteKing(row1, col1, row2, col2);
                }
                repaint();
            }

            
            //TURN TWO/BLACK
            if (turn == 2)
            {
                for (int i = 0; i <= 7; i++)
                {
                    for (int j = 0; j <= 7; j++)
                    {
                        if (board[i][j] == 'Y')
                        {
                            board[i][j] = 'L';
                        }
                    }
                }
                
                if (board[row1][col1] == 'L')
                {
                    if(row2 == 7)
                    {
                        if (row2 == row1+1 && col1 == col2 && board[row2][col2] == ' ') //Down one empty square
                        {
                            checkchar = board[row2][col2];
                            board[row2][col2] = 'L';
                            board[row1][col1] = ' ';
                            if (KingCheck(krow, kcol) == true)
                            {
                                board[row1][col1] = 'L';
                                board[row2][col2] = checkchar;
                                click = 0;
                            }
                            else
                            {
                                board[row2][col2] = 'L';
                                board[row1][col1] = ' ';
                                String Wpromotion = JOptionPane.showInputDialog(null, "What Piece?");
                                
                                if (Wpromotion.equalsIgnoreCase("Queen"))
                                {
                                    board[row2][col2] = 'F';
                                    board[row1][col1] = ' ';
                                    turn = 1;
                                }
                                else if (Wpromotion.equalsIgnoreCase("Rook"))
                                {
                                    board[row2][col2] = 'Z';
                                    board[row1][col1] = ' ';
                                    turn = 1;
                                }
                                else if (Wpromotion.equalsIgnoreCase("Bishop"))
                                {
                                    board[row2][col2] = 'V';
                                    board[row1][col1] = ' ';
                                    turn = 1;
                                }
                                else if (Wpromotion.equalsIgnoreCase("Knight") || Wpromotion.equalsIgnoreCase("night" ) || Wpromotion.equalsIgnoreCase("horse"))
                                {
                                    board[row2][col2] = 'J';
                                    board[row1][col1] = ' ';
                                    turn = 1;
                                }
                                else
                                {
                                    board[row2][col2] = 'F';
                                    board[row1][col1] = ' ';
                                    turn = 1;
                                }
                            }

                        }
                        else if (row2 == row1+1 && col2 == col1-1 || col2 == col1+1 && row2 == row1+1) //If a piece is downwards one square diagonal to pawn you are able to take it
                        {
                            if (board[row2][col2] == 'P' || board[row2][col2] == 'B' || 
                            	board[row2][col2] == 'N' || board[row2][col2] == 'Q' || 
                            	board[row2][col2] == 'R' || board[row2][col2] == 'E' || 
                                board[row2][col2] == 'C')
                            {
                                if (board[row2][col2] == ' ') //If it is an empty square to capture, return to original position
                                {
                                    board[row1][col1] = 'L';
                                    board[row2][col2] = board[row2][col2];
                                    turn = 2;
                                    click = 0;

                                }
                                else //If the square is one of the pieces mentioned above
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'L';
                                    board[row1][col1] = ' ';
                                    if (KingCheck(krow, kcol) == true)
                                    {
                                        board[row1][col1] = 'L';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'L';
                                        board[row1][col1] = ' ';
                                        String Wpromotion = JOptionPane.showInputDialog(null, "What Piece?");
                                        
                                        if (Wpromotion.equalsIgnoreCase("Queen"))
                                        {
                                            board[row2][col2] = 'F';
                                            board[row1][col1] = ' ';
                                            turn = 2;
                                        }
                                        else if (Wpromotion.equalsIgnoreCase("Rook"))
                                        {
                                            board[row2][col2] = 'Z';
                                            board[row1][col1] = ' ';
                                            turn = 2;
                                        }
                                        else if (Wpromotion.equalsIgnoreCase("Bishop"))
                                        {
                                            board[row2][col2] = 'V';
                                            board[row1][col1] = ' ';
                                            turn = 2;
                                        }
                                        else if (Wpromotion.equalsIgnoreCase("Knight") || Wpromotion.equalsIgnoreCase("night" ) || Wpromotion.equalsIgnoreCase("horse"))
                                        {
                                            board[row2][col2] = 'J';
                                            board[row1][col1] = ' ';
                                            turn = 2;
                                        }
                                        else
                                        {
                                            board[row2][col2] = 'F';
                                            board[row1][col1] = ' ';
                                            turn = 2;
                                        }
                                    }
                                }
                            }   
                        }
                    }
                    else if (row2 == row1+1 && col1 == col2 && board[row2][col2] == ' ') //Down one empty square
                    {
                        checkchar = board[row2][col2];
                        board[row2][col2] = 'L';
                        board[row1][col1] = ' ';
                        if (BKingCheck(bkrow, bkcol) == true)
                        {
                            board[row1][col1] = 'L';
                            board[row2][col2] = checkchar;
                            click = 0;
                        }
                        else
                        {
                            board[row2][col2] = 'L';
                            board[row1][col1] = ' ';
                            turn = 1;
                        }
                    }
                    else if (row2 == row1+1 && col2 == col1-1 || col2 == col1+1 && row2 == row1+1) //If a piece is downwards one square diagonal to pawn you are able to take it
                    {
                        if (board[row2][col2] == 'P' || board[row2][col2] == 'B' || 
                        	board[row2][col2] == 'N' || board[row2][col2] == 'Q' || 
                        	board[row2][col2] == 'R' || board[row2][col2] == ' ' || 
                        	board[row2][col2] == 'E' || board[row2][col2] == 'C')
                        {
                            if(board[row2-1][col2] == 'E' && row2-1 == 4)
                            {
                                checkchar = board[row2][col2];
                                board[row2][col2] = 'L';
                                board[row1][col1] = ' ';
                                board[row2-1][col2] = ' ';
                                if (BKingCheck(bkrow, bkcol) == true)
                                {
                                    board[row1][col1] = 'L';
                                    board[row2][col2] = checkchar;
                                    board[row2-1][col2] = 'E';
                                    click = 0;
                                }
                                else
                                {
                                    board[row2][col2] = 'L';
                                    board[row1][col1] = ' ';
                                    board[row2-1][col2] = ' ';

                                    turn = 1;
                                }
                            }
                            else if (board[row2][col2] == ' ') //If it is an empty square to capture, return to original position
                            {
                                board[row1][col1] = 'L';
                                board[row2][col2] = board[row2][col2];
                                turn = 2;
                                click = 0;
                            }

                            else //If the square is one of the pieces mentioned above
                            {
                                checkchar = board[row2][col2];
                                board[row2][col2] = 'L';
                                board[row1][col1] = ' ';
                                if (BKingCheck(bkrow, bkcol) == true)
                                {
                                    board[row1][col1] = 'L';
                                    board[row2][col2] = checkchar;
                                    click = 0;
                                }
                                else
                                {
                                    board[row2][col2] = 'L';
                                    board[row1][col1] = ' ';
                                    turn = 1;
                                }
                            }
                        }   
                    }

                    else if (row2 == 3 && board[row1][col1] == board[1][col1] && col2 == col1)
                    {
                        if (board[2][col1] == ' ' && board[3][col1] == ' ')
                        {
                            checkchar = board[row2][col2];
                            board[row2][col2] = 'L';
                            board[row1][col1] = ' ';
                            if (BKingCheck(bkrow, bkcol) == true)
                            {
                                board[row1][col1] = 'L';
                                board[row2][col2] = checkchar;
                                click = 0;
                            }
                            else
                            {
                                board[row2][col2] = 'Y';
                                board[row1][col1] = ' ';
                                turn = 1;
                            }
                        }
                    }
                    else if (!(row2 == row1+1 && col2 == col1-1 || col2 == col1+1))
                    {
                        board[row1][col1] = 'L';
                        board[row2][col2] = board[row2][col2];
                        turn = 2;
                        click = 0;
                    }
                }

                if (board[row1][col1] == 'Y') // EN PASSANT PAWN
                {

                    if (row2 == row1+1 && col1 == col2 && board[row2][col2] == ' ') //Down one empty square
                    {
                        checkchar = board[row2][col2];
                        board[row2][col2] = 'L';
                        board[row1][col1] = ' ';
                        if (BKingCheck(bkrow, bkcol) == true)
                        {
                            board[row1][col1] = 'L';
                            board[row2][col2] = checkchar;
                            click = 0;
                        }
                        else
                        {
                            board[row2][col2] = 'L';
                            board[row1][col1] = ' ';
                            turn = 1;
                        }

                    }
                    else if (row2 == row1+1 && col2 == col1-1 || col2 == col1+1 && row2 == row1+1) //If a piece is downwards one square diagonal to pawn you are able to take it
                    {
                        if (board[row2][col2] == 'P' || board[row2][col2] == 'B' || 
                            board[row2][col2] == 'N' || board[row2][col2] == 'Q' || 
                            board[row2][col2] == 'R' || board[row2][col2] == ' ' || 
                            board[row2][col2] == 'E' || board[row2][col2] == 'C')
                        {
                            if(board[row2-1][col2] == 'E' && row2-1 == 4)
                            {

                                checkchar = board[row2][col2];
                                board[row2][col2] = 'L';
                                board[row1][col1] = ' ';
                                board[row2-1][col2] = ' ';
                                if (BKingCheck(bkrow, bkcol) == true)
                                {
                                    board[row1][col1] = 'L';
                                    board[row2][col2] = checkchar;
                                    board[row2-1][col2] = 'E';
                                    click = 0;
                                }
                                else
                                {
                                    board[row2][col2] = 'L';
                                    board[row1][col1] = ' ';
                                    board[row2-1][col2] = ' ';

                                    turn = 1;
                                }
                            }
                            else if (board[row2][col2] == ' ') //If it is an empty square to capture, return to original position
                            {
                                board[row1][col1] = 'L';
                                board[row2][col2] = board[row2][col2];
                                turn = 2;
                                click = 0;
                            }

                            else //If the square is one of the pieces mentioned above
                            {
                                checkchar = board[row2][col2];
                                board[row2][col2] = 'Y';
                                board[row1][col1] = ' ';
                                if (BKingCheck(bkrow, bkcol) == true)
                                {
                                    board[row1][col1] = 'Y';
                                    board[row2][col2] = checkchar;
                                    click = 0;
                                }
                                else
                                {
                                    board[row2][col2] = 'Y';
                                    board[row1][col1] = ' ';
                                    turn = 1;
                                }
                            }
                        }   
                    }

                    else if (row2 == 3 && board[row1][col1] == board[1][col1] && col2 == col1)
                    {
                        if (board[2][col1] == ' ' && board[3][col1] == ' ')
                        {
                            checkchar = board[row2][col2];
                            board[row2][col2] = 'Y';
                            board[row1][col1] = ' ';
                            if (BKingCheck(bkrow, bkcol) == true)
                            {
                                board[row1][col1] = 'Y';
                                board[row2][col2] = checkchar;
                                click = 0;
                            }
                            else
                            {
                                board[row2][col2] = 'Y';
                                board[row1][col1] = ' ';
                                turn = 1;
                            }
                        }
                    }
                    else if (!(row2 == row1+1 && col2 == col1-1 || col2 == col1+1))
                    {
                        board[row1][col1] = 'L';
                        board[row2][col2] = board[row2][col2];
                        turn = 2;
                        click = 0;
                    }
                }

                //BLACK ROOK

                if (board[row1][col1] == 'H')
                {
                    int RMoveCC = 0;
                    if (row2 == row1 || col2 == col1)
                    {
                        //Up 
                        if(row2 < row1)
                        {
                            for (int RMoveC = row1-1; RMoveC > row2; RMoveC--)// Rook Move Check = RMoveC
                            {
                                if (board[RMoveC][col1] != ' ')
                                {
                                    RMoveCC -= 10;
                                }

                                else
                                {
                                    RMoveCC++;
                                }
                            }

                            if (RMoveCC < 0)
                            {
                                board[row1][col1] = 'H';
                                board[row2][col2] = board[row2][col2];
                                click = 0;
                            }

                            else
                            {
                            	if (board[row2][col2] == 'L' || board[row2][col2] == 'M' || 
                                    board[row2][col2] == 'V' || board[row2][col2] == 'F' || 
                                    board[row2][col2] == 'H' || board[row2][col2] == 'J' || 
                                    board[row2][col2] == 'Y' || board[row2][col2] == 'Z' ||
                                    board[row2][col2] == 'K')
                                {
                                    board[row1][col1] = 'H';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'Z';
                                    board[row1][col1] = ' ';
                                    if (BKingCheck(bkrow, bkcol) == true)
                                    {
                                        board[row1][col1] = 'Z';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'Z';
                                        board[row1][col1] = ' ';
                                        turn = 1;
                                    }
                                }
                            }
                        }
                        //Down
                        if(row2 > row1)
                        {
                            for (int RMoveC = row1+1; RMoveC < row2; RMoveC++)// Rook Move Check = RMoveC
                            {
                                if (board[RMoveC][col1] != ' ')
                                {
                                    RMoveCC -= 10;
                                }
                                else
                                {
                                    RMoveCC++;
                                }
                            }

                            if (RMoveCC < 0)
                            {
                                board[row1][col1] = 'H';
                                board[row2][col2] = board[row2][col2];
                                click = 0;
                            }
                            else
                            {
                            	if (board[row2][col2] == 'L' || board[row2][col2] == 'M' || 
                                    board[row2][col2] == 'V' || board[row2][col2] == 'F' || 
                                    board[row2][col2] == 'H' || board[row2][col2] == 'J' || 
                                    board[row2][col2] == 'Y' || board[row2][col2] == 'Z' ||
                                    board[row2][col2] == 'K')
                                {
                                    board[row1][col1] = 'H';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'Z';
                                    board[row1][col1] = ' ';
                                    if (BKingCheck(bkrow, bkcol) == true)
                                    {
                                        board[row1][col1] = 'Z';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'Z';
                                        board[row1][col1] = ' ';
                                        turn = 1;
                                    }
                                }
                            }
                        }
                        //Left
                        if(col2 < col1)
                        {
                            for (int RMoveC = col1-1; RMoveC > col2; RMoveC--)// Rook Move Check = RMoveC
                            {
                                if (board[row1][RMoveC] != ' ')
                                {
                                    RMoveCC -= 10;
                                }
                                else
                                {
                                    RMoveCC++;
                                }

                            }

                            if (RMoveCC < 0)
                            {
                                board[row1][col1] = 'H';
                                board[row2][col2] = board[row2][col2];
                                click = 0;
                            }
                            else
                            {
                            	if (board[row2][col2] == 'L' || board[row2][col2] == 'M' || 
                                    board[row2][col2] == 'V' || board[row2][col2] == 'F' || 
                                    board[row2][col2] == 'H' || board[row2][col2] == 'J' || 
                                    board[row2][col2] == 'Y' || board[row2][col2] == 'Z' ||
                                    board[row2][col2] == 'K')
                                {
                                    board[row1][col1] = 'H';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'Z';
                                    board[row1][col1] = ' ';
                                    if (BKingCheck(bkrow, bkcol) == true)
                                    {
                                        board[row1][col1] = 'Z';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'Z';
                                        board[row1][col1] = ' ';
                                        turn = 1;
                                    }
                                }
                            }
                        }
                        //Right
                        if(col2 > col1)
                        {
                            for (int RMoveC = col1+1; RMoveC < col2; RMoveC++)// Rook Move Check = RMoveC
                            {
                                if (board[row1][RMoveC] != ' ')
                                {
                                    RMoveCC -= 10;
                                }
                                else
                                {
                                    RMoveCC++;
                                }
                            }

                            if (RMoveCC < 0)
                            {
                                board[row1][col1] = 'H';
                                board[row2][col2] = board[row2][col2];
                                click = 0;
                            }
                            else
                            {
                                if (board[row2][col2] == 'L' || board[row2][col2] == 'M' || 
                                    board[row2][col2] == 'V' || board[row2][col2] == 'F' || 
                                    board[row2][col2] == 'H' || board[row2][col2] == 'J' || 
                                    board[row2][col2] == 'Y' || board[row2][col2] == 'Z' ||
                                    board[row2][col2] == 'K')
                                {
                                    board[row1][col1] = 'H';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'Z';
                                    board[row1][col1] = ' ';
                                    if (BKingCheck(bkrow, bkcol) == true)
                                    {
                                        board[row1][col1] = 'Z';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'Z';
                                        board[row1][col1] = ' ';
                                        turn = 1;
                                    }
                                }
                            }
                        }
                    }
                }

                
                if (board[row1][col1] == 'Z')
                {
                    int RMoveCC = 0;
                    if (row2 == row1 || col2 == col1)
                    {
                        //Up 
                        if(row2 < row1)
                        {
                            for (int RMoveC = row1-1; RMoveC > row2; RMoveC--)// Rook Move Check = RMoveC
                            {
                                if (board[RMoveC][col1] != ' ')
                                {
                                    RMoveCC -= 10;
                                }

                                else
                                {
                                    RMoveCC++;
                                }
                            }

                            if (RMoveCC < 0)
                            {
                                board[row1][col1] = 'Z';
                                board[row2][col2] = board[row2][col2];
                                click = 0;
                            }

                            else
                            {
                            	if (board[row2][col2] == 'L' || board[row2][col2] == 'M' || 
                                    board[row2][col2] == 'V' || board[row2][col2] == 'F' || 
                                    board[row2][col2] == 'H' || board[row2][col2] == 'J' || 
                                    board[row2][col2] == 'Y' || board[row2][col2] == 'Z' ||
                                    board[row2][col2] == 'K')
                                {
                                    board[row1][col1] = 'Z';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'Z';
                                    board[row1][col1] = ' ';
                                    if (BKingCheck(bkrow, bkcol) == true)
                                    {
                                        board[row1][col1] = 'Z';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'Z';
                                        board[row1][col1] = ' ';
                                        turn = 1;
                                    }
                                }
                            }
                        }
                        //Down
                        if(row2 > row1)
                        {
                            for (int RMoveC = row1+1; RMoveC < row2; RMoveC++)// Rook Move Check = RMoveC
                            {
                                if (board[RMoveC][col1] != ' ')
                                {
                                    RMoveCC -= 10;
                                }
                                else
                                {
                                    RMoveCC++;
                                }
                            }

                            if (RMoveCC < 0)
                            {
                                board[row1][col1] = 'Z';
                                board[row2][col2] = board[row2][col2];
                                click = 0;
                            }
                            else
                            {
                            	if (board[row2][col2] == 'L' || board[row2][col2] == 'M' || 
                                    board[row2][col2] == 'V' || board[row2][col2] == 'F' || 
                                    board[row2][col2] == 'H' || board[row2][col2] == 'J' || 
                                    board[row2][col2] == 'Y' || board[row2][col2] == 'Z' ||
                                    board[row2][col2] == 'K')
                                {
                                    board[row1][col1] = 'Z';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'Z';
                                    board[row1][col1] = ' ';
                                    if (BKingCheck(bkrow, bkcol) == true)
                                    {
                                        board[row1][col1] = 'Z';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'Z';
                                        board[row1][col1] = ' ';
                                        turn = 1;
                                    }
                                }
                            }
                        }
                        //Left
                        if(col2 < col1)
                        {
                            for (int RMoveC = col1-1; RMoveC > col2; RMoveC--)// Rook Move Check = RMoveC
                            {
                                if (board[row1][RMoveC] != ' ')
                                {
                                    RMoveCC -= 10;
                                }
                                else
                                {
                                    RMoveCC++;
                                }
                            }

                            if (RMoveCC < 0)
                            {
                                board[row1][col1] = 'Z';
                                board[row2][col2] = board[row2][col2];
                                click = 0;
                            }
                            else
                            {
                            	if (board[row2][col2] == 'L' || board[row2][col2] == 'M' || 
                                    board[row2][col2] == 'V' || board[row2][col2] == 'F' || 
                                    board[row2][col2] == 'H' || board[row2][col2] == 'J' || 
                                    board[row2][col2] == 'Y' || board[row2][col2] == 'Z' ||
                                    board[row2][col2] == 'K')
                                {
                                    board[row1][col1] = 'Z';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'Z';
                                    board[row1][col1] = ' ';
                                    if (BKingCheck(bkrow, bkcol) == true)
                                    {
                                        board[row1][col1] = 'Z';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'Z';
                                        board[row1][col1] = ' ';
                                        turn = 1;
                                    }
                                }
                            }
                        }
                        //Right
                        if(col2 > col1)
                        {
                            for (int RMoveC = col1+1; RMoveC < col2; RMoveC++)// Rook Move Check = RMoveC
                            {
                                if (board[row1][RMoveC] != ' ')
                                {
                                    RMoveCC -= 10;
                                }
                                else
                                {
                                    RMoveCC++;
                                }
                            }

                            if (RMoveCC < 0)
                            {
                                board[row1][col1] = 'Z';
                                board[row2][col2] = board[row2][col2];
                                click = 0;
                            }
                            else
                            {
                                if (board[row2][col2] == 'L' || board[row2][col2] == 'M' || 
                                    board[row2][col2] == 'V' || board[row2][col2] == 'F' || 
                                    board[row2][col2] == 'H' || board[row2][col2] == 'J' || 
                                    board[row2][col2] == 'Y' || board[row2][col2] == 'Z' ||
                                    board[row2][col2] == 'K')
                                {
                                    board[row1][col1] = 'Z';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'Z';
                                    board[row1][col1] = ' ';
                                    if (BKingCheck(bkrow, bkcol) == true)
                                    {
                                        board[row1][col1] = 'Z';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'Z';
                                        board[row1][col1] = ' ';
                                        turn = 1;
                                    }
                                }
                            }
                        }
                    }
                }

                
                //BLACK BISHOP

                if (board[row1][col1] == 'V')
                {
                    int BMoveCC = 0;
                    if(col2 < col1 && row2 < row1) //LEFT UP
                    {
                        int BMoveY = row1-1;
                        int BMoveX = col1-1;
                        int count = col1-1;

                        for(int BDCY = row1-1;BDCY >= 0; BDCY--) //BDCY = Bishop Diagonal Check Y
                        {
                            int BDCX = col1-1;
                            for(BDCX = col1-1; BDCX > count; BDCX--){
                            }
                            count--;
                            if(row2 == BDCY && col2 == BDCX)
                            {

                                for (BMoveX = col1-1; BMoveX > col2; BMoveX--)// Bishop Move Check = BMoveX, x coordinate --- LEFT UP
                                {
                                    if (board[BMoveY][BMoveX] == ' ')
                                    {
                                        BMoveCC++; //If there isnt a SQUARE occupied with a piece before the second click then keep going
                                    }

                                    else
                                    {
                                        BMoveCC -= 10; //If there is a SQUARE occupied with a piece before the second click 
                                        //then final verdict wont allow for piece to be placed
                                    }
                                    BMoveY--;
                                }
                                if (BMoveCC < 0) //if there is a piece between bishop and destination
                                {
                                    board[row1][col1] = 'V';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else if(board[row2][col2] == 'P' || board[row2][col2] == 'B' || 
                                		board[row2][col2] == 'R' || board[row2][col2] == 'Q' || 
                                		board[row2][col2] == 'N' || board[row2][col2] == 'Y' || 
                                		board[row2][col2] == 'Y')
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'V';
                                    board[row1][col1] = ' ';
                                    if (BKingCheck(bkrow, bkcol) == true)
                                    {
                                        board[row1][col1] = 'V';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'V';
                                        board[row1][col1] = ' ';
                                        turn = 1;
                                    }
                                }
                                else if(board[row2][col2] == 'L' || board[row2][col2] == 'M' || 
                                    	board[row2][col2] == 'V' || board[row2][col2] == 'F' || 
                                    	board[row2][col2] == 'H' || board[row2][col2] == 'J' || 
                                    	board[row2][col2] == 'Y' || board[row2][col2] == 'Z' ||
                                    	board[row2][col2] == 'K')
                                {
                                    board[row1][col1] = 'V';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else //if there isnt a piece between bishop and destination
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'V';
                                    board[row1][col1] = ' ';
                                    if (BKingCheck(bkrow, bkcol) == true)
                                    {
                                        board[row1][col1] = 'V';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'V';
                                        board[row1][col1] = ' ';
                                        turn = 1;
                                    }
                                }
                            }
                        }
                    }
                    if(col2 > col1 && row2 > row1) //RIGHT DOWN
                    {
                        int BMoveY = row1+1;
                        int BMoveX = col1+1;
                        int count = col1+1;

                        for(int BDCY = row1+1;BDCY <= 7; BDCY++) //BDCY = Bishop Diagonal Check Y
                        {
                            int BDCX = col1+1;
                            for(BDCX = col1+1; BDCX < count; BDCX++){
                            }
                            count++;
                            if(row2 == BDCY && col2 == BDCX)
                            {

                                for (BMoveX = col1+1; BMoveX < col2; BMoveX++)// Bishop Move Check = BMoveX, x coordinate --- LEFT UP
                                {
                                    if (board[BMoveY][BMoveX] == ' ')
                                    {
                                        BMoveCC++; //If there isnt a SQUARE occupied with a piece before the second click then keep going
                                    }

                                    else
                                    {
                                        BMoveCC -= 10; //If there is a SQUARE occupied with a piece before the second click 
                                        //then final verdict wont allow for piece to be placed
                                    }
                                    BMoveY++;
                                }
                                if (BMoveCC < 0) //if there is a piece between bishop and destination
                                {
                                    board[row1][col1] = 'V';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else if(board[row2][col2] == 'P' || board[row2][col2] == 'B' || 
                                		board[row2][col2] == 'R' || board[row2][col2] == 'Q' || 
                                		board[row2][col2] == 'N' || board[row2][col2] == 'Y' || 
                                		board[row2][col2] == 'Y')
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'V';
                                    board[row1][col1] = ' ';
                                    if (BKingCheck(bkrow, bkcol) == true)
                                    {
                                        board[row1][col1] = 'V';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'V';
                                        board[row1][col1] = ' ';
                                        turn = 1;
                                    }
                                }
                                else if(board[row2][col2] == 'L' || board[row2][col2] == 'M' || 
                                    	board[row2][col2] == 'V' || board[row2][col2] == 'F' || 
                                    	board[row2][col2] == 'H' || board[row2][col2] == 'J' || 
                                    	board[row2][col2] == 'Y' || board[row2][col2] == 'Z' ||
                                    	board[row2][col2] == 'K')
                                {
                                    board[row1][col1] = 'V';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else //if there isnt a piece between bishop and destination
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'V';
                                    board[row1][col1] = ' ';
                                    if (BKingCheck(bkrow, bkcol) == true)
                                    {
                                        board[row1][col1] = 'V';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'V';
                                        board[row1][col1] = ' ';
                                        turn = 1;
                                    }
                                }
                            }
                        }
                    }
                    if(col2 > col1 && row2 < row1) //RIGHT UP
                    {
                        int BMoveY = row1-1;
                        int BMoveX = col1+1;
                        int count = col1+1;

                        for(int BDCY = row1-1;BDCY >= 0; BDCY--) //BDCY = Bishop Diagonal Check Y
                        {
                            int BDCX = col1+1;
                            for(BDCX = col1+1; BDCX < count; BDCX++){
                            }
                            count++;
                            if(row2 == BDCY && col2 == BDCX)
                            {

                                for (BMoveX = col1+1; BMoveX < col2; BMoveX++)// Bishop Move Check = BMoveX, x coordinate --- LEFT UP
                                {
                                    if (board[BMoveY][BMoveX] == ' ')
                                    {
                                        BMoveCC++; //If there isnt a SQUARE occupied with a piece before the second click then keep going
                                    }

                                    else
                                    {
                                        BMoveCC -= 10; //If there is a SQUARE occupied with a piece before the second click 
                                        //then final verdict wont allow for piece to be placed
                                    }
                                    BMoveY--;
                                }
                                if (BMoveCC < 0) //if there is a piece between bishop and destination
                                {
                                    board[row1][col1] = 'V';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else if(board[row2][col2] == 'P' || board[row2][col2] == 'B' || 
                                		board[row2][col2] == 'R' || board[row2][col2] == 'Q' || 
                                		board[row2][col2] == 'N' || board[row2][col2] == 'Y' || 
                                		board[row2][col2] == 'Y')
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'V';
                                    board[row1][col1] = ' ';
                                    if (BKingCheck(bkrow, bkcol) == true)
                                    {
                                        board[row1][col1] = 'V';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'V';
                                        board[row1][col1] = ' ';
                                        turn = 1;
                                    }
                                }
                                else if(board[row2][col2] == 'L' || board[row2][col2] == 'M' || 
                                    	board[row2][col2] == 'V' || board[row2][col2] == 'F' || 
                                    	board[row2][col2] == 'H' || board[row2][col2] == 'J' || 
                                    	board[row2][col2] == 'Y' || board[row2][col2] == 'Z' ||
                                    	board[row2][col2] == 'K')
                                {
                                    board[row1][col1] = 'V';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else //if there isnt a piece between bishop and destination
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'V';
                                    board[row1][col1] = ' ';
                                    if (BKingCheck(bkrow, bkcol) == true)
                                    {
                                        board[row1][col1] = 'V';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'V';
                                        board[row1][col1] = ' ';
                                        turn = 1;
                                    }
                                }
                            }
                        }
                    }
                    if(col2 < col1 && row2 > row1) //LEFT DOWN
                    {
                        int BMoveY = row1+1;
                        int BMoveX = col1-1;
                        int count = col1-1;

                        for(int BDCY = row1+1;BDCY <= 7; BDCY++) //BDCY = Bishop Diagonal Check Y
                        {
                            int BDCX = col1-1;
                            for(BDCX = col1-1; BDCX > count; BDCX--){
                            }
                            count--;
                            if(row2 == BDCY && col2 == BDCX)
                            {

                                for (BMoveX = col1-1; BMoveX > col2; BMoveX--)// Bishop Move Check = BMoveX, x coordinate --- LEFT UP
                                {
                                    if (board[BMoveY][BMoveX] == ' ')
                                    {
                                        BMoveCC++; //If there isnt a SQUARE occupied with a piece before the second click then keep going
                                    }

                                    else
                                    {
                                        BMoveCC -= 10; //If there is a SQUARE occupied with a piece before the second click 
                                        //then final verdict wont allow for piece to be placed
                                    }
                                    BMoveY++;
                                }
                                if (BMoveCC < 0) //if there is a piece between bishop and destination
                                {
                                    board[row1][col1] = 'V';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else if(board[row2][col2] == 'P' || board[row2][col2] == 'B' || 
                                		board[row2][col2] == 'R' || board[row2][col2] == 'Q' || 
                                		board[row2][col2] == 'N' || board[row2][col2] == 'Y' || 
                                		board[row2][col2] == 'Y')
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'V';
                                    board[row1][col1] = ' ';
                                    if (BKingCheck(bkrow, bkcol) == true)
                                    {
                                        board[row1][col1] = 'V';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'V';
                                        board[row1][col1] = ' ';
                                        turn = 1;
                                    }
                                }
                                else if(board[row2][col2] == 'L' || board[row2][col2] == 'M' || 
                                    	board[row2][col2] == 'V' || board[row2][col2] == 'F' || 
                                    	board[row2][col2] == 'H' || board[row2][col2] == 'J' || 
                                    	board[row2][col2] == 'Y' || board[row2][col2] == 'Z' ||
                                    	board[row2][col2] == 'K')
                                {
                                    board[row1][col1] = 'V';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else //if there isnt a piece between bishop and destination
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'V';
                                    board[row1][col1] = ' ';
                                    if (BKingCheck(bkrow, bkcol) == true)
                                    {
                                        board[row1][col1] = 'V';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'V';
                                        board[row1][col1] = ' ';
                                        turn = 1;
                                    }
                                }
                            }
                        }
                    }
                }
                //BlACK QUEEN
                if(board[row1][col1] == 'F')
                {
                    int BMoveCC = 0;
                    int RMoveCC = 0;
                    if(col2 < col1 && row2 < row1) //LEFT UP
                    {
                        int BMoveY = row1-1;
                        int BMoveX = col1-1;
                        int count = col1-1;

                        for(int BDCY = row1-1;BDCY >= 0; BDCY--) //BDCY = Bishop Diagonal Check Y
                        {
                            int BDCX = col1-1;
                            for(BDCX = col1-1; BDCX > count; BDCX--){
                            }
                            count--;
                            if(row2 == BDCY && col2 == BDCX)
                            {

                                for (BMoveX = col1-1; BMoveX > col2; BMoveX--)// Bishop Move Check = BMoveX, x coordinate --- LEFT UP
                                {
                                    if (board[BMoveY][BMoveX] == ' ')
                                    {
                                        BMoveCC++; //If there isnt a SQUARE occupied with a piece before the second click then keep going
                                    }

                                    else
                                    {
                                        BMoveCC -= 10; //If there is a SQUARE occupied with a piece before the second click 
                                        //then final verdict wont allow for piece to be placed
                                    }
                                    BMoveY--;
                                }
                                if (BMoveCC < 0) //if there is a piece between bishop and destination
                                {
                                    board[row1][col1] = 'F';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else if(board[row2][col2] == 'P' || board[row2][col2] == 'B' || 
                                		board[row2][col2] == 'R' || board[row2][col2] == 'Q' || 
                                		board[row2][col2] == 'N' || board[row2][col2] == 'Y' || 
                                		board[row2][col2] == 'Y')
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'F';
                                    board[row1][col1] = ' ';
                                    if (BKingCheck(bkrow, bkcol) == true)
                                    {
                                        board[row1][col1] = 'F';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'F';
                                        board[row1][col1] = ' ';
                                        turn = 1;
                                    }
                                }
                                else if(board[row2][col2] == 'L' || board[row2][col2] == 'M' || 
                                    	board[row2][col2] == 'V' || board[row2][col2] == 'F' || 
                                    	board[row2][col2] == 'H' || board[row2][col2] == 'J' || 
                                    	board[row2][col2] == 'Y' || board[row2][col2] == 'Z' ||
                                    	board[row2][col2] == 'K')
                                {
                                    board[row1][col1] = 'F';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else //if there isnt a piece between bishop and destination
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'F';
                                    board[row1][col1] = ' ';
                                    if (BKingCheck(bkrow, bkcol) == true)
                                    {
                                        board[row1][col1] = 'F';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'F';
                                        board[row1][col1] = ' ';
                                        turn = 1;
                                    }
                                }

                            }
                        }
                    }
                    if(col2 > col1 && row2 > row1) //RIGHT DOWN
                    {
                        int BMoveY = row1+1;
                        int BMoveX = col1+1;
                        int count = col1+1;

                        for(int BDCY = row1+1;BDCY <= 7; BDCY++) //BDCY = Bishop Diagonal Check Y
                        {
                            int BDCX = col1+1;
                            for(BDCX = col1+1; BDCX < count; BDCX++){
                            }
                            count++;
                            if(row2 == BDCY && col2 == BDCX)
                            {

                                for (BMoveX = col1+1; BMoveX < col2; BMoveX++)// Bishop Move Check = BMoveX, x coordinate --- LEFT UP
                                {
                                    if (board[BMoveY][BMoveX] == ' ')
                                    {
                                        BMoveCC++; //If there isnt a SQUARE occupied with a piece before the second click then keep going
                                    }

                                    else
                                    {
                                        BMoveCC -= 10; //If there is a SQUARE occupied with a piece before the second click 
                                        //then final verdict wont allow for piece to be placed
                                    }
                                    BMoveY++;
                                }
                                if (BMoveCC < 0) //if there is a piece between bishop and destination
                                {
                                    board[row1][col1] = 'F';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else if(board[row2][col2] == 'P' || board[row2][col2] == 'B' || 
                                		board[row2][col2] == 'R' || board[row2][col2] == 'Q' || 
                                		board[row2][col2] == 'N' || board[row2][col2] == 'Y' || 
                                		board[row2][col2] == 'Y')
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'F';
                                    board[row1][col1] = ' ';
                                    if (BKingCheck(bkrow, bkcol) == true)
                                    {
                                        board[row1][col1] = 'F';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'F';
                                        board[row1][col1] = ' ';
                                        turn = 1;
                                    }
                                }
                                else if(board[row2][col2] == 'L' || board[row2][col2] == 'M' || 
                                    	board[row2][col2] == 'V' || board[row2][col2] == 'F' || 
                                    	board[row2][col2] == 'H' || board[row2][col2] == 'J' || 
                                    	board[row2][col2] == 'Y' || board[row2][col2] == 'Z' ||
                                    	board[row2][col2] == 'K')
                                {
                                    board[row1][col1] = 'F';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else //if there isnt a piece between bishop and destination
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'F';
                                    board[row1][col1] = ' ';
                                    if (BKingCheck(bkrow, bkcol) == true)
                                    {
                                        board[row1][col1] = 'F';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'F';
                                        board[row1][col1] = ' ';
                                        turn = 1;
                                    }
                                }
                            }
                        }
                    }
                    if(col2 > col1 && row2 < row1) //RIGHT UP
                    {
                        int BMoveY = row1-1;
                        int BMoveX = col1+1;
                        int count = col1+1;

                        for(int BDCY = row1-1;BDCY >= 0; BDCY--) //BDCY = Bishop Diagonal Check Y
                        {
                            int BDCX = col1+1;
                            for(BDCX = col1+1; BDCX < count; BDCX++){
                            }
                            count++;
                            if(row2 == BDCY && col2 == BDCX)
                            {

                                for (BMoveX = col1+1; BMoveX < col2; BMoveX++)// Bishop Move Check = BMoveX, x coordinate --- LEFT UP
                                {
                                    if (board[BMoveY][BMoveX] == ' ')
                                    {
                                        BMoveCC++; //If there isnt a SQUARE occupied with a piece before the second click then keep going
                                    }

                                    else
                                    {
                                        BMoveCC -= 10; //If there is a SQUARE occupied with a piece before the second click 
                                        //then final verdict wont allow for piece to be placed
                                    }
                                    BMoveY--;
                                }
                                if (BMoveCC < 0) //if there is a piece between bishop and destination
                                {
                                    board[row1][col1] = 'F';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else if(board[row2][col2] == 'P' || board[row2][col2] == 'B' || 
                                		board[row2][col2] == 'R' || board[row2][col2] == 'Q' || 
                                		board[row2][col2] == 'N' || board[row2][col2] == 'Y' || 
                                		board[row2][col2] == 'Y')
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'F';
                                    board[row1][col1] = ' ';
                                    if (BKingCheck(bkrow, bkcol) == true)
                                    {
                                        board[row1][col1] = 'F';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'F';
                                        board[row1][col1] = ' ';
                                        turn = 1;
                                    }
                                }
                                else if(board[row2][col2] == 'L' || board[row2][col2] == 'M' || 
                                    	board[row2][col2] == 'V' || board[row2][col2] == 'F' || 
                                    	board[row2][col2] == 'H' || board[row2][col2] == 'J' || 
                                    	board[row2][col2] == 'Y' || board[row2][col2] == 'Z' ||
                                    	board[row2][col2] == 'K')
                                {
                                    board[row1][col1] = 'F';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else //if there isnt a piece between bishop and destination
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'F';
                                    board[row1][col1] = ' ';
                                    if (BKingCheck(bkrow, bkcol) == true)
                                    {
                                        board[row1][col1] = 'F';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'F';
                                        board[row1][col1] = ' ';
                                        turn = 1;
                                    }
                                }
                            }
                        }
                    }
                    if(col2 < col1 && row2 > row1) //LEFT DOWN
                    {
                        int BMoveY = row1+1;
                        int BMoveX = col1-1;
                        int count = col1-1;

                        for(int BDCY = row1+1;BDCY <= 7; BDCY++) //BDCY = Bishop Diagonal Check Y
                        {
                            int BDCX = col1-1;
                            for(BDCX = col1-1; BDCX > count; BDCX--){
                            }
                            count--;
                            if(row2 == BDCY && col2 == BDCX)
                            {

                                for (BMoveX = col1-1; BMoveX > col2; BMoveX--)// Bishop Move Check = BMoveX, x coordinate --- LEFT UP
                                {
                                    if (board[BMoveY][BMoveX] == ' ')
                                    {
                                        BMoveCC++; //If there isnt a SQUARE occupied with a piece before the second click then keep going
                                    }

                                    else
                                    {
                                        BMoveCC -= 10; //If there is a SQUARE occupied with a piece before the second click 
                                        //then final verdict wont allow for piece to be placed
                                    }
                                    BMoveY++;
                                }
                                if (BMoveCC < 0) //if there is a piece between bishop and destination
                                {
                                    board[row1][col1] = 'F';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else if(board[row2][col2] == 'P' || board[row2][col2] == 'B' || 
                                		board[row2][col2] == 'R' || board[row2][col2] == 'Q' || 
                                		board[row2][col2] == 'N' || board[row2][col2] == 'Y' || 
                                		board[row2][col2] == 'Y')
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'F';
                                    board[row1][col1] = ' ';
                                    if (BKingCheck(bkrow, bkcol) == true)
                                    {
                                        board[row1][col1] = 'F';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'F';
                                        board[row1][col1] = ' ';
                                        turn = 1;
                                    }
                                }
                                else if(board[row2][col2] == 'L' || board[row2][col2] == 'M' || 
                                    	board[row2][col2] == 'V' || board[row2][col2] == 'F' || 
                                    	board[row2][col2] == 'H' || board[row2][col2] == 'J' || 
                                    	board[row2][col2] == 'Y' || board[row2][col2] == 'Z' ||
                                    	board[row2][col2] == 'K')
                                {
                                    board[row1][col1] = 'F';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else //if there isnt a piece between bishop and destination
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'F';
                                    board[row1][col1] = ' ';
                                    if (BKingCheck(bkrow, bkcol) == true)
                                    {
                                        board[row1][col1] = 'F';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'F';
                                        board[row1][col1] = ' ';
                                        turn = 1;
                                    }
                                }
                            }
                        }
                    }
                    if (row2 == row1 || col2 == col1)
                    {
                        //Up 
                        if(row2 < row1)
                        {
                            for (int RMoveC = row1-1; RMoveC > row2; RMoveC--)// Rook Move Check = RMoveC
                            {
                                if (board[RMoveC][col1] != ' ')
                                {
                                    RMoveCC -= 10;
                                }

                                else
                                {
                                    RMoveCC++;
                                }
                            }

                            if (RMoveCC < 0)
                            {
                                board[row1][col1] = 'F';
                                board[row2][col2] = board[row2][col2];
                                click = 0;
                            }

                            else
                            {
                                if (board[row2][col2] == 'L' || board[row2][col2] == 'M' || 
                                    board[row2][col2] == 'V' || board[row2][col2] == 'F' || 
                                    board[row2][col2] == 'H' || board[row2][col2] == 'J' || 
                                    board[row2][col2] == 'Y' || board[row2][col2] == 'Z' ||
                                    board[row2][col2] == 'K')
                                {
                                    board[row1][col1] = 'F';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'F';
                                    board[row1][col1] = ' ';
                                    if (BKingCheck(bkrow, bkcol) == true)
                                    {
                                        board[row1][col1] = 'F';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'F';
                                        board[row1][col1] = ' ';
                                        turn = 1;
                                    }
                                }
                            }
                        }
                        //Down
                        if(row2 > row1)
                        {
                            for (int RMoveC = row1+1; RMoveC < row2; RMoveC++)// Rook Move Check = RMoveC
                            {
                                if (board[RMoveC][col1] != ' ')
                                {
                                    RMoveCC -= 10;
                                }
                                else
                                {
                                    RMoveCC++;
                                }
                            }

                            if (RMoveCC < 0)
                            {
                                board[row1][col1] = 'F';
                                board[row2][col2] = board[row2][col2];
                                click = 0;
                            }
                            else
                            {
                                if (board[row2][col2] == 'L' || board[row2][col2] == 'M' || 
                                    board[row2][col2] == 'V' || board[row2][col2] == 'F' || 
                                    board[row2][col2] == 'H' || board[row2][col2] == 'J' || 
                                    board[row2][col2] == 'Y' || board[row2][col2] == 'Z' ||
                                    board[row2][col2] == 'K')
                                {
                                    board[row1][col1] = 'F';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'F';
                                    board[row1][col1] = ' ';
                                    if (BKingCheck(bkrow, bkcol) == true)
                                    {
                                        board[row1][col1] = 'F';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'F';
                                        board[row1][col1] = ' ';
                                        turn = 1;
                                    }
                                }
                            }
                        }
                        //Left
                        if(col2 < col1)
                        {
                            for (int RMoveC = col1-1; RMoveC > col2; RMoveC--)// Rook Move Check = RMoveC
                            {
                                if (board[row1][RMoveC] != ' ')
                                {
                                    RMoveCC -= 10;
                                }
                                else
                                {
                                    RMoveCC++;
                                }
                            }

                            if (RMoveCC < 0)
                            {
                                board[row1][col1] = 'F';
                                board[row2][col2] = board[row2][col2];
                                click = 0;
                            }
                            else
                            {
                                if (board[row2][col2] == 'L' || board[row2][col2] == 'M' || 
                                    board[row2][col2] == 'V' || board[row2][col2] == 'F' || 
                                    board[row2][col2] == 'H' || board[row2][col2] == 'J' || 
                                    board[row2][col2] == 'Y' || board[row2][col2] == 'Z' ||
                                    board[row2][col2] == 'K')
                                {
                                    board[row1][col1] = 'F';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'F';
                                    board[row1][col1] = ' ';
                                    if (BKingCheck(bkrow, bkcol) == true)
                                    {
                                        board[row1][col1] = 'F';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'F';
                                        board[row1][col1] = ' ';
                                        turn = 1;
                                    }
                                }
                            }
                        }
                        //Right
                        if(col2 > col1)
                        {
                            for (int RMoveC = col1+1; RMoveC < col2; RMoveC++)// Rook Move Check = RMoveC
                            {
                                if (board[row1][RMoveC] != ' ')
                                {
                                    RMoveCC -= 10;
                                }
                                else
                                {
                                    RMoveCC++;
                                }
                            }

                            if (RMoveCC < 0)
                            {
                                board[row1][col1] = 'F';
                                board[row2][col2] = board[row2][col2];
                                click = 0;
                            }
                            else
                            {
                                if (board[row2][col2] == 'L' || board[row2][col2] == 'M' || 
                                	board[row2][col2] == 'V' || board[row2][col2] == 'F' || 
                                	board[row2][col2] == 'H' || board[row2][col2] == 'J' || 
                                	board[row2][col2] == 'Y' || board[row2][col2] == 'Z' ||
                                	board[row2][col2] == 'K')
                                {
                                    board[row1][col1] = 'F';
                                    board[row2][col2] = board[row2][col2];
                                    click = 0;
                                }
                                else
                                {
                                    checkchar = board[row2][col2];
                                    board[row2][col2] = 'F';
                                    board[row1][col1] = ' ';
                                    if (BKingCheck(bkrow, bkcol) == true)
                                    {
                                        board[row1][col1] = 'F';
                                        board[row2][col2] = checkchar;
                                        click = 0;
                                    }
                                    else
                                    {
                                        board[row2][col2] = 'F';
                                        board[row1][col1] = ' ';
                                        turn = 1;
                                    }
                                }
                            }
                        }
                    }
                }
                //BLACK KNIGHT
                if(board[row1][col1] == 'J')
                {
                    if(row2 == row1-2 && col2 == col1-1) //UpLeftVert
                    {
                    	if(board[row2][col2] == ' ' || board[row2][col2] == 'P'
                        || board[row2][col2] == 'Q' || board[row2][col2] == 'B' 
                        || board[row2][col2] == 'N' || board[row2][col2] == 'R' 
                        || board[row2][col2] == 'E' || board[row2][col2] == 'C' )
                        {
                            checkchar = board[row2][col2];
                            board[row2][col2] = 'J';
                            board[row1][col1] = ' ';
                            if (BKingCheck(bkrow, bkcol) == true)
                            {
                                board[row1][col1] = 'J';
                                board[row2][col2] = checkchar;
                                click = 0;
                            }
                            else
                            {
                                board[row2][col2] = 'J';
                                board[row1][col1] = ' ';
                                turn = 1;
                            }
                        }
                    }
                    else if(row2 == row1-1 && col2 == col1-2) //UpLeftDiag
                    {
                    	if(board[row2][col2] == ' ' || board[row2][col2] == 'P'
                        || board[row2][col2] == 'Q' || board[row2][col2] == 'B' 
                        || board[row2][col2] == 'N' || board[row2][col2] == 'R' 
                        || board[row2][col2] == 'E' || board[row2][col2] == 'C' )
                        {
                            checkchar = board[row2][col2];
                            board[row2][col2] = 'J';
                            board[row1][col1] = ' ';
                            if (BKingCheck(bkrow, bkcol) == true)
                            {
                                board[row1][col1] = 'J';
                                board[row2][col2] = checkchar;
                                click = 0;
                            }
                            else
                            {
                                board[row2][col2] = 'J';
                                board[row1][col1] = ' ';
                                turn = 1;
                            }
                        }
                    }
                    else if(row2 == row1-2 && col2 == col1+1) //UpRightVert
                    {

                    	if(board[row2][col2] == ' ' || board[row2][col2] == 'P'
                        || board[row2][col2] == 'Q' || board[row2][col2] == 'B' 
                        || board[row2][col2] == 'N' || board[row2][col2] == 'R' 
                        || board[row2][col2] == 'E' || board[row2][col2] == 'C' )
                        {
                            checkchar = board[row2][col2];
                            board[row2][col2] = 'J';
                            board[row1][col1] = ' ';
                            if (BKingCheck(bkrow, bkcol) == true)
                            {
                                board[row1][col1] = 'J';
                                board[row2][col2] = checkchar;
                                click = 0;
                            }
                            else
                            {
                                board[row2][col2] = 'J';
                                board[row1][col1] = ' ';
                                turn = 1;
                            }
                        }
                    }
                    else if(row2 == row1-1 && col2 == col1+2) //UpRightDiag
                    {
                    	if(board[row2][col2] == ' ' || board[row2][col2] == 'P'
                        || board[row2][col2] == 'Q' || board[row2][col2] == 'B' 
                        || board[row2][col2] == 'N' || board[row2][col2] == 'R' 
                        || board[row2][col2] == 'E' || board[row2][col2] == 'C' )
                        {
                            checkchar = board[row2][col2];
                            board[row2][col2] = 'J';
                            board[row1][col1] = ' ';
                            if (BKingCheck(bkrow, bkcol) == true)
                            {
                                board[row1][col1] = 'J';
                                board[row2][col2] = checkchar;
                                click = 0;
                            }
                            else
                            {
                                board[row2][col2] = 'J';
                                board[row1][col1] = ' ';
                                turn = 1;
                            }
                        }
                    }

                    else if(row2 == row1+1 && col2 == col1-2) //DownLeftDiag
                    {
                    	if(board[row2][col2] == ' ' || board[row2][col2] == 'P'
                        || board[row2][col2] == 'Q' || board[row2][col2] == 'B' 
                        || board[row2][col2] == 'N' || board[row2][col2] == 'R' 
                        || board[row2][col2] == 'E' || board[row2][col2] == 'C' )
                        {
                            checkchar = board[row2][col2];
                            board[row2][col2] = 'J';
                            board[row1][col1] = ' ';
                            if (BKingCheck(bkrow, bkcol) == true)
                            {
                                board[row1][col1] = 'J';
                                board[row2][col2] = checkchar;
                                click = 0;
                            }
                            else
                            {
                                board[row2][col2] = 'J';
                                board[row1][col1] = ' ';
                                turn = 1;
                            }
                        }
                    }
                    else if(row2 == row1+2 && col2 == col1-1) //DownLeftVert
                    {
                    	if(board[row2][col2] == ' ' || board[row2][col2] == 'P'
                        || board[row2][col2] == 'Q' || board[row2][col2] == 'B' 
                        || board[row2][col2] == 'N' || board[row2][col2] == 'R' 
                        || board[row2][col2] == 'E' || board[row2][col2] == 'C' )
                        {
                            checkchar = board[row2][col2];
                            board[row2][col2] = 'J';
                            board[row1][col1] = ' ';
                            if (BKingCheck(bkrow, bkcol) == true)
                            {
                                board[row1][col1] = 'J';
                                board[row2][col2] = checkchar;
                                click = 0;
                            }
                            else
                            {
                                board[row2][col2] = 'J';
                                board[row1][col1] = ' ';
                                turn = 1;
                            }
                        }
                    }
                    else if(row2 == row1+1 && col2 == col1+2) //DownRightDiag
                    {
                    	if(board[row2][col2] == ' ' || board[row2][col2] == 'P'
                        || board[row2][col2] == 'Q' || board[row2][col2] == 'B' 
                        || board[row2][col2] == 'N' || board[row2][col2] == 'R' 
                        || board[row2][col2] == 'E' || board[row2][col2] == 'C' )
                        {
                            checkchar = board[row2][col2];
                            board[row2][col2] = 'J';
                            board[row1][col1] = ' ';
                            if (BKingCheck(bkrow, bkcol) == true)
                            {
                                board[row1][col1] = 'J';
                                board[row2][col2] = checkchar;
                                click = 0;
                            }
                            else
                            {
                                board[row2][col2] = 'J';
                                board[row1][col1] = ' ';
                                turn = 1;
                            }
                        }
                    }
                    else if(row2 == row1+2 && col2 == col1+1) //DownRightVert
                    {
                    	if(board[row2][col2] == ' ' || board[row2][col2] == 'P'
                        || board[row2][col2] == 'Q' || board[row2][col2] == 'B' 
                        || board[row2][col2] == 'N' || board[row2][col2] == 'R' 
                        || board[row2][col2] == 'E' || board[row2][col2] == 'C' )
                        {
                            checkchar = board[row2][col2];
                            board[row2][col2] = 'J';
                            board[row1][col1] = ' ';
                            if (BKingCheck(bkrow, bkcol) == true)
                            {
                                board[row1][col1] = 'J';
                                board[row2][col2] = checkchar;
                                click = 0;
                            }
                            else
                            {
                                board[row2][col2] = 'J';
                                board[row1][col1] = ' ';
                                turn = 1;
                            }
                        }
                    }
                    else
                    {
                        board[row1][col1] = 'J';
                        board[row2][col2] = board[row2][col2];
                        turn = 2;
                        click = 0;
                    }
                }
            }
        }
        if(board[row1][col1] == 'M' && turn == 2)
        {
        BlackKing(row1, col1, row2, col2);}
        repaint();
    }
    public void WhiteKing(int row1, int col1, int row2, int col2)
    {
        if(board[row1][col1] == 'K')
        {
            if(row2 == row1-1 && col2 == col1-1)
            {
                if(board[row2][col2] == ' ' || board[row2][col2] == 'L'
                || board[row2][col2] == 'F' || board[row2][col2] == 'V' 
                || board[row2][col2] == 'J' || board[row2][col2] == 'H' 
                || board[row2][col2] == 'Y' || board[row2][col2] == 'Z' )
                {
                    repaint();
                    checkchar = board[row2][col2];
                    board[row2][col2] = 'K';
                    board[row1][col1] = ' ';
                    if (KingCheck(row2, col2) == true)
                    {
                        board[row1][col1] = 'K';
                        board[row2][col2] = checkchar;
                        turn = 1;
                        click = 0;
                        
                    }
                    else
                    {
                        board[row1][col1] = ' ';
                        board[row2][col2] = 'K';
                        krow = row2;
                        kcol = col2;
                        turn = 2;
                        kmoved = 1;
                        
                    }
                }
                else
                {
                    board[row1][col1] = 'K';
                    board[row2][col2] = board[row2][col2];
                    turn = 1;
                    click = 0;
                }
            }
            else if (row2 == row1-1 && col2 == col1)
            {
                if(board[row2][col2] == ' ' || board[row2][col2] == 'L'
                || board[row2][col2] == 'F' || board[row2][col2] == 'V' 
                || board[row2][col2] == 'J' || board[row2][col2] == 'H' 
                || board[row2][col2] == 'Y' || board[row2][col2] == 'Z' )
                {
                    repaint();
                    checkchar = board[row2][col2];
                    board[row2][col2] = 'K';
                    board[row1][col1] = ' ';
                    if (KingCheck(row2, col2) == true)
                    {
                        board[row1][col1] = 'K';
                        board[row2][col2] = checkchar;
                        turn = 1;
                        click = 0;
                    }
                    else
                    {
                        board[row1][col1] = ' ';
                        board[row2][col2] = 'K';
                        krow = row2;
                        kcol = col2;
                        turn = 2;
                        kmoved = 1;
                    }
                }
                else
                {
                    board[row1][col1] = 'K';
                    board[row2][col2] = board[row2][col2];
                    turn = 1;
                    click = 0;
                }
            }
            else if (row2 == row1-1 && col2 == col1+1)
            {
                if(board[row2][col2] == ' ' || board[row2][col2] == 'L'
                || board[row2][col2] == 'F' || board[row2][col2] == 'V' 
                || board[row2][col2] == 'J' || board[row2][col2] == 'H' 
                || board[row2][col2] == 'Y' || board[row2][col2] == 'Z' )
                {

                    repaint();
                    checkchar = board[row2][col2];
                    board[row2][col2] = 'K';
                    board[row1][col1] = ' ';
                    if (KingCheck(row2, col2) == true)
                    {
                        board[row1][col1] = 'K';
                        board[row2][col2] = checkchar;
                        turn = 1;
                        click = 0;
                    }
                    else
                    {
                        board[row1][col1] = ' ';
                        board[row2][col2] = 'K';
                        krow = row2;
                        kcol = col2;
                        turn = 2;
                        kmoved = 1;
                    }
                }
                else
                {
                    board[row1][col1] = 'K';
                    board[row2][col2] = board[row2][col2];
                    turn = 1;
                    click = 0;
                }
            }

            else if(row2 == row1 && col2 == col1-1)
            {
                if(board[row2][col2] == ' ' || board[row2][col2] == 'L'
                || board[row2][col2] == 'F' || board[row2][col2] == 'V' 
                || board[row2][col2] == 'J' || board[row2][col2] == 'H' 
                || board[row2][col2] == 'Y' || board[row2][col2] == 'Z' )
                {
                    repaint();
                    checkchar = board[row2][col2];
                    board[row2][col2] = 'K';
                    board[row1][col1] = ' ';
                    if (KingCheck(row2, col2) == true)
                    {
                        board[row1][col1] = 'K';
                        board[row2][col2] = checkchar;
                        turn = 1;
                        click = 0;
                    }
                    else
                    {
                        board[row1][col1] = ' ';
                        board[row2][col2] = 'K';
                        krow = row2;
                        kcol = col2;
                        turn = 2;
                        kmoved = 1;
                    }
                }
                else
                {
                    board[row1][col1] = 'K';
                    board[row2][col2] = board[row2][col2];
                    turn = 1;
                    click = 0;
                }
            }

            else if (row2 == row1 && col2 == col1+1)
            {
                if(board[row2][col2] == ' ' || board[row2][col2] == 'L'
                || board[row2][col2] == 'F' || board[row2][col2] == 'V' 
                || board[row2][col2] == 'J' || board[row2][col2] == 'H' 
                || board[row2][col2] == 'Y' || board[row2][col2] == 'Z' )
                {

                    repaint();
                    checkchar = board[row2][col2];
                    board[row2][col2] = 'K';
                    board[row1][col1] = ' ';
                    if (KingCheck(row2, col2) == true)
                    {
                        board[row1][col1] = 'K';
                        board[row2][col2] = checkchar;
                        turn = 1;
                        click = 0;
                    }
                    else
                    {
                        board[row1][col1] = ' ';
                        board[row2][col2] = 'K';
                        krow = row2;
                        kcol = col2;
                        turn = 2;
                        kmoved = 1;
                    }
                }
                else
                {
                    board[row1][col1] = 'K';
                    board[row2][col2] = board[row2][col2];
                    turn = 1;
                    click = 0;
                }
            }

            else if(row2 == row1+1 && col2 == col1-1)
            {
                if(board[row2][col2] == ' ' || board[row2][col2] == 'L'
                || board[row2][col2] == 'F' || board[row2][col2] == 'V' 
                || board[row2][col2] == 'J' || board[row2][col2] == 'H' 
                || board[row2][col2] == 'Y' || board[row2][col2] == 'Z' )
                {
                    repaint();
                    checkchar = board[row2][col2];
                    board[row2][col2] = 'K';
                    board[row1][col1] = ' ';
                    if (KingCheck(row2, col2) == true)
                    {
                        board[row1][col1] = 'K';
                        board[row2][col2] = checkchar;
                        turn = 1;
                        click = 0;
                    }
                    else
                    {
                        board[row1][col1] = ' ';
                        board[row2][col2] = 'K';
                        krow = row2;
                        kcol = col2;
                        turn = 2;
                        kmoved = 1;
                    }
                }
                else
                {
                    board[row1][col1] = 'K';
                    board[row2][col2] = board[row2][col2];
                    turn = 1;
                    click = 0;
                }
            }
            else if (row2 == row1+1 && col2 == col1)
            {
                if(board[row2][col2] == ' ' || board[row2][col2] == 'L'
                || board[row2][col2] == 'F' || board[row2][col2] == 'V' 
                || board[row2][col2] == 'J' || board[row2][col2] == 'H' 
                || board[row2][col2] == 'Y' || board[row2][col2] == 'Z' )
                {

                    repaint();
                    checkchar = board[row2][col2];
                    board[row2][col2] = 'K';
                    board[row1][col1] = ' ';
                    if (KingCheck(row2, col2) == true)
                    {
                        board[row1][col1] = 'K';
                        board[row2][col2] = checkchar;
                        turn = 1;
                        click = 0;
                    }
                    else
                    {
                        board[row1][col1] = ' ';
                        board[row2][col2] = 'K';
                        krow = row2;
                        kcol = col2;
                        turn = 2;
                        kmoved = 1;
                    }
                }   
                else
                {
                    board[row1][col1] = 'K';
                    board[row2][col2] = board[row2][col2];
                    turn = 1;
                    click = 0;
                }
            }
            else if (row2 == row1+1 && col2 == col1+1)
            {
                if(board[row2][col2] == ' ' || board[row2][col2] == 'L'
                || board[row2][col2] == 'F' || board[row2][col2] == 'V' 
                || board[row2][col2] == 'J' || board[row2][col2] == 'H' 
                || board[row2][col2] == 'Y' || board[row2][col2] == 'Z' )
                {

                    repaint();
                    checkchar = board[row2][col2];
                    board[row2][col2] = 'K';
                    board[row1][col1] = ' ';
                    if (KingCheck(row2, col2) == true)
                    {
                        board[row1][col1] = 'K';
                        board[row2][col2] = checkchar;
                        turn = 1;
                        click = 0;
                    }
                    else
                    {
                        board[row1][col1] = ' ';
                        board[row2][col2] = 'K';
                        krow = row2;
                        kcol = col2;
                        turn = 2;
                        kmoved = 1;
                    }
                }
                else
                {
                    board[row1][col1] = 'K';
                    board[row2][col2] = board[row2][col2];
                    turn = 1;
                    click = 0;
                }
            }
            else if (row2 == 7 && col2 == 6 && board[7][7] == 'R' && board[7][4] == 'K')
            {
                if (KingCheck(7, 6) == false && 
                    KingCheck(7, 5) == false && 
                    KingCheck(7, 4) == false && 
                    board[7][6] == ' ' && 
                    board[7][5] == ' ' && 
                    kmoved == 0)
                {
                    board[row1][col1] = ' ';
                    board[row2][col2] = 'K';
                    board[row2][col2-1] = 'C';
                    board[7][7] = ' ';
                    krow = row2;
                    kcol = col2;
                    turn = 2;
                }
                else
                {
                    board[row1][col1] = 'K';
                    board[row2][col2] = board[row2][col2];
                    turn = 1;
                    click = 0;
                }
            }
            else if (row2 == 7 && col2 == 2 && board[7][0] == 'R' && board[7][4] == 'K')
            {
                if ( 
                    KingCheck(7, 2) == false && 
                    KingCheck(7, 3) == false && 
                    KingCheck(7, 4) == false && 
                    board[7][1] == ' ' && 
                    board[7][2] == ' ' && 
                    board[7][3] == ' ' &&
                    kmoved == 0)
                {
                    board[row1][col1] = ' ';
                    board[row2][col2] = 'K';
                    board[row2][col2+1] = 'C';
                    board[7][0] = ' ';
                    krow = row2;
                    kcol = col2;
                    turn = 2;
                }
                else
                {
                    board[row1][col1] = 'K';
                    board[row2][col2] = board[row2][col2];
                    turn = 1;
                    click = 0;
                }
            }
        }
    }
    
    public void BlackKing(int row1, int col1, int row2, int col2) 
    {
    	  //Black King

        if(board[row1][col1] == 'M')
        {
            if(row2 == row1-1 && col2 == col1-1)
            {
                if(board[row2][col2] == ' ' || board[row2][col2] == 'P'
                || board[row2][col2] == 'Q' || board[row2][col2] == 'B' 
                || board[row2][col2] == 'N' || board[row2][col2] == 'R' 
                || board[row2][col2] == 'E' || board[row2][col2] == 'C' )
                {
                    repaint();
                    checkchar = board[row2][col2];
                    if (BKingCheck(row2, col2) == true)
                    {
                        board[row1][col1] = 'M';
                        board[row2][col2] = checkchar;
                        turn = 2;
                        click = 0;
                    }
                    else 
                    {
                        board[row1][col1] = ' ';
                        board[row2][col2] = 'M';
                        bkrow = row2;
                        bkcol = col2;
                        turn = 1;
                        bkmoved = 1;
                    }
                }
                else
                {
                    board[row1][col1] = 'M';
                    board[row2][col2] = board[row2][col2];
                    turn = 2;
                    click = 0;
                }
            }
            else if (row2 == row1-1 && col2 == col1)
            {
                if(board[row2][col2] == ' ' || board[row2][col2] == 'P'
                || board[row2][col2] == 'Q' || board[row2][col2] == 'B' 
                || board[row2][col2] == 'N' || board[row2][col2] == 'R' 
                || board[row2][col2] == 'E' || board[row2][col2] == 'C' )
                {
                    repaint();
                    checkchar = board[row2][col2];
                    if (BKingCheck(row2, col2) == true)
                    {
                        board[row1][col1] = 'M';
                        board[row2][col2] = checkchar;
                        turn = 2;
                        click = 0;
                    }
                    else
                    {
                        board[row1][col1] = ' ';
                        board[row2][col2] = 'M';
                        bkrow = row2;
                        bkcol = col2;
                        turn = 1;
                        bkmoved = 1;
                    }
                }
                else
                {
                    board[row1][col1] = 'M';
                    board[row2][col2] = board[row2][col2];
                    turn = 2;
                    click = 0;
                }
            }
            else if (row2 == row1-1 && col2 == col1+1)
            {
            	if(board[row2][col2] == ' ' || board[row2][col2] == 'P'
                || board[row2][col2] == 'Q' || board[row2][col2] == 'B' 
                || board[row2][col2] == 'N' || board[row2][col2] == 'R' 
                || board[row2][col2] == 'E' || board[row2][col2] == 'C' )
                {

                    repaint();
                    checkchar = board[row2][col2];
                    if (BKingCheck(row2, col2) == true)
                    {
                        board[row1][col1] = 'M';
                        board[row2][col2] = checkchar;
                        turn = 2;
                        click = 0;
                    }
                    else
                    {
                        board[row1][col1] = ' ';
                        board[row2][col2] = 'M';
                        bkrow = row2;
                        bkcol = col2;
                        turn = 2;
                        bkmoved = 1;
                    }
                }
                else
                {
                    board[row1][col1] = 'M';
                    board[row2][col2] = board[row2][col2];
                    turn = 2;
                    click = 0;
                }
            }

            else if(row2 == row1 && col2 == col1-1)
            {
            	if(board[row2][col2] == ' ' || board[row2][col2] == 'P'
                || board[row2][col2] == 'Q' || board[row2][col2] == 'B' 
                || board[row2][col2] == 'N' || board[row2][col2] == 'R' 
                || board[row2][col2] == 'E' || board[row2][col2] == 'C' )
                {
                    repaint();
                    checkchar = board[row2][col2];
                    if (BKingCheck(row2, col2) == true)
                    {
                        board[row1][col1] = 'M';
                        board[row2][col2] = checkchar;
                        turn = 2;
                        click = 0;
                    }
                    else
                    {
                        board[row1][col1] = ' ';
                        board[row2][col2] = 'M';
                        bkrow = row2;
                        bkcol = col2;
                        turn = 1;
                        bkmoved = 1;
                    }
                }
                else
                {
                    board[row1][col1] = 'M';
                    board[row2][col2] = board[row2][col2];
                    turn = 2;
                    click = 0;
                }
            }

            else if (row2 == row1 && col2 == col1+1)
            {
            	if(board[row2][col2] == ' ' || board[row2][col2] == 'P'
                || board[row2][col2] == 'Q' || board[row2][col2] == 'B' 
                || board[row2][col2] == 'N' || board[row2][col2] == 'R' 
                || board[row2][col2] == 'E' || board[row2][col2] == 'C' )
                {

                    repaint();
                    checkchar = board[row2][col2];
                    if (BKingCheck(row2, col2) == true)
                    {
                        board[row1][col1] = 'M';
                        board[row2][col2] = checkchar;
                        turn = 2;
                        click = 0;
                    }
                    else
                    {
                        board[row1][col1] = ' ';
                        board[row2][col2] = 'M';
                        bkrow = row2;
                        bkcol = col2;
                        turn = 1;
                        bkmoved = 1;
                    }
                }
                else
                {
                    board[row1][col1] = 'M';
                    board[row2][col2] = board[row2][col2];
                    turn = 2;
                    click = 0;
                }
            }

            else if(row2 == row1+1 && col2 == col1-1)
            {
            	if(board[row2][col2] == ' ' || board[row2][col2] == 'P'
                || board[row2][col2] == 'Q' || board[row2][col2] == 'B' 
                || board[row2][col2] == 'N' || board[row2][col2] == 'R' 
                || board[row2][col2] == 'E' || board[row2][col2] == 'C' )
                {
                    repaint();
                    checkchar = board[row2][col2];
                    if (BKingCheck(row2, col2) == true)
                    {
                        board[row1][col1] = 'M';
                        board[row2][col2] = board[row2][col2];
                        turn = 2;
                        click = 0;
                    }
                    else
                    {
                        board[row1][col1] = ' ';
                        board[row2][col2] = 'M';
                        bkrow = row2;
                        bkcol = col2;
                        turn = 1;
                        bkmoved = 1;
                    }
                }
                else
                {
                    board[row1][col1] = 'M';
                    board[row2][col2] = board[row2][col2];
                    turn = 2;
                    click = 0;
                }
            }
            else if (row2 == row1+1 && col2 == col1)
            {
            	if(board[row2][col2] == ' ' || board[row2][col2] == 'P'
                || board[row2][col2] == 'Q' || board[row2][col2] == 'B' 
                || board[row2][col2] == 'N' || board[row2][col2] == 'R' 
                || board[row2][col2] == 'E' || board[row2][col2] == 'C' )
                {

                    checkchar = board[row2][col2];
                    if (BKingCheck(row2, col2) == true)
                    {
                        board[row1][col1] = 'M';
                        board[row2][col2] = checkchar;
                        turn = 2;
                        click = 0;
                    }
                    else
                    {
                        board[row1][col1] = ' ';
                        board[row2][col2] = 'M';
                        bkrow = row2;
                        bkcol = col2;
                        turn = 1;
                        bkmoved = 1;
                    }
                }   
                else
                {
                    board[row1][col1] = 'M';
                    board[row2][col2] = board[row2][col2];
                    turn = 2;
                    click = 0;
                }
            }
            else if (row2 == row1+1 && col2 == col1+1)
            {
            	if(board[row2][col2] == ' ' || board[row2][col2] == 'P'
                || board[row2][col2] == 'Q' || board[row2][col2] == 'B' 
                || board[row2][col2] == 'N' || board[row2][col2] == 'R' 
                || board[row2][col2] == 'E' || board[row2][col2] == 'C' )
                {

                    repaint();
                    checkchar = board[row2][col2];
                    if (BKingCheck(row2, col2) == true)
                    {
                        board[row1][col1] = 'M';
                        board[row2][col2] = checkchar;
                        turn = 2;
                        click = 0;
                    }
                    else
                    {
                        board[row1][col1] = ' ';
                        board[row2][col2] = 'M';
                        bkrow = row2;
                        bkcol = col2;
                        turn = 1;
                        bkmoved = 1;
                    }
                }
                else
                {
                    board[row1][col1] = 'M';
                    board[row2][col2] = board[row2][col2];
                    turn = 2;
                    click = 0;
                }
            }
            else if (row2 == 0 && col2 == 6 && board[0][7] == 'H' && board[0][4] == 'M')
            {
                if (BKingCheck(0, 6) == false && 
                    BKingCheck(0, 5) == false && 
                    BKingCheck(0, 4) == false && 
                    board[0][6] == ' ' && 
                    board[0][5] == ' ' && 
                    bkmoved == 0)
                {
                    board[row1][col1] = ' ';
                    board[row2][col2] = 'M';
                    board[row2][col2-1] = 'Z';
                    board[0][7] = ' ';
                    bkrow = row2;
                    bkcol = col2;
                    turn = 1;
                }
                else
                {
                    board[row1][col1] = 'M';
                    board[row2][col2] = board[row2][col2];
                    turn = 2;
                    click = 0;
                }
            }
            else if (row2 == 0 && col2 == 2 && board[0][0] == 'H' && board[0][4] == 'M')
            {
                if ( 
                	BKingCheck(0, 2) == false && 
                    BKingCheck(0, 3) == false && 
                    BKingCheck(0, 4) == false && 
                    board[0][1] == ' ' && 
                    board[0][2] == ' ' && 
                    board[0][3] == ' ' &&
                    bkmoved == 0)
                {
                    board[row1][col1] = ' ';
                    board[row2][col2] = 'M';
                    board[row2][col2+1] = 'Z';
                    board[0][0] = ' ';
                    bkrow = row2;
                    bkcol = col2;
                    turn = 1;
                }
                else
                {
                    board[row1][col1] = 'M';
                    board[row2][col2] = board[row2][col2];
                    turn = 2;
                    click = 0;
                }
            }
        }
    }
    
    
    public boolean KingCheck(int krow, int kcol)
    {
        if (KingDiagUL(krow, kcol) == true)
        {
            System.out.println("CHECKUL");
            return true;
        }
        else if (KingDiagUR(krow, kcol) == true)
        {
            System.out.println("CHECKUR");
            return true;
        }
        else if (KingDiagDL(krow, kcol) == true)
        {
            System.out.println("CHECKDL");
            return true;
        }
        else if (KingDiagDR(krow, kcol) == true)
        {
            System.out.println("CHECKDR");
            return true;
        }
        else if (KingRight(krow, kcol) == true)
        {
            System.out.println("CHECKR");
            return true;
        }
        else if (KingLeft(krow, kcol) == true)
        {
            System.out.println("CHECKL");
            return true;
        }
        else if (KingUp(krow, kcol) == true)
        {
            System.out.println("CHECKU");
            return true;
        }
        else if (KingDown(krow, kcol) == true)
        {
            System.out.println("CHECKD");
            return true;
        }
        else if (KingPawnDiag(krow, kcol) == true)
        {
            System.out.println("CHECKDIAG");
            return true;
        }
        else if (KingKnight(krow, kcol) == true)
        {
            System.out.println("CHECKKNIGHT");
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean KingDiagUL(int krow, int kcol)
    {
        int count = kcol-1;

        for(int BDCY = krow-1;BDCY >= 0 ; BDCY--) 
        {
            int BDCX = kcol-1;
            for(BDCX = kcol-1; BDCX > count; BDCX--){
            }
            count--;
            if (board[BDCY][BDCX] == 'V' || board[BDCY][BDCX] == 'F')
            {
                return true;
            }
            else if (board[BDCY][BDCX] != ' ' && board[BDCY][BDCX] != 'K' &&!(board[BDCY][BDCX] == 'V' || board[BDCY][BDCX] == 'F'))
            {
                return false;
            }
            if(BDCX == 0)
            {
                BDCY = 0;
            }
        }
        return false;
    }
    
    public boolean KingDiagUR(int krow, int kcol)
    {
        int count = kcol+1;
        
        for(int BDCY = krow-1;BDCY >= 0 ; BDCY--) 
        {
            int BDCX = kcol+1;
            for(BDCX = kcol+1; BDCX < count; BDCX++){
            }
            count++;
            if (board[BDCY][BDCX] == 'V' || board[BDCY][BDCX] == 'F')
            {
                return true;
            }
            else if (board[BDCY][BDCX] != ' ' && board[BDCY][BDCX] != 'K' &&!(board[BDCY][BDCX] == 'V' || board[BDCY][BDCX] == 'F'))
            {
                return false;
            }
            if(BDCX == 7)
            {
                BDCY = 0;
            }
        }
        return false;
    }
    
    public boolean KingDiagDL(int krow, int kcol)
    {
        int count = kcol-1;
        
        for(int BDCY = krow+1;BDCY <= 7 ; BDCY++) 
        {
            int BDCX = kcol-1;
            for(BDCX = kcol-1; BDCX > count; BDCX--){
            }
            count--;
            if (board[BDCY][BDCX] == 'V' || board[BDCY][BDCX] == 'F')
            {
                return true;
            }
            else if (board[BDCY][BDCX] != ' ' && board[BDCY][BDCX] != 'K' &&!(board[BDCY][BDCX] == 'V' || board[BDCY][BDCX] == 'F'))
            {
                return false;
            }
            if(BDCX == 0)
            {
                BDCY = 7;
            }
        }
        return false;
    }
    
    public boolean KingDiagDR(int krow, int kcol)
    {
        int count = kcol+1;
        
        for(int BDCY = krow+1;BDCY <= 7 ; BDCY++) 
        {
            int BDCX = kcol+1;
            for(BDCX = kcol+1; BDCX < count; BDCX++){
            }
            count++;
            if (board[BDCY][BDCX] == 'V' || board[BDCY][BDCX] == 'F')
            {
                return true;
            }
            else if (board[BDCY][BDCX] != ' ' && board[BDCY][BDCX] != 'K' &&!(board[BDCY][BDCX] == 'V' || board[BDCY][BDCX] == 'F'))
            {
                return false;
            }
            if(BDCX == 7)
            {
                BDCY = 7;
            }
        }
        return false;
    }
    
    public boolean KingRight(int krow, int kcol)
    {
        for (int RMoveC = kcol+1; RMoveC <= 7; RMoveC++)
        {
            if (board[krow][RMoveC] == 'F' || board[krow][RMoveC] == 'H'|| board[RMoveC][kcol] == 'Z')
            {
                return true;
            }
            else if (board[krow][RMoveC] != ' ' && board[krow][RMoveC] != 'K' &&
                    !(board[krow][RMoveC] == 'H' || board[krow][RMoveC] == 'Z' || board[krow][RMoveC] == 'F'))
            {
                return false;
            }
            else {}
        }
        return false;
    }
    
    public boolean KingLeft(int krow, int kcol)
    {
        for (int RMoveC = kcol-1; RMoveC >= 0; RMoveC--)
        {
            if (board[krow][RMoveC] == 'F' || board[krow][RMoveC] == 'H'|| board[RMoveC][kcol] == 'Z')
            {
                return true;
            }
            else if (board[krow][RMoveC] != ' ' && board[krow][RMoveC] != 'K' &&
                    !(board[krow][RMoveC] == 'H' || board[krow][RMoveC] == 'Z' || board[krow][RMoveC] == 'F'))
            {
                return false;
            }
            else {}
        }
        return false;
    }
    
    public boolean KingUp(int krow, int kcol)
    {
        for (int RMoveC = krow-1; RMoveC >= 0; RMoveC--)
        {
            if (board[RMoveC][kcol] == 'F' || board[RMoveC][kcol] == 'H' || board[RMoveC][kcol] == 'Z')
            {
                return true;
            }
            else if (board[RMoveC][kcol] != ' ' && board[RMoveC][kcol] != 'K' &&
                    !(board[RMoveC][kcol] == 'H' || board[RMoveC][kcol] == 'Z' || board[RMoveC][kcol] == 'F'))
            {
                return false;
            }
            else {}
        }
        return false;
    }
    
    public boolean KingDown(int krow, int kcol)
    {
        for (int RMoveC = krow+1; RMoveC <= 7; RMoveC++)
        {
            if (board[RMoveC][kcol] == 'F' || board[RMoveC][kcol] == 'H'|| board[RMoveC][kcol] == 'Z')
            {
                return true;
            }
            else if (board[RMoveC][kcol] != ' ' && board[RMoveC][kcol] != 'K' &&
                    !(board[RMoveC][kcol] == 'H' || board[RMoveC][kcol] == 'Z' || board[RMoveC][kcol] == 'F'))
            {
                return false;
            }
            else {}
        }
        return false;
    }
    
    public boolean KingPawnDiag(int krow, int kcol)
    {
        if (board[krow-1][kcol+1] == 'L' || board[krow-1][kcol-1] == 'L' || 
            board[krow-1][kcol+1] == 'Y' || board[krow-1][kcol-1] == 'Y')
        {
            return true;
        }
        else
            return false;
    }
    
    public boolean KingKnight(int krow, int kcol)
    {
        int count = 0; //goes through another statement if the one before wasnt a black//white knight
        
        if(count == 0)
        {
            if (krow+1 <= 7 && 
                kcol+2 <= 7)//2R 1D *Two right, one down
            {
                if(board[krow+1][kcol+2] == 'J')
                    return true;
                else
                    count++;
            }
            else
                count++;
        }
        if(count == 1)
        {
            if (krow+2 <= 7 && 
                kcol+1 <= 7)//1R 2D
            {
                if(board[krow+2][kcol+1] == 'J')
                    return true;
                else
                    count++;
            }
            else
                count++;
        }   
        //1/4
        if(count == 2)
        {
            if (krow+2 <= 7 && 
                kcol-1 >= 0)//1L 2D
            {
                if(board[krow+2][kcol-1] == 'J')
                    return true;
                else
                    count++;
            }
            else
                count++;
        }
        if(count == 3)
        {
            if (krow+1 <= 7 && 
                kcol-2 >= 0)//2L 1D
            {
                if(board[krow+1][kcol-2] == 'J')
                    return true;
                else
                    count++;
            }
            else
                count++;
        }
        //2/4
        if(count == 4)
        {
            if (krow-1 >= 0 && 
                kcol-2 >= 0)//2L 1U
            {
                if(board[krow-1][kcol-2] == 'J')
                    return true;
                else
                    count++;
            }
            else
                count++;
        }
        if(count == 5)
        {
            if (krow-2 >= 0 && 
                kcol-1 >= 0)//1L 2U
            {
                if(board[krow-2][kcol-1] == 'J')
                    return true;
                else
                    count++;
            }
            else
                count++;
        }
        //3/4
        if(count == 6)
        {
            if (krow-1 >= 0 && 
                kcol+2 <= 7)//2R 1U
            {
                if(board[krow-1][kcol+2] == 'J')
                    return true;
                else
                    count++;
            }
            else
                count++;
        }
        if(count == 7)
        {
            if (krow-2 >= 0 && 
                kcol+1 <= 7)//1R 2U
            {
                if(board[krow-2][kcol+1] == 'J')
                    return true;
            }
        }
        //4/4
        return false;
    }
    

//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
    
    
    public boolean BKingCheck(int bkrow, int bkcol)
    {
        if (BKingDiagUL(bkrow, bkcol) == true)
        {
            System.out.println("BCHECKUL");
            return true;
        }
        else if (BKingDiagUR(bkrow, bkcol) == true)
        {
            System.out.println("BCHECKUR");
            return true;
        }
        else if (BKingDiagDL(bkrow, bkcol) == true)
        {
            System.out.println("BCHECKDL");
            return true;
        }
        else if (BKingDiagDR(bkrow, bkcol) == true)
        {
            System.out.println("BCHECKDR");
            return true;
        }
        else if (BKingRight(bkrow, bkcol) == true)
        {
            System.out.println("BCHECKR");
            return true;
        }
        else if (BKingLeft(bkrow, bkcol) == true)
        {
            System.out.println("BCHECKL");
            return true;
        }
        else if (BKingUp(bkrow, bkcol) == true)
        {
            System.out.println("BCHECKU");
            return true;
        }
        else if (BKingDown(bkrow, bkcol) == true)
        {
            System.out.println("BCHECKD");
            return true;
        }
        else if (BKingPawnDiag(bkrow, bkcol) == true)
        {
            System.out.println("BCHECKDIAG");
            return true;
        }
        else if (BKingKnight(bkrow, bkcol) == true)
        {
            System.out.println("BCHECKKNIGHT");
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean BKingDiagUL(int bkrow, int bkcol)
    {
        int count = bkcol-1;

        for(int BDCY = bkrow-1;BDCY >= 0 ; BDCY--) 
        {
            int BDCX = bkcol-1;
            for(BDCX = bkcol-1; BDCX > count; BDCX--){
            }
            count--;
            if (board[BDCY][BDCX] == 'B' || board[BDCY][BDCX] == 'Q')
            {
                return true;
            }
            else if (board[BDCY][BDCX] != ' ' && board[BDCY][BDCX] != 'M' &&!(board[BDCY][BDCX] == 'B' || board[BDCY][BDCX] == 'Q'))
            {
                return false;
            }
            if(BDCX == 0)
            {
                BDCY = 0;
            }
        }
        return false;
    }
    
    public boolean BKingDiagUR(int bkrow, int bkcol)
    {
        int count = bkcol+1;
        
        for(int BDCY = bkrow-1;BDCY >= 0 ; BDCY--) 
        {
            int BDCX = bkcol+1;
            for(BDCX = bkcol+1; BDCX < count; BDCX++){
            }
            count++;
            if (board[BDCY][BDCX] == 'B' || board[BDCY][BDCX] == 'Q')
            {
                return true;
            }
            else if (board[BDCY][BDCX] != ' ' && board[BDCY][BDCX] != 'M' &&!(board[BDCY][BDCX] == 'B' || board[BDCY][BDCX] == 'Q'))
            {
                return false;
            }
            if(BDCX == 7)
            {
                BDCY = 0;
            }
        }
        return false;
    }
    
    public boolean BKingDiagDL(int bkrow, int bkcol)
    {
        int count = bkcol-1;
        
        for(int BDCY = bkrow+1;BDCY <= 7 ; BDCY++) 
        {
            int BDCX = bkcol-1;
            for(BDCX = bkcol-1; BDCX > count; BDCX--){
            }
            count--;
            if (board[BDCY][BDCX] == 'B' || board[BDCY][BDCX] == 'Q')
            {
                return true;
            }
            else if (board[BDCY][BDCX] != ' ' && board[BDCY][BDCX] != 'M' &&!(board[BDCY][BDCX] == 'B' || board[BDCY][BDCX] == 'Q'))
            {
                return false;
            }
            if(BDCX == 0)
            {
                BDCY = 7;
            }
        }
        return false;
    }
    
    public boolean BKingDiagDR(int bkrow, int bkcol)
    {
        int count = bkcol+1;
        
        for(int BDCY = bkrow+1;BDCY <= 7 ; BDCY++) 
        {
            int BDCX = bkcol+1;
            for(BDCX = bkcol+1; BDCX < count; BDCX++){
            }
            count++;
            if (board[BDCY][BDCX] == 'B' || board[BDCY][BDCX] == 'Q')
            {
                return true;
            }
            else if (board[BDCY][BDCX] != ' ' && board[BDCY][BDCX] != 'M' &&!(board[BDCY][BDCX] == 'B' || board[BDCY][BDCX] == 'Q'))
            {
                return false;
            }
            if(BDCX == 7)
            {
                BDCY = 7;
            }
        }
        return false;
    }
    
    public boolean BKingRight(int bkrow, int bkcol)
    {
        for (int RMoveC = bkcol+1; RMoveC <= 7; RMoveC++)
        {
            if (board[bkrow][RMoveC] == 'Q' || board[bkrow][RMoveC] == 'R' || board[bkrow][RMoveC] == 'C')
            {
            	System.out.println(true);
                return true;
            }
            else if (board[bkrow][RMoveC] != ' ' && board[bkrow][RMoveC] != 'M' &&
                    !(board[bkrow][RMoveC] == 'R' || board[bkrow][RMoveC] == 'C' || board[bkrow][RMoveC] == 'Q'))
            {
                return false;
            }
            else {}
        }
        return false;
    }
    
    public boolean BKingLeft(int bkrow, int bkcol)
    {
        for (int RMoveC = bkcol-1; RMoveC >= 0; RMoveC--)
        {
            if (board[bkrow][RMoveC] == 'Q' || board[bkrow][RMoveC] == 'R' || board[bkrow][RMoveC] == 'C')
            {
                return true;
            }
            else if (board[bkrow][RMoveC] != ' ' && board[bkrow][RMoveC] != 'M' &&
                    !(board[bkrow][RMoveC] == 'R' || board[bkrow][RMoveC] == 'C' || board[bkrow][RMoveC] == 'Q'))
            {
                return false;
            }
            else {}
        }
        return false;
    }
    
    public boolean BKingUp(int bkrow, int bkcol)
    {
        for (int RMoveC = bkrow-1; RMoveC >= 0; RMoveC--)
        {
            if (board[RMoveC][bkcol] == 'Q' || board[RMoveC][bkcol] == 'R' || board[RMoveC][bkcol] == 'C')
            {
                return true;
            }
            else if (board[RMoveC][bkcol] != ' ' && board[RMoveC][bkcol] != 'M' &&
                    !(board[RMoveC][bkcol] == 'R' || board[RMoveC][bkcol] == 'C' || board[RMoveC][bkcol] == 'Q'))
            {
                return false;
            }
            else {}
        }
        return false;
    }
    
    public boolean BKingDown(int bkrow, int bkcol)
    {
        for (int RMoveC = bkrow+1; RMoveC <= 7; RMoveC++)
        {
            if (board[RMoveC][bkcol] == 'Q' || board[RMoveC][bkcol] == 'R' || board[RMoveC][bkcol] == 'C')
            {
                return true;
            }
            else if (board[RMoveC][bkcol] != ' ' && board[RMoveC][bkcol] != 'M' &&
                    !(board[RMoveC][bkcol] == 'R' || board[RMoveC][bkcol] == 'C' || board[RMoveC][bkcol] == 'Q'))
            {
                return false;
            }
            else {}
        }
        return false;
    }
    
    public boolean BKingPawnDiag(int bkrow, int bkcol)
    {
        if (board[bkrow+1][bkcol+1] == 'P' || board[bkrow+1][bkcol-1] == 'P' || 
            board[bkrow+1][bkcol+1] == 'E' || board[bkrow+1][bkcol-1] == 'E')
        {
            return true;
        }
        else
            return false;
    }
    
    public boolean BKingKnight(int bkrow, int bkcol)
    {
        int count = 0; //goes through another statement if the one before wasnt a black//white knight
        
        if(count == 0)
        {
            if (bkrow+1 <= 7 && 
                bkcol+2 <= 7)//2R 1D *Two right, one down
            {
                if(board[bkrow+1][bkcol+2] == 'N')
                    return true;
                else
                    count++;
            }
            else
                count++;
        }
        if(count == 1)
        {
            if (bkrow+2 <= 7 && 
                bkcol+1 <= 7)//1R 2D
            {
                if(board[bkrow+2][bkcol+1] == 'N')
                    return true;
                else
                    count++;
            }
            else
                count++;
        }   
        //1/4
        if(count == 2)
        {
            if (bkrow+2 <= 7 && 
                bkcol-1 >= 0)//1L 2D
            {
                if(board[bkrow+2][bkcol-1] == 'N')
                    return true;
                else
                    count++;
            }
            else
                count++;
        }
        if(count == 3)
        {
            if (bkrow+1 <= 7 && 
                bkcol-2 >= 0)//2L 1D
            {
                if(board[bkrow+1][bkcol-2] == 'N')
                    return true;
                else
                    count++;
            }
            else
                count++;
        }
        //2/4
        if(count == 4)
        {
            if (bkrow-1 >= 0 && 
                bkcol-2 >= 0)//2L 1U
            {
                if(board[bkrow-1][bkcol-2] == 'N')
                    return true;
                else
                    count++;
            }
            else
                count++;
        }
        if(count == 5)
        {
            if (bkrow-2 >= 0 && 
                bkcol-1 >= 0)//1L 2U
            {
                if(board[bkrow-2][bkcol-1] == 'N')
                    return true;
                else
                    count++;
            }
            else
                count++;
        }
        //3/4
        if(count == 6)
        {
            if (bkrow-1 >= 0 && 
                bkcol+2 <= 7)//2R 1U
            {
                if(board[bkrow-1][bkcol+2] == 'N')
                    return true;
                else
                    count++;
            }
            else
                count++;
        }
        if(count == 7)
        {
            if (bkrow-2 >= 0 && 
                bkcol+1 <= 7)//1R 2U
            {
                if(board[bkrow-2][bkcol+1] == 'N')
                    return true;
            }
        }
        //4/4
        return false;
    }
    
    //Check on piece checking king, if that piece is in check then keep running program if not then it would be checkmate

    public void drawPieces(Graphics g)
    {
        for (int i = 0; i <= 7; i++)
        {
            for (int j = 0; j <= 7; j++)
            {
                g.setColor(Color.white);

                if(board[i][j] == 'P' || board[i][j] == 'E')
                    g.drawImage(WhitePawn, 30 + 100 * j, 25 + 100 * i, null);
                else if(board[i][j] == 'R' || board[i][j] == 'C')
                    g.drawImage(WhiteRook, 30 + 100 * j, 25 + 100 * i, null);
                else if(board[i][j] == 'Q')
                    g.drawImage(WhiteQueen, 30 + 100 * j, 25 + 100 * i, null);
                else if(board[i][j] == 'K')
                    g.drawImage(WhiteKing, 30 + 100 * j, 25 + 100 * i, null);
                else if(board[i][j] == 'B')
                    g.drawImage(WhiteBishop, 30 + 100 * j, 25 + 100 * i, null);
                else if(board[i][j] == 'N')
                    g.drawImage(WhiteKnight, 30 + 100 * j, 25 + 100 * i, null);
                else if(board[i][j] == 'L' || board[i][j] == 'Y')
                    g.drawImage(BlackPawn, 30 + 100 * j, 25 + 100 * i, null);
                else if(board[i][j] == 'H' || board[i][j] == 'Z')
                    g.drawImage(BlackRook, 30 + 100 * j, 25 + 100 * i, null);
                else if(board[i][j] == 'F')
                    g.drawImage(BlackQueen, 30 + 100 * j, 25 + 100 * i, null);
                else if(board[i][j] == 'M')
                    g.drawImage(BlackKing, 30 + 100 * j, 25 + 100 * i, null);
                else if(board[i][j] == 'V')
                    g.drawImage(BlackBishop, 30 + 100 * j, 25 + 100 * i, null);
                else if(board[i][j] == 'J')
                    g.drawImage(BlackKnight, 30 + 100 * j, 25 + 100 * i, null);

                //g.drawString("" + board[i][j], 75 + 100 * j, 75 + 100 * i);
            }
        }
    }


	public void mouseReleased(MouseEvent e) {
	}


	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
}
