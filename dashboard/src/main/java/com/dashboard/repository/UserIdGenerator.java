package com.dashboard.repository;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class UserIdGenerator implements IdentifierGenerator {

	@Override
    public Serializable generate(SessionImplementor session, Object object)
            throws HibernateException {

        Connection connection = session.connection();

        try {
            Statement statement=connection.createStatement();

            ResultSet rs=statement.executeQuery("SELECT CONCAT('U',LPAD(IFNULL(MAX(RIGHT(USER_ID,9)),  0)+1,9,'0')) AS id FROM USER");

            if(rs.next())
            {
            	String generatedId = rs.getString(1);
                return generatedId;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return null;
    }

}
