/*  Copyright 2012 Fabrizio Cannizzo
 *
 *  This file is part of RestFixture.
 *
 *  RestFixture (http://code.google.com/p/rest-fixture/) is free software:
 *  you can redistribute it and/or modify it under the terms of the
 *  GNU Lesser General Public License as published by the Free Software Foundation,
 *  either version 3 of the License, or (at your option) any later version.
 *
 *  RestFixture is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with RestFixture.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  If you want to contact the author please leave a comment here
 *  http://smartrics.blogspot.com/2008/08/get-fitnesse-with-some-rest.html
 */
package smartrics.rest.fitnesse.fixture.support.http;

import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.URIException;

/**
 * Delete method, enhanced with support of query parameters.
 * 
 * @author smartrics
 * 
 */
public class DeleteMethod extends org.apache.commons.httpclient.methods.DeleteMethod {
    @SuppressWarnings("deprecation")
    public URI getURI() throws URIException {
		return URIBuilder.newURI(this, super.getHostConfiguration());
    }

    public void setURI(URI uri) throws URIException {
        new URIBuilder().setURI(this, uri);
    }
}
