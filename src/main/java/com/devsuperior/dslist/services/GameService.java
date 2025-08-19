package com.devsuperior.dslist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> result = gameRepository
            .findAll()
            .stream()
            .map(game -> new GameMinDTO(game))
            .toList();
        return result;
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        return gameRepository
            .findById(id)
            .map(game -> new GameDTO(game))
            .orElseThrow(() -> new RuntimeException("Game not found"));
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinDTO> result = gameRepository
            .searchByList(listId)
            .stream()
            .map(x -> new GameMinDTO(x))
            .toList();
        return result;
    }
    
}
