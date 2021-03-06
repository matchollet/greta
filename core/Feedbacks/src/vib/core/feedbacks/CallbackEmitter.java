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
package vib.core.feedbacks;

/**
 *
 * @author Ken Prepin
 */
public interface CallbackEmitter {
    /**
     * Adds an {@code CallbackEmitter}.<br/>
     * The function {@code performeCallbacks} of all {@code CallbackPerformer}
     * added will be called when this emmits a list of {@code Callbacks}.
     * @param performer the {@code CallbackPerformer} to add
     * @see vib.core.feedbacks.CallbackPerformer#performCallback(vib.core.feedbacks.Callback)
     */
    public void addCallbackPerformer(CallbackPerformer performer);

    /**
     * Removes the first occurence of an {@code CallbackPerformer}.
     * @param performer the {@code CallbackPerformer} to remove
     */
    public void removeCallbackPerformer(CallbackPerformer performer);
}
