package com.da.security;

import com.da.model.The;
import com.da.repository.RolesRepository;
import com.da.repository.TheRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("userDetailServiceImpl")
public class UserDetailServiceImpl implements UserDetailsService {
    private final Logger log = LoggerFactory.getLogger(UserDetailServiceImpl.class);

    private final TheRepository theRepository;

    private final RolesRepository rolesRepository;

    public UserDetailServiceImpl(TheRepository theRepository, RolesRepository rolesRepository) {
        this.theRepository = theRepository;
        this.rolesRepository = rolesRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String maThe) throws UsernameNotFoundException {
        The the = theRepository.findByMaThe(maThe).get();
        if (!the.getTrangthai())
            throw new UserNotActivatedException("The: " + maThe + " was not activated");
        if (the.getTrangthai())
            throw new UserLockedException("User " + maThe + " was locked");


        return null;
    }
}
