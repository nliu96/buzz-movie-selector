package rottenTomatoes;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
/**
 *
 * @author theaz_000
 */
public class SearchLink implements Serializable {
    
    @Expose
    private String self;
    @Expose
    private String next;

    public String getSelf() {
        return self;
    }

    public String getNext() {
        return next;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public void setNext(String next) {
        this.next = next;
    }
    
    
}
