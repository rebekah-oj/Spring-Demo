package dao.api;

import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import service.PersonService;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    //for posting request
    @PostMapping
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    //for getting request
    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    //search for person using id
    @GetMapping(path = "/{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id)
                .orElse(null);
    }

    //delete a person using id
    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id) {
        personService.deletePerson(id);
    }

    //update person using id
    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @NonNull @Validated @RequestBody Person personToUpdate) {
        personService.updatePerson(id, personToUpdate);
    }
}
