package co.prodentix.pd.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

import co.prodentix.pd.domain.Enumerations.Sex;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.mapstruct.ap.internal.model.GeneratedType;

@Entity
@Table(name= "patients")
public class Patients implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(max = 200)
    @Column(name = "address", length = 200, nullable = false)
    private String address;

    @NotNull
    @Size(max = 25)
    @Column(name = "phone_number", length = 25, nullable = false)
    private  String phoneNumber;

    @NotNull
    @Size(max = 15)
    @Column(name = "first_name", length = 15, nullable = false)
    private String firstName;


    @NotNull
    @Size(max = 15)
    @Column(name = "second_name", length = 15, nullable = false)
    private String secondName;

    @NotNull
    @Size(max = 10)
    @Column(name = "last_name", length = 10, nullable = false)
    private String lastName;

    @NotNull
    @Size(max = 10)
    @Column(name = "second_last_name", length = 10, nullable = false)
    private String secondLastName;

    @NotNull
    @Size(max = 10)
    @Column(name = "sex_type", length = 10, nullable = false)
    private String sexType;


    @NotNull
    @Size(max = 50)
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @NotNull
    @Size(max = 100)
    @Column(name = "document_number", length = 100, nullable = false)
    private String documentNumber;

    @OneToOne(optional = false)
    @NotNull
    @JoinColumn(unique = true)
    private User user;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = {"patients"}, allowGetters = true)
    private DocumentType documentType;






}
