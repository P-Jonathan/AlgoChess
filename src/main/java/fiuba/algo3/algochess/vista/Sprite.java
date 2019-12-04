package fiuba.algo3.algochess.vista;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Sprite {
    private int x;
    private int y;
    private int width;
    private int height;
    private int imageWidth;
    private int imageHeight;
    private BufferedImage image;
    private BufferedImage actualFrame;
    private List<BufferedImage> actualFrameList;
    private List<List<BufferedImage>> frameList;

    public static final int DEFAULT_WIDTH = 32;
    public static final int DEFAULT_HEIGHT = 32;

    public Sprite(String filePath, int x, int y, int with, int height) {
        this.x = x;
        this.y = y;
        this.width = with;
        this.height = height;
        setImage(filePath);
        setFrameList();
    }

    public Sprite(String filePath) {
        this.x = 0;
        this.y = 0;
        this.width = DEFAULT_WIDTH;
        this.height = DEFAULT_HEIGHT;
        setImage(filePath);
        setFrameList();
    }

    private void setImage(String filePath) {
        try {
            System.out.println("Loading file: " + filePath + "...");
            image = ImageIO.read(new File(filePath));
            imageWidth = image.getWidth() / width;
            imageHeight = image.getHeight() / height;
            System.out.println("File loaded successfully: " + filePath + " - OK");
        } catch (Exception exception) {
            System.out.println("Error loading file: " + filePath + " - X");
            image = null;
        }
    }

    private void setFrameList() {
        frameList = new LinkedList<>();

        for (int x = 0; x < imageWidth; x++) {
            List<BufferedImage> frameSet = new LinkedList<>();
            for (int y = 0; y < imageHeight; y++){
                frameSet.add(getSubImage(x, y));
            }
            frameList.add(frameSet);
        }
        actualFrameList = frameList.get(0);
        actualFrame = actualFrameList.get(0);
    }

    private BufferedImage getSubImage(int x, int y) {
        return image.getSubimage(x * width, y * height, width, height);
    }

    public BufferedImage getFrame(int x, int y) {
        return frameList.get(y).get(x);
    }

    public List<BufferedImage> getFrames(int index) {
        return frameList.get(index);
    }

    public List<BufferedImage> getActualFrameList() {
        return actualFrameList;
    }

    public BufferedImage getActualFrame() {
        return actualFrame;
    }

    public void setActualFrame(int x, int y) {
        BufferedImage frame = getFrame(x, y);
        while (!frame.equals(actualFrame)) {
            nextFrame();
        }
    }

    public void nextFrameList() {
        int index = frameList.indexOf(actualFrameList);

        if (index == frameList.size()) {
            actualFrameList = frameList.get(0);
        } else {
            actualFrameList = frameList.get(++index);
        }
        actualFrame = actualFrameList.get(0);
    }

    public void nextFrame() {
        int index = actualFrameList.indexOf(actualFrame);

        if (index == actualFrameList.size())
            nextFrameList();
        else
            actualFrame = actualFrameList.get(++index);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
