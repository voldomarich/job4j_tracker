package ru.job4j.early;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void checkStringEmpty() {
        assertThatThrownBy(() -> PasswordValidator.validate(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Строка пуста");
    }

    @Test
    void checkStringEmpty2() {
        assertThatThrownBy(() -> PasswordValidator.validate(""))
                .isInstanceOf(IllegalArgumentException.class)
                .message()
                .isNotEmpty();
    }

    @Test
    void containsWhiteSpace() {
        assertThatThrownBy(() -> PasswordValidator.validate("Jdnb FNFb820j%Jj%g"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("не должен содержать пробел");
    }

    @Test
    void containsLessSymbols() {
        assertThatThrownBy(() -> PasswordValidator.validate("sW_2ert"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("должна быть от 8 до 32 символов включительно");
    }

    @Test
    void containsMoreSymbols() {
        assertThatThrownBy(() -> PasswordValidator.validate("ChnAjDdv120vm_dsfsdcdasnuyjtflfVNth"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("должна быть от 8 до 32 символов включительно");
    }

    @Test
    void lower() {
        assertThatThrownBy(() -> PasswordValidator.validate("LOOYRVHHG$10VF"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("хотя бы один символ в нижнем регистре");
    }

    @Test
    void upper() {
        assertThatThrownBy(() -> PasswordValidator.validate("lfkds$ivndfv"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("хотя бы один символ в верхнем регистре");
    }

    @Test
    void digit() {
        assertThatThrownBy(() -> PasswordValidator.validate("lfkd$siVn_dfv"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("хотя бы одну цифру");
    }

    @Test
    void specialSymbol() {
        assertThatThrownBy(() -> PasswordValidator.validate("lfkdsiVn100dfv"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("хотя бы один специальный символ");
    }

    @Test
    void qwertyLike1() {
        assertThatThrownBy(() -> PasswordValidator.validate("PASSWORD123%"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("не должен содержать данное слово в любом регистре");
    }

    @Test
    void qwertyLike() {
        assertThatThrownBy(() -> PasswordValidator.validate("PaSSWord123%"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("не должен содержать данное слово в любом регистре");
    }

    @Test
    void qwertyLike3() {
        assertThatThrownBy(() -> PasswordValidator.validate("PaROL_1bcsdj"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("не должен содержать данное слово в любом регистре");
    }

    @Test
    void qwertyLike2() {
        assertThatThrownBy(() -> PasswordValidator.validate("word_12345"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("не должен содержать данное слово в любом регистре");
    }

    @Test
    void check() {
        String i = PasswordValidator.validate("Jhwsay11hyew%jNcb");
        String expected = "Jhwsay11hyew%jNcb";
        assertThat(i).isEqualTo(expected);
    }

    @Test
    void check2() {
        String i = PasswordValidator.validate("abcDgprjg100_sd");
        String expected = "abcDgprjg100_sd";
        assertThat(i).isEqualTo(expected);
    }
}
