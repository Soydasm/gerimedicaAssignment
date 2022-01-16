package nl.gerimedica.assignment.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "T_CODE", uniqueConstraints={
        @UniqueConstraint(columnNames = {"id", "code"})
})
@Data
@ToString(of = {"id", "code"})
@Where(clause = "DELETED = '0'")
public class Code implements Serializable
{
    private static final long serialVersionUID = 1L;

    public static String DEFAULT_DELETED_VALUE = "0";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String deleted = DEFAULT_DELETED_VALUE;

    private String source;

    private String codeListCode;

    @Column(unique = true)
    private String code;

    @Column(length = 2000)
    @Size(max = 2000)
    private String displayValue;

    @Column(length = 2000)
    @Size(max = 2000)
    private String longDescription;

    private Date fromDate;

    private Date toDate;

    private String sortingPriority;

}
