import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NowySamochodGUI extends JFrame {

    private JPanel nowySamochodPanel;
    private JTextField nrRejestracyjnyField;
    private JTextField modelField;
    private JTextField markaField;
    private JRadioButton a5BiegówManualnaRadioButton;
    private JRadioButton a6BiegówManualnaRadioButton;
    private JRadioButton benzynaRadioButton;
    private JRadioButton dieselRadioButton;
    private JTextField predkoscField;
    private JButton dodajButton;
    private JButton anulujButton;
    private JLabel nrRejestracyjnyLabel;
    private JLabel modelLabel;
    private JLabel markaLabel;
    private JLabel skrzyniaLabel;
    private JLabel silnikLabel;
    private JLabel predkoscLabel;

    NowySamochodGUI(JComboBox combo){
        setContentPane(nowySamochodPanel);
        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Samochod s = new Samochod(predkoscField.getText(), modelField.getText(), nrRejestracyjnyField.getText(), 1000, 25);

                s.setModel(modelField.getText());
                s.setPredkoscMax(Integer.parseInt(predkoscField.getText()));
                s.setNrRejestracji(nrRejestracyjnyField.getText());
                if (a5BiegówManualnaRadioButton.isSelected()){
                    s.setSkrzynia(new SkrzyniaBiegow("5 biegów manualna", 50, 1500, 1, 5));
                }
                else if (a6BiegówManualnaRadioButton.isSelected()){
                    s.setSkrzynia(new SkrzyniaBiegow("6 biegów manualna", 80, 2000, 1, 6) );
                }

                if (benzynaRadioButton.isSelected()){
                    s.setSilnik(new Silnik("benzyna", 300, 1500, 10000, 0));
                }
                else if(dieselRadioButton.isSelected()){
                    s.setSilnik(new Silnik("diesel", 200, 1800, 10000, 0));
                }

                combo.addItem(s);


            }
        });
        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
