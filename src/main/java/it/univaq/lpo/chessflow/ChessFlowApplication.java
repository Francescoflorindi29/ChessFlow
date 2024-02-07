package it.univaq.lpo.chessflow;
import it.univaq.lpo.chessflow.errors.BusinessException;
import it.univaq.lpo.chessflow.gui.ChessApplicationGui;
import it.univaq.lpo.chessflow.gui.data.PieceMovedInfo;
import it.univaq.lpo.chessflow.gui.console.ConsoleChessBoardGuiApplication;
import it.univaq.lpo.chessflow.repository.PieceRepository;
import it.univaq.lpo.chessflow.repository.PieceRepositoryJsonImpl;


public class ChessFlowApplication {
	
	private final PieceRepository pieceRepository = new PieceRepositoryJsonImpl();
	private final ChessApplicationGui chessApplicationGUI = new ConsoleChessBoardGuiApplication();

	public static void main(String[] args) throws BusinessException {
		ChessFlowApplication application = new ChessFlowApplication();
		application.chessApplicationGUI.run(args);
	}

	public ChessFlowApplication() {
		this.init();
	}

	private void init() {
		chessApplicationGUI.addOnPieceMoved(this::onPieceMoved);

		/*
		 * You can also use this:
		 * `chessApplicationGUI.onPieceMoved(pieceMovedInfo -> this.onPieceMoved(pieceMovedInfo));`
		 * try to find the difference (method reference)
		 */
	}

	private void onPieceMoved(PieceMovedInfo pieceMovedInfo) {
		// TODO: What to do when a piece is moved? Obv... you need one (?) controller
	}
	
}
