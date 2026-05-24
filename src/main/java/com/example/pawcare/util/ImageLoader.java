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
        String resolvedPath = resourcePath.startsWith("/") ? resourcePath : "/" + resourcePath;
        try (InputStream stream = ImageLoader.class.getResourceAsStream(resolvedPath)) {
            if (stream == null) {
                return null;
            }
            return new Image(stream);
        } catch (Exception ex) {
            return null;
        }
    }
}
