package pl.leszekjanczewski.reckoning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;



//TODO: zdecydowanie zmiana nazwy - Class jest zbyt problematyczne w Javie - może 'Activity'?

@Data  //TODO: tu chyba nie chcesz mieć automatycznego hashCode w ogóle - ja bym tylko dał @Getter + @Setter;  w przypadku encji unikalność definiuje klucz głowny, nie zestaw atrybutów
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "classes") //TODO: tabele raczej w liczbie pojedynczej - tutaj można wtedy pominąć adnotację @Table
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private Long classId;

    @Column(name = "class_name") //TODO: adnotacje @Column nie są potrzebne w ogóle, jeżeli nazwy kolumn będą domyślne (jak tutaj)
    private String className;

   @ManyToOne
   @JoinColumn(name = "type_id")
    private TypeOfClass typeOfClass;

    @Column(name = "day_of_week")
    @NotEmpty(message = "Wybierz dzień zajęć")
    private String dayOfWeek;

//    @DateTimeFormat(pattern = "hh:mm")
//    @Temporal(TemporalType.TIME)
    @Column(name = "start_hour")
//    @NotEmpty(message = "Podaj godzinę zajęć")
    private LocalTime startHour;

    @Column(name = "duration")
//    @NotEmpty(message = "Podaj czas trwania zajęć")
    private int duration;

    @EqualsAndHashCode.Exclude //TODO: out
    @ManyToMany(mappedBy = "classes")
    private Set<Child> children = new HashSet<>();

    @EqualsAndHashCode.Exclude//TODO: out
    @ManyToMany
    @JoinTable(name = "classes_calendars", joinColumns = @JoinColumn(name = "class_id"), inverseJoinColumns = @JoinColumn(name = "calendar_id"))
    private Set<Calendar> calendars = new HashSet<>();

    @EqualsAndHashCode.Exclude//TODO: out
    @ManyToMany
    @JoinTable(name = "classes_payments", joinColumns = @JoinColumn(name = "class_id"), inverseJoinColumns = @JoinColumn(name = "payment_id"))
    private Set<Payment> payments = new HashSet<>();

    @EqualsAndHashCode.Exclude//TODO: out
    @ManyToMany
    @JoinTable(name = "classes_installments", joinColumns = @JoinColumn(name = "class_id"), inverseJoinColumns = @JoinColumn(name = "installment_id"))
    private Set<Installment> installments = new HashSet<>();
}
