package org.dw.model;



/**
 * VoteId entity. @author MyEclipse Persistence Tools
 */

public class VoteId  implements java.io.Serializable {


    // Fields    

     private User user;
     private Pronunciation pronunciation;


    // Constructors

    /** default constructor */
    public VoteId() {
    }

    
    /** full constructor */
    public VoteId(User user, Pronunciation pronunciation) {
        this.user = user;
        this.pronunciation = pronunciation;
    }

   
    // Property accessors

    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    public Pronunciation getPronunciation() {
        return this.pronunciation;
    }
    
    public void setPronunciation(Pronunciation pronunciation) {
        this.pronunciation = pronunciation;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VoteId) ) return false;
		 VoteId castOther = ( VoteId ) other; 
         
		 return ( (this.getUser()==castOther.getUser()) || ( this.getUser()!=null && castOther.getUser()!=null && this.getUser().equals(castOther.getUser()) ) )
 && ( (this.getPronunciation()==castOther.getPronunciation()) || ( this.getPronunciation()!=null && castOther.getPronunciation()!=null && this.getPronunciation().equals(castOther.getPronunciation()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getUser() == null ? 0 : this.getUser().hashCode() );
         result = 37 * result + ( getPronunciation() == null ? 0 : this.getPronunciation().hashCode() );
         return result;
   }   





}