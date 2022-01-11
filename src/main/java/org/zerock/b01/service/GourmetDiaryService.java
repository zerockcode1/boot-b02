package org.zerock.b01.service;


import org.zerock.b01.domain.GourmetDiary;
import org.zerock.b01.domain.GourmetImage;
import org.zerock.b01.dto.GourmetDiaryDTO;
import org.zerock.b01.dto.GourmetImageDTO;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public interface GourmetDiaryService {


//    default GourmetDiary dtoToEntity(GourmetDiaryDTO diaryDTO){
//
//        GourmetDiary diary = GourmetDiary.builder()
//                .gno(diaryDTO.getGno())
//                .title(diaryDTO.getTitle())
//                .content(diaryDTO.getContent())
//                .writer(diaryDTO.getWriter())
//                .build();
//
//        if(diaryDTO.getImageDTOSet() != null){
//
//            diaryDTO.getImageDTOSet().forEach(gourmetImageDTO -> {
//
//                GourmetImage image = GourmetImage.builder()
//                        .uuid(gourmetImageDTO.getUuid())
//                        .fileName(gourmetImageDTO.getFileName())
//                        .build();
//                diary.addImage(image);
//            });
//        }
//        return diary;
//    }
//
//    default GourmetDiaryDTO entityToDTO(GourmetDiary diary){
//
//        GourmetDiaryDTO gourmetDiaryDTO = GourmetDiaryDTO.builder()
//                .gno(diary.getGno())
//                .title(diary.getTitle())
//                .content(diary.getContent())
//                .writer(diary.getWriter())
//                .regDate(diary.getRegDate())
//                .modDate(diary.getModDate())
//                .build();
//
//        if(diary.getImageSet() != null && diary.getImageSet().size() > 0){
//            Set<GourmetImageDTO> imageDTOList = diary.getImageSet().stream().map(gourmetImage -> {
//                GourmetImageDTO imageDTO = GourmetImageDTO.builder()
//                        .uuid(gourmetImage.getUuid())
//                        .fileName(gourmetImage.getFileName())
//                        .ord(gourmetImage.getOrd())
//                        .build();
//                return imageDTO;
//            }).collect(Collectors.toSet());
//
//            gourmetDiaryDTO.setImageDTOSet(imageDTOList);
//        }
//
//        return gourmetDiaryDTO;
//    }


    Long register(GourmetDiaryDTO diaryDTO);

    GourmetDiaryDTO read(Long gno);

    void modify(GourmetDiaryDTO diaryDTO);
}
