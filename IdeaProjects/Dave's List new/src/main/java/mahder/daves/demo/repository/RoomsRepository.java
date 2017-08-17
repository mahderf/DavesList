package mahder.daves.demo.repository;

import mahder.daves.demo.models.Rooms;
import org.springframework.data.repository.CrudRepository;

public interface RoomsRepository extends CrudRepository<Rooms, Long> {
}
