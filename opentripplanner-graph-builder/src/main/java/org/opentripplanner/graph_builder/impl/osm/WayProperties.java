/* This program is free software: you can redistribute it and/or
 modify it under the terms of the GNU Lesser General Public License
 as published by the Free Software Foundation, either version 3 of
 the License, or (props, at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>. */

package org.opentripplanner.graph_builder.impl.osm;

import org.opentripplanner.common.model.P2;
import org.opentripplanner.routing.edgetype.StreetTraversalPermission;

/**
 * The common data for ways with a given set of tags: * the safety features * the slope override
 * 
 * @author novalis
 * 
 */
public class WayProperties implements Cloneable {

    private StreetTraversalPermission permission;

    /**
     * How much safer (less safe) this way is than the default, represented in terms of something
     * like DALYs lost per meter. The first element safety in the direction of the way and the
     * second is safety in the opposite direction.
     */
    private static final P2<Double> defaultSafetyFeatures = new P2<Double>(1.0, 1.0);

    private P2<Double> safetyFeatures = defaultSafetyFeatures;

    public void setSafetyFeatures(P2<Double> safetyFeatures) {
        this.safetyFeatures = safetyFeatures;
    }

    public P2<Double> getSafetyFeatures() {
        return safetyFeatures;
    }

    public void setPermission(StreetTraversalPermission permission) {
        this.permission = permission;
    }

    public StreetTraversalPermission getPermission() {
        return permission;
    }

    public WayProperties clone() {
        WayProperties result;
        try {
            result = (WayProperties) super.clone();
            result.setSafetyFeatures(new P2<Double>(safetyFeatures.getFirst(), safetyFeatures
                    .getSecond()));
            return result;
        } catch (CloneNotSupportedException e) {
            // unreached
            throw new RuntimeException(e);
        }
    }

	public boolean equals(Object o) {
		if (o instanceof WayProperties) {
			WayProperties other = (WayProperties) o;
			return safetyFeatures.equals(other.safetyFeatures)
					&& permission == other.permission;
		}
		return false;
	}
}
