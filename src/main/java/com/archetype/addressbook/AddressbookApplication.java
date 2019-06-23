package com.archetype.addressbook;

import com.archetype.addressbook.domain.*;
import com.archetype.addressbook.repositories.ContactRepository;
import com.archetype.addressbook.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class AddressbookApplication {

    private final PersonRepository personRepository;
    private final ContactRepository contactRepository;

    @Autowired
    public AddressbookApplication(PersonRepository personRepository, ContactRepository contactRepository) {
        this.personRepository = personRepository;
        this.contactRepository = contactRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(AddressbookApplication.class, args);
    }

    @Bean
    public ApplicationRunner sampleContacts() {
        return args -> {
            Person johnDoe = personRepository.save(
                    new Person("John Doe", "Utopia"));
            Person jackSparrow = personRepository.save(
                    new Person("Jack Sparrow", "Black Pearl"));

            johnDoe
                    .linkContacts(contactRepository.save(
                            new Email("john.doe@utopia.com")
                                    .setCategory(ContactCategory.work)
                    ))
                    .linkContacts(contactRepository.save(
                            new Phone("+1122333444555")
                                    .setCategory(ContactCategory.home)
                    ))
                    .setNote("John Doe exists only in incognito mode");

            jackSparrow
                    .linkContacts(contactRepository.save(
                            new Email("jack.sparrow@sevenseas.com")
                                    .setCategory(ContactCategory.home)
                    ))
                    .linkContacts(contactRepository.save(
                            new Website("https://pirates.disney.com/")
                                    .setCategory(ContactCategory.work)))
                    .setNote("Captain Sparrow does not have permanent address")
                    .setBirthday(LocalDate.of(1963, 6, 9));

            personRepository.save(johnDoe);
            personRepository.save(jackSparrow);

        };
    }


}
