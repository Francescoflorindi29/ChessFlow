package it.univaq.lpo.chessflow;
import it.univaq.lpo.chessflow.gui.ChessApplicationGUI;
import it.univaq.lpo.chessflow.repository.PieceRepository;
import it.univaq.lpo.chessflow.repository.PieceRepositoryJsonImpl;


public class ChessFlowApplication {
	
	private PieceRepository pieceRepository = new PieceRepositoryJsonImpl();
	private ChessApplicationGUI gui;

	public static void main(String[] args) {		
		ChessFlowApplication application = new ChessFlowApplication();
		application.gui.display(args);
	}
	
}
