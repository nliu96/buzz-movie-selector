package rottenTomatoes;
 
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
import org.primefaces.event.ToggleEvent;
 
/**
 *
 * @author dylanfloyd
 */
@ManagedBean
public class FieldsetView {
     
    /**
     * Event handler
     * @param event
     */
    public void handleToggle(ToggleEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Toggled", "Visibility:" + event.getVisibility());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}