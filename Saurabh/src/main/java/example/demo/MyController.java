package example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@Autowired
	StudentRepo studentRepo;
	@RequestMapping("/")
	List<Student> getAll()
	{
		return studentRepo.findAll();
	}
	
	@RequestMapping("Delete/{id}")
    public int delete(@PathVariable("id") int id) 
	{
		try {
			
			studentRepo.DeleteById(id);
			return 1;
		}
		catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@DeleteMapping("DeleteByIdAndMarks/{id}/{marks}")
	String DeleteByIdAndMarks(@PathVariable("id") int id,@PathVariable ("marks") int marks)
	{
		try {
			 studentRepo.deleteByIdAndMarks(id,marks);
			 return "Deleted Successfully";
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
