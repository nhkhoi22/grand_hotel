package com.ptit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ptit.dao.DepartmentDAO;
import com.ptit.dao.PositionDAO;
import com.ptit.dao.RoleDAO;
import com.ptit.dao.UserDAO;
import com.ptit.staff.Department;
import com.ptit.staff.Position;
import com.ptit.staff.Role;
import com.ptit.staff.User;

@Service("userService")
public class UserService {
	@Autowired
	private UserDAO userDAO;

	@Autowired
	private RoleDAO roleDAO;

	@Autowired
	PositionDAO positionDAO;

	@Autowired
	DepartmentDAO departmentDAO;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserService(UserDAO userDAO, RoleDAO roleDAO, PositionDAO positionDAO, DepartmentDAO departmentDAO,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userDAO = userDAO;
		this.roleDAO = roleDAO;
		this.departmentDAO = departmentDAO;
		this.positionDAO = positionDAO;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public User findUserByStaffCode(String staffCode) {
		return userDAO.findByStaffCode(staffCode);
	}

	public Position findPositionByName(String name) {
		return positionDAO.findByName(name);
	}

	public Department findDepartmentByName(String name) {
		return departmentDAO.findByName(name);
	}

	public List<User> findAllStaff() {
		return userDAO.findAll();
	}
	
	public List<Department> findAllDepartment(){
		return departmentDAO.findAll();
	}
	
	public List<Position> findAllPosition(){
		return positionDAO.findAll();
	}
	
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		Role userRole = roleDAO.findByName("USER");
		user.setRole(userRole);
		userDAO.save(user);
	}
	
	public void saveUserNonEncrypt(User user) {
		userDAO.save(user);
	}

	public void savePosition(Position position) {
		positionDAO.save(position);
	}

	public void saveDepartment(Department department) {
		departmentDAO.save(department);
	}
	
	public Department findDepartmentById(Long id) {
		return departmentDAO.findDepartmentById(id);
	}
	
	public Position findPositionById(Long id) {
		return positionDAO.findPositionById(id);
	}
	
	public List<Position> findPositionsByDepartment(Department department) {
		return positionDAO.findPositionByDepartment(department);
	}
	
	public boolean checkIfValidOldPassword(User user, String oldPassword) {
		if(bCryptPasswordEncoder.encode(oldPassword) == user.getPassword())
			return true;
		
		return false;
	}
	
	public void changeUserPassword(User user, String newPassword) {
		user.setPassword(bCryptPasswordEncoder.encode(newPassword));
		userDAO.save(user);
	}
}