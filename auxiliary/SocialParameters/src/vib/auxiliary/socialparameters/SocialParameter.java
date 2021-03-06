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
 *  This file is part of VIB (Virtual Interactive Behaviour).
 */
package vib.auxiliary.socialparameters;

import vib.core.util.animationparameters.AnimationParameter;

/**
 *
 * @author Florian Pecune
 */
public class SocialParameter extends AnimationParameter {

    public static final double FLOAT_PRECISION = 1000000;
    private static final double INVALID_VALUE = 2;


    public SocialParameter(){
        super();
    }

    public SocialParameter(boolean mask, int value){
        super(mask, value);
    }

    public SocialParameter(SocialParameter sp){
        super(sp);
    }

    public double getDoubleValue() {
        return getValue()/FLOAT_PRECISION;
    }

    public void setDoubleValue (double value) {
        applyValue((int)(value*FLOAT_PRECISION));
    }

    public void setAsInvalid(){
        setDoubleValue(INVALID_VALUE);//or any value outside [-1, 1]
    }

    public boolean isInvalid(){
        return getValue()>FLOAT_PRECISION || getValue()<-FLOAT_PRECISION;
    }
}
