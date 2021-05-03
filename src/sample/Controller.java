package sample;

import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    public ImageView eins;
    public ImageView zwei;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        BlikacLED LED1 = new BlikacLED(200, this.eins);
        LED1.start();

        BlikacLED LED2 = new BlikacLED(500, this.zwei);
        LED2.start();
    }
}

class BlikacLED extends Thread
{
    int perioda;
    ImageView img;

    @Override
    public void run()
    {
        try
        {
            img.setImage(new Image(new FileInputStream("off.png")));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        delay();

        try
        {
            img.setImage(new Image(new FileInputStream("on.png")));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        delay();

        run();
    }

    public BlikacLED(int perioda, ImageView img)
    {
        this.perioda = perioda;
        this.img = img;
    }

    public void delay()
    {
        try
        {
            sleep(perioda);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

}
