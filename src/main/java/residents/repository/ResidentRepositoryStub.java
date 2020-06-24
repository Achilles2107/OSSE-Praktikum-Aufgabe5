package residents.repository;

import residents.domain.Resident;
import residents.repository.ResidentRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Date;

public class ResidentRepositoryStub implements ResidentRepository {

    private List<Resident> residents;
    public ResidentRepositoryStub(List<Resident> residents){
        this.residents = residents;
    }

    @Override
    public List<Resident> getResidents() {
        return this.residents;
    }

}