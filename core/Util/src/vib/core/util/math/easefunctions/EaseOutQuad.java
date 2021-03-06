/* This file is part of Greta.
 * Greta is free software: you can redistribute it and / or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
* 
* Greta is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.See the
* GNU General Public License for more details.
* 
* You should have received a copy of the GNU General Public License
* along with Greta.If not, see <http://www.gnu.org/licenses/>.
*//*
 * This file is part of VIB (Virtual Interactive Behaviour).
 */

package vib.core.util.math.easefunctions;

import vib.core.util.math.Constante;
import vib.core.util.math.Function;
import vib.core.util.math.Product;
import vib.core.util.math.Sum;
import vib.core.util.math.X;

/**
 *
 * @author Jing Huang
 * @author Andre-Marie Pez
 */
public class EaseOutQuad implements Function {

      /**
     * Easing equation function for a quadratic (t^2) easing out: decelerating
     * to zero velocity.
     *
     * @param x	Current time (in frames or seconds).
     * @return	The correct value.
     */
    public double f(double x) {
        return -x * (x - 2);
    }

    public String getName() {
        return "EaseOutQuad";
    }

    @Override
    public Function getDerivative() {
        return Sum.of(Constante.of(2), Product.of(Constante.of(-2), X.x));
    }

    @Override
    public Function simplified() {
        return this;
    }
}
