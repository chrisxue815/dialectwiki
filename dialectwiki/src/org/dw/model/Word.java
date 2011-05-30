package org.dw.model;

import java.util.HashSet;
import java.util.Set;


/**
 * Word entity. @author MyEclipse Persistence Tools
 */

public class Word  implements java.io.Serializable {


    // Fields    

     private Integer wordId;
     private String wordName;
     private Set pronunciations = new HashSet(0);


    // Constructors

    /** default constructor */
    public Word() {
    }

    
    /** full constructor */
    public Word(String wordName, Set pronunciations) {
        this.wordName = wordName;
        this.pronunciations = pronunciations;
    }

   
    // Property accessors

    public Integer getWordId() {
        return this.wordId;
    }
    
    public void setWordId(Integer wordId) {
        this.wordId = wordId;
    }

    public String getWordName() {
        return this.wordName;
    }
    
    public void setWordName(String wordName) {
        this.wordName = wordName;
    }

    public Set getPronunciations() {
        return this.pronunciations;
    }
    
    public void setPronunciations(Set pronunciations) {
        this.pronunciations = pronunciations;
    }
   








}