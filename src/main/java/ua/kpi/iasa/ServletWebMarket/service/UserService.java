package ua.kpi.iasa.ServletWebMarket.service;

import ua.kpi.iasa.ServletWebMarket.dao.EnumSingletonDao;
import ua.kpi.iasa.ServletWebMarket.dao.UserDao;
import ua.kpi.iasa.ServletWebMarket.exception.DuplicateUsernameException;
import ua.kpi.iasa.ServletWebMarket.exception.LoginException;
import ua.kpi.iasa.ServletWebMarket.exception.PasswordsMatchException;
import ua.kpi.iasa.ServletWebMarket.exception.RegistrationException;
import ua.kpi.iasa.ServletWebMarket.model.Role;
import ua.kpi.iasa.ServletWebMarket.model.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.UUID;

public class UserService {

    private final UserDao userDao = EnumSingletonDao.INSTANCE.getUserDao();

    public Optional<User> getUserByUsername(String username) {
        return userDao.getByUsername(username);
    }

    public void deleteUserByUsername(String username) {
        userDao.removeByUsername(username);
    }

    public void register(User user) throws RegistrationException {
        Optional<User> optionalUser = userDao.getByUsername(user.getUsername());
        if (optionalUser.isPresent()) {
            throw new DuplicateUsernameException();
        }
        if (!user.getConfirmPassword().equals(user.getPassword())) {
            throw new PasswordsMatchException();
        }

        prepareUserToSave(user);
        userDao.save(user);
    }

    public void login(User user) throws LoginException {
        Optional<User> optionalUser = userDao.getByUsername(user.getUsername());
        User userFromDB = optionalUser.orElseThrow(() -> new LoginException("Username not exist!"));
        if (!userFromDB.getPassword().equals(encodePassword(user.getPassword()))) {
            throw new LoginException("Wrong Password!");
        }
    }

    private void prepareUserToSave(User user) {
        user.setId(UUID.randomUUID());
        user.getRole().add(Role.USER);
        user.setPassword(encodePassword(user.getPassword()));
    }

    public String encodePassword(String password) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


}
