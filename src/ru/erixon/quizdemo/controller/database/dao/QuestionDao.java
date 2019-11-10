package ru.erixon.quizdemo.controller.database.dao;

import ru.erixon.quizdemo.model.exceptions.ApplicationException;
import ru.erixon.quizdemo.model.question.Question;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import javax.imageio.stream.MemoryCacheImageInputStream;
import javax.imageio.stream.MemoryCacheImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionDao extends GenericDao<Question> {

    {
        columns.add("image");
        columns.add("answer");
    }
    public QuestionDao(Connection connection) {
        super(connection);
    }

    @Override
    public void createTable() {

    }

    @Override
    protected Question newEntity(ResultSet rs) throws SQLException, ApplicationException {
        try {
            InputStream stream = rs.getBinaryStream("image");
            BufferedImage image = ImageIO.read(stream);
            return new Question(image,rs.getString("answer"));
        } catch (IOException e) {
            throw new ApplicationException("image reading error", e);
        }
    }

    @Override
    protected Object[] getParams(Question question) {
        return new Object[]{question.getImage(), question.getAnswer()};
    }

    @Override
    protected String getTableName() {
        return "questions";
    }
}
