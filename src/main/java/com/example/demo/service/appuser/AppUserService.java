package com.example.demo.service.appuser;

import com.example.demo.model.AppUser;
import com.example.demo.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class AppUserService implements IAppUserService, UserDetailsService {
    @Autowired
    private AppUserRepository userRepository;
    @Override
    public AppUser getUserByUserName(String name) {
        return userRepository.findAppUserByName(name);
    }

    @Override
    public Iterable findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public AppUser save(AppUser appUser) {
        return userRepository.save(appUser);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      AppUser  user= this.getUserByUserName(username);
      List<GrantedAuthority> authorities= new ArrayList<>();
      authorities.add(user.getRoles());
      UserDetails userDetails= new User(
              user.getName(),
              user.getPassword(),
              authorities
      );
      return userDetails;
    }

}
