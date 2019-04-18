package pl.leszekjanczewski.reckoning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data //TODO: hashCode nie będzie poprawne (unikalne jest id)
@AllArgsConstructor //TODO: nie sądzę, żeby to było w jakiejkolwiek encji potrzebne - klucz jest generowany przez bazę a nie wstawiany z palca
@NoArgsConstructor  //TODO: out - jak usuniesz @AllArgsConstructor 
@Entity
@Table(name = "calendar") //TODO: zbędne
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "calendar_id")  //TODO: zdecydowanie sugerowałbym użycie tu po prostu 'id' - i tak dla każdej enccji; wtedy zrób typ bazowy dla wszystkich encji z jednym wspólnym polem 'id'; 
    //TODO: @Column jest zbędne
    private Long calendarId;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_activities")
    private Date dateOfActivites;  //TODO:  zdecydowanie przestaw się na java.time.*    -> tutaj chyba  potrzebujesz LocalDate  (ew. LocalDateTime)

    @ManyToMany(mappedBy = "calendars")
    private Set<Class> classes = new HashSet<>(); //TODO: Class -> Activity ?
}
