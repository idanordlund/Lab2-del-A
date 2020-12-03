import java.awt.*;
import java.util.Comparator;
import java.util.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    private Map<GeneralVehicle, CarGraphics> map;
    private List <GeneralVehicle> cars;


    // Initializes the panel
    public DrawPanel(List cars, int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.map = initializeCarGraphicsMap(cars);
        this.cars = cars;

    }
    //moves the image of the vehicle
    void moveit(GeneralVehicle car, int x, int y) {
        map.get(car).moveCarGraphics(x, y);

    }
    //returns the dimension of the image of a specific vehicle
    public Dimension getImageDimension(GeneralVehicle car){
        return map.get(car).getImageDimension();
    }
    // initializes the map of GeneralVehicles and CarGraphics
    private Map<GeneralVehicle, CarGraphics> initializeCarGraphicsMap(List<GeneralVehicle> cars) {
        Map<GeneralVehicle, CarGraphics> res = new TreeMap<>(new Comparator<GeneralVehicle>() {
            @Override
            public int compare(GeneralVehicle o1, GeneralVehicle o2) {
                return o1.hashCode() - o2.hashCode();
            }
        });
        for (GeneralVehicle car : cars) {
            CarGraphics tempGraphics = new CarGraphics(car);
            res.put(car,tempGraphics);
        }
        return res;
    }



    // This method is called each time the panel updates/refreshes/repaints itself

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (GeneralVehicle car : cars){
            map.get(car).drawYourself(g);
        }

    }
    // class that holds the image of the car and its position
    private class CarGraphics{
        private BufferedImage carImage;
        private Point carPoint = new Point();

        public CarGraphics(GeneralVehicle car){
            try {
                carImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/"+car.getModelName()+".jpg"));
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
        // updates the position of the image
        public void moveCarGraphics(int x, int y){
            carPoint.x = x;
            carPoint.y = y;
        }
        // draws the image
        public void drawYourself(Graphics g){
            g.drawImage(carImage, carPoint.x, carPoint.y, null);
        }
        // return the dimensions of the image
        public Dimension getImageDimension(){
            return new Dimension(carImage.getWidth(), carImage.getHeight());
        }
    }

}
