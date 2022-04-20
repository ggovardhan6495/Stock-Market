package com.market.user.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.market.user.entity.ERole;
import com.market.user.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

//	@Query("SELECT role from Role role where role.roleName=:rolename")
	Optional<Role> findByRoleName(ERole rolename);

}
