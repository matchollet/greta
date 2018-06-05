/*
 * This file is a part of the Modular application.
 */

package vib.application.modular.tools;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.AbstractListModel;
import vib.application.modular.ModularXMLFile;
import vib.application.modular.tools.LibListModel.LibElement;
import vib.core.util.xml.XMLTree;

/**
 *
 * @author Andre-Marie Pez
 */
public class LibListModel extends AbstractListModel<LibElement>{


    ArrayList<LibElement> libs;

    public LibListModel(){
        libs = new ArrayList<LibElement>();
        reload();
    }

    public void reload(){
        libs.clear();
        List<XMLTree> libsXML = ModularXMLFile.getLibs().getChildrenElement();
        libs.ensureCapacity(libsXML.size());
        for(XMLTree libXML : libsXML){
            if(libXML.isNamed("lib")){
                this.libs.add(new LibElement(libXML));
            }
        }
        Collections.sort(libs);
    }

    @Override
    public int getSize() {
        return libs.size();
    }

    @Override
    public LibElement getElementAt(int index) {
        return libs.get(index);
    }

    public LibElement createLib(){
        XMLTree libXML = ModularXMLFile.getLibs().createChild("lib");
        LibElement lib = new LibElement(libXML);
        libs.add(lib);
        Collections.sort(libs);
        int index = libs.indexOf(lib);
        fireIntervalAdded(this, index, index);
        return lib;
    }

    public void deleteLib(LibElement lib){
        lib.lib.getParent().removeChild(lib.lib);
        int index = libs.indexOf(lib);
        libs.remove(index);
        fireIntervalRemoved(this, index, index);
    }

    public void libIdChanged(LibElement lib){
//
//        int prev_index = libs.indexOf(lib);
//
        Collections.sort(libs);
//
//        int new_index = libs.indexOf(lib);
//
//        if(prev_index==new_index){
//            fireContentsChanged(this, new_index, new_index);
//        }
//        else{
//            fireIntervalRemoved(this, prev_index, prev_index);
//            fireIntervalAdded(this, new_index, new_index);
//        }
    }




    public class LibElement implements Comparable<LibElement>{

        XMLTree lib;
        NameChanger nc;

        private LibElement(XMLTree lib){
            this.lib = lib;
            updateNameChanger(false);
        }

        @Override
        public String toString() {
            return getId();
        }

        @Override
        public int compareTo(LibElement o) {
            return String.CASE_INSENSITIVE_ORDER.compare(getId(), o.getId());
        }

        public void updateNameChanger(boolean reference){
            nc = new NameChanger(lib, "id", reference);
        }

        public void setId(String name){
            nc.ApplyNewName(name);
            libIdChanged(this);
        }

        public String getId(){
            return lib.getAttribute("id");
        }

        public void setPath(String path) {
            lib.setAttribute("path", path);
        }

        public String getPath() {
            return lib.getAttribute("path");
        }

        public boolean exists(){
            return (new File(getPath())).exists();
        }

        public boolean isJar(){
            return getPath().toLowerCase().endsWith(".jar");
        }

        public void addDependence(String s) {
            XMLTree dep = lib.createChild("depends");
            dep.setAttribute("lib_id", s);
        }

        public void addNeed(String s) {
            XMLTree dep = lib.createChild("needs");
            dep.setAttribute("path", s);
        }
    }
}