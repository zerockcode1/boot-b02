package org.zerock.b01.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.b01.domain.GourmetDiary;
import org.zerock.b01.domain.Reply;

@SpringBootTest
@Log4j2
public class ReplyRepositoryTests {

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void testAddReply() {

        GourmetDiary diary = GourmetDiary.builder().gno(102L).build();

        Reply reply = Reply.builder()
                .replyText("Reply..Sample...")
                .replyer("repyer")
                .diary(diary)
                .build();

        replyRepository.save(reply);

    }

}
