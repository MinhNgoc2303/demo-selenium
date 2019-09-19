
package ObjectPageJson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewCustomer {

    @SerializedName("msgcustomernameExpected")
    @Expose
    private String msgcustomernameExpected;
    @SerializedName("msgNumericCaseExpected")
    @Expose
    private String msgNumericCaseExpected;
    @SerializedName("numericCase")
    @Expose
    private String numericCase;
    @SerializedName("specialCharacter")
    @Expose
    private String specialCharacter;
    @SerializedName("expectedSpecialCharactersMsg")
    @Expose
    private String expectedSpecialCharactersMsg;
    @SerializedName("expectedBlankCase")
    @Expose
    private String expectedBlankCase;
    @SerializedName("addressEmptyExpected_msg")
    @Expose
    private String addressEmptyExpectedMsg;
    @SerializedName("cityEmptyExpected")
    @Expose
    private String cityEmptyExpected;
    @SerializedName("stateEmptyExpected")
    @Expose
    private String stateEmptyExpected;
    @SerializedName("invalidNumberic")
    @Expose
    private String invalidNumberic;
    @SerializedName("invalidNumbericexpectedInvalidNUmberic_msg")
    @Expose
    private String invalidNumbericexpectedInvalidNUmbericMsg;
    @SerializedName("expectedEmptyPIN_msg")
    @Expose
    private String expectedEmptyPINMsg;
    @SerializedName("expectedInvalidPIN_msg")
    @Expose
    private String expectedInvalidPINMsg;
    @SerializedName("expectedEmptyTelephone_msg")
    @Expose
    private String expectedEmptyTelephoneMsg;
    @SerializedName("expectedEmptyEmail_msg")
    @Expose
    private String expectedEmptyEmailMsg;
    @SerializedName("incorrectEmailFormat")
    @Expose
    private String incorrectEmailFormat;
    @SerializedName("emailHaveSpace")
    @Expose
    private String emailHaveSpace;
    @SerializedName("expectedIncorrectEmail")
    @Expose
    private String expectedIncorrectEmail;
    @SerializedName("expectedEmptyCityField_msg")
    @Expose
    private String expectedEmptyCityFieldMsg;
    @SerializedName("customerName")
    @Expose
    private String customerName;
    @SerializedName("dateOfBirth")
    @Expose
    private String dateOfBirth;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("pin")
    @Expose
    private String pin;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("passwordNewCustomer")
    @Expose
    private String passwordNewCustomer;

    public String getMsgcustomernameExpected() {
        return msgcustomernameExpected;
    }

    public void setMsgcustomernameExpected(String msgcustomernameExpected) {
        this.msgcustomernameExpected = msgcustomernameExpected;
    }

    public String getMsgNumericCaseExpected() {
        return msgNumericCaseExpected;
    }

    public void setMsgNumericCaseExpected(String msgNumericCaseExpected) {
        this.msgNumericCaseExpected = msgNumericCaseExpected;
    }

    public String getNumericCase() {
        return numericCase;
    }

    public void setNumericCase(String numericCase) {
        this.numericCase = numericCase;
    }

    public String getSpecialCharacter() {
        return specialCharacter;
    }

    public void setSpecialCharacter(String specialCharacter) {
        this.specialCharacter = specialCharacter;
    }

    public String getExpectedSpecialCharactersMsg() {
        return expectedSpecialCharactersMsg;
    }

    public void setExpectedSpecialCharactersMsg(String expectedSpecialCharactersMsg) {
        this.expectedSpecialCharactersMsg = expectedSpecialCharactersMsg;
    }

    public String getExpectedBlankCase() {
        return expectedBlankCase;
    }

    public void setExpectedBlankCase(String expectedBlankCase) {
        this.expectedBlankCase = expectedBlankCase;
    }

    public String getAddressEmptyExpectedMsg() {
        return addressEmptyExpectedMsg;
    }

    public void setAddressEmptyExpectedMsg(String addressEmptyExpectedMsg) {
        this.addressEmptyExpectedMsg = addressEmptyExpectedMsg;
    }

    public String getCityEmptyExpected() {
        return cityEmptyExpected;
    }

    public void setCityEmptyExpected(String cityEmptyExpected) {
        this.cityEmptyExpected = cityEmptyExpected;
    }

    public String getStateEmptyExpected() {
        return stateEmptyExpected;
    }

    public void setStateEmptyExpected(String stateEmptyExpected) {
        this.stateEmptyExpected = stateEmptyExpected;
    }

    public String getInvalidNumberic() {
        return invalidNumberic;
    }

    public void setInvalidNumberic(String invalidNumberic) {
        this.invalidNumberic = invalidNumberic;
    }

    public String getInvalidNumbericexpectedInvalidNUmbericMsg() {
        return invalidNumbericexpectedInvalidNUmbericMsg;
    }

    public void setInvalidNumbericexpectedInvalidNUmbericMsg(String invalidNumbericexpectedInvalidNUmbericMsg) {
        this.invalidNumbericexpectedInvalidNUmbericMsg = invalidNumbericexpectedInvalidNUmbericMsg;
    }

    public String getExpectedEmptyPINMsg() {
        return expectedEmptyPINMsg;
    }

    public void setExpectedEmptyPINMsg(String expectedEmptyPINMsg) {
        this.expectedEmptyPINMsg = expectedEmptyPINMsg;
    }

    public String getExpectedInvalidPINMsg() {
        return expectedInvalidPINMsg;
    }

    public void setExpectedInvalidPINMsg(String expectedInvalidPINMsg) {
        this.expectedInvalidPINMsg = expectedInvalidPINMsg;
    }

    public String getExpectedEmptyTelephoneMsg() {
        return expectedEmptyTelephoneMsg;
    }

    public void setExpectedEmptyTelephoneMsg(String expectedEmptyTelephoneMsg) {
        this.expectedEmptyTelephoneMsg = expectedEmptyTelephoneMsg;
    }

    public String getExpectedEmptyEmailMsg() {
        return expectedEmptyEmailMsg;
    }

    public void setExpectedEmptyEmailMsg(String expectedEmptyEmailMsg) {
        this.expectedEmptyEmailMsg = expectedEmptyEmailMsg;
    }

    public String getIncorrectEmailFormat() {
        return incorrectEmailFormat;
    }

    public void setIncorrectEmailFormat(String incorrectEmailFormat) {
        this.incorrectEmailFormat = incorrectEmailFormat;
    }

    public String getEmailHaveSpace() {
        return emailHaveSpace;
    }

    public void setEmailHaveSpace(String emailHaveSpace) {
        this.emailHaveSpace = emailHaveSpace;
    }

    public String getExpectedIncorrectEmail() {
        return expectedIncorrectEmail;
    }

    public void setExpectedIncorrectEmail(String expectedIncorrectEmail) {
        this.expectedIncorrectEmail = expectedIncorrectEmail;
    }

    public String getExpectedEmptyCityFieldMsg() {
        return expectedEmptyCityFieldMsg;
    }

    public void setExpectedEmptyCityFieldMsg(String expectedEmptyCityFieldMsg) {
        this.expectedEmptyCityFieldMsg = expectedEmptyCityFieldMsg;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPasswordNewCustomer() {
        return passwordNewCustomer;
    }

    public void setPasswordNewCustomer(String passwordNewCustomer) {
        this.passwordNewCustomer = passwordNewCustomer;
    }

}
