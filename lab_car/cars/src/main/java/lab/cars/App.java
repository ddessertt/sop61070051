package lab.cars;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class App 
{
	ArrayList<Cars> cars = new ArrayList<Cars>();

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@RequestMapping(value = "/car", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<Cars>> createCar(@RequestBody Cars carInfo) {
		cars.add(carInfo);
		return new ResponseEntity<ArrayList<Cars>>(cars, HttpStatus.OK);
	}

	@RequestMapping(value = "/car/{index}", method = RequestMethod.PATCH)
	public ResponseEntity<ArrayList<Cars>> patchCar(@RequestBody Cars getInfoCar, @PathVariable("index") int index) {
		cars.set(index - 1, getInfoCar);
		return new ResponseEntity<ArrayList<Cars>>(cars, HttpStatus.OK);
	}

	@RequestMapping(value = "/car/{index}", method = RequestMethod.GET)
	public ResponseEntity<Cars> getCar(@PathVariable("index") int index) {
		return new ResponseEntity<Cars>(cars.get(index - 1), HttpStatus.OK);
	}

	@RequestMapping(value = "/car/{index}", method = RequestMethod.DELETE)
	public ResponseEntity<ArrayList<Cars>> deleteCar(@PathVariable("index") int index) {
		cars.remove(index - 1);
		return new ResponseEntity<ArrayList<Cars>>(cars, HttpStatus.OK);
	}
}
