package tn.esb.bis.demo.Domains;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Setter
@Entity
@NoArgsConstructor /// with parameter
@RequiredArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id ;
    @EqualsAndHashCode.Include
    private int Streetnum ;
    @NonNull
    @EqualsAndHashCode.Include

    private String StreetName;
    @NonNull
    private String city ;
    @EqualsAndHashCode.Include
    private int postalCode ;
    /// relation between adress and member
    @OneToOne
    private Member member ;

}
