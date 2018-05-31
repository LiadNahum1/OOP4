
public abstract class Ghost implements Visitor {
	public void collide(Pacman pacman) {
		pacman.impact(this);
	}
	public abstract void visit(NicePacman pacman);
	public abstract void visit(DefendedPacman pacman);
	public abstract void visit(AngryPacman pacman);
	
}
