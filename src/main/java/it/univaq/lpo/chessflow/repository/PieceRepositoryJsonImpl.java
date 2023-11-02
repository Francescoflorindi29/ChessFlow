package it.univaq.lpo.chessflow.repository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import it.univaq.lpo.chessflow.model.Piece;

public class PieceRepositoryJsonImpl implements PieceRepository {
	
	private final static String JSON_FILE_PATH = "/repo/pieces.repo.json";

	private final static Piece[] PIECES = readPiecesFromJson();
	
	private static Piece[] readPiecesFromJson() {
		try {
			Gson gson = new Gson();
			Reader reader = new InputStreamReader(PieceRepositoryJsonImpl.class.getResourceAsStream(JSON_FILE_PATH));
			JsonReader jsonReader = new JsonReader(reader);
			return gson.fromJson(jsonReader, Piece[].class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Piece[] getChessPieces() {
		return PIECES;
	}
	
}
