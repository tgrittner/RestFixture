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
package smartrics.rest.fitnesse.fixture.support;

import java.util.Map;

import org.w3c.dom.NodeList;

import smartrics.rest.client.RestResponse;

/**
 * Handles let expressions on XML content, returning XML string rather than the
 * string with the content within the tags.
 * 
 * @author smartrics
 * 
 */
public class LetBodyXmlHandler implements LetHandler {

    @Override
    public String handle(RestResponse response, Object expressionContext, String expression) {
        @SuppressWarnings("unchecked")
        Map<String, String> namespaceContext = (Map<String, String>) expressionContext;
        NodeList list = Tools.extractXPath(namespaceContext, expression, response.getBody());
        String val = Tools.xPathResultToXmlString(list);
        int pos = val.indexOf("?>");
        if (pos >= 0) {
            val = val.substring(pos + 2);
        }
        return val;
    }

}
