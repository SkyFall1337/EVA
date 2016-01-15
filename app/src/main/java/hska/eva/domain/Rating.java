package hska.eva.domain;

import java.io.Serializable;

/**
 * Created by Luke on 12.01.2016.
 */
public class Rating implements Serializable{

    private Long id;

    private Long motivation;

    private Long teamfaehigkeit;

    private Long kommunikation;

    private long knowhow;

    private long studentb_fk;

    private long student_fk;

    public Rating(){
    }

    public Rating(Long id, Long motivation, Long teamfaehigkeit, Long kommunikation, long knowhow, long studentb_fk, long student_fk) {
        this.id = id;
        this.motivation = motivation;
        this.teamfaehigkeit = teamfaehigkeit;
        this.kommunikation = kommunikation;
        this.knowhow = knowhow;
        this.studentb_fk = studentb_fk;
        this.student_fk = student_fk;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMotivation() {
        return motivation;
    }

    public void setMotivation(Long motivation) {
        this.motivation = motivation;
    }

    public Long getTeamfaehigkeit() {
        return teamfaehigkeit;
    }

    public void setTeamfaehigkeit(Long teamfaehigkeit) {
        this.teamfaehigkeit = teamfaehigkeit;
    }

    public Long getKommunikation() {
        return kommunikation;
    }

    public void setKommunikation(Long kommunikation) {
        this.kommunikation = kommunikation;
    }

    public long getKnowhow() {
        return knowhow;
    }

    public void setKnowhow(long knowhow) {
        this.knowhow = knowhow;
    }

    public long getStudentb_fk() {
        return studentb_fk;
    }

    public void setStudentb_fk(long studentb_fk) {
        this.studentb_fk = studentb_fk;
    }

    public long getStudent_fk() {
        return student_fk;
    }

    public void setStudent_fk(long student_fk) {
        this.student_fk = student_fk;
    }
}
