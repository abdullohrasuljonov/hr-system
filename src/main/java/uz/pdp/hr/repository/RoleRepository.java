package uz.pdp.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.hr.entity.Role;
import uz.pdp.hr.entity.enums.RoleName;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    Role findByRoleEnum(RoleName roleName);
}
