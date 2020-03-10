package com.peter.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_table")


public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
        @Column(name = "username")
        private String username;
        
        @Column(name = "password")
        private String password;
        
        @Column(name="authorization")
        private char authorization;

		public User(String username, String password, char authorization) {
			this.username = username;
			this.password = password;
			this.authorization = authorization;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public char getAuthorization() {
			return authorization;
		}

		public void setAuthorization(char authorization) {
			this.authorization = authorization;
		}

        
        
        
        
        
        
}
