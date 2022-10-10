package org.workshop.cc6.workshopserver.service.advisor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.workshop.cc6.workshopserver.data.entity.WorkshopUser;
import org.workshop.cc6.workshopserver.data.repository.AdvisorRepository;
import org.workshop.cc6.workshopserver.data.repository.UserRepository;
import org.workshop.cc6.workshopserver.data.repository.UserRoleRepository;
import org.workshop.cc6.workshopserver.dto.BaseResponse;
import org.workshop.cc6.workshopserver.dto.GetListResponse;
import org.workshop.cc6.workshopserver.dto.advisor.AdvisorModel;
import org.workshop.cc6.workshopserver.dto.advisor.CreateAdvisorRequest;
import org.workshop.cc6.workshopserver.dto.advisor.UpdateAdvisorRequest;
import org.workshop.cc6.workshopserver.dto.mapper.AdvisorMapper;

import javax.transaction.Transactional;

@Service
public class AdvisorService implements IAdvisorService {

    private final AdvisorRepository advisorRepository;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final AdvisorMapper advisorMapper;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AdvisorService(AdvisorRepository advisorRepository,
                          UserRepository userRepository,
                          UserRoleRepository userRoleRepository,
                          AdvisorMapper advisorMapper,
                          PasswordEncoder passwordEncoder
    ) {
        this.advisorRepository = advisorRepository;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.advisorMapper = advisorMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public BaseResponse create(CreateAdvisorRequest dto) {
        var user = new WorkshopUser();
        user.setUserEmail(dto.getUserEmail());
        user.setUserPass(passwordEncoder.encode(dto.getUserPass()));
        var role = userRoleRepository.findById((byte) 2);
        user.setUserRoleId(role.get());
        user = userRepository.save(user);
        var advisor = advisorMapper.toWorkshopAdvisor(dto);
        advisor.setUserId(user.getUserId());
        advisorRepository.save(advisor);
        return new BaseResponse("1");
    }

    @Override
    public BaseResponse update(UpdateAdvisorRequest dto) {
        var advisor = advisorMapper.updateToWorkshopAdvisor(dto);
        advisorRepository.save(advisor);
        return new BaseResponse("1");
    }

    @Override
    public GetListResponse<AdvisorModel> getAll() {
        var entities = advisorRepository.findAll().stream().filter(p -> p.getDeleted() == 0);
        var result = entities.map(advisorMapper::toAdvisorModel).toList();
        return new GetListResponse<>(result);
    }
}
