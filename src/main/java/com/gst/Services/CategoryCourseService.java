package com.gst.Services;

import com.gst.Model.Category;
import com.gst.Model.Course;

import java.util.List;

public interface CategoryCourseService {
    void saveCategory(Category category);

    void saveCourse(Course course);

    List<Course> findAllCourse();

    Category findCategoryName(String name);

    List<Category> findAllCategory();
}
