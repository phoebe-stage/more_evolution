package com.evolution.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Food extends Entity {
    public int nutrition = 1;
    public Food(Vector2 position, int radius) {
        super(position, radius);
        this.color = Color.LIME;
    }

    @Override
    public boolean cantCollide() {
        return false;
    }

    public int getNutrition() {
        return nutrition;
    }


}
