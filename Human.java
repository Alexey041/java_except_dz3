public class Human {
    private String firstname;
    protected String lastname;
    private String patronymic;
    private String birthDate;
    private String phoneNumber;
    private String gender;
    
    public Human(String firstname, String lastname, String patronymic, String birthDate, String phoneNumber,
            String gender) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Human [firstname=" + firstname + ", lastname=" + lastname + ", patronymic=" + patronymic
                + ", birthDate=" + birthDate + ", phoneNumber=" + phoneNumber + ", gender=" + gender + "]";
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
