package by.danilov.musicInstrumentAssistant.repository.api;

import by.danilov.musicInstrumentAssistant.domain.entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    Optional<User> findUserByLogin(String login);

    Boolean existsByLogin(String login);

}
