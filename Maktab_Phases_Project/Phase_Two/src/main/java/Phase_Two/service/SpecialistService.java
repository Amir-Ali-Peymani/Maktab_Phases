package Phase_Two.service;

import Phase_Two.entity.Specialist;

import java.util.List;

public interface SpecialistService {

    void saveSpecialist(Specialist specialist);

    Specialist getSpecialistById(Long id);

    List<Specialist> getAllSpecialists();

    void updateSpecialist(Specialist specialist);

    void deleteSpecialist(Specialist specialist);
}
