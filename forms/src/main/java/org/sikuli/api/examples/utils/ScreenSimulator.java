package org.sikuli.api.examples.utils;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ScreenSimulator {

        private final Dimension DEFAULT_SIZE = new Dimension(640,480);
        private ImageFrame frame = new ImageFrame();



        public void run(){

        }

        public void start(){
                Thread t = new Thread(){
                        public void run(){
                                frame.setVisible(true);
                                ScreenSimulator.this.run();
                        }
                };
                t.setDaemon(true);
                t.start();              
                wait(1);
        }

        public void showImage(BufferedImage image){             
                frame.addImage(image);
                frame.pack();
                frame.setLocationRelativeTo(null);
        }


        public void showComponent(JComponent component){
                frame.getContentPane().removeAll();
                frame.getContentPane().add(component);
                // not sure why this is needed for component to be shown...
                frame.setVisible(true);
        }


        public void showImage(URL imageUrl) {
                JLabel imageLabel = new JLabel(new ImageIcon(imageUrl));
                frame.getContentPane().removeAll();
                frame.getContentPane().add(imageLabel);
                frame.pack();
                frame.setLocationRelativeTo(null);
        }

        //      public void addImage(URL url) {
        //              try {
        //                      frame.addImage(ImageIO.read(url));                      
        //              } catch (IOException e) {
        //              }
        //      }
        //      
        //      
        //      public void addImageButton(URL url, String name){
        //              try {
        //                      frame.addImageButton(ImageIO.read(url), name);
        //              } catch (IOException e) {
        //              }
        //      }
        //      
        //      public void addTextField() {
        //              frame.addTextField();
        //      }

        public void wait(int seconds){
                try {
                        Thread.sleep(seconds*1000);
                } catch (InterruptedException e) {
                }               
        }

        Object pauseObserver = new Object();
        public void pause(){
                synchronized(pauseObserver){
                        try {
                                pauseObserver.wait();
                        } catch (InterruptedException e) {
                        }
                }
        }

        public void resume(){
                synchronized(pauseObserver){
                        pauseObserver.notify();
                }
        }

        Object clickObserver = new Object();
        public void waitForClick(){
                synchronized(clickObserver){
                        try {
                                clickObserver.wait();
                        } catch (InterruptedException e) {
                        }
                }
        }

        public void close(){
                frame.setVisible(false);
                frame.dispose();
                System.exit(0);
        }

        private class ImageFrame extends JFrame {

                //              void clear(){
                //                      getContentPane().removeAll();
                //              }
                //              
                //              void addTextField(){
                //                      JTextField f = new JTextField(20);
                //                      getContentPane().add(f);
                //                      //repaint();
                //              }

                void addImage(BufferedImage image){                     
                        JLabel l = new JLabel(new ImageIcon(image));
                        getContentPane().add(l);
                        //                      repaint();
                }
                //              
                //              void addImageButton(BufferedImage image, String name){
                //                      JButton b = new ImageButton(image, name);
                //                      getContentPane().setLayout(new FlowLayout());
                //                      getContentPane().add(b);
                //                      pack();
                //              }

                ImageFrame() {
                        getContentPane().setLayout(new FlowLayout());                   

                        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        setSize(DEFAULT_SIZE);
                        setResizable(false);
                        setLocationRelativeTo(null);
                }

        }

        public void setSize(int width, int height){
                frame.setSize(width, height);
                frame.setLocationRelativeTo(null);
        }

        public void setLocation(int x, int y){
                frame.setLocation(x,y);
        }

        public Rectangle getBounds() {
                return frame.getBounds();               
        }

}