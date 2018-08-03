/*
 * This file is part of VIB (Virtual Interactive Behaviour).
 */
package vib.core.behaviorrealizer.keyframegenerator;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import vib.core.keyframes.ExpressivityParameters;
import vib.core.keyframes.Keyframe;
import vib.core.keyframes.ShoulderKeyframe;
import vib.core.keyframes.TorsoKeyframe;
import vib.core.signals.ShoulderSignal;
import vib.core.signals.Signal;
import vib.core.signals.SpineDirection;
import vib.core.signals.SpinePhase;
import vib.core.signals.TorsoSignal;
import vib.core.util.math.Quaternion;

/**
 *
 * @author Quoc Anh Le
 */
public class TorsoKeyframeGenerator extends KeyframeGenerator {
    
    private TorsoKeyframe defaultPosition;
    
    public TorsoKeyframeGenerator() {
        super(TorsoSignal.class);
        defaultPosition = new TorsoKeyframe("rest", new SpinePhase("rest", 0, 0), "rest");
    }

    @Override
    protected void generateKeyframes(List<Signal> inputSignals, List<Keyframe> outputKeyframes) {

        for (Signal signal : inputSignals) {
            
            TorsoSignal torso = (TorsoSignal) signal;           
            torso.schedulePhases();
            
            LinkedList<TorsoKeyframe> keyframes = new LinkedList<TorsoKeyframe>();                   
            TorsoKeyframe startKeyframe = null;

            if(keyframes.isEmpty()) {
                startKeyframe = new TorsoKeyframe(defaultPosition);
            }
            else if(keyframes.peekLast().getOffset()<=torso.getPhases().get(0).getStartTime()){
                startKeyframe = new TorsoKeyframe(keyframes.peekLast());
            }

            if(startKeyframe != null){
                setTimeOn(startKeyframe, torso.getStartValue());
                ExpressivityParameters e = new ExpressivityParameters();
                e.fld = torso.getFLD();
                e.pwr = torso.getPWR();
                e.spc = torso.getSPC();
                e.tmp = torso.getTMP();
                e.tension = torso.getTension();
                startKeyframe.setParameters(e);
                
                if (torso.shoulder){
                    startKeyframe.setOnlytheShoulder();
                }
                
                keyframes.add(startKeyframe);
            }

            keyframes.add(createKeyFrame(torso, torso.getPhases().get(torso.getPhases().size()-1)));
            
            //V) add the ShoulderKeyframe into the output list
            outputKeyframes.addAll(keyframes);

            //VI) save the last position
            setRestPosition(keyframes.peekLast());

            /*for (SpinePhase phase : torso.getPhases()) {
                TorsoKeyframe keyframe = new TorsoKeyframe(torso.getId(), phase, torso.getCategory());
                ExpressivityParameters e = new ExpressivityParameters();
                e.fld = torso.getFLD();
                e.pwr = torso.getPWR();
                e.spc = torso.getSPC();
                e.tmp = torso.getTMP();
                e.tension = torso.getTension();
                keyframe.setParameters(e);
                outputKeyframes.add(keyframe);
            }*/
            /*
             * TorsoKeyframe keyframe_start = new
             * TorsoKeyframe(signal.getId(), torso.getCategory(),
             * torso.getStart(), (torso.getEnd()+torso.getStart())/2);
             * TorsoKeyframe keyframe_end = new
             * TorsoKeyframe(signal.getId(), "stand",
             * (torso.getEnd()+torso.getStart())/2, torso.getEnd());
             *
             * keyframes.add(keyframe_start); keyframes.add(keyframe_end);
             *
             */            
        }
    }

    @Override
    protected Comparator<Signal> getComparator() {
        return emptyComparator;
    }
    
    private void setTimeOn(TorsoKeyframe kf, double time){
        kf.setOffset(time);
        kf.setOnset(time);
    }
    
    private void setRestPosition(TorsoKeyframe phase){
        defaultPosition.verticalTorsion = new SpineDirection(phase.verticalTorsion); //phase.verticalTorsion;
        return;
    }
    
    private TorsoKeyframe createKeyFrame(TorsoSignal sh, SpinePhase phase) {
        TorsoKeyframe keyframe = new TorsoKeyframe(sh.getId(), phase, sh.getCategory());
        if (sh.shoulder){
            keyframe.setOnlytheShoulder();}
        
        ExpressivityParameters e = new ExpressivityParameters();

        e.fld = sh.getFLD();
        e.pwr = sh.getPWR();
        e.spc = sh.getSPC();
        e.tmp = sh.getTMP();
        e.tension = sh.getTension();
        keyframe.setParameters(e);
        return keyframe;
    }
    
    protected TorsoKeyframe interpolate(TorsoKeyframe first, TorsoKeyframe second, double time){
        double t = (time - first.getOffset()) / (second.getOffset()-first.getOffset());
  
        TorsoKeyframe result = new TorsoKeyframe(); // first
        //result = first
        
        SpineDirection vert = new SpineDirection(first.verticalTorsion);
        vert.inverse();
        
        result.verticalTorsion= vert;
        result.verticalTorsion.add(second.verticalTorsion);
        
        //result.lateralRoll.inverse();
        //result.sagittalTilt.inverse();
        //result.verticalTorsion.inverse();
        //result = -first
        
        //blend(result, second);
        //result = second+(-first)


        //result.lateralRoll.multiply(t);
        //result.sagittalTilt.multiply(t);
        result.verticalTorsion.multiply(t);
        //result = t*(second-first)

        result.verticalTorsion.add(first.verticalTorsion);
        //blend(result, first);
        //result = t*(second-first) + first

        setTimeOn(result, time);
        return result;
    }
    
    protected void blend(TorsoKeyframe first, TorsoKeyframe second) {
        //first.lateralRoll.add(second.lateralRoll);
        //first.sagittalTilt.add(second.sagittalTilt);
        first.verticalTorsion.add(second.verticalTorsion);
    }
    
}
