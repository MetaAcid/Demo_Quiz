package ru.erixon.quizdemo.panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RegisterPanel extends BorderLayoutPanel implements ActionListener, ItemListener {
    private CheckboxGroup cbg = new CheckboxGroup();
    private Checkbox cbTeacher = new Checkbox("Teacher", cbg, false);
    private Checkbox cbStudent = new Checkbox("Student", cbg, true);

    public RegisterPanel() {
        this.setBackground(new Color(255, 165, 56));
        initCheckBoxes();
    }

    private void initCheckBoxes(){
        cbStudent.addItemListener(this);
        cbTeacher.addItemListener(this);
        Panel panel = new Panel(new GridLayout(1, 2));
        panel.add(cbTeacher);
        panel.add(cbStudent);
        this.add(panel, BorderLayout.NORTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getItemSelectable() == cbStudent){
            this.setBackground(Color.BLACK);
        }
        else if (e.getItemSelectable() == cbTeacher) {
            this.setBackground(Color.DARK_GRAY);
        }

        this.repaint();
    }
}
