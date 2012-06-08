/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package smartrics.rest.fitnesse.fixture.support.http;

import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.URIException;

/**
 *
 * @author < href="mailto:peter.grund@1und1.de">pgrund</a>
 */
public class OptionsMethod extends org.apache.commons.httpclient.methods.OptionsMethod {

    @SuppressWarnings("deprecation")
    public URI getURI() throws URIException {
        HostConfiguration conf = super.getHostConfiguration();
        String scheme = conf.getProtocol().getScheme();
        String host = conf.getHost();
        int port = conf.getPort();
        return new URIBuilder().getURI(scheme, host, port, getPath(), getQueryString(), getParams());
    }

    public void setURI(URI uri) throws URIException {
        new URIBuilder().setURI(this, uri);
    }
}
