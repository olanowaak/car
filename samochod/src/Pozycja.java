public class Pozycja{
    private float x;
    private float y;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }



    public Pozycja(float x, float y) {
        this.setX(x);
        this.setY(y);
    }




    public void przeniesc(Pozycja cel, double czas, double predkosc) {
        if (predkosc !=0){
            double delta_x = (predkosc * czas / 1000 * (cel.x - this.x)) / (Math.sqrt(Math.pow((cel.x - this.x), 2) + Math.pow((cel.y - this.y), 2)));
            double delta_y = (predkosc * czas / 1000 * (cel.y - this.y)) / (Math.sqrt(Math.pow((cel.x - this.x), 2) + Math.pow((cel.y - this.y), 2)));
            if (cel.x - this.x > 0) {
                if (delta_x >= cel.x - this.x) {
                    this.x = cel.x;
                } else
                    this.x += delta_x;
            } else {
                if (delta_x <= cel.x - this.x) {
                    this.x = cel.x;
                } else
                    this.x += delta_x;
            }
            if (cel.y - this.y > 0) {
                if (delta_y >= cel.y - this.y) {
                    this.y = cel.y;
                } else
                    this.y += delta_y;
            } else {
                if (delta_y <= cel.y - this.y) {
                    this.y = cel.y;
                } else
                    this.y += delta_y;
            }
        }
    }

    public void przemiesc(double v, double dt, Pozycja cel) {
        if(cel.getX() - this.getX() != 0) {
            if (cel.getY() - this.getY() != 0) {
                double dx = v * dt * (cel.getX() - this.getX()) / (Math.sqrt(Math.pow(cel.getX() - this.getX(), 2) + Math.pow(cel.getY() - this.getY(), 2)));
                double dy = v * dt * (cel.getY() - this.getY()) / (Math.sqrt(Math.pow(cel.getX() - this.getX(), 2) + Math.pow(cel.getY() - this.getY(), 2)));
                this.setX((float) (this.x + dx));
                this.setY((float) (this.y + dy));
            }
            else{
                this.setX(cel.getX());
                this.setY(cel.getY());
            }
        }else{
            this.setX(cel.getX());
            this.setY(cel.getY());
        }



    }

    public void wypisz(){
        System.out.println("wpółrzędne samochodu: x=" + this.getX() + ", y=" + this.getY());
    }

    public String w(){
        String r = new String("wpółrzędne samochodu: x=" + this.getX() + ", y=" + this.getY());
        return r;
    }
   // public double przemiesc_x(double v, double deltaT, Pozycja cel){
     //   double d_x = v * deltaT/1000 * (cel.getX() - this.getX()/(pow(cel.getY() - this.getY(), 2))));
       // return d_x;}
    //public double przeniesc_y(double v, double deltaT, Pozycja cel){
      //  double d_y = v * deltaT/1000 * (cel.getY() - this.getY()/(Math.sqrt(Math.pow(cel.getX() - this.getX(), 2) + Math.pow(cel.getY() - this.getY(), 2))));
        //return d_y;}

        //napisac test jednostkowy JUnit 1 test


}

