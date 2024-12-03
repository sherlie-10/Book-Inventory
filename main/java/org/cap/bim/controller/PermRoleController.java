package org.cap.bim.controller;

import org.cap.bim.model.PermRole;
import org.cap.bim.service.IPermRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/permrole")
@RestController
public class PermRoleController {
	@Autowired
	private IPermRoleService permRoleService;
	
	@PostMapping("/post")
	public ResponseEntity<String> addNewRole(@RequestBody PermRole permRole){
		PermRole permRole1=permRoleService.addRole(permRole);
		if(permRole1!=null) {
			return new ResponseEntity<String>("Permissionrole added successfully", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Creation Error!",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/{rolenumber}")
	public ResponseEntity<PermRole> getRole(@PathVariable ("rolenumber") Integer roleNumber){
		PermRole permRole=permRoleService.getRoleByNumber(roleNumber);
		if(permRole==null) {
			return new ResponseEntity("RoleNumber "+roleNumber+"is not found!",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<PermRole>(permRole, HttpStatus.OK);
	}
	
	@PutMapping("/update/permrole/{rolenumber}")
	public ResponseEntity<PermRole> updateRole(@PathVariable ("rolenumber") Integer roleNumber, @RequestBody PermRole permRole){
		PermRole permRole1=permRoleService.updateRoleByNumber(roleNumber, permRole);
		if(permRole1==null) {
			return new ResponseEntity("Sorry! Rolenumber : "+roleNumber+" is not found",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<PermRole>(permRole1,HttpStatus.OK);
	}
	

}
