package org.woojukang.remixlab.query.creation.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.woojukang.remixlab.domain.creation.entity.Creation;
import org.woojukang.remixlab.domain.creation.entity.QCreation;


import java.util.List;

@Repository
@RequiredArgsConstructor
public class CreationQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;
    private final QCreation qCreation = QCreation.creation;

    // QEntity 나중에 삽입

    public List<Creation> findByUserId(Long userId){

        return jpaQueryFactory
                .selectFrom(qCreation)
                .where(qCreation
                        .user
                        .id
                        .eq(userId))
                .fetch();
    }

    public Creation findCreationEntityById(Long creationId){

        return jpaQueryFactory
                .select(qCreation)
                .from(qCreation)
                .where(qCreation
                        .id
                        .eq(creationId))
                .fetchOne();
    }




}
