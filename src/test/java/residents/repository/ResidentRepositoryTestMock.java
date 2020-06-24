package residents.repository;

import org.junit.Test;
import residents.domain.Resident;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;
import static residents.service.BaseResidentService.*;

public class ResidentRepositoryTestMock {

    @Test
    public void test(){

        List<Resident> list = new LinkedList<>();

        list.add(new Resident("Johannes", "Mustermann", "Musterstr",
                "Musterstadt", new Date(1955,5,1)));

        list.add(new Resident("Martina", "Musterfrau", "Musteralee",
                "Musterdorf", new Date(2002, 2, 20)));

        list.add(new Resident("Heinrich", "Klausmann", "Teststr",
                "München", new Date(1997, 8, 18)));


        ResidentRepository RepoMock = createMock(ResidentRepository.class);
        expect(RepoMock.getUniqueResident("1")).andReturn(quelle);
        expect(RepoMock.findeKonto("2")).andReturn(ziel);
        RepoMock.updateKonto(quelle);
        RepoMock.updateKonto(ziel);

    }

}