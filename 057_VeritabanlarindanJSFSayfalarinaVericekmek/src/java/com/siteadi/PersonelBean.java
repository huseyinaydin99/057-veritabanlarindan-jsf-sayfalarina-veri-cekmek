/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siteadi;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author husey
 */
@ManagedBean
@RequestScoped
public class PersonelBean implements Serializable{

    /**
     * Creates a new instance of PersonelBean
     */
    private Connection connection;
    private String data;
    List<Personel> depo = null;
    public PersonelBean() {
        try {
            getConnection();
            getData();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PersonelBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(PersonelBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PersonelBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(PersonelBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConnection() throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/firmaveritabani", "root", "toor");
        if (connection.isClosed()) {
            return null;
        } else {
            return connection;
        }
    }

    public List<Personel> getData() throws SQLException {
        depo = new ArrayList<>();
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("select * from personel");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            //System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4));
            data = resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4) + " <br>";
            depo.add(new Personel(resultSet.getInt(1),resultSet.getInt(5),resultSet.getString(2),resultSet.getString(3)));
        }
        resultSet.close();
        preparedStatement.close();
        return depo;
    }

    public List<Personel> getDepo() {
        return depo;
    }

    public void setDepo(List<Personel> depo) {
        this.depo = depo;
    }
    
    
}
