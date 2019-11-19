package com.projects.model;

import java.io.Serializable;

public class Tarea implements Serializable {
	
	    private Integer id;
	    private String name;
	    private Boolean done;
	    
	    public Tarea() {
			super();
			this.id = 0;
			this.name = "Default";
			this.done = false;
		}
	    public Tarea(Integer id, String name, Boolean done) {
			super();
			this.id = id;
			this.name = name;
			this.done = done;
		}
	    
	    public Tarea(String name, Boolean done) {
			super();
			this.id = -1;
			this.name = name;
			this.done = done;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Boolean getDone() {
			return done;
		}
		public void setDone(Boolean done) {
			this.done = done;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	    // standard contructors, getters, and setters
}

