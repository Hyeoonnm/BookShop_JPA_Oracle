package kr.ac.kopo.attach;

import jakarta.persistence.*;
import kr.ac.kopo.movie.Movie;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Attach {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int attachId;

    private int movieId;

    private String filename;
    private String uuid;

    @ManyToOne
    @JoinColumn(name = "movieId", insertable = false, updatable = false)
    private Movie movie;
}
