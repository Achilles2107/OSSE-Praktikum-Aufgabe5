package residents.service;

import residents.domain.Resident;
import residents.repository.ResidentRepositoryStub;
import residents.service.ResidentServiceException;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import residents.repository.ResidentRepository;
import residents.service.BaseResidentService;
import residents.repository.ResidentRepositoryStub.*;

import java.security.UnrecoverableEntryException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

public class ResidentRepositoryTest {
    private BaseResidentService residentService;

    private String[][] data = {
            {"Max", "Mustermann", "Musterstr", "Musterstadt", "1955-05-01"},
            {"Martina", "Musterfrau", "Musteralee","Musterdorf", "2002-02-20"},
            {"Obelix", "Gallier", "Zeltweg", "Kaff", "1997-08-18"},
            {"Klaus", "Klausmann", "Teststr", "München", "2002-04-12"},
            {"Claudia", "Klosterfrau", "Testpfad", "Frankfurt", "2020-02-22"},
            {"Claudio", "Klosterfrau", "Testpfad", "Frankfurt", "2020-02-22"}
    };

    public ResidentRepositoryTest() throws ParseException {
        List<Resident> list = new LinkedList<>();

        for (String[] s : this.data)
            list.add(new Resident(s[0], s[1], s[2], s[3], new SimpleDateFormat("yyyy-MM-dd").parse(s[4])));

        ResidentRepositoryStub residentRepositoryStub = new ResidentRepositoryStub(list);
        this.residentService = new BaseResidentService();
        this.residentService.setResidentRepository(residentRepositoryStub);
    }

    @Test
    public void filteredListTest() {


        List<Resident> filteredList = this.residentService.getFilteredResidentsList(new Resident("M*", "", "", "", null));
        assertEquals("Max", filteredList.get(0).getGivenName());
        assertEquals("Martina", filteredList.get(1).getGivenName());

        filteredList = this.residentService.getFilteredResidentsList(new Resident("", "*mann", "", "", null));
        assertEquals("Mustermann", filteredList.get(0).getFamilyName());
        assertEquals("Klausmann", filteredList.get(1).getFamilyName());

        filteredList = this.residentService.getFilteredResidentsList(new Resident("Martina", "", "", "Musterdorf", null));
        assertEquals("Musterfrau", filteredList.get(0).getFamilyName());


    }

    @Test(expected = ResidentServiceException.class)
    public void notSoUniqueTest() throws ResidentServiceException{
        this.residentService.getUniqueResident(new Resident("", "Klosterfrau", "", "", null));
    }

    @Test
    public void uniqueTest() throws ResidentServiceException{
        assertEquals(this.residentService.getUniqueResident(new Resident("Claudio", "Klosterfrau", "", "", null)).getFamilyName(),  "Klosterfrau");
        assertEquals(this.residentService.getUniqueResident(new Resident("Obelix", "", "", "", null)).getFamilyName(),  "Gallier");
        assertEquals(this.residentService.getUniqueResident(new Resident("", "", "Musteralee", "", null)).getFamilyName(),  "Musterfrau");

    }
}