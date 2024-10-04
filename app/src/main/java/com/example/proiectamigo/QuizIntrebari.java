package com.example.proiectamigo;

public class QuizIntrebari {
    public String vectIntreb[]={
            "Care este cel mai vândut produs fast-food din lume?","În ce an a fost fondat primul restaurant McDonald's?","Ce fast-food este cunoscut pentru bucățile sale de pui prăjite?","Care este originea hamburgerului?","Ce lanț de restaurante fast-food este specializat în sandwich-uri de pește?","Care este numele popular al produsului format din cartofi prăji acoperți cu brânză și sos?","Care este ingredientul principal într-un wrap clasic mexican?","Ce fast-food este cunoscut pentru \"Whopper\"?","Care este denumirea franțizei de fast-food specializată în sandwich-uri cu friptură de vită făcută în casă?","În ce țară a fost fondat lanțul de restaurante fast-food Domino's Pizza?"
    };
    public String vectRasp[][]={
            {"Cheeseburger","Pizza","Hot Dog","Fried Chicken"},{"1940","1955","1967","1973"},{"KFC","Subway","Taco Bell","Burger King"},{"Germania","Franța","Statele Unite","Italia"},{"McDonald's","Subway","Arby's","Chick-fil-A"},{"Onion Rings","Poutine","Mozzarella Sticks","Loaded Fries"},{"Pui","Carne de vită","Fasole","Porc"},{"McDonald's","Wendy's","Burger King","Taco Bell"},{"Jimmy John's","Arby's","Subway","Five Guys"},{"Italia","Statele Unite","Australia","Japonia"}
    };
    public String raspCorecte[]={"Pizza","1955","KFC","Statele Unite","Subway","Poutine","Pui","Burger King","Arby's","Statele Unite"};
    public String getIntrebare(int i){
        return vectIntreb[i];
    }
    public String getRaspA(int i){
        return vectRasp[i][0];
    }
    public String getRaspB(int i){
        return vectRasp[i][1];
    }
    public String getRaspC(int i){
        return vectRasp[i][2];
    }
    public String getRaspD(int i){
        return vectRasp[i][3];
    }
    public String getRaspCorect(int i){
        return raspCorecte[i];
    }
}