/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.dep.util;

import javafx.scene.control.Alert;

/**
   Author: Darwin Díaz González.
 */

public interface AlertService {
    
    void showAlert(Alert.AlertType alertType, String title, String header, String message);
    
}
