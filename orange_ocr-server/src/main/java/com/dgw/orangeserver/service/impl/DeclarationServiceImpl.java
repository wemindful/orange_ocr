package com.dgw.orangeserver.service.impl;

import com.dgw.orangeserver.constants.Constants;
import com.dgw.orangeserver.entity.Declaration;
import com.dgw.orangeserver.entity.Pages;
import com.dgw.orangeserver.repository.DeclarationRepository;
import com.dgw.orangeserver.service.DeclarationService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @program: orange_ocr-parent
 * @description:
 * @author: Mr.Dai
 * @create: 2020-04-07 18:45
 **/
@Service
public class DeclarationServiceImpl implements DeclarationService {

    @Autowired
    private DeclarationRepository declarationRepository;


    @Override
    public Page<Declaration> findAllBySearch(Pages pages, Long articleId, String articleName, String articleAuthors) {
        Pageable pageable = PageRequest.of(pages.getPage(), pages.getPageSize(), Sort.Direction.DESC, "articleId");
        return declarationRepository.findAll(this.getWhereClause(articleId, articleName, articleAuthors), pageable);
    }

    /**
     * where SQL
     * @param articleId
     * @param articleName
     * @param articleAuthors
     * @return
     */
    private Specification<Declaration> getWhereClause(Long articleId, String articleName, String articleAuthors) {
           return new Specification<Declaration>() {
               @Override
               public Predicate toPredicate(Root<Declaration> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                   List<Predicate> predicateList=new ArrayList<>();
                   if(articleId!=null) {
                     predicateList.add(
                             cb.or(cb.equal(root.get("articleId"),articleId))
                     );
                   }
                   if(!StringUtils.isEmpty(articleName)){
                       predicateList.add(
                               cb.or(cb.like(root.get("articleName"), articleName + "%"))
                       );
                   }
                   if (!StringUtils.isEmpty(articleAuthors)) {
                       predicateList.add(
                               cb.or(cb.like(root.get("articleAuthors"), articleAuthors + "%"))
                       );
                   }
                   Predicate [] predicates=new Predicate[predicateList.size()];
                   return query.where(predicateList.toArray(predicates)).getRestriction();
               }
           };
    }

    @Override
    public Declaration findDeclarationByDeclarationId(Long articleId) {
        Optional<Declaration> optionalArticle = declarationRepository.findById(articleId);
        if (!optionalArticle.isPresent()) {
            return null;
        }
        Declaration article = optionalArticle.get();
        return article;
    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public void updateDeclarationIsEnable(Long articleId, Integer isEnable) {
        Optional<Declaration> optionalArticle = declarationRepository.findById(articleId);
        if (optionalArticle.isPresent()) {
            Declaration article = optionalArticle.get();
            article.setIsEnable(isEnable);
            declarationRepository.save(article);
        }
    }

    @Override
    public Integer countByDeclarationInputDate(Date date) {
        return declarationRepository.countByArticleInputDate(date);
    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public void deleteDeclaration(Long articleId) {
        declarationRepository.deleteById(articleId);
    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public void saveOrUpdateDeclaration(Declaration article) {
        declarationRepository.save(article);
    }
}
