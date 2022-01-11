package org.zerock.b01.repository.list;

import org.springframework.data.domain.Page;

import org.zerock.b01.domain.GourmetDiary;
import org.zerock.b01.dto.GourmetListDTO;
import org.zerock.b01.dto.PageRequestDTO;

public interface GourmetList {

    Page<GourmetListDTO> getList(PageRequestDTO pageRequestDTO);

    Page<GourmetDiary> getListWithAllImage(PageRequestDTO pageRequestDTO);
}
