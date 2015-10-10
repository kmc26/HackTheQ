package app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import app.db.Employee;
import app.db.RestaurantQueue;
import app.db.RestaurantRepository;

@Controller
public class RestaurantController {
	@Autowired
	RestaurantRepository repo;
	
	@RequestMapping("/restaurant")
	@ResponseBody
	public RestaurantQueue askRestaurant(@RequestParam(value="id") String id) {
		RestaurantQueue rq = repo.findOne(id);
		if (rq == null) {
			rq = new RestaurantQueue(null, 0, 0);
		}
		return rq;
	}
	
	@RequestMapping("/restaurant/update")
	@ResponseBody
	public RestaurantQueue addToQueue(@RequestParam(value="id") String id, @RequestParam(value="time") int time) {
		RestaurantQueue rq =  repo.findOne(id);
		if (rq != null) {
			rq.setTotalTimes(rq.getTotalTimes()+time);
			rq.setNumEntries(rq.getNumEntries()+1);
			repo.save(rq);
		} else {
			rq = new RestaurantQueue(id, time, 1);
			repo.save(rq);
		}
		return rq;
	}
	
	@RequestMapping("/restaurant/reset")
	@ResponseBody
	public void reset() {
		List<RestaurantQueue> restaurantQueues =  repo.findAll();
		for(RestaurantQueue rq : restaurantQueues) {
			repo.delete(rq);
		}
	}
}
