package org.workshop.cc6.workshopserver.service.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.workshop.cc6.workshopserver.data.entity.WorkshopClient;
import org.workshop.cc6.workshopserver.data.entity.WorkshopUser;
import org.workshop.cc6.workshopserver.data.repository.ClientRepository;
import org.workshop.cc6.workshopserver.data.repository.UserRepository;
import org.workshop.cc6.workshopserver.data.repository.UserRoleRepository;
import org.workshop.cc6.workshopserver.dto.user.request.CreateUserClientRequest;
import org.workshop.cc6.workshopserver.dto.user.response.CreateUserClientResponse;
import org.workshop.cc6.workshopserver.util.Constants;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final ClientRepository clientRepository;

    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, ClientRepository clientRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.clientRepository = clientRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public CreateUserClientResponse registerClient(CreateUserClientRequest user) {
        var newUser = new WorkshopUser();
        newUser.setUserEmail(user.getUserEmail());
        newUser.setUserPass(passwordEncoder.encode(user.getUserPass()));
        var r =userRoleRepository.findById((byte)3).get();
        newUser.setUserRoleId(r);
        newUser = userRepository.save(newUser);
        var newClient = new WorkshopClient();
        newClient.setClientName(user.getClientName());
        newClient.setUserId(newUser.getUserId());
        newClient.setClientLastName(user.getClientLastName());
        newClient.setClientPhoneNumber(user.getClientPhoneNumber());
        newClient.setClientDpi(user.getClientDpi());
        clientRepository.save(newClient);

        return new CreateUserClientResponse(Constants.SUCCESS_CODE);
    }

}
