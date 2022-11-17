package tn.esb.bis.demo.Domains;

import lombok.*;
import tn.esb.bis.demo.Enumerations.MemeberType;

import javax.persistence.*;
import java.util.Date;

//@EqualsAndHashCode // for methods equals and .hashcode() => dans ce cas la deux memebres sont idantique s'ils ont une
//egalité entre tous les attrb
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // la comp entre les obj sera effectuant en uniq les att marqué include
@Entity
@Getter
@Setter
@NoArgsConstructor /// for constructors with no parameters
@RequiredArgsConstructor // aml constructor paramétré b les attrbs mamoulin as nonNull
@ToString(exclude = {"photo","phone"})


public class Member {
    @JoinColumn(name="id" , referencedColumnName = "id") /// join mabin
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    @Column(name ="Firstname" , length = 100)
    @NonNull// name is marke
    // d as an obligation
    @EqualsAndHashCode.Include
    private String name ;
    @Column(name ="family" , length = 100)
    @EqualsAndHashCode.Include
    private String FamName;
    @EqualsAndHashCode.Include
    private String email ;
    @NonNull
    public String phone ;
    @Lob
    private Byte[] photo;
    private Date FinalDate;

    ///relation between member and adress  (Orm)
    @OneToOne (mappedBy = "member") /// menionne que les deux att member et meeberAddress proviennent de la meme relation(1-1)
    @JoinColumn(name = "address_id" , referencedColumnName = "id")  /// 'address_id ' foreign key refrences Adresse(id)

    private Address memberAddress ;



}
