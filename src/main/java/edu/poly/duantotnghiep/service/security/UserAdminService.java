package edu.poly.duantotnghiep.service.security;


import edu.poly.duantotnghiep.config.security.AdminUser;
import edu.poly.duantotnghiep.model.NhanVienModel;
import edu.poly.duantotnghiep.repository.INhanVienRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAdminService implements UserDetailsService {

    private INhanVienRepository nhanVienRepository;

    public UserAdminService(INhanVienRepository nhanVienRepository) {
        this.nhanVienRepository = nhanVienRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        NhanVienModel nhanVienModel = nhanVienRepository.findByUsername(username).orElse(null);
        if(nhanVienModel==null ){
            throw new UsernameNotFoundException("Username không tồn tại");
        }
        if(!nhanVienModel.getUsername().equals(username)){
            throw new UsernameNotFoundException("Username không tồn tại");
        }
        return new AdminUser(nhanVienModel);
    }
}
