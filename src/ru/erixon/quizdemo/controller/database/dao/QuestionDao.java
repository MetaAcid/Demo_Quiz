package ru.erixon.quizdemo.controller.database.dao;

import ru.erixon.quizdemo.Application;
import ru.erixon.quizdemo.model.exceptions.ApplicationException;
import ru.erixon.quizdemo.model.question.Question;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDao extends GenericDao<Question> {

    {
        columns.add("image");
        columns.add("answer");
        columns.add("difficulty");
    }
    public QuestionDao(Connection connection) {
        super(connection);
    }

    public List<Question> getQuestionsByParams(int qty, Question.Difficulty difficulty) throws ApplicationException {
        try {
            String sql = String.format("select * from %s where difficulty = ? order by random()", getTableFullName());
            ResultSet rs = super.executeSelect(sql, difficulty.name());
            List<Question> list = new ArrayList<>();
            while(qty > 0 && rs.next()){
                list.add(this.newEntity(rs));
                qty--;
            }
            rs.close();
            return list;
        } catch (SQLException e) {
            throw new ApplicationException(e);
        }
    }

    @Override
    protected Question newEntity(ResultSet rs) throws ApplicationException {
        try {

            InputStream stream = rs.getBinaryStream("image");
            BufferedImage image = ImageIO.read(stream);
            Question.Difficulty difficulty = Question.Difficulty.valueOf(rs.getString("difficulty"));
            return new Question(rs.getLong("id"), image,rs.getString("answer"), difficulty);
        } catch (IOException | SQLException e) {
            throw new ApplicationException("image reading error", e);
        }
    }

    @Override
    protected Object[] getParams(Question question) {
        return new Object[]{question.getImage(), question.getAnswer(), question.getDifficulty().name()};
    }

    @Override
    protected String getTableName() {
        return "questions";
    }
}
