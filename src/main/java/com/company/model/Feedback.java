
/**
 * Created by dsrpc on 27.02.2018.
 */
package com.company.model;



import lombok.*;
import org.hibernate.annotations.CreationTimestamp;



import javax.persistence.*;
import java.util.Date;



@Entity
@Table(name = "FEEDBACK")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@ToString
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;


    @Column(name = "TITLE", length = 100, nullable = false)
    private String title;


    @Lob
    @Column(name = "CONTENT", nullable = false)
    private String content;



    @CreationTimestamp
    @Column(name = "CREATED_ON", nullable = false)
    private Date createdOn;



    @Column(name = "RATE", nullable = false)
    private Integer rate;

    @Override
    public String toString() {
        return "Feedback: " +
                "id=" + id +
                ", user=" + user +
                ",\n title: '" + title + '\'' +
                ",\n content: '" + content + '\'' +
                ",\n createdOn: " + createdOn +
                ",\n rate: " + rate +
                ' ';
    }
}