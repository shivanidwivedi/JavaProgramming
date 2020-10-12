package design_questions;

import javax.validation.Payload;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author shivanidwivedi on 11/10/20
 * @project JavaProgramming
 */
public class LibraryDependency {
    private void installLibraries(Library head){
        Set<Library> installedLibraries = new HashSet<>();
        installLibrary(head, installedLibraries);
    }
    private Payload installPayLoad(Payload payload){
        return payload;
    }

    void installLibrary(Library currentLibrary, Set<Library> installedLibraries){
        if(currentLibrary == null){
            throw new IllegalArgumentException("Unable to install new library");
        }
        for(Library current : installedLibraries){
            if(!installedLibraries.contains(currentLibrary)){
                installLibrary(current, installedLibraries);
            }
        }
        installPayLoad(currentLibrary.getPayload());
        installedLibraries.add(currentLibrary);
    }


}

abstract class Library{
    private Payload payload;
    abstract Payload getPayload();
    abstract List<Library> getDependency();
}