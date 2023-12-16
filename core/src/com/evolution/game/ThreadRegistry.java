package com.evolution.game;

import com.badlogic.gdx.math.Vector2;
import com.evolution.game.sensors.*;

import java.util.ArrayList;
import java.util.HashMap;

public class ThreadRegistry {

    private ThreadRegistry instance;

    private HashMap<Integer, AngularSensor> sensorRegistry = new HashMap<>();

    private int maxThread = 0;
    private int minThread = 0;

    private int maxThreadSum = 0;
    private int minThreadSum = 0;
//    private Guy default_guy = new Guy(Vector2.Zero,0);



    public ThreadRegistry() {
        sensorRegistry.put(0, new GuySensor(null));
        sensorRegistry.put(1, new ObstacleSensor(null));
        sensorRegistry.put(2, new CloseGuySensor(null));
        sensorRegistry.put(3, new DirectionSensor(null));
        sensorRegistry.put(4, new StuckSensor(null));
        sensorRegistry.put(5,new AlwaysSensor(null));
        sensorRegistry.put(6,new WallSensor(null));
        ColourMaster.setDivisions(sensorRegistrySize());
    }

    public ThreadRegistry getInstance() {
        if (instance == null) {
            this.instance = new ThreadRegistry();
        }
        return instance;
    }

    public int sensorRegistrySize() {
        return sensorRegistry.size();
    }

    public AngularSensor getSensor(int sensorNum, Guy guy) {
        return sensorRegistry.get(sensorNum).clone(guy);
    }

    public void registerThread(Thread thread) {
        int threadNumInt = Integer.parseInt(thread.getThreadNum());
        if (minThread == 0 ) {
            minThread = threadNumInt;
        }
        if (maxThread < threadNumInt) {
            maxThread = threadNumInt;
        }
        if (minThread > threadNumInt) {
            minThread = threadNumInt;
        }
    }

    public int getMaxThread() {
        return this.maxThread;
    }

    public int getMinThread() {
        return this.minThread;
    }

    public void registerThreadSum(int sum) {
        if (minThreadSum == 0 ) {
            minThreadSum = sum;
        }
        if (maxThreadSum < sum) {
            maxThreadSum = sum;
        }
        if (minThreadSum > sum) {
            minThreadSum = sum;
        }
    }

    public int getMaxThreadSum() {
        return maxThreadSum;
    }

    public int getMinThreadSum() {
        return minThreadSum;
    }
}
