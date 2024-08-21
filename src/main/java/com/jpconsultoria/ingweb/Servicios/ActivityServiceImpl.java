package com.jpconsultoria.ingweb.Servicios;

import com.jpconsultoria.ingweb.Entidades.Activity;
import com.jpconsultoria.ingweb.Entidades.Chapter;
import com.jpconsultoria.ingweb.Entidades.Type;
import com.jpconsultoria.ingweb.Repositorios.ActivityRepository;
import com.jpconsultoria.ingweb.Repositorios.ChapterRepository;
import com.jpconsultoria.ingweb.Repositorios.TypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ChapterRepository chapterRepository;

    @Autowired
    private TypeRepository typeRepository;


    @Override
    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    @Override
    public Activity getActivityById(Long id) {
        return activityRepository.findById(id).orElse(null);
    }

    @Override
    public Activity createActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public Activity updateActivity(Long id, Activity activity) {
        if (activityRepository.existsById(id)) {
            activity.setId(id);
            return activityRepository.save(activity);
        }
        return null;
    }

    @Override
    public void deleteActivity(Long id) {
        activityRepository.deleteById(id);
    }

    @Override
    public List<Activity> findByProjectId(Long projectId) {
        return activityRepository.findByProjectId(projectId);
    }

    @Override
    public List<Type> findAllTypes() {
        return typeRepository.findAll();
    }

    @Override
    public List<Chapter> findAllChapters() {
        return chapterRepository.findAll();
    }
}
