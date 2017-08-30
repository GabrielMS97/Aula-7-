package br.ufjf.dcc171;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class JanelaLista extends JFrame {

    private final JLabel lblNumero = new JLabel("Número");
    private final JTextField txtNumero = new JTextField("0", 5);
    private final JButton btnExcluir = new JButton("Excluir");
    private final DefaultListModel modelo = new DefaultListModel();
    private final JList lstLista = new JList(modelo);

    public JanelaLista() throws HeadlessException {
        super("Lista");
        setLayout(new BorderLayout());
        JPanel pnlEntrada = new JPanel();
        pnlEntrada.setLayout(new BorderLayout(5, 5));
        pnlEntrada.add(lblNumero, BorderLayout.WEST);
        pnlEntrada.add(txtNumero, BorderLayout.CENTER);
        add(pnlEntrada, BorderLayout.NORTH);
        add(new JScrollPane(lstLista), BorderLayout.CENTER);
        add(btnExcluir, BorderLayout.SOUTH);

        /*for (int i = 0; i <= 3; i++) {
            modelo.addElement(i * 10);
        }*/
        txtNumero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo.addElement((Integer.parseInt(txtNumero.getText())));
                txtNumero.setText("");
            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List selecionados = lstLista.getSelectedValuesList();
                for (Object selecionado : selecionados) {
                    modelo.removeElement(selecionado);
                }
            }
        });
    }

}
