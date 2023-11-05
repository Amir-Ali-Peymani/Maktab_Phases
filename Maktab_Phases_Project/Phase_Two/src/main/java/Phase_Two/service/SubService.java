package Phase_Two.service;

import org.springframework.util.function.SupplierUtils;

import java.util.List;

public interface SubService {

    void saveSubService(SubService subService);

    SubService getSubServiceById(Long id);

    SubService getSubServiceByName(String name);

    List<SubService> getAllSubServices();

    void updateSubService(SubService subService);

    void deleteSubService(SubService subService);
}
