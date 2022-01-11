package org.zerock.b01.repository.list;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.zerock.b01.domain.GourmetDiary;
import org.zerock.b01.domain.QGourmetDiary;
import org.zerock.b01.domain.QGourmetImage;
import org.zerock.b01.dto.GourmetListDTO;
import org.zerock.b01.dto.PageRequestDTO;

import java.util.List;


@Log4j2
public class GourmetListImpl extends QuerydslRepositorySupport implements GourmetList {

    GourmetListImpl(){
        super(GourmetDiary.class);
    }

    @Override
    public Page<GourmetListDTO> getList(PageRequestDTO pageRequestDTO) {

        log.info("getList..................");

        QGourmetDiary diary = QGourmetDiary.gourmetDiary;
        QGourmetImage image = QGourmetImage.gourmetImage;

        JPQLQuery<GourmetDiary> query = from(diary);
        query.leftJoin(diary.imageSet,image);

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.or(image.ord.isNull());
        booleanBuilder.or(image.ord.eq(0));

        query.where(booleanBuilder);


        JPQLQuery<GourmetListDTO> dtoQuery =
                query.select(Projections.bean(GourmetListDTO.class,  diary.gno, diary.title, diary.writer,
                        image.uuid, image.fileName));

        Pageable pageable = pageRequestDTO.getPageable("gno");


        this.getQuerydsl().applyPagination(pageable, dtoQuery);

        List<GourmetListDTO> dtoList = dtoQuery.fetch();

        long count = dtoQuery.fetchCount();

        return new PageImpl<>(dtoList, pageable, count);
    }
}
