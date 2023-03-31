import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class controller extends JFrame {
    model model;
    view view;

    public controller(model m, view v) {
        this.model = m;
        this.view = v;
        this.setContentPane(view.getPanel());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        view.setCryptListener(new cryptListener());
    }

    private class cryptListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            view.setData(model.getData());
        }
    }

    public static void main(String[] args) throws IOException {
        model m = new model();
        view v = new view();
        controller thisIsTheProgram = new controller(m,v);
        thisIsTheProgram.setVisible(true);

    }
}
