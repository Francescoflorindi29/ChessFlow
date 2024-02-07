package it.univaq.lpo.chessflow.gui.console;

import it.univaq.lpo.chessflow.errors.BusinessException;
import it.univaq.lpo.chessflow.gui.ChessApplicationGui;
import it.univaq.lpo.chessflow.gui.ChessBoardBuilderGui;
import it.univaq.lpo.chessflow.gui.ChessBoardGui;
import it.univaq.lpo.chessflow.gui.ObservableChessBoardGui;
import it.univaq.lpo.chessflow.gui.data.*;
import it.univaq.lpo.chessflow.model.Color;
import it.univaq.lpo.chessflow.model.PieceName;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Consumer;


public class ConsoleChessBoardGuiApplication implements ChessApplicationGui {

    private final ChessBoardGui chessBoardGui = new ObservableChessBoardGui();
    private final List<Consumer<PieceMovedInfo>> onPieceMovedCallbacks = new ArrayList<>();

    public ConsoleChessBoardGuiApplication() {
        this.init();
    }

    private void init() {
        ChessBoardBuilderGui.buildChessBoard(chessBoardGui);

        // TODO: maybe this is not needed... but, is it clear the power of the lambdas?
        // Yes, yes... maybe there is something better but keep patience!
        this.chessBoardGui.addOnPieceDrawn((pieceDrawnInfo) -> System.out.println("ConsoleApp | detected drawn: " + pieceDrawnInfo));
    }

    private void printBoard() {
        Iterator<List<BoardCellGui>> boardRowsIterator = this.chessBoardGui.rowsIterator();
        while (boardRowsIterator.hasNext()) {
            System.out.print("|");
            for (BoardCellGui cell: boardRowsIterator.next()) {
                System.out.print("<" + this.pieceToString(cell.getPieceOn()) + ">");
            }
            System.out.println();
        }
    }

    private String pieceToString(PieceGui piece) {

        if (Objects.isNull(piece)) {
            return "    ";
        }

        String pieceChar = piece.getPieceName().toString().substring(0, 3).toUpperCase();
        String colorChar = piece.getColor().toString().substring(0, 1).toLowerCase();
        return colorChar + pieceChar;
    }

    // TODO: delete me! It's only to demonstrate how to do
    private <T> T getRandomElementFromArray(T[] array) {
        Random r = new Random();
        return array[r.nextInt(array.length)];
    }

    // TODO: delete me! It's only to demonstrate how to do
    private void randomDraw() throws BusinessException {
        PieceGui randomPiece = PieceGui.builder()
                .color(this.getRandomElementFromArray(Color.values()))
                .pieceName(this.getRandomElementFromArray(PieceName.values()))
                .build();
        CoordinatesGui randomCoordinates = this.getRandomElementFromArray(
                ChessCoordinatesGui.CHESSBOARD_COORDINATES.toArray(new CoordinatesGui[0]));
        this.chessBoardGui.drawPieceAt(randomPiece, randomCoordinates);
    }

    @Override
    public ChessBoardGui getBoard() {
        return this.chessBoardGui;
    }

    @Override
    public void run(String[] args) throws BusinessException {
        this.printBoard();
        System.out.println("ConsoleApp | Hello, I will run until \"exit\" is typed");

        // TODO: Implement display logic (try to be cleaned in your code!)
        try {
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            while (!Objects.equals("exit", stdIn.readLine())) {

                this.randomDraw();
                this.printBoard();

                System.out.println("ConsoleApp | maybe a day I will do something intelligent...");
                System.out.println("ConsoleApp | Hello, I will run until \"exit\" is typed");
            }
        } catch (Exception e) {
            throw new BusinessException("ConsoleApp | error displaying board: " + e.getLocalizedMessage(), e);
        }
    }

    @Override
    public void addOnPieceMoved(Consumer<PieceMovedInfo> onPieceMovedCallback) {
        this.onPieceMovedCallbacks.add(onPieceMovedCallback);
    }

    @Override
    public void removeOnPieceMoved(Consumer<PieceMovedInfo> onPieceMovedCallback) {
        this.onPieceMovedCallbacks.remove(onPieceMovedCallback);
    }
}
