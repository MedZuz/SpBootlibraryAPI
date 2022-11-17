package tn.esb.bis.demo.Domains;


//whole annotatioon for the model her type mta annotaiton lele model
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor// with parameter
@Entity// book to be as table
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
@ToString(exclude = {"coverImage" , "code_isbn"}) // adreesse mta l'obj w tatina toutes les vacleurss des attrbs
public class Book {

    @Id
    @EqualsAndHashCode.Include
    private String code_isbn ;
    @EqualsAndHashCode.Include
    private String title;

    @Column(scale = 3 ,precision=7) // 7,854
    @NonNull
    private BigDecimal prix;
    @NonNull
    @JsonFormat(pattern = "yyyy-mm-dd")
    private LocalDate date_de_sortie ;
    @NonNull
    private int nbExamplares ;

    @Lob
    private byte[] coverImage;

    private String summary ;

    private String  Booktheme ;


    @ManyToOne()

    @JoinColumn(name = "writer_id" , referencedColumnName = "id")  /// 'address_id ' foreign key refrences Adresse(id)

      private Writer writer;

}
