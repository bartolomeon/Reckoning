package pl.leszekjanczewski.reckoning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.leszekjanczewski.reckoning.model.Class;

import java.util.List;

@Repository
public interface ClassRepo extends JpaRepository<Class, Long> {

    Class findByClassId(Long id);

    
    //TODO: nativeQuery jest tu zdecydowanie zbędne, użyj JPQLa (można zrobić SELECT NEW ...)  jeżeli potrzebujesz specjalnego typu, 
    //albo chyba lepiej - po prostu użyj findAll() i potem wykorzystaj tylko classId i className z tych obiektów
    @Query(value = "SELECT class_id, class_name FROM classes", nativeQuery = true) 
    List<Object[]> listClassWithName(); 
}
