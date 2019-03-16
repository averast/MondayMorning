import java.awt.Shape;
import java.io.IOException;

public class Utils {

//need a static logging mechanism
public static void Log(String info)
{
    System.out.println(info);
}

}


//None of the members in this need to be private, since this is literaly just a collection of numbers
//fite me in smash if you disagree
class Vector2
{
    public int x, y;

    public Vector2(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

//Dummy classes just used to structure the engine 
class Sprite implements Drawable
{
    private String path;
    public Image(String path)
    {
        this.path = path;
    }

    public void load() throws IOException
    {
        try {
            Utils.Log("Implement me");
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

abstract class Drawable
{

}

class Rectangle 
{

}

class Tiles implements Drawable
{
    
}

class Renderer {
    public Renderer() {}

    public void draw(Drawable d) {}
}

class Input
{
    public Input() {}
    
    public static Vector2 getInput() 
    {
        return new Vector2(0,0);
    }
}