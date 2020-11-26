package dao;

import model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//define operations allowed
public interface PersonDao {

    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person) {
        //creates a random id from server
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

     List<Person> selectAllPerson();

    Optional<Person> selectPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Person person);
}
