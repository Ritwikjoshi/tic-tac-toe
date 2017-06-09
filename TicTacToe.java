import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class TicTacToe extends JFrame implements ActionListener{
	JPanel p=new JPanel();
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	int winner =0;
	ImageIcon X,O;
	int player=1;
	JButton b1=new JButton("New Game");
	JLabel l=new JLabel("Player "+player);
	JLabel l1=new JLabel();
	String[][] s={{"1","2","3"},{"4","5","6"},{"7","8","9"}};
	int[][] a=new int[3][3];
	JButton b[][]=new JButton[3][3];
	TicTacToe(){
		super("TicTacToe");
		setSize(600,600);
		X=new ImageIcon(this.getClass().getResource("X.jpg"));
		O=new ImageIcon(this.getClass().getResource("O.png"));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		l.setFont(new Font("Verdana",1,20));
		l1.setFont(new Font("Verdana",1,20));
		p.setLayout(new GridLayout(3,3,20,20));
		p1.setLayout(new BorderLayout());
		p.setPreferredSize(new Dimension(440,440));
		add(p,BorderLayout.CENTER);
		add(p1,BorderLayout.NORTH);
		add(p2,BorderLayout.SOUTH);
		p1.add(b1,BorderLayout.WEST);
		b1.addActionListener(this);
		p1.add(l,BorderLayout.EAST);
		p2.add(l1);
		p.setBackground(Color.BLACK);
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++){
				b[i][j]=new JButton(s[i][j]);
				b[i][j].setBackground(Color.YELLOW);
				b[i][j].setBorder(null);
				p.add(b[i][j]);
				b[i][j].addActionListener(this);
			}
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		String cmd=e.getActionCommand();
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++){
			if(cmd.equals(s[i][j]))
			{
				if(player==1 && a[i][j]==0)
				{
					b[i][j].setIcon(O);
					player=2;
					l.setText("Player "+player);
					a[i][j]=2;
				}
				else if(player==2 && a[i][j]==0){
					b[i][j].setIcon(X);
					player=1;
					l.setText("Player "+player);
					a[i][j]=1;
				}
				if(winner==0)
				{
					for(int k=0;k<3;k++)
						if(a[k][0]==a[k][1] && a[k][1]==a[k][2] && a[k][0]!=0)
						{
							if(player==1)
							{
								b[k][0].setIcon(new ImageIcon(this.getClass().getResource("X4.jpg")));
								b[k][1].setIcon(new ImageIcon(this.getClass().getResource("X4.jpg")));
								b[k][2].setIcon(new ImageIcon(this.getClass().getResource("X4.jpg")));
								l1.setText("Player "+(player+1)+" wins");
							}
							else{
								b[k][0].setIcon(new ImageIcon(this.getClass().getResource("O4.png")));
								b[k][1].setIcon(new ImageIcon(this.getClass().getResource("O4.png")));
								b[k][2].setIcon(new ImageIcon(this.getClass().getResource("O4.png")));
								l1.setText("Player "+(player-1)+" wins");
							}
							winner=1;
						}
					for(int k=0;k<3;k++)
						if(a[0][k]==a[1][k] && a[1][k]==a[2][k] && a[0][k]!=0)
						{
							if(player==1)
							{
								b[0][k].setIcon(new ImageIcon(this.getClass().getResource("X1.jpg")));
								b[1][k].setIcon(new ImageIcon(this.getClass().getResource("X1.jpg")));
								b[2][k].setIcon(new ImageIcon(this.getClass().getResource("X1.jpg")));
								l1.setText("Player "+(player+1)+" wins");
							}
							else{
								b[0][k].setIcon(new ImageIcon(this.getClass().getResource("O1.png")));
								b[1][k].setIcon(new ImageIcon(this.getClass().getResource("O1.png")));
								b[2][k].setIcon(new ImageIcon(this.getClass().getResource("O1.png")));
								l1.setText("Player "+(player-1)+" wins");
							}winner=1;
						}
					if(a[0][0]==a[1][1] && a[1][1]==a[2][2] && a[0][0]!=0)
						{
							if(player==1)
							{
								b[0][0].setIcon(new ImageIcon(this.getClass().getResource("X3.jpg")));
								b[1][1].setIcon(new ImageIcon(this.getClass().getResource("X3.jpg")));
								b[2][2].setIcon(new ImageIcon(this.getClass().getResource("X3.jpg")));
								l1.setText("Player "+(player+1)+" wins");
							}
							else{
								b[0][0].setIcon(new ImageIcon(this.getClass().getResource("O2.png")));
								b[1][1].setIcon(new ImageIcon(this.getClass().getResource("O2.png")));
								b[2][2].setIcon(new ImageIcon(this.getClass().getResource("O2.png")));
								l1.setText("Player "+(player-1)+" wins");
							}winner=1;
						}	
					if(a[0][2]==a[1][1] && a[1][1]==a[2][0] && a[0][2]!=0)
						{
							if(player==1)
							{
								b[0][2].setIcon(new ImageIcon(this.getClass().getResource("X2.jpg")));
								b[1][1].setIcon(new ImageIcon(this.getClass().getResource("X2.jpg")));
								b[2][0].setIcon(new ImageIcon(this.getClass().getResource("X2.jpg")));
								l1.setText("Player "+(player+1)+" wins");
							}
							else{
								b[0][2].setIcon(new ImageIcon(this.getClass().getResource("O3.png")));
								b[1][1].setIcon(new ImageIcon(this.getClass().getResource("O3.png")));
								b[2][0].setIcon(new ImageIcon(this.getClass().getResource("O3.png")));
								l1.setText("Player "+(player-1)+" wins");
							}winner=1;
						}
				}
				if(visited(a) && winner==0)
					l1.setText("DRAW");	
			}
		}
		if(cmd.equals("New Game"))
		{
			dispose();
			new TicTacToe();
		}
		
	}
	boolean visited(int a[][])
	{
		boolean visit=true;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(a[i][j]==0)
					visit=false;
			}
		}
		return visit;
	}
	public static void main(String args[]){
		new TicTacToe();
	}
}
