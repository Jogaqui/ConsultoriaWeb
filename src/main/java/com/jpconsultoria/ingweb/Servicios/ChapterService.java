package com.jpconsultoria.ingweb.Servicios;

import com.jpconsultoria.ingweb.Entidades.Chapter;
import java.util.List;

public interface ChapterService {
    List<Chapter> getAllChapters();
    Chapter getChapterById(Long id);
    Chapter createChapter(Chapter chapter);
    Chapter updateChapter(Long id, Chapter chapter);
    void deleteChapter(Long id);
}
