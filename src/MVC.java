import Controller.ContactController;
import Model.ContactModel;
import View.ListView;

public class MVC {
    ContactModel contactModel = new ContactModel();
    ListView listView = new ListView();
    ContactController contactController = new ContactController(contactModel,listView);
}
