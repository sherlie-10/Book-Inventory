package org.cap.bim.service;

import org.cap.bim.model.PermRole;

public interface IPermRoleService {
	public PermRole addRole(PermRole permRole);
	public PermRole getRoleByNumber(Integer roleNumber);
	public PermRole updateRoleByNumber(Integer roleNumber,PermRole permRole);
}
