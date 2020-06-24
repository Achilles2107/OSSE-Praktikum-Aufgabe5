package residents.service;

import residents.domain.Resident;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import residents.domain.ResidentRepositoryStub;
import residents.repository.ResidentRepository;
import residents.service.BaseResidentService;

import java.security.UnrecoverableEntryException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ResidentRepositoryTest {
    @Test
    public void givenNameWildcardTest(){
        BaseResidentService residentService = new BaseResidentService();
        residentService.setResidentRepository(new ResidentRepositoryStub());

        List<Resident> filteredList = residentService.getFilteredResidentsList(new Resident(" H*", "", "", "", null));
        Resident[] givenNameList = new Resident[2];

        for(Resident r : filteredList){
            assertEquals("Heinrich", r.getGivenName());
        }

        filteredList = residentService.getFilteredResidentsList(new Resident(" M*", "", "", "", null));

        for(Resident r : filteredList){
            //givenNameList.
                    assertEquals("Heinrich", r.getGivenName());
        }

    }


    @Test
    public void residentServiceRepoTest(){
        BaseResidentService residentService = new BaseResidentService();
        residentService.setResidentRepository(new ResidentRepositoryStub());

        List<Resident> filteredList = residentService.getFilteredResidentsList(new Resident(" P*", "", "", "", null));

        for(Resident r : filteredList){
            assertEquals("Peter", r.getGivenName());
        }

    }
}