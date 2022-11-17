package tn.esb.bis.demo.Domains;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;


@NoArgsConstructor
@Getter
@Setter
/// use the not null atts
@RequiredArgsConstructor
@ToString
@Entity



public class Writer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id ;
    @NonNull
    @EqualsAndHashCode.Include
    private String Name;
    @NonNull
    private String FamilyName ;
    @NonNull
    @EqualsAndHashCode.Include
    private LocalDate birthday;
    private String nationality ;
    private String Desc ;
    @Lob
    private Byte[] photo;

    //relation entre writer et book - // tkbl set bch book ytawdch and writer akther mn mara to wrigh it  //
    @OneToMany(mappedBy = "writer")
    @ToString.Exclude

    private Set<Book> books ;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Writer writer = (Writer) o;
        return id != null && Objects.equals(id, writer.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
