package app;

import app.Game;
import app.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.GameReposiroty;

import java.util.List;

/**
 * Created by maxim on 14.05.2021.
 */
@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameReposiroty gameReposiroty;

    @Override
    public Game save(Game game) {
        return gameReposiroty.saveAndFlush(game);
    }

    @Override
    public void delete(Game game) {
        gameReposiroty.delete(game);
    }

    @Override
    public Game update(Game game) {
        return gameReposiroty.save(game);
    }

    @Override
    public Game getGameById(long id) {
        return gameReposiroty.getOne(id);
    }

    @Override
    public List<Game> getGameByName(String name) {
        return gameReposiroty.findByName(name);
    }
}
