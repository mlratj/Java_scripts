package org.example.repository.impl;

import org.example.exceptions.ValidationException;
import org.example.model.Role;
import org.example.model.UserAccount;
import org.example.model.UserAccountRole;
import org.example.repository.AbstractRepository;
import org.example.repository.EntityManagerHelper;

import java.util.Date;

public class UserAccountRoleRepository extends AbstractRepository<UserAccountRole,
        Integer> {
    @Override
    protected Class<UserAccountRole> getPersistentClass() {
        return UserAccountRole.class;
    }
    public void assignUserToRole(UserAccount userAccount, Role role) throws
            ValidationException {
        if (role == null) {
            throw new ValidationException("role");
        } //if
        if (userAccount == null) {
            throw new ValidationException("userAccount");
        } //if
        UserAccountRole userAccountRole = new UserAccountRole();
        userAccountRole.setCreated(new Date());
        userAccountRole.setModified(new Date());
        userAccountRole.setRole(role);
        userAccountRole.setUserAccount(userAccount);
        EntityManagerHelper.startTransaction();
        merge(userAccountRole);
        EntityManagerHelper.commitTransaction();
    }
}
