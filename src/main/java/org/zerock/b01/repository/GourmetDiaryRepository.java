package org.zerock.b01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.b01.domain.GourmetDiary;
import org.zerock.b01.repository.list.GourmetList;

public interface GourmetDiaryRepository extends JpaRepository<GourmetDiary, Long>, GourmetList {
}
