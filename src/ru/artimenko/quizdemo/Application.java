package ru.artimenko.quizdemo;

public class Application {
    public static void main(String[] args) {
        TeacherFrame test = new TeacherFrame("test window");
        test.setVisible(true);
        test.setSize(500, 600);
        
        BaseDialog studentDialog = new BaseDialog(test) {};
        
        studentDialog.setVisible(true);
        studentDialog.setSize(100, 200);
        studentDialog.setLocation(800, 800);

    }
}
