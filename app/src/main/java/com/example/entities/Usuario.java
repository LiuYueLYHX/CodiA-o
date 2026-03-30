package main.java.com.example.entities;

public class Usuario {
    
    private Integer id = 0;
    private String name = "NaN";
    private String email = "NaN";
    private String password = "NaN";

    public Usuario(){

    }

    public Usuario(String name, String password){
        this.name = name;
        this.password = password;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

        @Override
    public String toString(){
       return getId() + ", " + getName() + ", " + getEmail() + ", " + getPassword();
    }



}
