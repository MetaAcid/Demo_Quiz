package ru.erixon.quizdemo;

import ru.artimenko.quizdemo.BaseFrame;
import ru.erixon.quizdemo.controller.Config;
import ru.erixon.quizdemo.controller.database.PostgresConnectionManager;
import ru.erixon.quizdemo.controller.database.dao.QuestionDao;
import ru.erixon.quizdemo.model.question.Question;
import ru.erixon.quizdemo.view.frames.MainFrame;
import ru.erixon.quizdemo.view.panels.TimerPanel;
import sun.awt.image.FileImageSource;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageProducer;
import java.awt.image.PixelGrabber;
import java.io.*;
import java.nio.ByteBuffer;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public final static PostgresConnectionManager manager = new PostgresConnectionManager("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");;
    public final static Config config = new Config();

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame("Main Menu");
//        File image = new File("C:\\Users\\erixon\\Desktop\\19_74.jpg");
////        ImageConsumer ic = new PixelGrabber()
//        ByteArrayOutputStream outputStream = null;
//        try {
//            BufferedImage read = ImageIO.read(image);
//
//
//            QuestionDao questionDao = new QuestionDao(manager.getConnection());
//            Question byId = questionDao.getById(15);
//            System.out.println("");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}
