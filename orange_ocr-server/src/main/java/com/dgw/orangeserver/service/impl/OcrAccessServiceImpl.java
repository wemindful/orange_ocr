package com.dgw.orangeserver.service.impl;

import com.dgw.orangeserver.entity.OcrAccess;
import com.dgw.orangeserver.service.OcrAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;

/**
 * @program: orange_ocr-parent
 * @description:
 * @author: Mr.Dai
 * @create: 2020-04-08 14:35
 **/
@Service
public class OcrAccessServiceImpl implements OcrAccessService {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Integer sumWebsiteAccess(Date date) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Integer> query = cb.createQuery(Integer.class);

        Root<OcrAccess> root = query.from(OcrAccess.class);
        CriteriaQuery<Integer> accessCount = query.select(cb.sum(root.get("accessCount")));
        if (date != null) {
            Predicate predicate = cb.equal(root.get("accessDate"), date);
            query.where(predicate);
        }
        Integer result = entityManager.createQuery(query).getSingleResult();
        if (result == null) {
            result = 0;
        }
        return result;
    }
}
