package it.univaq.lpo.chessflow.gui;

import it.univaq.lpo.chessflow.errors.BusinessException;
import it.univaq.lpo.chessflow.gui.data.*;
import lombok.SneakyThrows;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ObservableChessBoardGui implements ChessBoardGui {

    private final SortedMap<CoordinatesGui, BoardCellGuiImpl> orderedCells;
    private final List<Consumer<PieceDrawnInfo>> onPieceDrawnCallbacks = new ArrayList<>();

    public ObservableChessBoardGui() {
        this.orderedCells = new TreeMap<>(ChessCoordinatesGui.comparatorByRowThenByColumn());

        for (CoordinatesGui coordinates: ChessCoordinatesGui.CHESSBOARD_COORDINATES) {
            this.orderedCells.put(coordinates, BoardCellGuiImpl.builder().coordinates(coordinates).build());
        }
    }

    @Override
    public void clearSquareAt(CoordinatesGui coordinate) throws BusinessException {
        drawPieceAt(BoardCellGuiImpl.NO_PIECE_ON, coordinate);
    }

    @Override
    public boolean drawPieceAt(PieceGui piece, CoordinatesGui coordinate) throws BusinessException {
        ChessCoordinatesGui.checkValidCoordinatesOrThrowBusinessException(coordinate);

        BoardCellGuiImpl cell = this.orderedCells.get(coordinate);
        if (!Objects.equals(cell.getPieceOn(), piece)) {
            cell.setPieceOn(piece);

            this.notifyOnPieceMoved(
                    PieceDrawnInfo.builder()
                            .coordinates(coordinate)
                            .piece(piece)
                            .build()
            );

            return true;
        }

        return false;
    }

    @Override
    public BoardCellGui getCell(CoordinatesGui coordinatesGui) throws BusinessException {
        ChessCoordinatesGui.checkValidCoordinatesOrThrowBusinessException(coordinatesGui);

        return this.orderedCells.get(coordinatesGui);
    }

    @Override
    public Iterator<List<BoardCellGui>> rowsIterator() {
        return this.orderedCells.values().stream()
                .map(boardCellGui -> (BoardCellGui) boardCellGui)
                .collect(Collectors.groupingBy((boardCellGui -> boardCellGui.getCoordinates().getY())))
                .values()
                .iterator();
    }

    @Override
    public void addOnPieceDrawn(Consumer<PieceDrawnInfo> onPieceDrawnCallback) {
        this.onPieceDrawnCallbacks.add(onPieceDrawnCallback);
    }

    @Override
    public void removeOnPieceDrawn(Consumer<PieceDrawnInfo> onPieceDrawnCallback) {
        this.onPieceDrawnCallbacks.remove(onPieceDrawnCallback);
    }

    @Override
    @SneakyThrows
    public void reset() {
        for (Map.Entry<CoordinatesGui, BoardCellGuiImpl> cellByCoordinates: this.orderedCells.entrySet()) {
            drawPieceAt(BoardCellGui.NO_PIECE_ON, cellByCoordinates.getKey());
        }
    }
    
    private void notifyOnPieceMoved(final PieceDrawnInfo pieceDrawnInfo) {
        this.onPieceDrawnCallbacks.forEach(callback -> callback.accept(pieceDrawnInfo));
    }
}
