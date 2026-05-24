package com.example.pawcare.util;

import javafx.scene.image.Image;

import java.io.InputStream;

public final class ImageLoader {
    private static final String DEFAULT_ICON = "/pawIcon.jpeg";

    private ImageLoader() {
    }

    public static Image load(String resourcePath) {
        return load(resourcePath, DEFAULT_ICON);
    }

    public static Image load(String resourcePath, String fallbackResourcePath) {
        Image fallback = loadInternal(fallbackResourcePath);
        Image requested = loadInternal(resourcePath);
        return requested != null ? requested : fallback;
    }

    private static Image loadInternal(String resourcePath) {
        if (resourcePath == null || resourcePath.isBlank()) {
            return null;
        }
        InputStream stream = ImageLoader.class.getResourceAsStream(resourcePath.startsWith("/")
                ? resourcePath
                : "/" + resourcePath);
        if (stream == null) {
            return null;
        }
        return new Image(stream);
    }
}
