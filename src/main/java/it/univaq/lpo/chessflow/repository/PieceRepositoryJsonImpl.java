package it.univaq.lpo.chessflow.repository;

import java.io.InputStreamReader;
import java.io.Reader;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import it.univaq.lpo.chessflow.errors.BusinessException;
import it.univaq.lpo.chessflow.model.Piece;

public class PieceRepositoryJsonImpl implements PieceRepository {
	
	private final static String JSON_FILE_PATH = "/repo/pieces.repo.json";	
	
	private Gson gson = new Gson();

	@Override
	public Piece[] getChessPieces() throws BusinessException {
		try {
			Reader reader = new InputStreamReader(
					PieceRepositoryJsonImpl.class.getResourceAsStream(JSON_FILE_PATH));
			JsonReader jsonReader = new JsonReader(reader);
			
			return gson.fromJson(jsonReader, Piece[].class);
		} catch(Exception e) {
			throw new BusinessException(e);
		}
	}
	
}
