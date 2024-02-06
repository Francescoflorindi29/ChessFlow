package it.univaq.lpo.chessflow.gui.console;

import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.Optional;

import it.univaq.lpo.chessflow.errors.BusinessException;
import it.univaq.lpo.chessflow.gui.ChessBoardGUI;
import it.univaq.lpo.chessflow.gui.CoordinatesGUI;
import it.univaq.lpo.chessflow.gui.PieceGUI;
import it.univaq.lpo.chessflow.gui.PieceMoveGUI;

public class ConsoleChessBoardGUI implements ChessBoardGUI {
    
    private Consumer<PieceMoveGUI> onPieceMoved = (PieceMoveGUI move) -> {};
    private Map<CoordinatesGUI, Optional<PieceGUI>> state;
    private boolean printEnabled = true;
    
    public ConsoleChessBoardGUI() {
        for(int row = 0; row < SIZE; row++) {
            for(int col = 0; col < SIZE; col++) {
                CoordinatesGUI coordinate = new CoordinatesGUI(row, col);
                state.put(coordinate, Optional.empty());
            }
        }
    }

	private void printState() {
        if(this.printEnabled) {
            for (int row = 0; row < SIZE; row++) {
                System.out.print("|");
                for (int col = 0; col < SIZE; col++) {
                    Optional<PieceGUI> piece = this.findPieceAt(row, col);
                    System.out.print(" " + pieceToString(piece) + " |");
                }
                System.out.println();
            }
        }
	}
	
	private void checkCoordinates(int x, int y) throws BusinessException {
        if(x >= SIZE) {
            throw new BusinessException("illegal X coordinate " + y);
        }
        if(y >= SIZE) {
            throw new BusinessException("illegal Y coordinate " + y);
        }
	}

	private void checkCoordinates(CoordinatesGUI coordinates) throws BusinessException {
        this.checkCoordinates(coordinates.getX(), coordinates.getY());
	}

	private String pieceToString(Optional<PieceGUI> piece) {
        return piece.map(presentPiece ->  {
            String pieceChar = presentPiece.getPieceName().toString().substring(0, 3).toUpperCase();
            String colorChar = presentPiece.getColor().toString().substring(0, 1).toLowerCase();

            return colorChar + pieceChar;
        }).orElse(" ");
	}
	
	private Optional<PieceGUI> checkCoordinatesAndfindPieceAt(CoordinatesGUI coordinates) throws BusinessException {
        return this.checkCoordinatesAndfindPieceAt(coordinates.getX(), coordinates.getY());
	}

	private Optional<PieceGUI> checkCoordinatesAndfindPieceAt(int row, int col) throws BusinessException {
        this.checkCoordinates(row, col);
        return this.findPieceAt(row, col);
	}
	
	private Optional<PieceGUI> findPieceAt(int row, int col) {
        CoordinatesGUI requiredCoordinate = new CoordinatesGUI(row, col);
        return this.state.get(requiredCoordinate);
	}

	private void notifyPieceMoved(PieceGUI piece, CoordinatesGUI sourceCoordinates, CoordinatesGUI targetCoordinates) {
        PieceMoveGUI move = new PieceMoveGUI(piece, sourceCoordinates, targetCoordinates);
        this.onPieceMoved.accept(move);
	}
	
	@Override
    public void onPieceMoved(Consumer<PieceMoveGUI> executedMove) {
        this.printState();
        this.onPieceMoved = executedMove;
    }

    @Override
    public void drawPieceAt(PieceGUI piece, CoordinatesGUI coordinate) throws BusinessException {
        if(Objects.isNull(piece)) {
            this.clearSquareAt(coordinate);
        }
        else {
            this.checkCoordinates(coordinate);
            this.state.put(coordinate, Optional.of(piece));
            this.printState();
        }
    }

    @Override
    public void clearSquareAt(CoordinatesGUI coordinate) throws BusinessException {
        this.checkCoordinates(coordinate);

        this.state.put(coordinate, Optional.empty());
        this.printState();
    }
    
    public void enablePrint() {
        this.printEnabled = true;
    }

    public void disablePrint() {
        this.printEnabled = false;
    }

    public void move(CoordinatesGUI sourceCoordinates, CoordinatesGUI targetCoordinates) throws BusinessException {
        boolean isPrintActuallyEnabled = this.printEnabled;
        if(isPrintActuallyEnabled) {
            this.disablePrint();
        }
        
        Optional<PieceGUI> foundPiece = this.checkCoordinatesAndfindPieceAt(sourceCoordinates);
        if(foundPiece.isPresent()) {
            PieceGUI selectedPiece = foundPiece.get();
            
            this.clearSquareAt(sourceCoordinates);
            this.drawPieceAt(selectedPiece, targetCoordinates);
            this.notifyPieceMoved(selectedPiece, sourceCoordinates, targetCoordinates);

            if(isPrintActuallyEnabled) {
                this.printState();
                this.enablePrint();
            }

        }
    }
}
