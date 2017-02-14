package fr.epita.Fundementalproject.model;


    public class Identity {
		 private String uid;
		 private String displayname;
		 private String email;
		 private String birthDate;
		 private String password;
		 /**
		  * @param uid
		  * @param displayname
		  * @param email
		  */
	public Identity(String uid, String displayname, String email, String birthDate, String password) {

		  this.uid = uid;
		  this.displayname = displayname;
		  this.email = email;
		  this.birthDate = birthDate;
		  this.password = password;
		}
    	public String getUid() {
    		return uid;
		}
		 public void setUid(String uid) {
		  this.uid = uid;
		 }
		 public String getDisplayName() {
		  return displayname;
		 }
		 public void setDisplayName(String displayname) {
		  this.displayname = displayname;
		 }
		 public String getEmail() {
		  return email;
		 }
		 public void setEmail(String email) {
		  this.email = email;
		 }
		 
		 public String getBirthDate() {
		  return birthDate;
		 }
		 public void setBirthDate(String birthDate) {
		  this.birthDate = birthDate;
		 }
		 public String getPassword() {
			  return password;
			 }
			 public void setPassword(String password) {
			  this.password = password;
			 }
			 
		 @Override
		 public String toString() {
		  return "Identity [uid=" + uid + ", displayname=" + displayname + ", email=" + email + " bithdate: " + birthDate + "]";
		 }
		
}