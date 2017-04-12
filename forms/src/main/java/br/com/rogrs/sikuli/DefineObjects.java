package br.com.rogrs.sikuli;

import static org.sikuli.api.API.browse;

import java.net.MalformedURLException;
import java.net.URL;

import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopMouse;
import org.sikuli.api.visual.Canvas;
import org.sikuli.api.visual.DesktopCanvas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DefineObjects {

    private static final Logger log = LoggerFactory.getLogger(DefineObjects.class);

   

    public void open() {

        try {
            browse(new URL("http://code.google.com"));

            ScreenRegion s = new DesktopScreenRegion();

            URL imageURL = new URL("http://code.google.com/images/code_logo.gif");
            Target imageTarget = new ImageTarget(imageURL);

            ScreenRegion r = s.wait(imageTarget, 5000);

            Canvas canvas = new DesktopCanvas();
            canvas.add().label("Hello World");
            canvas.display(3);

            Mouse mouse = new DesktopMouse();
            mouse.click(r.getCenter());

        } catch (MalformedURLException e) {
            log.error("Erro ao abrir browser " + e.getMessage(), e);
        }
    }

}
