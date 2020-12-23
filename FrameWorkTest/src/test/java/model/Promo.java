package model;

import java.util.Objects;

public class Promo {
    private String promo;

    public  Promo(String promo){
        this.promo = promo;
    }
    public void setPromo(String promo) {this.promo = promo;}
    public String getPromo() {
        return promo;
    }

    @Override
    public  String toString(){
        return "Promo{" +
                "promo='" + promo + '\'' +
                '}';
    }

    @Override
    public  boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Promo)) return  false;
        Promo promo = (Promo) o;
        return Objects.equals(getPromo(), promo.getPromo()) ;
    }

    public  int hashCode(){return  Objects.hash(getPromo());}
}
