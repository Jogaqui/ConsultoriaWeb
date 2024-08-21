package com.jpconsultoria.ingweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jpconsultoria.ingweb.Entidades.Chapter;
import com.jpconsultoria.ingweb.Servicios.ChapterServiceImpl;

@Controller
@RequestMapping("/chapters")
public class ChapterController {

    @Autowired
    private ChapterServiceImpl chapterService;

    @GetMapping("/lista")
    public String listChapters(Model model) {
        model.addAttribute("chapters", chapterService.getAllChapters());
        return "chapters/index";
    }

    @GetMapping("/crear")
    public String createChapterForm(Model model) {
        model.addAttribute("chapter", new Chapter());
        return "chapters/create";
    }

    @PostMapping("/save")
    public String saveChapter(@ModelAttribute Chapter chapter) {
        chapterService.createChapter(chapter);
        return "redirect:/chapters/lista";
    }

    @GetMapping("/editar/{id}")
    public String editChapterForm(@PathVariable("id") Long id, Model model) {
        Chapter chapter = chapterService.getChapterById(id);
        if (chapter != null) {
            model.addAttribute("chapter", chapter);
            return "chapters/edit";
        }
        return "redirect:/chapters/lista";
    }

    @PostMapping("/update/{id}")
    public String updateChapter(@PathVariable("id") Long id, @ModelAttribute Chapter chapter) {
        chapterService.updateChapter(id, chapter);
        return "redirect:/chapters/lista";
    }

    @GetMapping("/eliminar/{id}")
    public String deleteChapter(@PathVariable("id") Long id) {
        chapterService.deleteChapter(id);
        return "redirect:/chapters/lista";
    }
}

