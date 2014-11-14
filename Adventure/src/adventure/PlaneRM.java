
package adventure;
        
import javafx.geometry.Pos;
import javalib.colors.Black;
import javalib.colors.IColor;
import javalib.colors.Yellow;
import javalib.worldimages.CircleImage;
import javalib.worldimages.Posn;
import javalib.worldimages.WorldImage;

        
public class PlaneRM {
    
    int width;
    int deltaWidth;
    int height = 0;
    static int MAXW = 500;
    static int REGULAR_MULTIPLE = 10;
    IColor color = new Black();
    
    static int middleOfScreenWidth = MAXW/2;
    int topOfScreen;

    // =============================
    
    PlaneRM() {
        this(MAXW/2, -1);
    }

    
    private PlaneRM (int width, int deltaWidth) {
            this.width = width;
            this.deltaWidth = deltaWidth;
    }
    
    public boolean isEqualTo(PlaneRM otherPlane) {
        return (this.deltaWidth == otherPlane.deltaWidth) 
                && (this.height == otherPlane.height) 
                && (this.width == otherPlane.width);
    }
    
   public PlaneHM goHyper() {
        return new PlaneHM(this.width, this.deltaWidth);
    }
   
  // REGULAR: MOVE RIGHT AND LEFT
   public PlaneRM onTick(int multiple){
       int newWidth = width + deltaWidth * multiple;
        if (newWidth < 0) {
            return new PlaneRM(0, deltaWidth);
        } else if (newWidth >= MAXW) {
            return new PlaneRM(MAXW, -deltaWidth);
        } else {
            return new PlaneRM(newWidth, deltaWidth);
        }
   }
   

   public PlaneRM react(String s) {
        switch (s) {
            case "right":
                //       System.out.println("GOING RIGHT: ");
                return new PlaneRM(width, Math.abs(deltaWidth)).onTick(REGULAR_MULTIPLE);
            case "left":
                //        System.out.println("GOING LEFT: ");
                return new PlaneRM(width, -Math.abs(deltaWidth)).onTick(REGULAR_MULTIPLE);
        }
    // System.out.println("STAYING THE SAME");
     return this;
   }
 
   // NEED TO LOOK AT GAMEWORLDS DOCUMENTATION
    public WorldImage planeImage() {
        return new CircleImage(new Posn(this.width, this.height), 10, color);
//            return new FromFileImage(this.center, "Images/shark.png").
//          overlayImages(new CircleImage(this.center, this.radius, this.col));
    }
    
    
    
    
          
}