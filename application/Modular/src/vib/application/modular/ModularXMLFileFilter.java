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
 * This file is a part of the Modular application.
 */

package vib.application.modular;

import java.io.File;
import javax.swing.filechooser.FileFilter;
import vib.core.util.xml.XML;
import vib.core.util.xml.XMLParser;
import vib.core.util.xml.XMLTree;

/**
 *
 * @author Andre-Marie Pez
 */
public class ModularXMLFileFilter extends FileFilter{

    private XMLParser parser;
    private static String markup = "modulated";
    private static String description = "Modular (xml)";
    private static String xml = ".xml";

    public ModularXMLFileFilter(){
        parser = XML.createParser();
        parser.setValidating(false);
    }

    @Override
    public boolean accept(File f) {
        if(f.isDirectory()) {
            return true;
        }
        if(! f.getName().toLowerCase().endsWith(xml)) {
            return false;
        }
        XMLTree xmltree = parser.parseFile(f.getAbsolutePath());
        return xmltree!=null && xmltree.getName().equalsIgnoreCase(markup);
    }

    @Override
    public String getDescription() {
        return description;
    }

}
