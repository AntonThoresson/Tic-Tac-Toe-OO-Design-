
public class Controller {
	private View view;
	private Player player;
	private RuleEngine ruleEngine;
	
	public Controller() {
		player = new Player(this);
		view = new View(this, player.getSize());
	}
	
	public void cellClicked(int r, int c) {
		if (player.move(r, c)) {
			view.updateGUI(r, c, player.isGameOver(), player.getPlayerTurn());
		}
		else {
			return;
		}
	}
	
	
	
	
	
	
}
