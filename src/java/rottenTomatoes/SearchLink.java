package rottenTomatoes;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import javax.annotation.Generated;

/**
 *
 * @author dylanfloyd
 */
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

    /**
     *
     * @return
     */
    public String getSelf() {
        return self;
    }

    /**
     *
     * @return
     */
    public String getNext() {
        return next;
    }

    /**
     *
     * @param self
     */
    public void setSelf(String self) {
        this.self = self;
    }

    /**
     *
     * @param next
     */
    public void setNext(String next) {
        this.next = next;
    }
    
    
}
