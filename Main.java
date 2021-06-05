import javax.swing.JFrame;
class Main{
    public static void main(String []args){
        another_class ac_obj = new another_class();
        ac_obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ac_obj.setSize(350, 150);
        ac_obj.setVisible(true);
    }
}
