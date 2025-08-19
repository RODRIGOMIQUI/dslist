package com.devsuperior.dslist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.repositories.GameListRepository;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = gameListRepository
            .findAll()
            .stream()
            .map(gameList -> new GameListDTO(gameList))
            .toList();
        return result;
    }

    @Transactional(readOnly = true)
    public GameListDTO findById(Long id) {
        return gameListRepository
            .findById(id)
            .map(gameList -> new GameListDTO(gameList))
            .orElseThrow(() -> new RuntimeException("Game list not found"));
    }
}
