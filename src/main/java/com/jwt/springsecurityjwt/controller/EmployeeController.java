package com.jwt.springsecurityjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.springsecurityjwt.modal.AuthenticationRequest;
import com.jwt.springsecurityjwt.modal.AuthenticationResponse;
import com.jwt.springsecurityjwt.util.JwtUtil;

@RestController
public class EmployeeController {
	@Autowired
	AuthenticationManager authManager;

	@Autowired
	UserDetailsService userDetailService;

	@Autowired
	JwtUtil jwtUtil;
	// private EmployeeDAO employeeDao;

	@RequestMapping(path = "/")
	public String getEmployees() {
		return "<h1>Hello test</h1>";
	}

	@RequestMapping(path = "/users")
	public String user() {
		return "<h1>Welcome all user</h1>";
	}

	@RequestMapping(path = "/admin")
	public String admin() {
		return "<h1>Hello Admin</h1>";

	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthToken(@RequestBody AuthenticationRequest autReq) throws Exception {

		try {
			authManager.authenticate(new UsernamePasswordAuthenticationToken(autReq.getUserId(), autReq.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("bad Credential", e);
		}

		final UserDetails userDetal = userDetailService.loadUserByUsername(autReq.getUserId());
		final String jwt = jwtUtil.generateToken(userDetal);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

}
