package es.upm.miw.devops.code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SearchesTest {

    @Test
    void testFindUserFamilyNameByUserNameDistinct() {
        assertThat(new Searches().findUserFamilyNameByUserNameDistinct("Paula").toList())
                .containsExactly("Torres");
    }

    @Test
    void testFindUserFractionNumeratorByFamilyName() {
        assertThat(new Searches().findFractionNumeratorByUserFamilyName("Torres").toList())
                .containsExactly(2, 4, 0, 1, 1);
    }

    @Test
    void testFindFamilyNameByFractionDenominator() {
        assertThat(new Searches().findUserFamilyNameByFractionDenominator(2).toList())
                .containsExactly("López", "Torres");
    }

    @Test
    void testFindBillableUsers() {
        assertThat(new Searches().findBillableUsers().toList())
                .containsExactly("Oscar Fernandez", "Ana Blanco");
    }

    @Test
    void testDeleteUser() {
        new Searches().deleteUser("1");
    }

    @Test
    void testDeleteUserNotFound() {
        assertThrows(IllegalArgumentException.class, () -> new Searches().deleteUser("999"));
    }

    @Test
    void testUpdateUserActive() {
        User user = new Searches().updateUserActive("1");
        assertThat(user.isActive()).isTrue();
        assertThat(user.getId()).isEqualTo("1");
    }

    @Test
    void testUpdateUserActiveNotFound() {
        assertThrows(IllegalArgumentException.class, () -> new Searches().updateUserActive("999"));
    }

    void testFindUserIdByAnyProperFraction() {
    }

    void testFindUserNameByAnyImproperFraction() {
    }

    void testFindUserFamilyNameByAllSignFractionDistinct() {
    }

    void testFindDecimalFractionByUserName() {
    }

    void testFindDecimalFractionBySignFraction() {
    }

    void testFindFractionAdditionByUserId() {
    }

    void testFindFractionSubtractionByUserName() {
    }

    void testFindFractionMultiplicationByUserFamilyName() {
    }
}
