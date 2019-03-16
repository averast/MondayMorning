import java.io.IOException;
import java.util.ArrayList;

public class Entity {

    Renderer renderer;
    Vector2 pos;
    Sprite sprite;
    Rectangle hitBox;

    public Entity(String assetPath) 
    {
        sprite = new Sprite(assetPath);
    }

    //Delay initilization of things since file IO can fail
    //And this makes it easy to handle the exception gracefully
    public void init(Renderer r) throws IOException
    {
        try
        {
            renderer = r;
            sprite.load();
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public Entity(String path, Vector2 pos)
    {
        assetpath = path;
        this.pos = pos;
    }

    public void update(Vector2 v)
    {
        pos.x = pos.x + v.x;
        pos.y = pos.y + v.y;
    }

    public void setPos(Vector2 pos)
    {
        this.pos = pos;
    }

    public void draw()
    {
        renderer.draw(sprite);
    }

    public Vector2 getPos() { return pos; }
}