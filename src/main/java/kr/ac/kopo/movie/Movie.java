package kr.ac.kopo.movie;

import jakarta.persistence.*;
import kr.ac.kopo.attach.Attach;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int movieId;

    private String title;

    private String director;

    private String genre;

    @Temporal(TemporalType.DATE)
    private Date openDate;

    @OneToMany
    @JoinColumn(name = "attachId", insertable = false, updatable = false)
    private List<Attach> attach;
}
