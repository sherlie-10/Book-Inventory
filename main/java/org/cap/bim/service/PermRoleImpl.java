package org.cap.bim.service;

import java.util.Optional;


import org.cap.bim.exception.RoleNotFoundException;
import org.cap.bim.model.PermRole;
import org.cap.bim.repository.IPermRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermRoleImpl implements IPermRoleService{

	@Autowired
	private IPermRoleRepository permRoleRepository;
	
	@Override
	public PermRole addRole(PermRole permRole) {
		return permRoleRepository.save(permRole);
	}

	@Override
	public PermRole getRoleByNumber(Integer roleNumber) {
		Optional<PermRole> permRole=permRoleRepository.findById(roleNumber);
		if(permRole.isPresent()) {
			return permRole.get();
		}
		throw new RoleNotFoundException("No Role is found with this rolenumber");
	}

	@Override
	public PermRole updateRoleByNumber(Integer roleNumber, PermRole permRole) {
		Optional<PermRole> permRole1=permRoleRepository.findById(roleNumber);
		if(permRole1.isPresent()) {
			permRole1.get().setPermRole(permRole.getPermRole());
			permRoleRepository.save(permRole1.get());
			return permRole1.get();
		}
		throw new RoleNotFoundException("No Role is found with this rolenumber to update");
	}
	
}
