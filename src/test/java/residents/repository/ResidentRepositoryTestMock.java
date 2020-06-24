package residents.repository;

import residents.domain.Resident;
import residents.service.BaseResidentService;
import residents.service.ResidentServiceException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import java.util.Arrays;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


public class ResidentRepositoryTestMock {
    private BaseResidentService residentService;
    private ResidentRepository residentRepositoryMock;
    private List<Resident> residentList = new LinkedList<>();

    public ResidentRepositoryTestMock() throws ParseException {
        String[][] data = {
                {"Max", "Mustermann", "Musterstr", "Musterstadt", "1955-05-01"},
                {"Martina", "Musterfrau", "Musteralee", "Musterdorf", "2002-02-20"},
                {"Obelix", "Gallier", "Zeltweg", "Kaff", "1997-08-18"},
                {"Klaus", "Klausmann", "Teststr", "München", "2002-04-12"},
                {"Claudia", "Klosterfrau", "Testpfad", "Frankfurt", "2020-02-22"},
                {"Claudio", "Klosterfrau", "Testpfad", "Frankfurt", "2020-02-22"}
        };

        for (String[] s : data)
            residentList.add(new Resident(s[0], s[1], s[2], s[3], new SimpleDateFormat("yyyy-MM-dd").parse(s[4])));

        ResidentRepositoryStub residentRepositoryStub = new ResidentRepositoryStub(residentList);
        this.residentService = new BaseResidentService();
        this.residentService.setResidentRepository(residentRepositoryStub);

        this.residentRepositoryMock = createMock(ResidentRepository.class);
        expect(residentRepositoryMock.getResidents()).andReturn(residentList);
        replay(residentRepositoryMock);
        residentService.setResidentRepository(residentRepositoryMock);
    }

    @Test
    public void unique() throws Exception {
        Resident resident = new Resident("Max", "Mustermann", "Musterstr", "mustadsasderstadt", new SimpleDateFormat("yyyy-MM-dd").parse("1955-05-01"));
        assertThat(resident.getFamilyName(), equalTo(residentService.getUniqueResident(resident).getFamilyName()));
        verify(residentRepositoryMock);
    }

    @Test(expected = ResidentServiceException.class)
    public void uniqueWithWildcard() throws Exception {
        residentService.getUniqueResident(new Resident("Cl*", "", "", "", null));
        verify(residentRepositoryMock);
    }

    @Test
    public void filteredListTest() {
        assertThat(Arrays.asList(residentList.get(4), residentList.get(5)), equalTo(residentService.getFilteredResidentsList(new Resident("", "Klo*", "", "", null))));
        verify(residentRepositoryMock);

    }
}