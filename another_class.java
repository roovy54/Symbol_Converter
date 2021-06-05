
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.logging.StreamHandler;

public class another_class extends JFrame{
    private JTextField item1;
    private JTextField item2;
    private JTextField item3;
    private JTextField item4;

    private JRadioButton pb;
    private JRadioButton bb;
    private JRadioButton ib;
    private JRadioButton bib;
    private ButtonGroup grp;

    private Font pf;
    private Font bf;
    private Font itf;
    private Font bif;

    public HashMap<Character, Character> Symbols = new HashMap<Character, Character>();;
    public another_class(){
        super("Symbol_Converter");
        Symbols.put('T', 'θ');
        Symbols.put('A', 'α');
        Symbols.put('B', 'β');
        Symbols.put('G', 'γ');
        Symbols.put('W', 'ω');
        setLayout(new FlowLayout());
        item1 = new JTextField(20);
        item2 = new JTextField("Input text: ",7);
        item3 = new JTextField(20);
        item4 = new JTextField("Output text: ", 7);
        item2.setEditable(false);
        item4.setEditable(false);
        add(item2);
        add(item1);
        add(item4);
        add(item3);

        pb = new JRadioButton("plain", true);
        bb = new JRadioButton("bold", false);
        ib = new JRadioButton("italic", false);
        bib = new JRadioButton("bold & italic", false);
        add(pb);
        add(bb);
        add(ib);
        add(bib);
        grp = new ButtonGroup();
        grp.add(pb);
        grp.add(bb);
        grp.add(ib);
        grp.add(bib);

        pf = new Font("Serif", Font.PLAIN, 14);
        bf = new Font("Serif", Font.BOLD, 14);
        itf = new Font("Serif", Font.ITALIC, 14);
        bif = new Font("Serif", Font.BOLD + Font.ITALIC, 14);


        item1.addActionListener(new thehandler());
        pb.addItemListener(new thehandler(pf));
        bb.addItemListener(new thehandler(bf));
        ib.addItemListener(new thehandler(itf));
        bib.addItemListener(new thehandler(bif));


    }
    public class thehandler implements ActionListener, ItemListener{
        Font font;
        public thehandler(){

        }
        public thehandler(Font f){
            font = f;
        }
        public void actionPerformed(ActionEvent event){
            String new_string = "";
            String string = event.getActionCommand();
            int num = string.length();
            another_class ac_obj = new another_class();
            for(int x = 0; x < num; x++){
                if (ac_obj.Symbols.get(string.charAt(x)) == null)
                    new_string += string.charAt(x);
                else{
                    new_string += ac_obj.Symbols.get(string.charAt(x));
                }
            }
            item3.setText(new_string);
        }
        public void itemStateChanged(ItemEvent event){
            item3.setFont(font);
        }
    }
}
