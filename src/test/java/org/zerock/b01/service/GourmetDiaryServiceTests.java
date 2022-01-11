package org.zerock.b01.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.b01.dto.GourmetDiaryDTO;
import org.zerock.b01.dto.GourmetImageDTO;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class GourmetDiaryServiceTests {

    @Autowired
    private GourmetDiaryService diaryService;

    @Test
    public void testRegister() {

        GourmetDiaryDTO diaryDTO = GourmetDiaryDTO.builder()
                .title("Test...")
                .content("Content...")
                .writer("user00")
                .build();

        Set<GourmetImageDTO > imageDTOSet = IntStream.rangeClosed(0,3).mapToObj(i -> {
            GourmetImageDTO imageDTO = GourmetImageDTO.builder()
                    .uuid(UUID.randomUUID().toString())
                    .fileName("file.."+i+".jpg")
                    .build();

            return imageDTO;
        }).collect(Collectors.toSet());

        diaryDTO.setImageDTOSet(imageDTOSet);

        diaryService.register(diaryDTO);
    }

    @Test
    public void testRead() {

        GourmetDiaryDTO diaryDTO = diaryService.read(101L);

        log.info(diaryDTO);

    }

    @Test
    public void testModify() {

        GourmetDiaryDTO diaryDTO = diaryService.read(102L);

        diaryDTO.setTitle("modified...........title");

        Set<GourmetImageDTO > imageDTOSet = IntStream.rangeClosed(0,1).mapToObj(i -> {
            GourmetImageDTO imageDTO = GourmetImageDTO.builder()
                    .uuid(UUID.randomUUID().toString())
                    .fileName("modified file.."+i+".jpg")
                    .build();

            return imageDTO;
        }).collect(Collectors.toSet());

        diaryDTO.setImageDTOSet(imageDTOSet);

        diaryService.modify(diaryDTO);
    }

}














