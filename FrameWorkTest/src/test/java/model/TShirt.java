package model;

import java.util.Objects;

public class TShirt {


    private String name;
    private String size;

    public  TShirt(String name, String size){
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {this.name = name;}
    public  String getSize(){
        return size;
    }
    public  void setSize(String size) {this.size = size;}

    @Override
    public  String toString(){
        return "TShirt{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                '}';
    }

    @Override
    public  boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof TShirt)) return  false;
        TShirt tShirt = (TShirt) o;
        return Objects.equals(getName(), tShirt.getName()) &&
                Objects.equals(getSize(), tShirt.getSize());
    }

    public  int hashCode(){return  Objects.hash(getName(), getSize());}

}
