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
 *  This file is part of the auxiliaries of VIB (Virtual Interactive Behaviour).
 */

package vib.auxiliary.player.ogre.capture;

/**
 *
 * @author Andre-Marie Pez
 */
public interface CaptureListener {

    /**
     * Called when a capture is started by a {@code Capturer}.
     * @param source the {@code Capturer} which starts the capture.
     * @param time the VIB's time in milliseconds.
     */
    public void captureStarted(Capturer source, long time);

    /**
     * Called when a new frame is captured by a {@code Capturer}.
     * @param source the {@code Capturer} which captures the new frame.
     * @param time the VIB's time in milliseconds.
     */
    public void captureNewFrame(Capturer source, long time);

    /**
     * Called when a capture is ended by a {@code Capturer}.
     * @param source the {@code Capturer} which ends the capture.
     * @param time the VIB's time in milliseconds.
     */
    public void captureEnded(Capturer source, long time);
}
