package hska.eva.domain;

import java.io.Serializable;

/**
 * Created by Luke on 12.01.2016.
 */
public class Rating implements Serializable{

    private Long id;

    private int motivation;

    private int teamfaehigkeit;

    private int kommunikation;

    private int knowhow;

    private long studentb_fk;

    private long student_fk;

    public Rating(){
    }

    public Rating(Long id, int motivation, int teamfaehigkeit, int kommunikation, int knowhow, long studentb_fk, long student_fk) {
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

    public int getMotivation() {
        return motivation;
    }

    public void setMotivation(int motivation) {
        this.motivation = motivation;
    }

    public int getTeamfaehigkeit() {
        return teamfaehigkeit;
    }

    public void setTeamfaehigkeit(int teamfaehigkeit) {
        this.teamfaehigkeit = teamfaehigkeit;
    }

    public int getKommunikation() {
        return kommunikation;
    }

    public void setKommunikation(int kommunikation) {
        this.kommunikation = kommunikation;
    }

    public int getKnowhow() {
        return knowhow;
    }

    public void setKnowhow(int knowhow) {
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
