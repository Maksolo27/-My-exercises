package app;

import app.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by maxim on 14.05.2021.
 */
@Repository
public interface GameReposiroty extends JpaRepository<Game, Long>, CrudRepository<Game, Long> {

    List<Game> findByName(String name);

}
