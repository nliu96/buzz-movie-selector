package rottenTomatoes;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

/**
 *
 * @author dylanfloyd
 */
@Generated("org.jsonschema2pojo")
/**
 *
 * @author theaz_000
 */
public class AlternateIds implements Serializable {
    
    @Expose
    private String imdb;

    /**
     *
     * @return
     */
    public String getImdb() {
        return imdb;
    }

    /**
     *
     * @param imdb
     */
    public void setImdb(String imdb) {
        this.imdb = imdb;
    }
    
    
}