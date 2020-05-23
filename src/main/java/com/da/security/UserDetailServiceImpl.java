package com.da.security;

import com.da.common.Constant;
import com.da.model.Roles;
import com.da.model.The;
import com.da.repository.RolesRepository;
import com.da.repository.TheRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        log.trace("Service authenticate: {}", maThe);
        try {
            The the = theRepository.findByMaThe(maThe).get();
//            if (!the.getTrangthai())
//                throw new UserNotActivatedException("The: " + maThe + " was not activated");
            if (the.getTrangthai())
                throw new UserLockedException("User " + maThe + " was locked");
            Roles role = rolesRepository.findByRole(the.getIdRole(), Constant.GROUP_ROLE).get();
            List<GrantedAuthority> grantedAuthorities = Stream.of(role.getNameRole())
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
            UserDetails userDetails = new UserDetails(the.getMaThe(), the.getPassword(), grantedAuthorities);
            the.setPassword(null);
            userDetails.setThe(the);
            return userDetails;
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            throw new UsernameNotFoundException("User with maThe " + maThe + " not found in the database");
        }
    }
}
