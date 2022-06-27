/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scopadasso;

import scopadasso.controller.Controller;
import scopadasso.model.GameManager;
import scopadasso.view.View;

/**
 *
 * @author Andrea
 */
public class ScopaDAsso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        gameManager.preparation();
        View view = new View();
        Controller controller = new Controller(gameManager, view);
    }
    
}
