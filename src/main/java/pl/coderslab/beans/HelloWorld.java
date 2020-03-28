package pl.coderslab.beans;

public class HelloWorld {

    private String message;

//    public HelloWorld(String message) {
//        this.message = message;
//    }


    // modyfikacja wstrzyknięcie wartości atrybutu przez setter - metoda dostępowa
    public void setMessage(String message) {
        this.message = message;
    }

    public void printMessage(){
        System.out.println(this.message);
    }

}
