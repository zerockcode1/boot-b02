package org.zerock.b01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.b01.domain.GourmetDiary;

public interface GourmetDiaryRepository extends JpaRepository<GourmetDiary, Long> {
}
