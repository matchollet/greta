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
package vib.core.util.animationparameters;

import vib.core.util.Constants;
import vib.core.util.log.Logs;
import vib.core.util.time.Timer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Andre-Marie Pez
 */
public abstract class AnimationParametersFrameParser<APF extends AnimationParametersFrame>{

    protected abstract APF instanciateFrame();

    public List<APF> readFromFile(String filename, boolean zeroIsNow) {
        ArrayList<APF> frames = new ArrayList<APF>();
        if (new File(filename).exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(filename));
                String line = br.readLine(); //TODO: detect frame rate or bap version from this first line
                int startTime = (int) (Timer.getTime()*Constants.FRAME_PER_SECOND);
                while ((line = br.readLine()) != null) {
                    String firstline = line;
                    String secondline = br.readLine();

                    APF frame = instanciateFrame();
                    frame.readFromString(firstline, secondline);

                    if(zeroIsNow) {
                        frame.setFrameNumber(frame.getFrameNumber() + startTime);
                    }

                    frames.add(frame);
                }
                br.close();
            } catch (Exception ignored) {
                Logs.warning("Error reading file: " + ignored);
            }
        }
        return frames;
    }

    public List<APF> readFromString(String framesString, boolean hasHeader, boolean zeroIsNow) {
        ArrayList<APF> frames = new ArrayList<APF>();
        StringTokenizer lines = new StringTokenizer(framesString, "\n\r");
        if(hasHeader){
            String header = lines.nextToken(); //TODO: detect frame rate or bap version from this first line
        }

        int startTime = (int) (Timer.getTime()*Constants.FRAME_PER_SECOND);

        while (lines.hasMoreTokens()) {
            String firstline = lines.nextToken();
            String secondline = lines.nextToken();

            APF frame = instanciateFrame();
            frame.readFromString(firstline, secondline);
            if(zeroIsNow) {
                frame.setFrameNumber(frame.getFrameNumber() + startTime);
            }

            frames.add(frame);
        }
        return frames;
    }

}
