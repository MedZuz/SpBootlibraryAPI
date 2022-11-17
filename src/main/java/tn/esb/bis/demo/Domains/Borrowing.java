package tn.esb.bis.demo.Domains;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor // constructor with no args cuz we have the id Auto
@Entity
@ToString
public class Borrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id ;
    private Date loanDate ;
    private String State ;

}
