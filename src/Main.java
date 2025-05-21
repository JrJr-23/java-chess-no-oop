import javax.swing.JFrame;

public class Main
{
    public  static void main(String[] args)
    {
        JFrame frame = new JFrame();

        frame.setBounds(0, 0, 865, 890);
        frame.setTitle("Chess");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Chess game = new Chess();
        frame.add(game);
        frame.setVisible(true);
    }
}
