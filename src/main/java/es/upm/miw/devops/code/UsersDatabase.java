package es.upm.miw.devops.code;

import java.util.List;
import java.util.stream.Stream;

public class UsersDatabase {

    public Stream<User> findAll() {

        List<Fraction> fractions1 = List.of(
                new Fraction(0, 1),
                new Fraction(1, 1),
                new Fraction(2, 1)
        );
        List<Fraction> fractions2 = List.of(
                new Fraction(2, 1),
                new Fraction(-1, 5),
                new Fraction(2, 4),
                new Fraction(4, 3)
        );
        List<Fraction> fractions3 = List.of(
                new Fraction(1, 5),
                new Fraction(3, -6),
                new Fraction(1, 2),
                new Fraction(4, 4)
        );
        List<Fraction> fractions4 = List.of(
                new Fraction(2, 2),
                new Fraction(4, 4)
        );
        List<Fraction> fractions5 = List.of(
                new Fraction(0, 1),
                new Fraction(0, -2),
                new Fraction(0, 3)
        );

        List<Fraction> fractions6 = List.of(
                new Fraction(0, 0),
                new Fraction(1, 0),
                new Fraction(1, 1)
        );

        User user1 = new User("1", "Oscar", "Fernandez", fractions1);
        user1.setEmail("oscar@example.com");
        user1.setIdentity("12345678A");
        user1.setAddress("Calle Falsa 123");
        user1.setCity("Madrid");
        user1.setProvince("Madrid");
        user1.setPostalCode("28001");
        user1.setRole("ADMIN");

        User user2 = new User("2", "Ana", "Blanco", fractions2);
        user2.setEmail("ana@example.com");
        user2.setIdentity("87654321B");
        user2.setAddress("Avenida Verdad 456");
        user2.setCity("Barcelona");
        user2.setProvince("Barcelona");
        user2.setPostalCode("08001");

        return Stream.of(
                user1,
                user2,
                new User("3", "Oscar", "López", fractions3),
                new User("4", "Paula", "Torres", fractions4),
                new User("5", "Antonio", "Blanco", fractions5),
                new User("6", "Paula", "Torres", fractions6)
        );
    }
}
