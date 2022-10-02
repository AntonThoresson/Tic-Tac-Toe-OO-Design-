import java.awt.event.*;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;

public class View extends JFrame {
	private Controller controller;
	private Board board;
	private JButton cells[][];
	private JFrame viewFrame = new JFrame();
	private JPanel myMainPanel = new JPanel();
	private JLabel myLabel = new JLabel();
	private JPanel myTextPanel = new JPanel();
	private JPanel myCellPanel = new JPanel();

	public View(Controller _controller, int size) {
		controller = _controller;

		cells = new JButton[size][size];
		myCellPanel.setLayout(new GridLayout(size, size));

		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				final int _r = r;
				final int _c = c;
				JButton cell = cells[r][c] = new JButton();
				cell.setPreferredSize(new Dimension(50, 50));
				cell.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						controller.cellClicked(_r, _c);
					}
				});
				myCellPanel.add(cell);
			}
		}

		myTextPanel.setLayout(new GridLayout(1, 1));
		myTextPanel.setPreferredSize(new Dimension(150, 50));
		myTextPanel.add(myLabel);
		myMainPanel.setLayout(new BoxLayout(myMainPanel, BoxLayout.Y_AXIS));
		myMainPanel.add(myCellPanel);
		myMainPanel.add(myTextPanel);

		myLabel.setText("Player 1's turn");
		myLabel.setHorizontalAlignment(SwingConstants.CENTER);

		viewFrame.setTitle("Good Tic Tac Toe");
		viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewFrame.getContentPane().add(myMainPanel);
		viewFrame.pack();
		viewFrame.setVisible(true);
	}

	public void updateGUI(int r, int c, boolean gameOver, char playerChar) {
		String setPlayerChar;
		setPlayerChar = Character.toString(playerChar);
		cells[r][c].setText(setPlayerChar);

		if (gameOver) {
			if (playerChar == 'O') {
				myLabel.setText("Player 1 won!");
			} else {
				myLabel.setText("Player 2 won!");
			}
		} else {
			if (playerChar == 'O') {
				myLabel.setText("Player 2's turn");
			} else {
				myLabel.setText("Player 1's turn");
			}
		}
	}

}
