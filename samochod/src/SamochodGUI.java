import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SamochodGUI extends Thread {

    private JTextField modelSamochodu;
    private JTextField numerRejestracyjny;
    private JTextField wagaSamochodu;
    private JTextField predkoscSamochodu;
    private JButton włączButton;
    private JButton wyłączButton;
    private JButton zwiększBiegButton;
    private JButton zmniejszBiegButton;
    private JComboBox wybierzSamochod;
    private JButton dodajNowyButton;
    private JButton usuńButton;
    private JPanel Samochód;
    private JTextField nazwaSkrzyni;
    private JTextField biegSkrzyni;
    private JTextField wagaSkrzyni;
    private JTextField cenaSkrzyni;
    private JTextField nazwaSilnika;
    private JTextField cenaSilnika;
    private JTextField wagaSilnika;
    private JTextField obrotySilnika;
    private JTextField nazwaSprzegla;
    private JTextField cenaSprzegla;
    private JTextField wagaSprzegla;
    private JTextField stanSprzegla;
    private JButton ujmijGazuButton;
    private JButton dodajGazuButton;
    private JButton zwolnijButton;
    private JButton naciśnijButton;
    private JPanel Mapa;
    private JLabel auto;


    //asocjacja jednokierunkowa
    Samochod samochod;

    public Samochod getSamochod() {
        return samochod;
    }

    public void setSamochod(Samochod samochod) {
        this.samochod = samochod;
    }

    SamochodGUI() {

        //auto.setVisible(false);

        refresh();


        wyłączButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(samochod!=null) {
                    boolean s1 = samochod.isStanWlaczenia();
                    samochod.wylacz();
                    boolean s2 = samochod.isStanWlaczenia();
                    if (s1 != s2) {
                        System.out.println("samochód został wyłączony z użyciem przycisku");
                    }
                }
                refresh();
            }
        });
        włączButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(samochod!=null) {
                    boolean s1 = samochod.isStanWlaczenia();
                    samochod.wlacz();
                    boolean s2 = samochod.isStanWlaczenia();
                    if (s1 != s2) {
                        System.out.println("samochód został włączony z użyciem przycisku");
                    }
                }
                else{
                    System.out.println("brak samochodu");
                }
                refresh();
            }
        });
        zmniejszBiegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(samochod!=null) {
                    if (samochod.isStanWlaczenia()) {
                        int b1 = samochod.getSkrzynia().getAktualnyBieg();
                        samochod.getSkrzynia().zmniejszBieg();
                        int b2 = samochod.getSkrzynia().getAktualnyBieg();
                        if (b1 != b2) {
                            System.out.println("bieg został zmniejszony z użyciem przycisku");
                        }
                    }
                }
                else{
                    System.out.println("brak samochodu");
                }
                refresh();
            }
        });
        zwiększBiegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(samochod!=null) {
                    if (samochod.isStanWlaczenia()) {
                        int b1 = samochod.getSkrzynia().getAktualnyBieg();
                        samochod.getSkrzynia().zwiekszBieg();
                        int b2 = samochod.getSkrzynia().getAktualnyBieg();
                        if (b1 != b2) {
                            System.out.println("bieg został zwiększony z użyciem przycisku");
                        }
                    }
                }
                else{
                    System.out.println("brak samochodu");
                }
                refresh();
            }
        });

        ujmijGazuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(samochod!=null) {
                    if (samochod.isStanWlaczenia()) {
                        samochod.getSilnik().zmniejszObroty();
                    }
                }
                else{
                    System.out.println("brak samochodu");
                }
                refresh();
            }
        });
        dodajGazuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(samochod!=null) {
                    if (samochod.isStanWlaczenia()) {
                        samochod.getSilnik().zwiekszObroty();
                    }
                }
                else{
                    System.out.println("brak samochodu");
                }
                refresh();
            }
        });
        zwolnijButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(samochod!=null) {
                    if (samochod.isStanWlaczenia()) {
                        samochod.getSkrzynia().sprzeglo.zwolnij();
                    }
                }
                else{
                    System.out.println("brak samochodu");
                }
                refresh();
            }
        });
        naciśnijButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(samochod!=null) {
                    if (samochod.isStanWlaczenia()) {
                        samochod.getSkrzynia().sprzeglo.wcisnij();
                    }
                }
                else{
                    System.out.println("brak samochodu");
                }
                refresh();
            }
        });
        Mapa.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(samochod!=null) {
                    super.mousePressed(e);
                    samochod.jedzDo(new Pozycja(e.getX(), e.getY()));
                }
                else{
                    System.out.println("brak samochodu");
                }
                //System.out.println("jedź do: " + e.getX() + "," + e.getY());
                refresh();
            }

        });
        //this.start();
        dodajNowyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame f = new NowySamochodGUI(wybierzSamochod);
                f.pack();
                f.setVisible(true);

            }
        });
        wybierzSamochod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (wybierzSamochod.getSelectedItem() != null) {
                    setSamochod((Samochod) wybierzSamochod.getSelectedItem());
                    samochod = (Samochod) wybierzSamochod.getSelectedItem();
                }
                else {

                    samochod = null;
                    modelSamochodu.setText("");
                    numerRejestracyjny.setText("");
                    wagaSamochodu.setText("");
                    //samochod.setAktualnaPredkosc(0);
                    predkoscSamochodu.setText("");

                    nazwaSkrzyni.setText("");
                    biegSkrzyni.setText("");
                    wagaSkrzyni.setText("");
                    cenaSkrzyni.setText("");

                    nazwaSilnika.setText("");
                    cenaSilnika.setText("");
                    wagaSilnika.setText("");
                    obrotySilnika.setText("");


                    nazwaSprzegla.setText("");
                    cenaSprzegla.setText("");
                    wagaSprzegla.setText("");
                    stanSprzegla.setText("");
                }
                refresh();
            }

        });
        usuńButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                refresh();
                /*if(samochod==null){
                    auto.setVisible(false);
                }

                modelSamochodu.setText("");
                numerRejestracyjny.setText("");
                wagaSamochodu.setText("");
                //samochod.setAktualnaPredkosc(0);
                predkoscSamochodu.setText("");

                nazwaSkrzyni.setText("");
                biegSkrzyni.setText("");
                wagaSkrzyni.setText("");
                cenaSkrzyni.setText("");

                nazwaSilnika.setText("");
                cenaSilnika.setText("");
                wagaSilnika.setText("");
                obrotySilnika.setText("");


                nazwaSprzegla.setText("");
                cenaSprzegla.setText("");
                wagaSprzegla.setText("");
                stanSprzegla.setText("");

                 */

                if(samochod!=null){
                    samochod.interrupt();
                }


                wybierzSamochod.removeItem(samochod);
                samochod = (Samochod) wybierzSamochod.getSelectedItem();
                //samochod = null;

            }

        });
        refresh();
        start();
    }

    public void run(){
        super.run();
        while(true) {
            if(samochod != null){
                refresh();
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                //interrupt();
                //return;
                e.printStackTrace();
            }
        }
        }


    public void refresh(){

        if(samochod==null){
            auto.setVisible(false);
            modelSamochodu.setText("");
            numerRejestracyjny.setText("");
            wagaSamochodu.setText("");
            //samochod.setAktualnaPredkosc(0);
            predkoscSamochodu.setText("");

            nazwaSkrzyni.setText("");
            biegSkrzyni.setText("");
            wagaSkrzyni.setText("");
            cenaSkrzyni.setText("");

            nazwaSilnika.setText("");
            cenaSilnika.setText("");
            wagaSilnika.setText("");
            obrotySilnika.setText("");


            nazwaSprzegla.setText("");
            cenaSprzegla.setText("");
            wagaSprzegla.setText("");
            stanSprzegla.setText("");
        }
        if(samochod != null) {
            auto.setVisible(true);
            auto.setLocation((int) samochod.getAktualnaPozycja().getX(), (int) samochod.getAktualnaPozycja().getY());
            modelSamochodu.setText(samochod.getModel());
            numerRejestracyjny.setText(samochod.getNrRejestracji());
            wagaSamochodu.setText(String.valueOf(samochod.getWaga()));
            samochod.setAktualnaPredkosc((int) (samochod.getSilnik().getObroty() / (samochod.getSkrzynia().getAktualnePrzelozenie())));
            predkoscSamochodu.setText(String.valueOf(samochod.getAktualnaPredkosc()));

            nazwaSkrzyni.setText(samochod.getSkrzynia().getNazwa());
            biegSkrzyni.setText(String.valueOf(samochod.getSkrzynia().getAktualnyBieg()));
            samochod.getSkrzynia().setAktualnePrzelozenie();
            wagaSkrzyni.setText(String.valueOf(samochod.getSkrzynia().getWaga()));
            cenaSkrzyni.setText(String.valueOf(samochod.getSkrzynia().getCena()));

            nazwaSilnika.setText(samochod.getSilnik().getNazwa());
            cenaSilnika.setText(String.valueOf(samochod.getSilnik().getCena()));
            wagaSilnika.setText(String.valueOf(samochod.getSilnik().getWaga()));
            obrotySilnika.setText(String.valueOf(samochod.getSilnik().getObroty()));


            nazwaSprzegla.setText(samochod.getSkrzynia().sprzeglo.getNazwa());
            cenaSprzegla.setText(String.valueOf(samochod.getSkrzynia().sprzeglo.getCena()));
            wagaSprzegla.setText(String.valueOf(samochod.getSkrzynia().sprzeglo.getWaga()));
            stanSprzegla.setText(samochod.getSkrzynia().sprzeglo.getStrStanSprzegla());

            //ImageIcon car = new ImageIcon("car.png");
            //auto.setIcon(car);

        }




    }

    public static void main(String[] args) {

        Samochod sam = new Samochod(220, "Ford Fiesta", "KGR 4S44", 1500, 200);
        sam.wlacz();
        sam.setAktualnaPredkosc(0);



        JFrame frame = new JFrame("SamochodGUI");
        frame.setContentPane(new SamochodGUI().Samochód);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //frame.setUndecorated(true);
        frame.pack();
        frame.setVisible(true);



    }


}
