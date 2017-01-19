package boot_rest.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import boot_rest.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	public CourseController() {

	}

	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable String topicId) {
		System.out.println("In get all courses with id ..." + topicId);
		return courseService.getAllCourses(topicId);
	}

	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return courseService.getCourse(courseId);
	}

	@RequestMapping(method=RequestMethod.POST,value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course,@PathVariable String topicId) {
		System.out.println("add course for topic id " + topicId +" course - " + course);
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{topicId}/courses/{courseid}")
	public void updateCourse(@RequestBody Course course,@PathVariable String topicId) {
		System.out.println("in updatecourse...");
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}
	
	
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{topicId}/courses/{courseid}")
	public void deleteTopic(@PathVariable String courseid) {
		courseService.deleteCourse(courseid);
	}

} 
