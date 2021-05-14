package app;

import app.Game;

import java.util.List;

/**
 * Created by maxim on 14.05.2021.
 */
public interface GameService {

    Game save(Game game);

    void delete(Game game);

    Game update(Game game);

    Game getGameById(long id);

    List<Game> getGameByName(String name);
}
