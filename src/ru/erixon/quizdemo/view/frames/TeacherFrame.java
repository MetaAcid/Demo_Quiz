package ru.erixon.quizdemo.view.frames;

import ru.artimenko.quizdemo.BaseFrame;
import ru.erixon.quizdemo.view.panels.TeacherMainPanel;
import ru.erixon.quizdemo.view.panels.StudentSingleStatPanel;
import ru.erixon.quizdemo.view.panels.ClassStatPanel;
import java.awt.*;

public class TeacherFrame extends BaseFrame {
    private TeacherMainPanel teacherMainPanel = new TeacherMainPanel();

    public TeacherFrame(String title) throws HeadlessException {
        super(title);
        this.add(teacherMainPanel);
        this.setSize(700,700);
        this.setVisible(true);
    }

}
