import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class view {
    private JButton Loggaut;
    private JTextArea Data;
    private JPanel panel;

    public view(){}

    public JPanel getPanel(){
        return panel;
    }

    public void setData(String c){
        Data.setText(c);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("View");
        frame.setContentPane(new view().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void setCryptListener(ActionListener cryptListener) {
        Loggaut.addActionListener(cryptListener);
    }
}
