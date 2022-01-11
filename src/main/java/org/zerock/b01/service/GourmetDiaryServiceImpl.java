package org.zerock.b01.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.b01.domain.GourmetDiary;
import org.zerock.b01.dto.GourmetDiaryDTO;
import org.zerock.b01.dto.GourmetImageDTO;
import org.zerock.b01.repository.GourmetDiaryRepository;


import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class GourmetDiaryServiceImpl implements GourmetDiaryService {

    private final GourmetDiaryRepository repository;

    private final ModelMapper modelMapper;


    @Override
    public Long register(GourmetDiaryDTO diaryDTO) {

        log.info(diaryDTO);

        GourmetDiary diary = modelMapper.map(diaryDTO, GourmetDiary.class);

        log.info(diary);
        log.info(diary.getImageSet());

        return repository.save(diary).getGno();
    }


    @Override
    @Transactional(readOnly = true)
    public GourmetDiaryDTO read(Long gno) {

        Optional<GourmetDiary> result = repository.findById(gno);

        GourmetDiary diary = result.orElseThrow();

        log.info(diary);
        log.info(diary.getImageSet());
        //GourmetDiaryDTO diaryDTO = entityToDTO(diary);

        GourmetDiaryDTO diaryDTO = modelMapper.map(diary, GourmetDiaryDTO.class);

        return diaryDTO;
    }

    @Override
    public void modify(GourmetDiaryDTO diaryDTO) {

        GourmetDiary diary = modelMapper.map(diaryDTO, GourmetDiary.class);


        repository.save(diary).getGno();
    }
}
