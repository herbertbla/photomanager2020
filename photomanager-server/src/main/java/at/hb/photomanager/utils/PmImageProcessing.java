package at.hb.photomanager.utils;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

/**
 * Utility class for different image processing functions
 *
 * @author herbert
 */
public final class PmImageProcessing {

    /**
     * ==== rotateClockwise
     *
     * @param image           image that should be rotated
     * @param rotationDegrees how many degrees the image should be rotated
     * @return rotated image
     */
    public static BufferedImage rotateClockwise(BufferedImage image, int rotationDegrees) {
        if (rotationDegrees == 0 || rotationDegrees % 360 == 0) {
            return image;
        }

        double rotationRequired = Math.toRadians(rotationDegrees);
        double pivotX = (double) image.getWidth() / 2;
        double pivotY = (double) image.getHeight() / 2;
        BufferedImage rotatedImg;
        if (rotationDegrees % 180 != 0) { //bei 90 oder 270 Grad
            AffineTransform tx = AffineTransform.getTranslateInstance((image.getHeight() - image.getWidth()) / (double) 2, (image.getWidth() - image.getHeight()) / (double) 2);
            tx.rotate(rotationRequired, pivotX, pivotY);
            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
            rotatedImg = op.filter(image, null);
        } else { //bei 180 Grad
            AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, pivotX, pivotY);
            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
            rotatedImg = op.filter(image, null);
        }
        return rotatedImg;
    }

    /**
     * ==== isLandscape
     * Checks if the image is in landscape format
     *
     * @param image image
     * @return true if the picture is in landscape format
     */
    public static boolean isLandscape(BufferedImage image) {
        return image.getWidth() > image.getHeight();
    }

    /**
     * ==== scale
     * Ändert die Größe des übergebenen Images um den scaleFactor
     *
     * @param image       image
     * @param scaleFactor scale factor
     * @return Bild nach der Transformation
     */
    public static BufferedImage scale(BufferedImage image, double scaleFactor) {
        AffineTransform tx = AffineTransform.getScaleInstance(scaleFactor, scaleFactor);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        return op.filter(image, null);
    }

    /**
     * ==== scaleToWidth
     * Skaliert das Bild auf eine bestimmte Höhe in Pixel
     *
     * @param image     image
     * @param width     target width
     * @return Bild nach der Transformation
     */
    public static BufferedImage scaleToWidth(BufferedImage image, int width) {
        double scaleFactor = calculateScaleFactor((double)image.getWidth(), (double)width);
        return scale(image, scaleFactor);
    }

    /**
     * ==== scaleToHeight
     * Skaliert das Bild auf eine bestimmte Höhe in Pixel
     *
     * @param image     image
     * @param height    target height
     * @return scaled image
     */
    public static BufferedImage scaleToHeight(BufferedImage image, int height) {
        double scaleFactor = calculateScaleFactor((double)image.getHeight(), (double)height);
        return scale(image, scaleFactor);
    }

    /**
     * ==== hasExpectedAspectRatio
     * Calculate if a image has a specified aspect ratio with a certain tolarance
     *
     * @param img               image
     * @param ratioHeight       ratio height
     * @param ratioWidth        ratio width
     * @param ratioTolerance    tolerance of the ratio calculation
     * @return true if the image has the specified ratio
     */
    public static boolean hasExpectedAspectRatio(BufferedImage img, double ratioHeight, double ratioWidth, double ratioTolerance) {
        double expectedAspectRatio = ratioHeight / ratioWidth;
        return Math.abs(((double) img.getHeight() / (double) img.getWidth()) - expectedAspectRatio) < ratioTolerance;
    }

    /**
     * ==== calculateScaleFactor
     * Calculates the scale factor between two sizes
     *
     * @param size1
     * @param size2
     * @return the scale factor
     */
    public static double calculateScaleFactor(double size1, double size2) {
        return (double) 1 / (size1 / size2);
    }
}
