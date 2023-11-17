package com.example.phase3.service.Impl;

import com.example.phase3.dto.SpecialistDTO;
import com.example.phase3.entity.Order;
import com.example.phase3.entity.Proposal;
import com.example.phase3.entity.Specialist;
import com.example.phase3.enumeration.OrderStatus;
import com.example.phase3.enumeration.SpecialistStatus;
import com.example.phase3.exception.*;
import com.example.phase3.exception.NullPointerException;
import com.example.phase3.repository.OrderRepository;
import com.example.phase3.repository.ProposalRepository;
import com.example.phase3.repository.SpecialistRepository;
import com.example.phase3.service.SpecialistService;
import com.example.phase3.util.ImageUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class SpecialistServiceImpl implements SpecialistService {

    private final SpecialistRepository specialistRepository;

    private final OrderRepository orderRepository;

    private final ProposalRepository proposalRepository;

    @Override
    public void saveSpecialist(Specialist specialist) throws NullPointerException {
        if (specialist == null) {
            throw new NullPointerException();
        }
        specialist.setSpecialistStatus(SpecialistStatus.AWAITING_TO_CONFIRM);
        specialistRepository.save(specialist);
    }

    @Override
    public SpecialistDTO getCustomerByEmailAndPassword(String email, String password) throws InvalidUserNameAndPasswordException, AuthenticationNotFoundException {
        if (email == null || email.equals("") || password == null || password.equals("")){
            throw new InvalidUserNameAndPasswordException();
        }
        Specialist specialist = specialistRepository.getSpecialistByEmailAndPassword(email, password);
        if (specialist == null){
            throw new AuthenticationNotFoundException();
        }
        return SpecialistDTO.fromSpecialistDTO(specialist);
    }


    @Override
    public List<SpecialistDTO> getAllSpecialists() {
        List<Specialist> specialists = specialistRepository.findAll();
        return specialists.stream()
                .map(SpecialistDTO::fromSpecialistDTO)
                .toList();
    }

    @Override
    public void updateSpecialist(String email, Specialist specialist) throws InvalidEmailException, NullPointerException {
        if (email == null || email.equals("")) {
            throw new InvalidEmailException();
        }
        Specialist specialistUpdate = specialistRepository.findByEmail(email);
        if (specialist == null) {
            throw new NullPointerException();
        }
        specialistUpdate.setEmail(specialist.getEmail());
        specialistUpdate.setPassword(specialist.getPassword());
        specialistRepository.save(specialistUpdate);
    }

    @Override
    public void deleteSpecialist(long id) throws AuthenticationNotFoundException {
        Specialist specialist = specialistRepository.getSpecialistById(id);
        if (specialist == null) {
            throw new AuthenticationNotFoundException();
        }
        specialistRepository.delete(specialist);
    }

    @Override
    public void specialistsGiveProposal(long id, long orderId, Proposal proposal) throws UnAuthorizedSpecialistException {
        Specialist specialist = specialistRepository.getSpecialistById(id);
        if (specialist.getSpecialistStatus().equals(SpecialistStatus.CONFIRM)){
            Order order = orderRepository.getOrderById(orderId);
            order.setOrderStatus(OrderStatus.AWAITING_SPECIALIST_SELECTION);
            proposal.setSpecialist(specialist);
            proposal.setOrder(order);
            proposalRepository.save(proposal);
        }else {
            throw new UnAuthorizedSpecialistException();
        }

    }

    @Override
    public String uploadImage(long id, MultipartFile file) throws IOException {
//        Specialist specialist = specialistRepository.getSpecialistById(id);
//        specialist.setProfilePicture(ImageUtils.compressImage(file.getBytes()));
//        specialistRepository.save(specialist);
//        if (specialist.getProfilePicture() == null) {
//            return "file uploaded successfully";
//        }
//        return null;
        Specialist specialist = specialistRepository.getSpecialistById(id);
        if (file.getSize() <= 300 * 1024) {
            specialist.setProfilePicture(ImageUtils.compressImage(file.getBytes()));
            specialistRepository.save(specialist);
            return "File uploaded successfully";
        } else {
            return "File size exceeds the allowed limit of 300 kilobytes";
        }
    }

    @Override
    public byte[] downloadImage(long id) {
        Specialist specialist = specialistRepository.getSpecialistById(id);
        byte[] images = ImageUtils.decompressImage(specialist.getProfilePicture());
        return images;
    }
}
