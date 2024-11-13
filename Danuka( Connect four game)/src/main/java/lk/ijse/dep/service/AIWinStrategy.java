/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.dep.service;

/**
   Author: Darwin Díaz González.
 */

public class AIWinStrategy implements WinnerNotificationStrategy {
    
    @Override
    public String getWinnerMessage(String playerName) {
        return "Game is over, AI has won the game !";
    }
    
}
