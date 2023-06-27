package pl.javastart.validationtask;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import pl.javastart.validationtask.constraint.ValidPassword;
import pl.javastart.validationtask.constraint.ZipCode;

public class RegisterFormDto {

    static final String NO_EMPTY_MESSAGE = "Pole nie może być puste";
    static final String MIN_3_CHAR_MESSAGE = "Pole musi mieć conajmniej 3 znaki";
    @NotBlank(message = NO_EMPTY_MESSAGE)
    @Size(min = 3, max = 20, message = MIN_3_CHAR_MESSAGE)
    private String firstName;
    @NotBlank(message = NO_EMPTY_MESSAGE)
    @Size(min = 3, max = 20, message = MIN_3_CHAR_MESSAGE)
    private String surname;
    @NotBlank(message = NO_EMPTY_MESSAGE)
    @Size(min = 2, max = 50, message = MIN_3_CHAR_MESSAGE)
    private String address;
    @NotBlank(message = NO_EMPTY_MESSAGE)
    @ZipCode
    private String postalCode;
    @NotBlank(message = NO_EMPTY_MESSAGE)
    private String city;
    @Email(message = "musi być poprawnie sformatowanym adresem e-mail", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;
    @NotBlank(message = NO_EMPTY_MESSAGE)
    @Size(min = 8, max = 20, message = "Hasło musi mieć co najmniej 8 znaków")
    @ValidPassword
    private String password;
    @AssertTrue(message = "akceptacja regulaminu jest wymagana")
    private boolean termsAgreement;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isTermsAgreement() {
        return termsAgreement;
    }

    public void setTermsAgreement(boolean termsAgreement) {
        this.termsAgreement = termsAgreement;
    }
}
