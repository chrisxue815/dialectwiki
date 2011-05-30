package org.dw.model;

import java.util.Date;


/**
 * Pronunciation entity. @author MyEclipse Persistence Tools
 */

public class Pronunciation  implements java.io.Serializable {


    // Fields    

     private Integer pronId;
     private Integer userId;
     private Integer cityId;
     private Integer wordId;
     private String prUrl;
     private Date uploadDate;
     private Integer goodVoteNum;
     private Integer badVoteNum;


    // Constructors

    /** default constructor */
    public Pronunciation() {
    }

	/** minimal constructor */
    public Pronunciation(Integer userId, Integer cityId, Integer wordId, Integer goodVoteNum, Integer badVoteNum) {
        this.userId = userId;
        this.cityId = cityId;
        this.wordId = wordId;
        this.goodVoteNum = goodVoteNum;
        this.badVoteNum = badVoteNum;
    }
    
    /** full constructor */
    public Pronunciation(Integer userId, Integer cityId, Integer wordId, String prUrl, Date uploadDate, Integer goodVoteNum, Integer badVoteNum) {
        this.userId = userId;
        this.cityId = cityId;
        this.wordId = wordId;
        this.prUrl = prUrl;
        this.uploadDate = uploadDate;
        this.goodVoteNum = goodVoteNum;
        this.badVoteNum = badVoteNum;
    }

   
    // Property accessors

    public Integer getPronId() {
        return this.pronId;
    }
    
    public void setPronId(Integer pronId) {
        this.pronId = pronId;
    }

    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCityId() {
        return this.cityId;
    }
    
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getWordId() {
        return this.wordId;
    }
    
    public void setWordId(Integer wordId) {
        this.wordId = wordId;
    }

    public String getPrUrl() {
        return this.prUrl;
    }
    
    public void setPrUrl(String prUrl) {
        this.prUrl = prUrl;
    }

    public Date getUploadDate() {
        return this.uploadDate;
    }
    
    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Integer getGoodVoteNum() {
        return this.goodVoteNum;
    }
    
    public void setGoodVoteNum(Integer goodVoteNum) {
        this.goodVoteNum = goodVoteNum;
    }

    public Integer getBadVoteNum() {
        return this.badVoteNum;
    }
    
    public void setBadVoteNum(Integer badVoteNum) {
        this.badVoteNum = badVoteNum;
    }
   








}