package org.example.repository.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.example.api.model.RegisterUserRequest;
import org.example.exceptions.ValidationException;
import org.example.model.UserAccount;
import org.example.repository.AbstractRepository;
import org.example.repository.EntityManagerHelper;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;

public class UserAccountRepository extends AbstractRepository<UserAccount, Integer> {
    @Override
    protected Class<UserAccount> getPersistentClass() {
        return UserAccount.class;
    }
    public UserAccount findByEmail(String email) {
        if (StringUtils.isBlank(email)) {
            return null;
        } //if
        CriteriaBuilder criteriaBuilder =
                EntityManagerHelper.entityManager().getCriteriaBuilder();
        CriteriaQuery<UserAccount> criteriaQuery =
                criteriaBuilder.createQuery(UserAccount.class);
        Root<UserAccount> userAccounts = criteriaQuery.from(UserAccount.class);
        criteriaQuery.where(
                criteriaBuilder.equal(
                        criteriaBuilder.lower(
                                userAccounts.<String>get("email")
                        ),
                        email.toLowerCase())
        );
        return getFirstResultOrNull(
                EntityManagerHelper.entityManager().createQuery(criteriaQuery).getResultList()
        );
    }
    public UserAccount registerUser(RegisterUserRequest userRequest) throws
            ValidationException {
        if (userRequest == null) {
            throw new ValidationException("userRequest");
        } //if
        userRequest.validateData();
        UserAccount userAccount = findByEmail(userRequest.getEmail());
        if (userAccount != null) {
            throw new ValidationException("Provided email already taken...");
        } //if
        userAccount = new UserAccount();
        userAccount.setCreated(new Date());
        userAccount.setModified(new Date());
        userAccount.setEmail(userRequest.getEmail());
        userAccount.setPassSalt(
                DigestUtils.sha256Hex(
                        RandomStringUtils.randomAlphanumeric(256)
                )
        );
        userAccount.setPassHash(
                userAccount.generatePassHash(
                        userRequest.getPassword(),
                        userAccount.getPassSalt()
                )
        );
        EntityManagerHelper.startTransaction();
        userAccount = merge(userAccount);
        EntityManagerHelper.commitTransaction();
        UserAccountRoleRepository userAccountRoleRepository = new UserAccountRoleRepository();
        userAccountRoleRepository.assignUserToRole(
                userAccount,
                RoleRepository.findByAbbr(
                        "USER"
                )
        );
        return userAccount;
    }
}