package example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	@Query(value="Select * from Student",nativeQuery=true)
	List<Student>findAll();
	
	@Modifying
	@Transactional
	@Query(value="Delete  from Student Where id=?1",nativeQuery=true)
	int DeleteById(int id);
	
	@Transactional
    @Modifying
    @Query(value = "DELETE FROM Student WHERE id > ?1 AND marks > ?2", nativeQuery = true)
    void deleteByIdAndMarks(int id, int marks);
}
