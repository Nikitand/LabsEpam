package model;

import java.util.Objects;

public class TShirt {

    private String size;

    public  TShirt(String size){
        this.size = size;
    }
    public void setSize(String size) {this.size = size;}
    public String getSize() {
        return size;
    }

    @Override
    public  String toString(){
        return "TShirt{" +
                "size='" + size + '\'' +
                '}';
    }

    @Override
    public  boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof TShirt)) return  false;
        TShirt tShirt = (TShirt) o;
        return Objects.equals(getSize(), tShirt.getSize()) ;
    }

    public  int hashCode(){return  Objects.hash(getSize());}


}
