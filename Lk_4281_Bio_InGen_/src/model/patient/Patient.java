/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.patient;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class Patient {
    private String pt_internalid;
    private String pt_idpassport;
    private String pt_lastnames;
    private String pt_firstnames;
    private String pt_genre;
    private String pt_brthday;
    private String pt_contcNum;
    private String pt_email;
    private String pt_plusinfo;
    private String pt_type;

    public Patient() {
    }

    public Patient(String pt_internalid, String pt_idpassport, String pt_lastnames, String pt_firstnames, String pt_genre, String pt_brthday, String pt_contcNum, String pt_email, String pt_plusinfo, String pt_type) {
        this.pt_internalid = pt_internalid;
        this.pt_idpassport = pt_idpassport;
        this.pt_lastnames = pt_lastnames;
        this.pt_firstnames = pt_firstnames;
        this.pt_genre = pt_genre;
        this.pt_brthday = pt_brthday;
        this.pt_contcNum = pt_contcNum;
        this.pt_email = pt_email;
        this.pt_plusinfo = pt_plusinfo;
        this.pt_type = pt_type;
    }

    //Getters
    public String getPt_internalid() {return pt_internalid;}
    public String getPt_idpassport() {return pt_idpassport;}
    public String getPt_lastnames() {return pt_lastnames;}
    public String getPt_firstnames() {return pt_firstnames;}
    public String getPt_genre() {return pt_genre;}
    public String getPt_brthday() {return pt_brthday;}
    public String getPt_contcNum() {return pt_contcNum;}
    public String getPt_email() {return pt_email;}
    public String getPt_plusinfo() {return pt_plusinfo;}
    public String getPt_type() {return pt_type;}
    
    //Setters
    public void setPt_idpassport(String pt_idpassport) {this.pt_idpassport = pt_idpassport;}
    public void setPt_lastnames(String pt_lastnames) {this.pt_lastnames = pt_lastnames;}
    public void setPt_firstnames(String pt_firstnames) {this.pt_firstnames = pt_firstnames;}
    public void setPt_genre(String pt_genre) {this.pt_genre = pt_genre;}
    public void setPt_brthday(String pt_brthday) {this.pt_brthday = pt_brthday;}
    public void setPt_contcNum(String pt_contcNum) {this.pt_contcNum = pt_contcNum;}
    public void setPt_email(String pt_email) {this.pt_email = pt_email;}
    public void setPt_plusinfo(String pt_plusinfo) {this.pt_plusinfo = pt_plusinfo;}
    public void setPt_type(String pt_type) {this.pt_type = pt_type;}
 
    
    //Methods
    
    //Internal ID
    private String pt_intid(){
        String today=LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMM"));
        String prefix= "pt_"+today+"_";
        int highestSequence=0;
        
        try(BufferedReader reader=new BufferedReader(new FileReader("C:/Users/diego/Desktop/Proyectos Privados/Java_ApacheNetbeans/Lk_4281_Bio_InGen_/docs/Database/Patients"))){
            String line;
            while((line =reader.readLine())!=null){
                String[] data=line.split("\\|");
                if(data.length>0){
                    String existingId = data[0].trim();
                    if(existingId.startsWith(prefix)){
                      String seqStr = existingId.substring(prefix.length());
                      int seqNum = Integer.parseInt(seqStr);
                        if (seqNum > highestSequence) {
                          highestSequence = seqNum;  
                        }
                    }
                }
            }
        }catch(IOException | NumberFormatException e){
            JOptionPane.showMessageDialog(null, "No File Found");
        }
      return String.format("%s%04d", prefix, highestSequence + 1);
    }
}
