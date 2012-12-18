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

import java.util.HashMap;
import java.util.Map;

/**
 * Builds strategies to handle LET body.
 * 
 * Supported strategies:
 * <table>
 * <tr>
 * <td>{@code header}</td><td>applies the expression to the response headers</td>
 * </tr>
 * <tr>
 * <td>{@code body}</td><td>applies the expression to the body</td>
 * </tr>
 * <tr>
 * <td>{@code body:xml}</td><td>applies the expression to the body as XML. expressions are XPaths.</td>
 * </tr>
 * <tr>
 * <td>{@code js}</td><td>applies expression to body as JSON</td>
 * </tr>
 * <tr>
 * <td>{@code const}</td><td>it's actually  a shortcut to allow setting of const labels</td>
 * </tr>
 * </table>
 * 
 * @author smartrics
 * 
 */
public class LetHandlerFactory {
    private static Map<String, LetHandler> strategies = new HashMap<String, LetHandler>();

    static {
        strategies.put("header", new LetHeaderHandler());
        strategies.put("body", new LetBodyHandler());
        strategies.put("body:xml", new LetBodyXmlHandler());
        strategies.put("js", new LetBodyJsHandler());
        strategies.put("const", new LetBodyConstHandler());
    }

    private LetHandlerFactory() {

    }

    /**
     * @param part
     * @return the handler for the given strategy. null if not found.
     */
    public static LetHandler getHandlerFor(String part) {
        return strategies.get(part);
    }
}
