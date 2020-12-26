package com.datn.qltccn.controller;

import com.datn.qltccn.dto.PasswordChange;
import com.datn.qltccn.dto.UserDTO;
import com.datn.qltccn.dto.UserSearchDTO;
import com.datn.qltccn.exception.ResultException;
import com.datn.qltccn.model.*;
import com.datn.qltccn.repository.*;
import com.datn.qltccn.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    private final UserRepository userRepository;

    private final KhachhangRepository khachhangRepository;

    private final ChiphiRepository chiphiRepository;

    private final NgansachRepository ngansachRepository;

    private final ThongbaoUserRepository thongbaoUserRepository;

    private final ThunhapRepository thunhapRepository;

    public UserController(UserService userService, UserRepository userRepository, KhachhangRepository khachhangRepository, ChiphiRepository chiphiRepository, NgansachRepository ngansachRepository, ThongbaoUserRepository thongbaoUserRepository, ThunhapRepository thunhapRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.khachhangRepository = khachhangRepository;
        this.chiphiRepository = chiphiRepository;
        this.ngansachRepository = ngansachRepository;
        this.thongbaoUserRepository = thongbaoUserRepository;
        this.thunhapRepository = thunhapRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> add(@RequestBody UserDTO userDTO) {
        userService.addNewUser(userDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/add-admin")
    public ResponseEntity<Void> addAdmin(@RequestBody UserDTO userDTO) {
        userService.addNewUserAdmin(userDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/edit-profile")
    public ResponseEntity<UserDTO> editProfile(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.editProfile(userDTO));
    }

    @PutMapping("/edit-admin")
    public ResponseEntity<Void> editADMIN(@RequestBody UserDTO userDTO) {
        userService.editAdmin(userDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/change-password")
    public ResponseEntity<Void> changePassword(@RequestBody PasswordChange p) throws ResultException {
        userService.changePassword(p);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        userRepository.deleteById(id);
        Khachhang kh = khachhangRepository.findByIdUser(id);
        khachhangRepository.delete(kh);
        Optional<Thunhap> th = thunhapRepository.findByIdUser(id);
        th.ifPresent(thunhapRepository::delete);

        Optional<ThongbaoUser> tb = thongbaoUserRepository.findByIdUser(id);
        tb.ifPresent(thongbaoUserRepository::delete);

        Optional<Ngansach> ns = ngansachRepository.findByIdUser(id);
        ns.ifPresent(ngansachRepository::delete);

        Optional<Chiphi> cp = chiphiRepository.findByIdUser(id);
        cp.ifPresent(chiphiRepository::delete);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/profile-user")
    public ResponseEntity<UserDTO> getProfile() {
        return new ResponseEntity<>(userService.getProfile(), HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<UserSearchDTO> userSearchDTOResponseEntity(@RequestBody UserSearchDTO dto) {
        log.info("Start rest to userSearchDTOResponseEntity :{}", dto);
        userService.userSearch(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/lock-user/{id}")
    public ResponseEntity<Void> lockUser(@PathVariable("id") Integer id){
        userService.lockUser(id);
        return new ResponseEntity<>(  HttpStatus.OK);
    }

    @GetMapping("/un-lock-user/{id}")
    public ResponseEntity<Void> unlockUser(@PathVariable("id") Integer id){
        userService.unLockUser(id);
        return new ResponseEntity<>(  HttpStatus.OK);
    }
}
