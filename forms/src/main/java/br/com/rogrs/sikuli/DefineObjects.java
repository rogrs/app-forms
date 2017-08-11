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

			// Open the main page of Google Code in the default web browser
			browse(new URL("http://code.google.com"));

			// Create a screen region object that corresponds to the default
			// monitor in full screen
			ScreenRegion s = new DesktopScreenRegion();

			// Specify an image as the target to find on the screen
			URL imageURL = new URL("http://code.google.com/images/code_logo.gif");
			Target imageTarget = new ImageTarget(imageURL);

			// Wait for the target to become visible on the screen for at most 5
			// seconds
			// Once the target is visible, it returns a screen region object
			// corresponding
			// to the region occupied by this target
			ScreenRegion r = s.wait(imageTarget, 5000);

			// Display "Hello World" next to the found target for 3 seconds
			Canvas canvas = new DesktopCanvas();
			canvas.add().label("Hello World");
			canvas.display(3);

			// Click the center of the found target
			Mouse mouse = new DesktopMouse();
			mouse.click(r.getCenter());

		} catch (MalformedURLException e) {
			log.error("Erro ao abrir browser " + e.getMessage(), e);
		}
	}

}
