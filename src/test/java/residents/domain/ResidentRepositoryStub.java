package residents.domain;

import residents.repository.ResidentRepository;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static residents.domain.Resident.*;

import residents.domain.Resident;
import residents.repository.ResidentRepository;

public class ResidentRepositoryStub implements ResidentRepository {
    public List<Resident> getResidents() {

        List<Resident> list = new LinkedList<>();

        list.add(new Resident("Johannes", "Mustermann", "Musterstr",
                "Musterstadt", new Date(1955,5,1)));

        list.add(new Resident("Martina", "Musterfrau", "Musteralee",
                "Musterdorf", new Date(2002, 2, 20)));

        list.add(new Resident("Heinrich", "Klausmann", "Teststr",
                "München", new Date(1997, 8, 18)));


        return list;
    }
}