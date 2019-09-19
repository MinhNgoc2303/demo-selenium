
package ObjectPageJson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EditCustomer {

    @SerializedName("expectedEmptyCusId")
    @Expose
    private String expectedEmptyCusId;
    @SerializedName("numeric")
    @Expose
    private String numeric;
    @SerializedName("expectedIdNotNumberic")
    @Expose
    private String expectedIdNotNumberic;
    @SerializedName("specialCharacter")
    @Expose
    private String specialCharacter;
    @SerializedName("expectedSpecialCharacter_msg")
    @Expose
    private String expectedSpecialCharacterMsg;
    @SerializedName("lessThan6Digits")
    @Expose
    private String lessThan6Digits;
    @SerializedName("expectedEmptyAddress_msg")
    @Expose
    private String expectedEmptyAddressMsg;
    @SerializedName("expectedEmptyCity_msg")
    @Expose
    private String expectedEmptyCityMsg;
    @SerializedName("expectedNumberic_msg")
    @Expose
    private String expectedNumbericMsg;
    @SerializedName("expectedEmptyStateField_msg")
    @Expose
    private String expectedEmptyStateFieldMsg;
    @SerializedName("expectedEmptyPINField_msg")
    @Expose
    private String expectedEmptyPINFieldMsg;
    @SerializedName("expectedNumbericPINField_msg")
    @Expose
    private String expectedNumbericPINFieldMsg;
    @SerializedName("expectedEmptyTelephoneField_msg")
    @Expose
    private String expectedEmptyTelephoneFieldMsg;
    @SerializedName("expectedEmptyEmailField_msg")
    @Expose
    private String expectedEmptyEmailFieldMsg;
    @SerializedName("expectedInvalidFormatEmail_msg")
    @Expose
    private String expectedInvalidFormatEmailMsg;
    @SerializedName("invaldFormatMail")
    @Expose
    private String invaldFormatMail;

    public String getExpectedEmptyCusId() {
        return expectedEmptyCusId;
    }

    public void setExpectedEmptyCusId(String expectedEmptyCusId) {
        this.expectedEmptyCusId = expectedEmptyCusId;
    }

    public String getNumeric() {
        return numeric;
    }

    public void setNumeric(String numeric) {
        this.numeric = numeric;
    }

    public String getExpectedIdNotNumberic() {
        return expectedIdNotNumberic;
    }

    public void setExpectedIdNotNumberic(String expectedIdNotNumberic) {
        this.expectedIdNotNumberic = expectedIdNotNumberic;
    }

    public String getSpecialCharacter() {
        return specialCharacter;
    }

    public void setSpecialCharacter(String specialCharacter) {
        this.specialCharacter = specialCharacter;
    }

    public String getExpectedSpecialCharacterMsg() {
        return expectedSpecialCharacterMsg;
    }

    public void setExpectedSpecialCharacterMsg(String expectedSpecialCharacterMsg) {
        this.expectedSpecialCharacterMsg = expectedSpecialCharacterMsg;
    }

    public String getLessThan6Digits() {
        return lessThan6Digits;
    }

    public void setLessThan6Digits(String lessThan6Digits) {
        this.lessThan6Digits = lessThan6Digits;
    }

    public String getExpectedEmptyAddressMsg() {
        return expectedEmptyAddressMsg;
    }

    public void setExpectedEmptyAddressMsg(String expectedEmptyAddressMsg) {
        this.expectedEmptyAddressMsg = expectedEmptyAddressMsg;
    }

    public String getExpectedEmptyCityMsg() {
        return expectedEmptyCityMsg;
    }

    public void setExpectedEmptyCityMsg(String expectedEmptyCityMsg) {
        this.expectedEmptyCityMsg = expectedEmptyCityMsg;
    }

    public String getExpectedNumbericMsg() {
        return expectedNumbericMsg;
    }

    public void setExpectedNumbericMsg(String expectedNumbericMsg) {
        this.expectedNumbericMsg = expectedNumbericMsg;
    }

    public String getExpectedEmptyStateFieldMsg() {
        return expectedEmptyStateFieldMsg;
    }

    public void setExpectedEmptyStateFieldMsg(String expectedEmptyStateFieldMsg) {
        this.expectedEmptyStateFieldMsg = expectedEmptyStateFieldMsg;
    }

    public String getExpectedEmptyPINFieldMsg() {
        return expectedEmptyPINFieldMsg;
    }

    public void setExpectedEmptyPINFieldMsg(String expectedEmptyPINFieldMsg) {
        this.expectedEmptyPINFieldMsg = expectedEmptyPINFieldMsg;
    }

    public String getExpectedNumbericPINFieldMsg() {
        return expectedNumbericPINFieldMsg;
    }

    public void setExpectedNumbericPINFieldMsg(String expectedNumbericPINFieldMsg) {
        this.expectedNumbericPINFieldMsg = expectedNumbericPINFieldMsg;
    }

    public String getExpectedEmptyTelephoneFieldMsg() {
        return expectedEmptyTelephoneFieldMsg;
    }

    public void setExpectedEmptyTelephoneFieldMsg(String expectedEmptyTelephoneFieldMsg) {
        this.expectedEmptyTelephoneFieldMsg = expectedEmptyTelephoneFieldMsg;
    }

    public String getExpectedEmptyEmailFieldMsg() {
        return expectedEmptyEmailFieldMsg;
    }

    public void setExpectedEmptyEmailFieldMsg(String expectedEmptyEmailFieldMsg) {
        this.expectedEmptyEmailFieldMsg = expectedEmptyEmailFieldMsg;
    }

    public String getExpectedInvalidFormatEmailMsg() {
        return expectedInvalidFormatEmailMsg;
    }

    public void setExpectedInvalidFormatEmailMsg(String expectedInvalidFormatEmailMsg) {
        this.expectedInvalidFormatEmailMsg = expectedInvalidFormatEmailMsg;
    }

    public String getInvaldFormatMail() {
        return invaldFormatMail;
    }

    public void setInvaldFormatMail(String invaldFormatMail) {
        this.invaldFormatMail = invaldFormatMail;
    }

}
