/*  Copyright 2011 Fabrizio Cannizzo
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
package smartrics.rest.fitnesse.fixture;

import java.util.ArrayList;
import java.util.List;

import smartrics.rest.fitnesse.fixture.support.CellWrapper;
import smartrics.rest.fitnesse.fixture.support.RowWrapper;

/**
 * Wrapper class for a row when running with Slim.
 * 
 * @author smartrics
 * 
 */
public class SlimRow implements RowWrapper<String> {

	private final List<CellWrapper<String>> row;

	/**
	 * @param rawRow a list of string representing the row cells as passed by Slim.
	 */
    public SlimRow(List<String> rawRow) {
        this.row = new ArrayList<CellWrapper<String>>();
        for (String r : rawRow) {
            this.row.add(new SlimCell(r));
		}
	}

	public CellWrapper<String> getCell(int c) {
        if (c < this.row.size()) {
            return this.row.get(c);
		}
		return null;
	}

    public int size() {
        if (row != null) {
            return row.size();
        }
        return 0;
    }

    /**
     * @return the row as list of strings.
     */
    public List<String> asList() {
        List<String> ret = new ArrayList<String>();
        for (CellWrapper<String> w : row) {
            ret.add(w.body());
        }
        return ret;
    }

    public CellWrapper<String> removeCell(int c) {
        if (c < this.row.size()) {
            return this.row.remove(c);
        }
        return null;
    }
}
