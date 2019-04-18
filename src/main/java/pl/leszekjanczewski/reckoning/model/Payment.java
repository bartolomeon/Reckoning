package pl.leszekjanczewski.reckoning.model;

//import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id") //TODO: 'id'
    private Long paymentId;

    @Column(name = "amount")
    private Double amount;

    @Temporal(TemporalType.DATE)
    private Date paymantDay;  //TODO: typo -> 'paymentDay'

    @ManyToMany(mappedBy = "payments")
    private Set<Client> clients = new HashSet<>();

    @ManyToMany(mappedBy = "payments")
    private Set<Child> children = new HashSet<>();

    @ManyToMany(mappedBy = "payments")
    private Set<Class> classes = new HashSet<>();

    @OneToOne(mappedBy = "payment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Installment installment;
}
