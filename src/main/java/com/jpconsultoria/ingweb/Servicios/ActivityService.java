package com.jpconsultoria.ingweb.Servicios;

import com.jpconsultoria.ingweb.Entidades.Activity;
import com.jpconsultoria.ingweb.Entidades.Chapter;
import com.jpconsultoria.ingweb.Entidades.Type;

import java.util.List;

public interface ActivityService {
    List<Activity> getAllActivities();
    Activity getActivityById(Long id);
    Activity createActivity(Activity activity);
    Activity updateActivity(Long id, Activity activity);
    void deleteActivity(Long id);

    // Nuevos métodos
    List<Activity> findByProjectId(Long projectId);
    List<Type> findAllTypes();
    List<Chapter> findAllChapters();
}