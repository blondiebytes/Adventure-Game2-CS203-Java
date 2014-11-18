
package adventure;

import java.util.Random;


public class LaserRM implements Comparable<LaserRM>, Collideable<LaserRM>, Tickable<LaserRM> {
    // ----------------------------------------------------------------
    // LASER TESTING:
    // REGUALR MODE: After pressing ENTER, do the future lasers switch color?
    // After pressing the SPACEBAR, does the plane shoot an laser?
    // Is the laser removed once off screen?
    
    // PROBLEM: How to store these? In a bag? So more than one laser can 
    // be on screen? Also, how to track once off-screen? --> check if height too high
    
    
    String color;
    int width;
    int height;
    int deltaHeight = 1;
    int identity;
    static int count = 0;
    
    // ========== CONSTRUCTORS ==========
    
    
    // Two ways lasers 
    LaserRM(PlaneRM plane) {
        this.width = plane.width;
        this.height = plane.height;
        Random rnd = new Random();
        if (rnd.nextInt() % 2 == 1) {
            this.color = "red";
        } else {
            this.color = "blue";
        }
        this.identity = count;
        count++;
    }
    
    LaserRM(int width, int height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }
    
    LaserRM(int width, int height, String color, int identity) {
        this.width = width;
        this.height = height;
        this.color = color;
    }
    
     public int getWidth() {
         return this.width;
     }
     
     public int getHeight() {
         return this.height;
     }
     
    
    // ========== REACT ==========
    public void react(String se) {
        if (se.equals("spacebar")) {
            //shoot laser
        }
        if (se.equals("enter")) {
            if (color.equals("red")) {
                color = "blue";
            } else {
                color = "red";
            }
        }
    }
    
    
    // ========== TICK ==========
    public LaserRM onTick() {
        return new LaserRM(this.width, this.height + deltaHeight, this.color, this.identity);
    }
    
    
    
    
    // ========== EQUALITY ==========
     public boolean isEqualToId(LaserRM otherLaser) {
        return this.identity == otherLaser.identity;
    }
    
     
    
     // ========== COMPARETO ==========
    public int compareTo(LaserRM otherLaser) {
        if (this.isEqualToId(otherLaser)) {
            return 0;
        } else if (this.identity < otherLaser.identity) {
            return 1;
        } else {
            return -1;
        }
    }

    // ========== COLLISION ==========
    public LaserRM collidesWith(Collideable thing) {
      if (this.height == thing.getHeight()) {
            return this;
        } else {
            // I HATE NULL;
            return null;
        }    
    }
    
    
}