package com.datn.qltccn.service.impl;

import com.datn.qltccn.dao.UserDAO;
import com.datn.qltccn.dto.PasswordChange;
import com.datn.qltccn.dto.UserDTO;
import com.datn.qltccn.dto.UserSearchDTO;
import com.datn.qltccn.exception.ErrorCode;
import com.datn.qltccn.exception.ResultException;
import com.datn.qltccn.model.*;
import com.datn.qltccn.repository.*;
import com.datn.qltccn.security.SecurityUtils;
import com.datn.qltccn.security.UserTypeEnum;
import com.datn.qltccn.service.FileStorageService;
import com.datn.qltccn.service.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final UserRepository usersRepository;

    private final RoleRepository rolesRepository;


    private final ModelMapper modelMapper;

    private final UserDAO userDAO;

    private final FileStorageService fileStorageService;

    @Autowired
    private KhachhangRepository khachhangRepository;

    private final ThunhapRepository thunhapRepository;

    private final ThongbaoUserRepository thongbaoUserRepository;

    private final NgansachRepository ngansachRepository;

    private final ChiphiRepository chiphiRepository;

    @Autowired
    private LoaithongbaoRepository loaithongbaoRepository;

    @Autowired
    private LoaingansachRepository loaingansachRepository;

    @Autowired
    private LoaiviRepository loaiviRepository;

    @Autowired
    private ViRepository viRepository;

    public UserServiceImpl(UserRepository usersRepository, RoleRepository rolesRepository, ModelMapper modelMapper, UserDAO userDAO, FileStorageService fileStorageService, ThunhapRepository thunhapRepository, ThongbaoUserRepository thongbaoUserRepository, NgansachRepository ngansachRepository, ChiphiRepository chiphiRepository) {
        this.usersRepository = usersRepository;
        this.rolesRepository = rolesRepository;
        this.modelMapper = modelMapper;
        this.userDAO = userDAO;
        this.fileStorageService = fileStorageService;
        this.thunhapRepository = thunhapRepository;
        this.thongbaoUserRepository = thongbaoUserRepository;
        this.ngansachRepository = ngansachRepository;
        this.chiphiRepository = chiphiRepository;
    }

    @Override
    public void userSearch(UserSearchDTO userSearchDTO) {
        log.info(" start service to userSearch with :{}", userSearchDTO);
        userDAO.searchUser(userSearchDTO);
    }

    @Override
    public UserDTO getCurrentUserLogin() {
        log.info("start service to getCurrentUserLogin");
        Integer idThe = SecurityUtils.getCurrentUserIdLogin();
        User the = usersRepository.findById(idThe).get();
        return modelMapper.map(the, UserDTO.class);
    }

    @Override
    public UserDTO getUserProfileEmp(Integer idUser) {
        return null;
    }

    @Override
    public String getUserNameLogin() {
//        log.info("start service to get userLogin");
//        The the = theRepository.getOne(SecurityUtils.getCurrentUserIdLogin());
//        Users users = usersRepository.findByMaThe(the.getId());
        return null;
    }

    @Override
    public List<User> getALl() {
        return usersRepository.findAll();
    }

    @Override
    public void changePassword(PasswordChange passwordChange) throws ResultException {
        log.info("start service to changePassword with {} ", passwordChange);
        User the = usersRepository.getOne(SecurityUtils.getCurrentUserIdLogin());
        if (!passwordEncoder.matches(passwordChange.getOldPassword(), the.getPass())) {
            throw new ResultException(ErrorCode.PASSWORD_MATCH);
        }
        the.setPass(passwordEncoder.encode(passwordChange.getNewPassword()));
        usersRepository.save(the);
    }

    @Override
    public void forgotPassword(String email) throws ResultException {
//        log.info("start service to forgotPassword with email :{} ", email);
//        String newPassword = RandomString.rdPW();
//        Optional<Users> users = usersRepository.findByEmail(email.trim());
//        if (!users.isPresent()) {
//            throw new ResultException(ErrorCode.EMAIL_EXISTED);
//        }
//        The the = theRepository.getOne(users.get().getMaThe());
//        the.setPassword(passwordEncoder.encode(newPassword));
//        theRepository.save(the);
    }

    @Override
    public void doLock(Integer idThe) {
//        log.info("start service to doLock with idThe :{} ", idThe);
//        The the = theRepository.getOne(idThe);
//        the.setTrangthai(false);
//        theRepository.save(the);
    }

    @Override
    public void doUnLock(Integer idThe) {
//        log.info("start service to doUnLock with idThe :{} ", idThe);
//        The the = theRepository.getOne(idThe);
//        the.setTrangthai(true);
//        theRepository.save(the);

    }

    @Override
    public UserDTO loadUserEdit(int idThe) {
//        UserDTO dto = new UserDTO();
//        The the = theRepository.findById(idThe).get();
//        Users users = usersRepository.findByMaThe(the.getId());


        return null;
    }

    @Override
    public void addNewUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        user.setPass(passwordEncoder.encode(userDTO.getPass()));
        user.setUsername(userDTO.getUsername());
        user.setIdRole(UserTypeEnum.ADMIN.getId());
        usersRepository.save(user);
        Khachhang khachhang = new Khachhang();
        khachhang.setDiachi(userDTO.getDiachi());
        khachhang.setEmail(userDTO.getEmail());
        khachhang.setIdUser(user.getId());
        khachhang.setNgaysinh(userDTO.getNgaysinh());
        khachhang.setNghenghiep(userDTO.getNghenghiep());
        khachhang.setTenkhachhang(userDTO.getTenkhachhang());
        khachhangRepository.save(khachhang);
    }

    @Override
    public UserDTO getProfile() {
        Integer id = SecurityUtils.getCurrentUserIdLogin();
        Optional<User> user = usersRepository.findById(id);
        if (user.isPresent()){
            UserDTO dto  = modelMapper.map(user.get(),UserDTO.class);
            Role role =  rolesRepository.findById(user.get().getIdRole()).get();
            Optional<Khachhang> khc = khachhangRepository.findByIdUser(user.get().getId());
            Khachhang kh = new Khachhang();
            if (khc.isPresent()){
                kh = khc.get();
            }
            dto.setNghenghiep(kh.getNghenghiep());
            dto.setTenkhachhang(kh.getTenkhachhang());
            dto.setEmail(kh.getEmail());
            dto.setNgaysinh(kh.getNgaysinh());
            dto.setDiachi(kh.getDiachi());
            dto.setRoleName(role.getNameRole());
            return dto;
        }
        return null;
    }

    @Override
    public void addNewUserAdmin(UserDTO userDTO) {
        User user = modelMapper.map(userDTO,User.class);
        user.setPass(passwordEncoder.encode(userDTO.getPass()));
        user.setUsername(userDTO.getUsername());
        user.setIdRole(userDTO.getIdRole());
        usersRepository.save(user);
    }

    @Override
    public UserDTO editProfile(UserDTO userDTO) {
        Optional<Khachhang> khc = khachhangRepository.findByIdUser(SecurityUtils.getCurrentUserIdLogin());
        Khachhang kh = new Khachhang();
        if (khc.isPresent()){
            kh = khc.get();
        }
        kh.setTenkhachhang(userDTO.getTenkhachhang());
        kh.setNghenghiep(userDTO.getNghenghiep());
        kh.setNgaysinh(userDTO.getNgaysinh());
        kh.setEmail(userDTO.getEmail());
        kh.setDiachi(userDTO.getDiachi());
        khachhangRepository.save(kh);
        UserDTO re = new UserDTO();
        re.setDiachi(kh.getDiachi());
        re.setNgaysinh(kh.getNgaysinh());
        re.setEmail(kh.getEmail());
        re.setTenkhachhang(kh.getTenkhachhang());
        re.setNghenghiep(kh.getNghenghiep());
        User user = getUserLogin();
        Role role = rolesRepository.findById(user.getIdRole()).get();
        re.setRoleName(role.getNameRole());
        re.setIdRole(role.getId());
        re.setUsername(user.getUsername());
        re.setPass(user.getPass());
        re.setId(user.getId());
        return re;
    }

    @Override
    public void editAdmin(UserDTO userDTO) {
        User u  = usersRepository.getOne(userDTO.getId());
        u.setIdRole(userDTO.getIdRole());
        u.setUsername(userDTO.getUsername());
        usersRepository.save(u);
    }

    @Override
    public void lockUser(Integer id) {
        User u = usersRepository.getOne(id);
//        u.setActive(false);
        usersRepository.save(u);
    }

    @Override
    public void unLockUser(Integer id) {
        User u = usersRepository.getOne(id);
//        u.setActive(true);
        usersRepository.save(u);
    }

    @Override
    public void deleteUser(Integer id) {
        usersRepository.deleteById(id);
        Optional<Khachhang> kh = khachhangRepository.findByIdUser(id);
        kh.ifPresent(khachhangRepository:: delete);
        List<Thunhap> th = thunhapRepository.findAllByIdUser(id);
        if (!CollectionUtils.isEmpty(th)){
            thunhapRepository.deleteAll(th);
        }

        List<ThongbaoUser> tb = thongbaoUserRepository.findAllByIdUser(id);
        if (!CollectionUtils.isEmpty(tb)){
            thongbaoUserRepository.deleteAll(tb);
        }

        List<Ngansach> ns = ngansachRepository.findAllByIdUser(id);
        if (!CollectionUtils.isEmpty(ns)){
            ngansachRepository.deleteAll(ns);
        }

        List<Chiphi> cp = chiphiRepository.findAllByIdUser(id);
        if (!CollectionUtils.isEmpty(cp)){
            chiphiRepository.deleteAll(cp);
        }

        List<Loaingansach> lns = loaingansachRepository.findAllByIdUser(id);
        if (!CollectionUtils.isEmpty(lns)){
            loaingansachRepository.deleteAll(lns);
        }

        List<Loaithongbao> ltb  = loaithongbaoRepository.findAllByIdUser(id);
        if (!CollectionUtils.isEmpty(ltb)){
            loaithongbaoRepository.deleteAll(ltb);
        }

        List<Loaivi> lv  = loaiviRepository.findAllByIdUser(id);
        if (!CollectionUtils.isEmpty(lv)){
            loaiviRepository.deleteAll(lv);
        }

        List<Vi> uv  = viRepository.findAllByIdUser(id);
        if (!CollectionUtils.isEmpty(uv)){
            viRepository.deleteAll(uv);
        }
    }

    private User getUserLogin(){
        Optional<User> u = usersRepository.findById(SecurityUtils.getCurrentUserIdLogin());
        return u.orElse(null);
    }
}
