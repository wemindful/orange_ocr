package com.dgw.orangeserver.service.impl;


import com.dgw.orangeserver.entity.OcrTexts;
import com.dgw.orangeserver.entity.Pages;
import com.dgw.orangeserver.repository.TagRepository;
import com.dgw.orangeserver.service.OcrTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OcrTextServiceImpl implements OcrTextService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Page<OcrTexts> findAllBySearch(Pages pages, Long tagId, String tagName) {
        Pageable pageable = PageRequest.of(pages.getPage(), pages.getPageSize(), Sort.Direction.DESC, "tagId");
        return  tagRepository.findAll(this.getWhereClause(tagId, tagName), pageable);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public OcrTexts saveTag(OcrTexts tag) {
       return tagRepository.save(tag);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void deleteTagByTagId(Long tagId) {
        tagRepository.deleteById(tagId);
    }

    @Override
    public OcrTexts findTagByTagName(String tagName) {
        return tagRepository.findBytextName(tagName);
    }

    @Override
    public Integer countByTagInputDate(Date tagInputdate) {
        return tagRepository.countByTagInputDate(tagInputdate);
    }

    @Override
    public Long count() {
        return tagRepository.count();
    }

    /**
     * 动态生成where语句
     *
     * @param tagId,tagName
     * @return
     */
    private Specification<OcrTexts> getWhereClause(Long tagId, String tagName) {
        return new Specification<OcrTexts>() {
            @Override
            public Predicate toPredicate(Root<OcrTexts> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicate = new ArrayList<>();
                if (tagId != null) {
                    predicate.add(
                            cb.or(cb.equal(root.get("textId"), tagId ))
                    );
                }
                if (!StringUtils.isEmpty(tagName)) {
                    predicate.add(
                            cb.or(cb.like(root.get("textName"), tagName + "%"))
                    );
                }
                Predicate[] pre = new Predicate[predicate.size()];
                return query.where(predicate.toArray(pre)).getRestriction();
            }
        };
    }
}
