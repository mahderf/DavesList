package mahder.daves.demo.repository;

import mahder.daves.demo.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long>{
}
