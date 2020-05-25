package Cube;

import Cube.Window.Renderer;

public abstract class AbstractGame {
    public abstract void update(Game game, float deltaTime);
    public abstract void render(Game game, Renderer renderer);

}
