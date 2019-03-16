import java.io.IOException;

public class World
{
    Sprite background;
    Tiles tileset;
    Renderer renderer;

    public World(String backgroundPath, String tilesetPath)
    {
        background = new Sprite(backgroundPath);
        tileset = new Tiles(tilesetPath);
    }

    public void init(Renderer r) throws IOException
    {
        try
        {
            renderer = r;
            background.load();
            tileset.load();
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void draw()
    {
        renderer.draw(background);
        renderer.draw(tileset);
    }

}