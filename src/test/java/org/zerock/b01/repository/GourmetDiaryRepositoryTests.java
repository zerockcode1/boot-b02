package org.zerock.b01.repository;



import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.zerock.b01.domain.GourmetDiary;
import org.zerock.b01.domain.GourmetImage;
import org.zerock.b01.dto.GourmetListDTO;
import org.zerock.b01.dto.PageRequestDTO;

import java.util.UUID;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class GourmetDiaryRepositoryTests {

    @Autowired
    private GourmetDiaryRepository repository;

    @Test
    public void testInsert() {

        IntStream.rangeClosed(1, 100).forEach(i -> {

            GourmetDiary diary = GourmetDiary.builder()
                    .title("Diary.."+i)
                    .content("Content..."+i)
                    .writer("user" + (i % 10))
                    .build();

            int imageCount = i % 3;

            for(int j = 0; j < imageCount; j++){

                String uuidStr = UUID.randomUUID().toString();

                String fileName = "D"+i+"_"+j+".jpg";

                GourmetImage image = GourmetImage.builder().fileName(fileName).uuid(uuidStr).build();

                diary.addImage(image);

            }//end for

            repository.save(diary);
            log.info("------------------------------");

        });

    }

    @Test
    public void eksadke() {

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();

        Page<GourmetListDTO> result = repository.getList(pageRequestDTO);

        log.info(result);

        result.getContent().forEach(dto -> log.info(dto));







    }

}
