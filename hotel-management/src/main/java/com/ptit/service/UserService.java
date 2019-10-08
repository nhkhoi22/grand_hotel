package com.ptit.service;

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
	public UserService(UserDAO userDAO, RoleDAO roleDAO,
			PositionDAO positionDAO, DepartmentDAO departmentDAO,
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

	public void saveUser(User user, Position position) {
		user.setPosition(position);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
        Role userRole = roleDAO.findByName("USER");
        user.setRole(userRole);
		userDAO.save(user);
	}
	
	public void savePosition(Position position) {
		positionDAO.save(position);
	}
	
	public void saveDepartment(Department department) {
		departmentDAO.save(department);
	}
}