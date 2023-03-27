package by.itacademy.it_bootcamp.dao;

import by.itacademy.it_bootcamp.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface UserRepository
        extends PagingAndSortingRepository<User, Long> {

}
