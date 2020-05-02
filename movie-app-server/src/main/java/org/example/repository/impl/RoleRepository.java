package org.example.repository.impl;

import org.apache.commons.lang3.StringUtils;
import org.example.model.Role;
import org.example.repository.AbstractRepository;
import org.example.repository.EntityManagerHelper;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class RoleRepository extends AbstractRepository<Role, Integer> {
    @Override
    protected Class<Role> getPersistentClass() {
        return Role.class;
    }
    public static Role findByAbbr(String abbr) {
        if (StringUtils.isBlank(abbr)) {
            return null;
        } //if
        CriteriaBuilder criteriaBuilder =
                EntityManagerHelper.entityManager().getCriteriaBuilder();
        CriteriaQuery<Role> criteriaQuery = criteriaBuilder.createQuery(Role.class);
        Root<Role> roles = criteriaQuery.from(Role.class);
        criteriaQuery.where(
                criteriaBuilder.equal(
                        criteriaBuilder.lower(
                                roles.<String>get("abbr")
                        ),
                        abbr.toLowerCase())
        );
        return getFirstResultOrNull(
                EntityManagerHelper.entityManager().createQuery(criteriaQuery).getResultList()
        );
    }
}