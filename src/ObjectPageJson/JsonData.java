
package ObjectPageJson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonData {

    @SerializedName("NewCustomer")
    @Expose
    private NewCustomer newCustomer;
    @SerializedName("EditCustomer")
    @Expose
    private EditCustomer editCustomer;

    public NewCustomer getNewCustomer() {
        return newCustomer;
    }

    public void setNewCustomer(NewCustomer newCustomer) {
        this.newCustomer = newCustomer;
    }

    public EditCustomer getEditCustomer() {
        return editCustomer;
    }

    public void setEditCustomer(EditCustomer editCustomer) {
        this.editCustomer = editCustomer;
    }

}
