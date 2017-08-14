package com.gst.Services;

import com.gst.Model.Category;
import com.gst.Model.Course;
import com.gst.Repository.CategoryRepository;
import com.gst.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryCourseServiceImpl implements CategoryCourseService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CourseRepository courseRepository;

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void saveCourse(Course course) {
        course.setCategory(course.getCategory());
        courseRepository.save(course);
    }

    @Override
    public Category findCategoryName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public List<Course> findAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }
}
