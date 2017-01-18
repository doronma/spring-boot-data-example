package boot_rest.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;

	private List<Topic> topics = new ArrayList<Topic>(
			Arrays.asList(new Topic("spring", "Spring framework", "Spring framework Description"),
					new Topic("spring1", "Spring2 framework", "Spring2 framework Description")));

	public List<Topic> getAllTopics() {
		List <Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	public Topic getTopic(String id) {
		
		return topicRepository.findOne(id);
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
		
		
		
	}

	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
		
	}

	public void deleteTopic(String id) {
		topicRepository.delete(id);
		
	}

}