package ru.erixon.quizdemo.view.panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RegisterPanel extends BorderLayoutPanel implements ActionListener, ItemListener {
    private CheckboxGroup cbg = new CheckboxGroup();
    private Checkbox cbTeacher = new Checkbox("Teacher", cbg, false);
    private Checkbox cbStudent = new Checkbox("Student", cbg, true);
    private StudentRegisterFormPanel pnlStudentRegister = new StudentRegisterFormPanel();
    private TeacherRegisterFromPanel pnlTeacherRegister = new TeacherRegisterFromPanel();

    public RegisterPanel() {
        initCheckBoxes();
        ChangeRegisterPanels();
    }

    private void initCheckBoxes(){
        cbStudent.addItemListener(this);
        cbTeacher.addItemListener(this);
        Panel panel = new Panel(new GridLayout(1, 2));
        panel.add(cbTeacher);
        panel.add(cbStudent);
        this.add(panel, BorderLayout.NORTH);
    }

    private void ChangeRegisterPanels(){
       if (cbg.getSelectedCheckbox().equals(cbTeacher)) {
           this.remove(pnlStudentRegister);
           this.add(pnlTeacherRegister, BorderLayout.CENTER);
       }  else if (cbg.getSelectedCheckbox().equals(cbStudent)) {
           this.remove(pnlTeacherRegister);
           this.add(pnlStudentRegister, BorderLayout.CENTER);
       }
       this.validate();
//       this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getItemSelectable() == cbStudent){
            this.ChangeRegisterPanels();
        }
        else if (e.getItemSelectable() == cbTeacher) {
            this.ChangeRegisterPanels();
        }

        this.repaint();
    }
}
