package register.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import register.model.User;

/**
 * Created by maxim on 16.05.2021.
 */
public interface UsersRepository extends CrudRepository<User, Long>, JpaRepository<User, Long> {

}
