/*
 * Copyright (c) 2022, DevTaube
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *     Redistributions of source code must retain the above copyright notice,
 *     this list of conditions and the following disclaimer.
 *
 *     Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package devtaube.wein2d;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.net.URL;

public final class Sprite
{

    private Image image;

    public Sprite(String filePath, FileOrigin fileOrigin)
    {
        switch(fileOrigin)
        {
            case WORKING_DIRECTORY:
                try
                {
                    image = ImageIO.read(new File(filePath));
                }
                catch(Exception e) { e.printStackTrace(); }
                break;

            case CLASSPATH:
                try
                {
                    image = ImageIO.read(ClassLoader.getSystemClassLoader().getResourceAsStream(filePath));
                }
                catch(Exception e) { e.printStackTrace(); }
                break;

            case WEB_URL:
                try
                {
                    image = ImageIO.read(new URL(filePath));
                }
                catch(Exception e) { e.printStackTrace(); }
                break;
        }
    }

    public int getWidth() { return image.getWidth(null); }

    public int getHeight() { return image.getWidth(null); }

    public Image getImage()
    {
        return image;
    }

}
